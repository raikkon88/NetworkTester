package com.company.Runnables;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequestRunnable implements Runnable {

    Exception _exception = null;
    String _host;


    public HttpRequestRunnable(String host){
        _host = host;
    }

    @Override
    public void run() {
        try {
            getHTML(_host);
        } catch (Exception e) {
            _exception = e;
        }
    }


    public static void getHTML(String urlString) throws Exception{
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        System.out.println(result.toString());
    }
}
