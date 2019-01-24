package com.gushiyu.springbootwebcrud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootWebcrudApplicationTests {

    @Test
    public void contextLoads() {
        Jedis jedis = new Jedis("192.168.57.131",7000);
        jedis.set("name", "gushiyu");
        String s = jedis.get("name");
        String s1 = jedis.get("sex");
        String s2 = jedis.type("gsy");
        Map map = jedis.hgetAll("gsy");
        System.out.println(s+s1+s2+map);
        jedis.close();
    }



}
