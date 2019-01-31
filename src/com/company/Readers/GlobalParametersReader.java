package com.company.Readers;

import java.util.HashMap;

public class GlobalParametersReader {

    HashMap<String, String> _parameters;
    HashMap<String, Boolean> _validParams;


    public GlobalParametersReader(){
        _parameters = new HashMap<>();

        _validParams = new HashMap<>();
        _validParams.put("-I", true);
        _validParams.put("-n", true);
        _validParams.put("-d", true);
        _validParams.put("-i", true);
    }

    public HashMap<String, String> read(String[] args, int start) throws Exception {
        while (start < args.length){
            if(_validParams.get(args[start])){
                if(args[start].equals("-I")){
                    insertParam(args[start], "");
                    start++;
                }
                else{
                    if(start + 1 >= args.length) throw new Exception("The parameter " + args[start] + " needs a value");
                    else{
                        insertParam(args[start], args[start + 1]);
                    }
                    start+=2;
                }
            }
            else{
                throw new Exception("The param " + args[start] + " is not valid.");
            }
        }
        return _parameters;
    }

    private void insertParam(String key, String value){
        if (_parameters.containsKey(key)) {
            _parameters.replace(key, value);
        } else {
            _parameters.put(key, value);
        }
    }

}
