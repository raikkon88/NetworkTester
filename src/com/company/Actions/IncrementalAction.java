package com.company.Actions;

public class IncrementalAction extends Action {

    private int _increment;
    private long _delay;
    private int _maxNumberOfRequests;

    public IncrementalAction(Runnable runnable, int maxRequests, int increment, long delayInMillis){
        super(runnable, increment);
        _increment = increment;
        _delay = delayInMillis;
        _maxNumberOfRequests = maxRequests;
    }

    @Override
    public void execute() throws InterruptedException {
        _maxRequests = _increment;
        while(_maxRequests < _maxNumberOfRequests){
            doRequests();
            Thread.sleep(_delay);
            _maxRequests += _increment;
        }
        if(_maxRequests != _maxNumberOfRequests){
            _maxRequests =_maxNumberOfRequests;
            doRequests();
        }

    }
}
