package com.company.Builders;

public class GenericInstruction extends Instruction {


    public GenericInstruction(String pathToExecutable){
        _command = pathToExecutable;
    }

    @Override
    public String getCommand() {
        return _command;
    }
}
