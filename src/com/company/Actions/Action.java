package com.company.Actions;

public abstract class Action {

    protected int _maxRequests;
    protected Runnable _action;

    public Action(Runnable action, int maxRequests){
        _action = action;
        _maxRequests = maxRequests;
    }

    public abstract void execute() throws InterruptedException;

    public void doRequests(){
        for (int i = 0; i < _maxRequests; i++){
            new Thread(_action).start();
        }
    }

}
