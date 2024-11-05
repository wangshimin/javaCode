package day33_Socketnet.a10_test;

import java.util.UUID;

public class UUIDTest {
    public static void main(String[] args) {
        String str = UUID.randomUUID().toString().replace("-", "");
        System.out.println(str); // 35e0cb5ecfa5429c82a1b0dbacbc4b1c
    }
}
