package com.example.serv;

/**
 * Created by Agneev on 22-04-2016.
 */
import com.example.server.vo.Content;

public class App {
    public static void main(String[] args) {

        System.out.println("Sending POST to GCM");

        String apiKey = "AIzaSyAtIO2uIsab99P58REOY8dfv0_jwg_oRfE";
        Content content = createContent();

        Post2Gcm.post(apiKey, content);
    }

    public static Content createContent() {
        Content c = new Content();

        c.addRegId("APA91bF0YOtrFEkK8IOwxeQ3jE_Ew9U9EKSE6EkP1KIQmqHDQqWmyeoSj31lYZYdRauNSinmq1rztGl3K4YQkGZLjLUcYrYsBO03zscPrmfo7O8utq_qC-hgFjv0w5RmGXp7orxcTO66");

        c.createData("Glynn", "Anor Londo");

        return c;
    }
}

