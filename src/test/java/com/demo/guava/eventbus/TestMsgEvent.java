package com.demo.guava.eventbus;

import com.demo.guava.eventbus.listeners.EventListener;
import com.demo.guava.eventbus.msg.MsgEvent;
import com.google.common.eventbus.EventBus;
import org.junit.Test;

/**
 * Created by liliang on 2017/1/5.
 */
public class TestMsgEvent {

    @Test
    public void testMsgSubscribe()
    {
        EventBus eventBus = new EventBus("test");
        EventListener listener = new EventListener();

        eventBus.register(listener);

        eventBus.post(new MsgEvent(200));
        eventBus.post(new MsgEvent(300));
        eventBus.post(new MsgEvent(400));
        System.out.println("LastMessage:"+listener.getLastMessage());
    }
}
