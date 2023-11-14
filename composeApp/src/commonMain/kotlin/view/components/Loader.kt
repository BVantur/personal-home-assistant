package view.components

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@Composable
fun Loader(
    modifier: Modifier = Modifier
) {
    val strokeWidth = 5.dp
    val secondaryColor = MaterialTheme.colors.secondary
    CircularProgressIndicator(
        modifier = modifier.drawBehind {
            drawCircle(
                secondaryColor,
                radius = size.width / 2 - strokeWidth.toPx() / 2,
                style = Stroke(strokeWidth.toPx())
            )
        },
        color = MaterialTheme.colors.primaryVariant,
        strokeWidth = strokeWidth
    )
}
