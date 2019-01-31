package com.company;


import com.company.Actions.Action;

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
public class Main {

    public static void main(String[] args) throws Exception {

        try {
            Action action = new ActionFactory().create(args);
            action.execute();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }


    }










}
