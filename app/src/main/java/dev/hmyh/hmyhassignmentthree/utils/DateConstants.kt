package dev.hmyh.hmyhassignmentthree.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

const val FORMAT_DATE_M_D_Y_T_HH_mm_ss = "yyyy-MM-dd'T'HH:mm:ss"
const val FORMAT_DATE_M_D_Y_HH_mm_ss = "yyyy-MM-dd HH:mm:ss"
const val FORMAT_YYY_MM_DD="yyyy-MM-dd"
const val FORMAT_DD_MMMM_YYY="dd MMMM, yyyy"
const val FORMAT_MMMM_YYY="MMMM, yyyy"
const val FORMAT_MONTH="MMMM"
const val FORMAT_DD_MMMM_YYY_HMS="dd MMMM, yyyy - hh:mm:aa"
const val FORMAT_DD_MMMM_YYY_HMS_CALL_REPORT="dd MMMM, yyyy | hh:mm:aa"
const val FORMAT_CALL_PLAN_CREATE="yyyy-MM-dd "
const val FORMAT_YEAR="yyyy"

fun getFormattedDateFromTimeStamp(inputDate: String?, format: String = FORMAT_YYY_MM_DD): String {

    if (inputDate == null){
        return ""
    }
    else{
        try {
            val simpleDateFormat = SimpleDateFormat(FORMAT_YYY_MM_DD, Locale.US)
            val date = simpleDateFormat.parse(inputDate)

            val formatDateForBooking = SimpleDateFormat(FORMAT_DATE_M_D_Y_T_HH_mm_ss, Locale.US)
            return formatDateForBooking.format(date)
        } catch (e: ParseException) {
            return ""
        }
    }

}

fun getFormattedDateNotTFromTimeStamp(inputDate: String?, format: String = FORMAT_YYY_MM_DD): String {

    if (inputDate == null){
        return ""
    }
    else{
        try {
            val simpleDateFormat = SimpleDateFormat(FORMAT_YYY_MM_DD, Locale.US)
            val date = simpleDateFormat.parse(inputDate)

            val formatDateForBooking = SimpleDateFormat(FORMAT_DATE_M_D_Y_HH_mm_ss, Locale.US)
            return formatDateForBooking.format(date)
        } catch (e: ParseException) {
            return ""
        }
    }

}

//fun getFormattedDateCallPlanCreate(inputDate: String?,format: String)

fun getFromApiToShowData(inputDate: String?,format: String = FORMAT_YYY_MM_DD): String{

    if (inputDate == null){
        return ""
    }
    else{
        try {
            val simpleDateFormat = SimpleDateFormat(FORMAT_DATE_M_D_Y_T_HH_mm_ss,Locale.US)
            val date = simpleDateFormat.parse(inputDate)

            val formatShowData = SimpleDateFormat(format, Locale.US)
            return formatShowData.format(date)
        }catch (e: ParseException){
            return ""
        }
    }

}

fun getDateFromApi(inputDate: String?,format: String= FORMAT_DATE_M_D_Y_T_HH_mm_ss): String{
    if (inputDate == null){
        return ""
    }
    else{
        try {
            val simpleDateFormat = SimpleDateFormat(FORMAT_YYY_MM_DD,Locale.US)
            val date = simpleDateFormat.parse(inputDate)

            val formatShowData = SimpleDateFormat(format, Locale.US)
            return formatShowData.format(date)
        }catch (e: ParseException){
            return ""
        }
    }
}

fun getFromApiToShowDataNotT(inputDate: String?,format: String = FORMAT_YYY_MM_DD): String{

    try {
        val simpleDateFormat = SimpleDateFormat(FORMAT_DATE_M_D_Y_HH_mm_ss,Locale.US)
        val date = simpleDateFormat.parse(inputDate)

        val formatShowData = SimpleDateFormat(format, Locale.US)
        return formatShowData.format(date)
    }catch (e: ParseException){
        return ""
    }
}

fun getFromApiToShowMonthData(inputDate: String?,format: String = FORMAT_DD_MMMM_YYY): String{

    if (inputDate == null){
        return ""
    }
    else{
        try {
            val simpleDateFormat = SimpleDateFormat(FORMAT_DATE_M_D_Y_T_HH_mm_ss,Locale.US)
            val date = simpleDateFormat.parse(inputDate)

            val formatShowData = SimpleDateFormat(format, Locale.US)
            return formatShowData.format(date)
        }catch (e: ParseException){
            return ""
        }
    }
}

