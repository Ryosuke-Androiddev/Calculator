package com.example.calculator.feature.presentation.util

import com.example.calculator.feature.domain.model.CalculationContent
import com.example.calculator.feature.domain.model.CalculationInfo
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*

object DummyData {

    val list: List<CalculationInfo> = listOf(
        CalculationInfo(
            1,
            "Java",
            Date()
        ),
        CalculationInfo(
            2,
            "Kotlin",
            Date()
        ),
        CalculationInfo(
            3,
            "Python",
            Date()
        ),
        CalculationInfo(
            4,
            "JavaScript",
            Date()
        ),
        CalculationInfo(
            5,
            "Ruby",
            Date()
        ),
        CalculationInfo(
            6,
            "Swift",
            Date()
        ),
        CalculationInfo(
            7,
            "PHP",
            Date()
        ),
        CalculationInfo(
            8,
            "Haskell",
            Date()
        ),
        CalculationInfo(
            9,
            "RUST",
            Date()
        ),
        CalculationInfo(
            10,
            "Go",
            Date()
        ),
        CalculationInfo(
            11,
            "C",
            Date()
        ),
        CalculationInfo(
            12,
            "C+",
            Date()
        ),
        CalculationInfo(
            13,
            "C++",
            Date()
        ),
        CalculationInfo(
            14,
            "C#",
            Date()
        ),
        CalculationInfo(
            15,
            "HTML",
            Date()
        ),
    )

    val contentList = listOf<CalculationContent>(
        CalculationContent(
        contentId = 1L,
        answer = 100L,
        formulaProcess = "20×5",
        1L
        ),
        CalculationContent(
            contentId = 2L,
            answer = 100L,
            formulaProcess = "20×5",
            1L
        ),
        CalculationContent(
            contentId = 3L,
            answer = 100L,
            formulaProcess = "20×5",
            1L
        ),
        CalculationContent(
            contentId = 4L,
            answer = 100L,
            formulaProcess = "20×5",
            1L
        ),
        CalculationContent(
            contentId = 5L,
            answer = 100L,
            formulaProcess = "20×5",
            1L
        ),
        CalculationContent(
            contentId = 6L,
            answer = 100L,
            formulaProcess = "20×5",
            1L
        ),
        CalculationContent(
            contentId = 7L,
            answer = 100L,
            formulaProcess = "20×5",
            1L
        ),
        CalculationContent(
            contentId = 8L,
            answer = 100L,
            formulaProcess = "20×5",
            1L
        ),
        CalculationContent(
            contentId = 9L,
            answer = 100L,
            formulaProcess = "20×5",
            1L
        ),
        CalculationContent(
            contentId = 10L,
            answer = 100L,
            formulaProcess = "20×5",
            1L
        ),
        CalculationContent(
            contentId = 11L,
            answer = 100L,
            formulaProcess = "20×5",
            1L
        ),
        CalculationContent(
            contentId = 12L,
            answer = 100L,
            formulaProcess = "20×5",
            1L
        ),
        CalculationContent(
            contentId = 13L,
            answer = 100L,
            formulaProcess = "20×5",
            1L
        ),
        CalculationContent(
            contentId = 14L,
            answer = 100L,
            formulaProcess = "20×5",
            1L
        ),
        CalculationContent(
            contentId = 15L,
            answer = 100L,
            formulaProcess = "20×500",
            1L
        ),
    )
}