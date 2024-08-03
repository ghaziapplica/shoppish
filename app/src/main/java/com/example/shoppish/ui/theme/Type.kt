package com.example.shoppish.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.shoppish.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */



)

val poppinsFamilyFont = FontFamily (
    Font(R.font.poppins_regular),
    Font(R.font.poppins_medium, FontWeight.W500),
    Font(R.font.poppins_semibold, FontWeight.W600),
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_light, FontWeight.Light),
    Font(R.font.poppins_extralight, FontWeight.ExtraLight),
    Font(R.font.poppins_thin, FontWeight.Thin),
    Font(R.font.poppins_black, FontWeight.Black),
    Font(R.font.poppins_extrabold, FontWeight.ExtraBold),
)
val metropolisFamilyFont = FontFamily (
    Font(R.font.metropolis_regular),
    Font(R.font.metropolis_medium, FontWeight.W500),
    Font(R.font.metropolis_semibold, FontWeight.W600),
    Font(R.font.metropolis_bold, FontWeight.Bold),
    Font(R.font.metropolis_light, FontWeight.Light),
    Font(R.font.poppins_extralight, FontWeight.ExtraLight),
    Font(R.font.metropolis_thin, FontWeight.Thin),
    Font(R.font.metropolis_black, FontWeight.Black),
    Font(R.font.metropolis_extrabold, FontWeight.ExtraBold),
)