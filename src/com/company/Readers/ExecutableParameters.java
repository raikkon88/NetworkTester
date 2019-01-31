package com.company.Readers;

import com.company.Actions.Action;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.HashMap;

public class ExecutableParameters extends BasicParameters {

    public ExecutableParameters(HashMap<String, String> parameterValues) {
        super(parameterValues);
    }

    @Override
    public Action createAction() {
        throw new NotImplementedException();
    }

}
