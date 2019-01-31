package com.company;

import com.company.Actions.Action;
import com.company.Readers.*;

import java.util.HashMap;

public class ActionFactory {

    private final String ACTION_HTTP = "http";
    private final String ACTION_ARPING = "arping";
    private final String ACTION_EXECUTABLE = "executable";

    private Action action;

    public ActionFactory() { }

    public Action create(String[] arguments) throws Exception {

        if(arguments.length < 1) throw new Exception("Not enought arguments");

        BasicParameters parameters = null;
        GlobalParametersReader reader = new GlobalParametersReader();
        HashMap<String, String> parameterValues = null;

        if (arguments[0].equals(ACTION_HTTP) && arguments.length > 2 && arguments.length < 7) {
            parameterValues = reader.read(arguments, 2);
            parameters = new HttpParameters( parameterValues, arguments[1]);
        } else if (arguments[0].equals(ACTION_ARPING) && arguments.length > 3 && arguments.length < 8) {
            parameterValues = reader.read(arguments, 3);
            parameters = new ARPingParameters(parameterValues, arguments[1], arguments[2]);
        } else if (arguments[0].equals(ACTION_EXECUTABLE) && arguments.length > 1) {
            parameterValues = reader.read(arguments, 1);
            parameters = new ExecutableParameters(parameterValues);
        } else {
            throw new Exception("Arguments must contains at first http, arping or executable");
        }

        return parameters.createAction();

    }




}
