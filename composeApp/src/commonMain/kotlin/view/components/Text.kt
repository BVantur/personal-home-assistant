package view.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle

@Composable
fun H1Text(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.h1
    )
}

@Composable
fun H2Text(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.h2
    )
}

@Composable
fun H3Text(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.h3
    )
}

@Composable
fun H4Text(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.h4
    )
}

@Composable
fun H5Text(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.h5
    )
}

@Composable
fun Subtitle1Text(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.subtitle1
    )
}

@Composable
fun Subtitle2Text(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.subtitle2
    )
}

@Composable
fun Body1Text(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.body1
    )
}

@Composable
fun Body2Text(
    text: String,
    color: Color = Color.Unspecified,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = text,
        color = color,
        style = MaterialTheme.typography.body2
    )
}

@Composable
fun ButtonText(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.button
    )
}

@Composable
fun SpannableText() {
    val annotatedString = buildAnnotatedString {
        append("Še nimaš računa? ")
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colors.primary,
                textDecoration = TextDecoration.Underline
            )
        ) {
            append(" Registriraj se")
        }
    }

    Text(text = annotatedString)
}