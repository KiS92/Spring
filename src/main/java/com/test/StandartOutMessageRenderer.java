package com.test;

/**
 * Created or updated by KiS92 on 01.04.2016:21:47.
 */
public class StandartOutMessageRenderer implements MessageRenderer {
    private MessageProvider messageProvider;

    @Override
    public void render() {
        if (messageProvider == null)
            throw new RuntimeException("you must set messageProvider of class:" + this.getClass().getName());
        System.out.println(messageProvider.getMessage());
    }

    @Override
    public MessageProvider getMessageProvider() {
        return messageProvider;
    }

    @Override
    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }
}
