package com.company.Builders;

public class UniqueParam extends ParamDecorator {

    private Instruction _instruction;

    public UniqueParam(Instruction instruction, String name, String value){
        _instruction = instruction;
        _command = " " + name + " " + value;
    }

    @Override
    public String getCommand() {
        return _instruction.getCommand() + _command;
    }
}
