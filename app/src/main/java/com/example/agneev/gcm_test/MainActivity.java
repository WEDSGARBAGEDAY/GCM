package com.example.agneev.gcm_test;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.gcm.GoogleCloudMessaging;

import java.io.IOException;


public class MainActivity extends AppCompatActivity implements OnClickListener{

    Button btnRegId;
    Button btnSndMsg;
    EditText etRegId;
    GoogleCloudMessaging gcm;
    String regid;
    String PROJECT_NUMBER = "783684119799";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegId = (Button) findViewById(R.id.button_get_id);
        etRegId = (EditText) findViewById(R.id.edit_text_id);
        btnSndMsg = (Button) findViewById(R.id.button);

        btnRegId.setOnClickListener(this);
        btnSndMsg.setOnClickListener(this);
    }

    public void getRegId() {
        new AsyncTask<Void, Void, String>() {

            @Override
            protected String doInBackground(Void... params) {
                String msg = "";
                try {
                    if(gcm == null) {
                        gcm = GoogleCloudMessaging.getInstance(getApplicationContext());
                    }

                    regid = gcm.register(PROJECT_NUMBER);
                    msg = "Device registered, registration ID=" + regid;
                    Log.i("GCM", "!!!!! " + regid);

                } catch(IOException ex) {
                    msg = "Error: " + ex.getMessage();
                }
                return msg;
            }

            @Override
            protected void onPostExecute(String msg) {
                etRegId.setText(msg);
            }
        }.execute(null, null, null);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_get_id:
                getRegId();
                break;
            case R.id.button:
                sendMessage();
                break;
        }
    }

    public void sendMessage(){
        Log.i("GCM", "Sending message");
        Message message = new Message(getString(R.string.API_KEY), "APA91bF0YOtrFEkK8IOwxeQ3jE_Ew9U9EKSE6EkP1KIQmqHDQqWmyeoSj31lYZYdRauNSinmq1rztGl3K4YQkGZLjLUcYrYsBO03zscPrmfo7O8utq_qC-hgFjv0w5RmGXp7orxcTO66",
                "Glynn", "Anor Londo");
        Thread sender = new Thread(message);
        sender.start();
    }
}

