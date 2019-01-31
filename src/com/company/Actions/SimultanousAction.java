package com.company.Actions;

public class SimultanousAction extends Action {

    public SimultanousAction(Runnable action, int maxRequests) {
        super(action, maxRequests);
    }

    @Override
    public void execute() {
        doRequests();
    }

}
