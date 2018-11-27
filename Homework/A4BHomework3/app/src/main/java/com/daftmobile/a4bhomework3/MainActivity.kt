package com.daftmobile.a4bhomework3

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.support.v7.app.AppCompatActivity
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        EMAIL_RETRIEVER = EmailRetriever.Impl(applicationContext)
    }

    fun onButtonClick(view: View) {
        val intent = Intent(Intent.ACTION_PICK).apply {
            type = ContactsContract.CommonDataKinds.Email.CONTENT_TYPE
        }
        startActivityForResult(intent, PICK_CONTACT_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == PICK_CONTACT_REQUEST && resultCode == Activity.RESULT_OK) {
            val uri = data?.data
            val emailAddress = uri?.let { EMAIL_RETRIEVER.retrieve(it) }
            if (emailAddress != null) {
                sendEmail(emailAddress,"Wiadomość z pracy domowej")
            }
        }
    }

    private fun sendEmail(emailAddress: String, subject: String) {
        val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:")).apply {
            putExtra(Intent.EXTRA_EMAIL, arrayOf(emailAddress))
            putExtra(Intent.EXTRA_SUBJECT, subject)
        }
        startActivity(intent)
    }

    companion object {
        const val PICK_CONTACT_REQUEST: Int = 1
        lateinit var EMAIL_RETRIEVER: EmailRetriever
    }
}
