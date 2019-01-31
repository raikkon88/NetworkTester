package com.company.Builders;

public class ARPing extends Instruction {

    public ARPing(){
        _command = "sudo /usr/sbin/arping";
    }


    @Override
    public String getCommand() {
        return _command;
    }
}
