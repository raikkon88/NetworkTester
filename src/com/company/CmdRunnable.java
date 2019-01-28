package com.company;

import java.io.IOException;

public class CmdRunnable implements Runnable {

    int _petitionNumber = -1;
    String _cmd = "";

    public CmdRunnable (String command, int petitionNumber){
        _cmd = command;
        _petitionNumber = petitionNumber;
    }

    @Override
    public void run() {
        try {
            System.out.println(_petitionNumber + " -> " + runCmd());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String runCmd() throws IOException {
        java.util.Scanner s = new java.util.Scanner(Runtime.getRuntime().exec(_cmd).getInputStream()).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
