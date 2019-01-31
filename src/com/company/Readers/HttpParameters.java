package com.company.Readers;

import com.company.Actions.Action;
import com.company.Actions.IncrementalAction;
import com.company.Actions.SimultanousAction;
import com.company.Runnables.HttpRequestRunnable;

import java.util.HashMap;

public class HttpParameters extends BasicParameters {

    protected String _host;

    public HttpParameters(HashMap<String, String> parameterValues, String host) {
        super(parameterValues);
        _host = host;
    }

    public String getHost(){
        return _host;
    }

    public Action createAction(){
        if(isIncremental()){
            return new IncrementalAction(
                    new HttpRequestRunnable(getHost()),
                    getRequestsNumber(),
                    getIncrement(),
                    getDelayInMillis());
        }
        else {
            return new SimultanousAction(new HttpRequestRunnable(getHost()), getRequestsNumber());
        }
    }

}
