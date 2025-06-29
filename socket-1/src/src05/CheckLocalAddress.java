package src05;

import java.net.InetAddress;

public class CheckLocalAddress {
    public static void main(String[] args) {
        try{
            // IP Address
        InetAddress addr = InetAddress.getByName("8.8.8.8");
        // Host name
        System.out.println("Host name is: " + addr.getHostName());
        // Host Address
        System.out.println("Ip address is: " + addr.getHostAddress());
        System.out.println("Ipv4 address is:" + InetAddress.getLocalHost());
        }catch(Exception e){
            System.err.println(e);
        }
    }
}
