package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created or updated by KiS92 on 28.03.2016:21:46.
 */
public class Hello {
    public static void main(String[] args) {
//        System.out.println("hello");

//        MessageProvider mp = new HelloWorldMessageProvider();
//        MessageRenderer mr = new StandartOutMessageRenderer();
//        mr.setMessageProvider(mp);
//        mr.render();

//        MessageRenderer mr = MessageSupportFactory.getInstance().getMessageRenderer();
//        MessageProvider mp = MessageSupportFactory.getInstance().getMessageProvider();
//        mr.setMessageProvider(mp);
//        mr.render();

        ApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/spring/app-context.xml");
        MessageRenderer messageRenderer = (MessageRenderer) ctx.getBean("renderer", MessageRenderer.class);
        MessageProvider messageProvider = (MessageProvider) ctx.getBean("provider", MessageProvider.class);
        messageRenderer.setMessageProvider(messageProvider);
        messageRenderer.render();

    }
}
