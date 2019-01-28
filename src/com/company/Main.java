package com.company;


public class Main {

    static final int N_PET = 1;

    public static void main(String[] args) {
        String cmd = "sudo /usr/sbin/arping -d 192.168.3.1 -p -s 11:11:11:11:11:11";
        bash(cmd);
    }


    /**
     * Instructions for arping usage
     *
     * Install arping :
     *
     * sudo apt-get update
     * sudo apt-get install arping
     *
     * Then edit /etc/sudoers and give permission to execute arping
     *
     * <USERNAME>    ALL=(ALL) NOPASSWD:/usr/sbin/arping
     *
     */

    public static void bash(String cmd) {
        for (int i = 0; i < N_PET; i++){
            int number = new Integer(i);
            new Thread(new CmdRunnable(cmd, number)).start();
        }
    }


    public static void http(){
        for (int i = 0; i < N_PET; i++){
            int number = new Integer(i);
            new Thread(new HttpRequestRunnable(number)).start();
        }
    }

}
