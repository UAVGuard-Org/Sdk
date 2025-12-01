package com.uavguard.sdk;

public abstract class Action {

    protected String name;
    protected byte[] packet;

    public Action(String name, byte[] packet) {
        this.name = name;
        this.packet = packet;
    }

    public String getName() {
        return name;
    }

    public byte[] getPacket() {
        return packet;
    }
}
