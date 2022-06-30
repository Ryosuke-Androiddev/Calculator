package com.example.calculator.feature.data.data_source

import androidx.room.TypeConverter
import com.example.calculator.feature.data.util.DataLayerConstants.DATABASE_TYPE_CONVERTER_SEPARATOR
import java.lang.StringBuilder

class DatabaseConverter {

    @TypeConverter
    fun convertListToString(list: List<String>): String {
        val stringBuilder = StringBuilder()
        for (calculation in list) {
            // 計算過程を , を使って、セパレートする
            stringBuilder.append(calculation).append(DATABASE_TYPE_CONVERTER_SEPARATOR)
        }
        // aaa, bbb, ccc, → 最後の,を削除することで aaa, bbb, ccc となって、文字列の長さが決まる
        stringBuilder.setLength(stringBuilder.length - DATABASE_TYPE_CONVERTER_SEPARATOR.length)
        return stringBuilder.toString()
    }

    @TypeConverter
    fun convertStringToList(string: String): List<String> {
        return string.split(DATABASE_TYPE_CONVERTER_SEPARATOR)
    }
}