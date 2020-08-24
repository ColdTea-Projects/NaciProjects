package de.sample.android.dslalertdialog

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface

@MyDialogBuilderMarker
class MyDialogBuilder {
    var context: Context? = null
    var titleText: String = ""
    var message: String = ""
    var positiveText: String = ""
    var onDismissAction: (dialog: DialogInterface) -> Unit = { _ -> }
    var negativeButtonItem: MyButtonItem? = null
    var onPositiveClickAction: (dialog: DialogInterface, which: Int) -> Unit = { _, _ -> }

    fun with(context: () -> Context) {
        this.context = context()
    }

    infix fun titleText(titleText: String) {
        this.titleText = titleText
    }
//
    fun message(message: () -> String) {
        this.message = message()
    }
//
    fun positiveButton(
        positiveText: String,
        positiveAction: (dialog: DialogInterface, which: Int) -> Unit
    ) {
        this.positiveText = positiveText
        this.onPositiveClickAction = positiveAction
    }
//
    fun negativeButton(lambda: MyButtonItemBuilder.() -> Unit) {
        negativeButtonItem = MyButtonItemBuilder().apply(lambda).build()
    }



    fun build(): AlertDialog.Builder {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(titleText)
        builder.setMessage(message)
        builder.setPositiveButton(positiveText, onPositiveClickAction)
        builder.setOnDismissListener(onDismissAction)

        negativeButtonItem?.let {
            builder.setNegativeButton(it.text, it.onClickAction)
        }
        return builder
    }
}

class MyButtonItemBuilder {
    var text: String = ""
    var onClickAction: (dialog: DialogInterface, which: Int) -> Unit = { _, _ -> }

    fun buttonText(text: () -> String) {
        this.text = text()
    }

    fun actionButton(
        onClickAction: (dialog: DialogInterface, which: Int) -> Unit
    ) {
        this.onClickAction = onClickAction
    }

    fun build(): MyButtonItem {
        return MyButtonItem(text, onClickAction)
    }
}

data class MyButtonItem(
    val text: String = "",
    val onClickAction: (dialog: DialogInterface, which: Int) -> Unit = { _, _ -> }
)

@DslMarker
annotation class MyDialogBuilderMarker
