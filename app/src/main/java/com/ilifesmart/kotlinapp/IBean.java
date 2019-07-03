package com.ilifesmart.kotlinapp;

public interface IBean {

    void postponeComputation(long delay, Runnable computation);
}
