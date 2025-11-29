package com.uavguard.sdk;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.function.Consumer;

public interface Video {
    int getPort();
    void setup(DatagramSocket socket, InetAddress ip) throws Exception;
    void loop(DatagramSocket socket, InetAddress ip, byte[] data)
        throws Exception;
    void setCallback(Consumer<byte[]> callback);
}
