package com.kodyuzz.myservice

import android.app.IntentService
import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.media.MediaPlayer
import android.os.Build
import android.util.Log
import android.widget.TextView

// TODO: Rename actions, choose action names that describe tasks that this
// IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
private const val ACTION_FOO = "com.kodyuzz.tafa.download.action.FOO"
private const val ACTION_BAZ = "com.kodyuzz.tafa.download.action.BAZ"

// TODO: Rename parameters
private const val EXTRA_PARAM1 = "com.kodyuzz.tafa.download.extra.PARAM1"
private const val EXTRA_PARAM2 = "com.kodyuzz.tafa.download.extra.PARAM2"

/**
 * An [IntentService] subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
class MyIntentService : IntentService("MyIntentService") {


    override fun onHandleIntent(intent: Intent?) {
        when (intent?.action) {
            ACTION_FOO -> {
                val param1 = intent.getStringExtra(EXTRA_PARAM1)
                val param2 = intent.getStringExtra(EXTRA_PARAM2)
                param2?.let { param1?.let { it1 -> handleActionFoo(it1, it) } }
            }
            ACTION_BAZ -> {
                val param1 = intent.getStringExtra(EXTRA_PARAM1)
                val param2 = intent.getStringExtra(EXTRA_PARAM2)
                param1?.let { param2?.let { it1 -> handleActionBaz(it, it1) } }
            }
        }

        Log.d(TAG, "onHandleIntent: ")


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            var mediaPlayer = MediaPlayer()
            mediaPlayer.setDataSource(assets.openFd("Beautiful Lemon Bundt Cake.mp3"))
            mediaPlayer.prepare()
            mediaPlayer.start()
        }


        //set typeface
//        var createFromAsset = Typeface.createFromAsset(assets, "abc.ttf")
//        TextView(this).typeface = createFromAsset
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private fun handleActionFoo(param1: String, param2: String) {
        TODO("Handle action Foo")
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private fun handleActionBaz(param1: String, param2: String) {
        TODO("Handle action Baz")
    }

    companion object {

        private const val TAG = "MyIntentService"

        /**
         * Starts this service to perform action Foo with the given parameters. If
         * the service is already performing a task this action will be queued.
         *
         * @see IntentService
         */
        // TODO: Customize helper method
        @JvmStatic
        fun startActionFoo(context: Context, param1: String, param2: String) {
            val intent = Intent(context, MyIntentService::class.java).apply {
                action = ACTION_FOO
                putExtra(EXTRA_PARAM1, param1)
                putExtra(EXTRA_PARAM2, param2)
            }
            context.startService(intent)
        }

        /**
         * Starts this service to perform action Baz with the given parameters. If
         * the service is already performing a task this action will be queued.
         *
         * @see IntentService
         */
        // TODO: Customize helper method
        @JvmStatic
        fun startActionBaz(context: Context, param1: String, param2: String) {
            val intent = Intent(context, MyIntentService::class.java).apply {
                action = ACTION_BAZ
                putExtra(EXTRA_PARAM1, param1)
                putExtra(EXTRA_PARAM2, param2)
            }
            context.startService(intent)
        }
    }
}
