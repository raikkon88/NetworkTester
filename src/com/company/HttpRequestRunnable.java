package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequestRunnable implements Runnable {

    int _petitionNumber = -1;
    int _resultCode = 200;
    Exception _exception = null;


    public HttpRequestRunnable(int petitionNumber){
        _petitionNumber = petitionNumber;
    }

    @Override
    public void run() {
        try {
            getHTML("http://calxitu.ddns.net", _petitionNumber);
        } catch (Exception e) {
            _exception = e;
        }
    }

    public int getResultCode(){
        return _resultCode;
    }


    public static void getHTML(String urlString, Integer pet) throws Exception{
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
        System.out.println(pet + "->" + result.toString());
    }
}
