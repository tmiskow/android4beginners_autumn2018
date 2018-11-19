package com.daftmobile.a4bhomework2

import android.app.AlertDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onButtonClick(view: View) {
        if (view is Button) {
            val dialogMessage = getString(R.string.button_click_message, view.text)
            val dialogButtonText = getString(R.string.button_click_button_text)
            AlertDialog.Builder(this)
                .setMessage(dialogMessage)
                .setPositiveButton(dialogButtonText) { dialog, _ ->
                    dialog.dismiss()
                }.show()
        }
    }
}
