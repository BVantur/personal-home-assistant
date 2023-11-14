package view.theme

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

object PHAShapes {
    fun shapes(
        small: CornerBasedShape = RoundedCornerShape(4.dp),
        medium: CornerBasedShape = RoundedCornerShape(4.dp),
        large: CornerBasedShape = RoundedCornerShape(0.dp)
    ): Shapes {
        return Shapes(
            small = small,
            medium = medium,
            large = large
        )
    }
}