fun getFromApiToShowMonthDataForReport(inputDate: String?,format: String = FORMAT_MMMM_YYY): String{

    if (inputDate == null){
        return ""
    }
    else{
        try {
            val simpleDateFormat = SimpleDateFormat(FORMAT_DATE_M_D_Y_HH_mm_ss,Locale.US)
            val date = simpleDateFormat.parse(inputDate)

            val formatShowData = SimpleDateFormat(format, Locale.US)
            return formatShowData.format(date)
        }catch (e: ParseException){
            return ""
        }
    }
}

fun getFromApiToShowMonthYearForReport(inputDate: String?,format: String = FORMAT_MMMM_YYY): String{

    if (inputDate == null){
        return ""
    }
    else{
        try {
            val simpleDateFormat = SimpleDateFormat(FORMAT_DATE_M_D_Y_T_HH_mm_ss,Locale.US)
            val date = simpleDateFormat.parse(inputDate)

            val formatShowData = SimpleDateFormat(format, Locale.US)
            return formatShowData.format(date)
        }catch (e: ParseException){
            return ""
        }
    }
}

fun getFromApiToShowMonthForReport(inputDate: String?,format: String = FORMAT_MONTH): String{

    if (inputDate == null){
        return ""
    }
    else{
        try {
            val simpleDateFormat = SimpleDateFormat(FORMAT_DATE_M_D_Y_T_HH_mm_ss,Locale.US)
            val date = simpleDateFormat.parse(inputDate)

            val formatShowData = SimpleDateFormat(format, Locale.US)
            return formatShowData.format(date)
        }catch (e: ParseException){
            return ""
        }
    }
}

fun getFromApiToShowMonthNotTDataTime(inputDate: String?,format: String = FORMAT_DD_MMMM_YYY_HMS): String{

    if (inputDate == null){
        return ""
    }
    else{
        try {
            val simpleDateFormat = SimpleDateFormat(FORMAT_DATE_M_D_Y_HH_mm_ss,Locale.US)
            val date = simpleDateFormat.parse(inputDate)

            val formatShowData = SimpleDateFormat(format, Locale.US)
            return formatShowData.format(date)
        }catch (e: ParseException){
            return ""
        }
    }

}

fun getFromApiToShowMonthTDataTimeCallReport(inputDate: String?, format: String = FORMAT_DD_MMMM_YYY_HMS_CALL_REPORT): String{

    if (inputDate == null){
        return ""
    }
    else{
        try {
            val simpleDateFormat = SimpleDateFormat(FORMAT_DATE_M_D_Y_T_HH_mm_ss,Locale.US)
            val date = simpleDateFormat.parse(inputDate)

            val formatShowData = SimpleDateFormat(format, Locale.US)
            return formatShowData.format(date)
        }catch (e: ParseException){
            return ""
        }
    }

}

fun getFromApiToShowMonthTDataTime(inputDate: String?,format: String = FORMAT_DD_MMMM_YYY_HMS): String{

    if (inputDate == null){
        return ""
    }
    else{
        try {
            val simpleDateFormat = SimpleDateFormat(FORMAT_DATE_M_D_Y_T_HH_mm_ss,Locale.US)
            val date = simpleDateFormat.parse(inputDate)

            val formatShowData = SimpleDateFormat(format, Locale.US)
            return formatShowData.format(date)
        }catch (e: ParseException){
            return ""
        }
    }
}

fun getFromApiToShowEdit(inputDate: String?,format: String = FORMAT_YYY_MM_DD): String{

    if (inputDate == null){
        return ""
    }
    else{
        try {
            val simpleDateFormat = SimpleDateFormat(FORMAT_DATE_M_D_Y_T_HH_mm_ss,Locale.US)
            val date = simpleDateFormat.parse(inputDate)

            val formatShowData = SimpleDateFormat(format, Locale.US)
            return formatShowData.format(date)
        }catch (e: ParseException){
            return ""
        }
    }
}

fun getApiMovieDate(inputDate: String?,format: String = FORMAT_YEAR): String{

    if (inputDate == null){
        return ""
    }
    else{
        try {
            val simpleDateFormat = SimpleDateFormat(FORMAT_YYY_MM_DD,Locale.US)
            val date = simpleDateFormat.parse(inputDate)

            val formatShowData = SimpleDateFormat(format, Locale.US)
            return formatShowData.format(date)
        }catch (e: ParseException){
            return ""
        }
    }
}

