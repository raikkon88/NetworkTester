package com.company.Readers;

import com.company.Actions.Action;
import com.company.Actions.IncrementalAction;
import com.company.Actions.SimultanousAction;
import com.company.Builders.ARPing;
import com.company.Builders.Instruction;
import com.company.Builders.UniqueParam;
import com.company.Runnables.CmdRunnable;

import java.util.HashMap;

public class ARPingParameters extends HttpParameters {

    protected String _mac;

    public ARPingParameters(HashMap<String, String> parameterValues, String host, String mac) {
        super(parameterValues, host);
        _mac = mac;
    }

    public String getMac(){
        return _mac;
    }

    public Action createAction(){

        Instruction instruction = new UniqueParam(new ARPing(), "-d", getHost());
        instruction = new UniqueParam(instruction, "-p", ""); // Using inet with promiscuous mode.
        instruction = new UniqueParam(instruction, "-s", getMac());
        instruction = new UniqueParam(instruction, "-c", Integer.toString(1));
        instruction = new UniqueParam(instruction, "-u", "");
        if(isIncremental()) {
            return new IncrementalAction(new CmdRunnable(instruction), getRequestsNumber(),getIncrement(), getDelayInMillis());
        }
        else {
            return new SimultanousAction(new CmdRunnable(instruction), getRequestsNumber());
        }
    }
}
