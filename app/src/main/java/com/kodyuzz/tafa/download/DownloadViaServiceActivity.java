package com.kodyuzz.tafa.download;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

public class DownloadViaServiceActivity extends AppCompatActivity {
    public static final int MY_REQUEST = 23;
    private static final String TAG = "DownloadViaServiceActiv";
    String urlAdress = "https://github.com/gopinathankm/Java-Training-2018/raw/master/OCP%20Oracle%20Certified%20Professional%20Java%20SE%208%20Programmer%20II%20Study%20Guide%20Exam%201Z0-809.pdf";
    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                Log.v(TAG, "Permission is granted");
                //File write logic here
                start();
            } else {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_REQUEST);
            }
        } else {
            start();
        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_REQUEST) {
            for (int i = 0; i < permissions.length; i++) {
                if (permissions[i] == Manifest.permission.WRITE_EXTERNAL_STORAGE && grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    start();

                }
            }
        }
    }

    private void start() {
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.show();
        Intent intent = new Intent(this, DownloadService.class);
        intent.putExtra("url", urlAdress);
        intent.putExtra("receiver", new DownloadReceiver(new Handler()));
        Log.d(TAG, "start: the name of thread " + Thread.currentThread().getName());
        startService(intent);
    }

    private void openPdf() {
        File file = new File(getApplicationInfo().dataDir, "a.pdf");
        Intent intent = new Intent();
        intent.setPackage("com.adobe.reader");
        intent.setDataAndType(Uri.fromFile(file), "application/pdf");
        startActivity(intent);
    }

    private class DownloadReceiver extends ResultReceiver {

        public DownloadReceiver(Handler handler) {
            super(handler);
        }

        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {

            super.onReceiveResult(resultCode, resultData);

            if (resultCode == DownloadService.UPDATE_PROGRESS) {

                int progress = resultData.getInt("progress"); //get the progress
                mProgressDialog.setProgress(progress);

                if (progress == 100) {
                    mProgressDialog.dismiss();
                    openPdf();
                }
            }
        }


    }
}
