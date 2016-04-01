package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created or updated by KiS92 on 01.04.2016:21:47.
 */
public class MessageSupportFactory {
    private static MessageSupportFactory instance;

    static {
        instance = new MessageSupportFactory();
    }

    private MessageRenderer messageRenderer;
    private MessageProvider messageProvider;

    private MessageSupportFactory() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("msf.properties").getFile());
        if (!file.exists())
            throw new RuntimeException("msf.properties not found in resources");
        Properties props = new Properties();
        try (InputStream fileInputStream = new FileInputStream(file)) {
            props.load(fileInputStream);
            String rendererClass = props.getProperty("renderer.class");
            String providerClass = props.getProperty("provider.class");

            messageRenderer = (MessageRenderer) Class.forName(rendererClass).newInstance();
            messageProvider = (MessageProvider) Class.forName(providerClass).newInstance();

        } catch (ClassNotFoundException | IOException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static MessageSupportFactory getInstance() {
        return instance;
    }

    public MessageRenderer getMessageRenderer() {
        return messageRenderer;
    }

    public MessageProvider getMessageProvider() {
        return messageProvider;
    }


}
