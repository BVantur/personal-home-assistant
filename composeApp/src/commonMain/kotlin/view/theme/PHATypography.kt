package view.theme

import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object PHATypography {
    fun typography(
        defaultFontFamily: FontFamily = FontFamily.Default,
        h1: TextStyle = TextStyle(
            fontWeight = FontWeight.Light,
            fontSize = 96.sp,
            letterSpacing = (-1.5).sp
        ),
        h2: TextStyle = TextStyle(
            fontWeight = FontWeight.Light,
            fontSize = 60.sp,
            letterSpacing = (-0.5).sp
        ),
        h3: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 48.sp,
            letterSpacing = 0.sp
        ),
        h4: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 34.sp,
            letterSpacing = 0.25.sp
        ),
        h5: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 24.sp,
            letterSpacing = 0.sp
        ),
        h6: TextStyle = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp,
            letterSpacing = 0.15.sp
        ),
        subtitle1: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            letterSpacing = 0.15.sp
        ),
        subtitle2: TextStyle = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            letterSpacing = 0.1.sp
        ),
        body1: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            letterSpacing = 0.5.sp
        ),
        body2: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            letterSpacing = 0.25.sp
        ),
        button: TextStyle = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            letterSpacing = 1.25.sp
        ),
        caption: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            letterSpacing = 0.4.sp
        ),
        overline: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 10.sp,
            letterSpacing = 1.5.sp
        )
    ): Typography {
        return Typography(
            defaultFontFamily = defaultFontFamily,
            h1 = h1,
            h2 = h2,
            h3 = h3,
            h4 = h4,
            h5 = h5,
            h6 = h6,
            subtitle1 = subtitle1,
            subtitle2 = subtitle2,
            body1 = body1,
            body2 = body2,
            button = button,
            caption = caption,
            overline = overline,
        )


//        @Composable
//        fun montserratFamily() = FontFamily(
//            font(
//                "Poppins Light",
//                "poppins_light",
//                FontWeight.Light,
//                FontStyle.Normal
//            ),
//            font(
//                "Poppins Regular",
//                "poppins_regular",
//                FontWeight.Normal,
//                FontStyle.Normal
//            ),
//            font(
//                "Poppins Italic",
//                "poppins_italic",
//                FontWeight.Normal,
//                FontStyle.Italic
//            ),
//            font(
//                "Poppins Medium",
//                "poppins_medium",
//                FontWeight.Medium,
//                FontStyle.Normal
//            ),
//            font(
//                "Poppins Bold",
//                "poppins_bold",
//                FontWeight.Bold,
//                FontStyle.Normal
//            )
//        )
    }
}