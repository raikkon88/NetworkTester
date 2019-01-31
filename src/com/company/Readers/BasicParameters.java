package com.company.Readers;

import com.company.Actions.Action;

import java.util.HashMap;

public abstract class BasicParameters {

    protected int _requestsNumber;
    protected HashMap<String, String> _parameterValues;


    public BasicParameters(HashMap<String, String> parameterValues){
        _parameterValues = parameterValues;
        _requestsNumber = Integer.parseInt(_parameterValues.get("-n"));

    }

    public abstract Action createAction();

    public int getRequestsNumber(){
        return _requestsNumber;
    }

    public boolean isIncremental(){
        return _parameterValues.containsKey("-I");
    }

    public int getDelayInMillis(){
        return Integer.parseInt(_parameterValues.get("-d"));
    }

    public int getIncrement(){
        return Integer.parseInt(_parameterValues.get("-i"));
    }

}
