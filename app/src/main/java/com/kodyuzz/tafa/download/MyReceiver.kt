package com.kodyuzz.tafa.download

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.util.Log

class MyReceiver : BroadcastReceiver() {

    companion object{
        private const val TAG = "MyReceiver"
    }

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        Log.d(TAG, "onReceive: ")

        var asyncTask = object : AsyncTask<String, Int, String>(){
            override fun doInBackground(vararg p0: String?): String {
                TODO("Not yet implemented")
            }

            override fun onProgressUpdate(vararg values: Int?) {
                super.onProgressUpdate(*values)
            }

            override fun onPostExecute(result: String?) {
                super.onPostExecute(result)
            }

            override fun onPreExecute() {
                super.onPreExecute()
            }

        }
        asyncTask.execute("db")
     }
}
