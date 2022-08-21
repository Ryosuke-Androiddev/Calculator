package com.example.calculator.feature.presentation.ui.list

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.calculator.R
import com.example.calculator.databinding.FragmentListBinding
import com.example.calculator.feature.domain.model.CalculationInfo
import com.example.calculator.feature.presentation.component.adapter.list_item.CalculationInfoItemAdapter
import com.example.calculator.feature.presentation.component.dialog.CustomPopUpDialogFragment
import com.example.calculator.feature.presentation.component.dialog.MakeCalculationPopUpDialogFragment
import com.example.calculator.feature.presentation.ui.list.viewmodel.ListViewModel
import com.example.calculator.feature.presentation.util.DummyData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment(R.layout.fragment_list),
    MakeCalculationPopUpDialogFragment.MakeCalculationPopUpDialogListener,
    CustomPopUpDialogFragment.CustomPopUpDialogListener {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ListViewModel by viewModels()
    private val adapter by lazy { CalculationInfoItemAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)

        Log.d("UpdateFragment", "ListFragment View Created")

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        viewModel.getAllCalculationInfoUseCase.observe(viewLifecycleOwner) {
            // submitList() はここで呼び出す
        }

        childFragmentManager.setFragmentResultListener("update_navigation", viewLifecycleOwner) { requestKey: String, bundle: Bundle ->
            val result = bundle["result"] as CalculationInfo
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(result)
            findNavController().navigate(action)
        }

        binding.DashBorderButton.setOnClickListener {
            MakeCalculationPopUpDialogFragment().show(childFragmentManager, "Make New Calculation Pop Up")
        }

        binding.dashBorderExplainTextView.setOnClickListener {
            MakeCalculationPopUpDialogFragment().show(childFragmentManager, "Make New Calculation Pop Up")
        }

        // 検索処理
        binding.searchInputText.setOnEditorActionListener { editText, action, _ ->

            if (action == EditorInfo.IME_ACTION_SEARCH) {

                hideKeyboard()
                editText.text?.toString()?.let { searchQuery ->
                    if (searchQuery.isNotEmpty()) {
                        // 個々の呼び出しをsubmitList()する処理がないと変更を確認できない
                        viewModel.searchCalculationInfoUseCase(searchQuery = searchQuery)
                    } else {
                        Toast.makeText(requireContext(), "Please Input 0 more Characters", Toast.LENGTH_SHORT).show()
                    }
                }
                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false
        }
    }

    private fun hideKeyboard() {
        val view = activity?.currentFocus
        if (view != null) {
            val manager = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            manager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    // submitList() のタイミングに注意する
    private fun setupRecyclerView() {

        binding.listRecyclerView.adapter = adapter
        binding.listRecyclerView.layoutManager = LinearLayoutManager(context)

        // この処理をLiveDataで購読している処理に回す
        adapter.submitList(DummyData.list)

        adapter.setOnCalculationClickListener(
            object : CalculationInfoItemAdapter.OnCalculationItemClickListener {

                override fun onCalculationItemInfoOnClick(calculationInfo: CalculationInfo) {
                    navigateToUpdateFragment(calculationInfo = calculationInfo)
                }

                override fun showPopUpWindow(calculationInfo: CalculationInfo) {
                    // pass Dialog Fragment Manager (childFragment Manager)
                    CustomPopUpDialogFragment(calculationInfo = calculationInfo).show(childFragmentManager, "Custom Pop Up")
                }
            }
        )
    }

    private fun navigateToUpdateFragment(calculationInfo: CalculationInfo) {
        val action = ListFragmentDirections.actionListFragmentToUpdateFragment(calculationItem = calculationInfo)
        findNavController().navigate(action)
    }

    private fun navigateToCreateNewItemFragment(calculationInfo: CalculationInfo) {
        val action = ListFragmentDirections.actionListFragmentToCreateNewItemFragment(newCalculationInfo = calculationInfo)
        findNavController().navigate(action)
    }

    override fun onMakeNewCalculationSaveButtonClick(calculationInfo: CalculationInfo) {
        navigateToCreateNewItemFragment(calculationInfo = calculationInfo)
    }

    override fun onCustomPopUpDialogSaveButtonClick(dialog : CustomPopUpDialogFragment) {
        // Title のUPDATEのUseCaseをここで呼び出す
        dialog.dismiss()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}