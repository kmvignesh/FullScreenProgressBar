package com.example.vicky.fullscreenprogressbar

import android.app.Dialog
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        NetworkTask(this).execute()

    }


    class NetworkTask(var activity: MainActivity) : AsyncTask<Void,Void,Void>(){

        var dialog = Dialog(activity,android.R.style.Theme_Translucent_NoTitleBar)

        override fun onPreExecute() {
            val view = activity.layoutInflater.inflate(R.layout.full_screen_progress_bar,null)
            dialog.setContentView(view)
            dialog.setCancelable(false)
            dialog.show()
            super.onPreExecute()
        }

        override fun doInBackground(vararg p0: Void?): Void? {
            Thread.sleep(5000)
            return null
        }

        override fun onPostExecute(result: Void?) {
            super.onPostExecute(result)
            dialog.dismiss()
        }

    }

}
