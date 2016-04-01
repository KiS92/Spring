package com.test;

/**
 * Created or updated by KiS92 on 01.04.2016:21:47.
 */
public interface MessageRenderer {
    void render();

    MessageProvider getMessageProvider();

    void setMessageProvider(MessageProvider messageProvider);
}
