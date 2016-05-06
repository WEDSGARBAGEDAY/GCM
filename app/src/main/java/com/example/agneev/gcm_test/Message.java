package com.example.agneev.gcm_test;

import android.util.Log;

/**
 * Created by Agneev on 22-04-2016.
 */

public class Message implements Runnable{

    public Message(String api, String id, String n, String l){
        apiKey = api;
        regID = id;
        name = n;
        loc = l;
    }

    String apiKey;
    String regID;
    String name;
    String loc;

    public void sendMsg() {
        Log.i("GCM", "Sending Message");

        Content content = createContent();

        Post2Gcm.post(apiKey, content);
    }

    public Content createContent() {
        Content c = new Content();

        c.addRegId(regID);

        c.createData(name, loc);

        return c;
    }

    @Override
    public void run() {
        sendMsg();
    }
}

