package dev.hmyh.hmyhassignmentthree.activity

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import dev.hmyh.hmyhassignmentthree.R
import kotlinx.android.synthetic.main.dialog_warning.view.*

abstract class BaseActivity: AppCompatActivity() {

    private var alertDialog: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("ResourceAsColor", "ResourceType")
    protected fun showAlertDialog(
        title: String = "Hmyh Assignment Three",
        message: String = "The implementation for this is not in the current release.",
        onConfirm: () -> Unit
    ) = if (alertDialog == null) {

        val factory = LayoutInflater.from(this)
        val deleteDialogView: View = factory.inflate(R.layout.dialog_warning, null)
        alertDialog =
            AlertDialog.Builder(this).create()
        alertDialog?.setView(deleteDialogView)
        deleteDialogView.tvDialogTitle.text = title
        deleteDialogView.tvDialogBody.text = message
        alertDialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        deleteDialogView.tvDialogOk.setOnClickListener {
            alertDialog?.dismiss()
        }

        alertDialog?.show()
    }
    else {

        val factory = LayoutInflater.from(this)
        val deleteDialogView: View = factory.inflate(R.layout.dialog_warning, null)
        alertDialog =
            AlertDialog.Builder(this).create()
        alertDialog?.setView(deleteDialogView)
        deleteDialogView.tvDialogTitle.text = title
        deleteDialogView.tvDialogBody.text = message
        alertDialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        deleteDialogView.tvDialogOk.setOnClickListener {
            alertDialog?.dismiss()
        }

        alertDialog?.show()
    }


}