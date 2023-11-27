package view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import data.models.TextData
import dev.icerock.moko.resources.compose.stringResource
import sp.bvantur.assistant.SharedRes
import view.theme.PHAColors

typealias OnDialogAction = () -> Unit

data class DialogData(
    val title: TextData? = null,
    val message: TextData? = null,
    val positiveAction: TextData? = null,
    val negativeAction: TextData? = null,
    val onPositiveAction: OnDialogAction? = null,
    val onNegativeAction: OnDialogAction? = null,
)

@Composable
fun PHADialog(
    modifier: Modifier = Modifier,
    dialogData: DialogData
) {
    Box(modifier = Modifier.fillMaxSize().background(PHAColors.Ebony.copy(alpha = 0.4f))) {
        Dialog(
            onDismissRequest = {},
            properties = DialogProperties()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                    .shadow(elevation = 5.dp)
                    .background(MaterialTheme.colors.surface, RoundedCornerShape(8.dp))
                    .padding(24.dp)
            ) {
                dialogData.title?.let { title ->
                    H5Text(
                        text = title.asString()
                    )
                }
                dialogData.message?.let { message ->
                    Body1Text(
                        modifier = Modifier.padding(top = 9.dp),
                        text = message.asString()
                    )
                }
                dialogData.positiveAction?.let { positiveAction ->
                    PHAButton(
                        modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                        onClick = { dialogData.onPositiveAction?.invoke() }
                    ) {
                        ButtonText(
                            modifier = Modifier.align(Alignment.CenterVertically),
                            text = positiveAction.asString()
                        )
                    }
                }
                dialogData.negativeAction?.let { negativeAction ->
                    PHAButton(
                        modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                        onClick = { dialogData.onNegativeAction?.invoke() }
                    ) {
                        ButtonText(text = negativeAction.asString())
                    }
                }
            }
        }
    }
}