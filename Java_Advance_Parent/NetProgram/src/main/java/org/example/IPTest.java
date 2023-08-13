package org.example;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPTest {
    public static void main(String[] args) {
        try {
            InetAddress ia = InetAddress.getLocalHost();
//            InetAddress ia = InetAddress.getByName("www.baidu.com");
            System.out.println(ia.getHostName());
            System.out.println(ia.getHostAddress());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
