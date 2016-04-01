package com.test;

/**
 * Created or updated by KiS92 on 01.04.2016:21:46.
 */
public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello";
    }
}
