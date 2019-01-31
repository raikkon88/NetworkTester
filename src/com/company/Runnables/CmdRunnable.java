package com.company.Runnables;

import com.company.Builders.Instruction;

import java.io.IOException;

public class CmdRunnable implements Runnable {

    /** ARPING EXAMPLE : "sudo /usr/sbin/arping -d 192.168.3.1 -p -s 11:11:11:11:11:11" **/
    private static String ARPING = "sudo /usr/sbin/arping";
    private static String D = " -d ";
    private static String PS = " -p -s ";

    Instruction _cmd;

    public CmdRunnable (Instruction command){
        _cmd = command;
    }

    @Override
    public void run() {
        try {
            System.out.println(runCmd());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String runCmd() throws IOException {
        java.util.Scanner s = new java.util.Scanner(Runtime.getRuntime().exec(_cmd.getCommand()).getInputStream()).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
