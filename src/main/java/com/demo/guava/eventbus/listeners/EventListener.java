package com.demo.guava.eventbus.listeners;

import com.demo.guava.eventbus.msg.MsgEvent;
import com.google.common.eventbus.Subscribe;

/**
 * Created by liliang on 2017/1/5.
 */
public class EventListener {
    public int lastMessage = 0;

    @Subscribe
    public void listen(MsgEvent event) {
        lastMessage = event.getMessage();
        System.out.println("Message:"+lastMessage);
    }

    public int getLastMessage() {
        return lastMessage;
    }
}
