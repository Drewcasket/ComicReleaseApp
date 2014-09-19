package com.example.drew.hackdayproject;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

/**
 * Created by Drew on 9/17/14.
 */
public class ScrapeData {

    public String getWebData() {
        Connection.Response response = null;
        try {

            response = Jsoup
                    .connect("http://www.tfaw.com/Arriving-This-Week")
                    .timeout(7000)
                    .execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (response != null) return response.body();

        else return "Network connection error. Try again later";
    }
}
