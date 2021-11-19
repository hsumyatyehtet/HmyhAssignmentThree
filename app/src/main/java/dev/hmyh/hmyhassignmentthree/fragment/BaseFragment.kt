package dev.hmyh.hmyhassignmentthree.fragment

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.kaopiz.kprogresshud.KProgressHUD
import dev.hmyh.hmyhassignmentthree.R
import kotlinx.android.synthetic.main.dialog_warning.view.*

abstract class BaseFragment: Fragment() {

    private var alertDialog: AlertDialog? = null
    lateinit var kProgressHUD: KProgressHUD

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        kProgressHUD = KProgressHUD.create(requireContext())
        super.onViewCreated(view, savedInstanceState)
    }

    @SuppressLint("ResourceAsColor", "ResourceType")
    protected fun showAlertDialog(
        title: String = "Hmyh Assignment Three",
        message: String = "The implementation for this is not in the current release.",
        onConfirm: () -> Unit
    ) = if (alertDialog == null) {

        val factory = LayoutInflater.from(context)
        val deleteDialogView: View = factory.inflate(R.layout.dialog_warning, null)
        alertDialog =
            AlertDialog.Builder(requireContext()).create()
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

        val factory = LayoutInflater.from(context)
        val deleteDialogView: View = factory.inflate(R.layout.dialog_warning, null)
        alertDialog =
            AlertDialog.Builder(requireContext()).create()
        alertDialog?.setView(deleteDialogView)
        deleteDialogView.tvDialogTitle.text = title
        deleteDialogView.tvDialogBody.text = message
        alertDialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        deleteDialogView.tvDialogOk.setOnClickListener {
            alertDialog?.dismiss()
        }

        alertDialog?.show()
    }

    protected fun showProgressDialog() {
        kProgressHUD.setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
            .setLabel("Loading")
            .show()
    }

    protected fun hideProgressDialog() {
        kProgressHUD.dismiss()
    }

}