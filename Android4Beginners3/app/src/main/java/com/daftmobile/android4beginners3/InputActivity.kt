package com.daftmobile.android4beginners3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_input.*

class InputActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)
        addButton.setOnClickListener(this::setResultAndFinish)
    }

    private fun setResultAndFinish(view: View) {
        val text = Intent().putExtra("result", addInput.text.toString())
        setResult(Activity.RESULT_OK, text)
        finish()
    }
}
