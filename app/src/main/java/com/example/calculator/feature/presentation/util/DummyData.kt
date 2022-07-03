package com.example.calculator.feature.presentation.util

import com.example.calculator.feature.domain.model.CalculationContent
import com.example.calculator.feature.domain.model.CalculationInfo

object DummyData {

    val list: List<CalculationInfo> = listOf(
        CalculationInfo(
            1,
            "Java",
            20220614L,
            1L
        ),
        CalculationInfo(
            2,
            "Kotlin",
            20220614L,
            1L
        ),
        CalculationInfo(
            3,
            "Python",
            20220614L,
            1L
        ),
        CalculationInfo(
            4,
            "JavaScript",
            20220614L,
            1L
        ),
        CalculationInfo(
            5,
            "Ruby",
            20220614L,
            1L
        ),
        CalculationInfo(
            6,
            "Swift",
            20220614L,
            1L
        ),
        CalculationInfo(
            7,
            "PHP",
            20220614L,
            1L
        ),
        CalculationInfo(
            8,
            "Haskell",
            20220614L,
            1L
        ),
        CalculationInfo(
            9,
            "RUST",
            20220614L,
            1L
        ),
        CalculationInfo(
            10,
            "Go",
            20220614L,
            1L
        ),
        CalculationInfo(
            11,
            "C",
            20220614L,
            1L
        ),
        CalculationInfo(
            12,
            "C+",
            20220614L,
            1L
        ),
        CalculationInfo(
            13,
            "C++",
            20220614L,
            1L
        ),
        CalculationInfo(
            14,
            "C#",
            20220614L,
            1L
        ),
        CalculationInfo(
            15,
            "HTML",
            20220614L,
            1L
        ),
    )

    val contentList = listOf<CalculationContent>(CalculationContent(
        contentId = 1L,
        answer = 100L,
        formulaProcess = listOf(
            "20×5=",
            "20×5=",
            "20×5=",
            "20×5=",
            "20×5=",
            "20×5=",
            "20×5=",
            "20×5=",
            "20×5=",
            "20×5=",
        )
    ))
}