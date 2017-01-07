package com.demo.guava.eventbus.msg;

/**
 * Created by liliang on 2017/1/5.
 */
public class MsgEvent {

    private final int message;

    public MsgEvent(int message) {
        this.message = message;
    }

    public int getMessage() {
        return message;
    }
}
