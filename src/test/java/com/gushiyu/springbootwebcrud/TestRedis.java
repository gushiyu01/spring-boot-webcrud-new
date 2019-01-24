package com.gushiyu.springbootwebcrud;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;

public class TestRedis {
    @Test
    public void contextLoads() {
        Jedis jedis = new Jedis("192.168.57.131",7000);
        jedis.set("name", "gushiyu");
        String s = jedis.get("name");
        String s1 = jedis.get("sex");
        String s2 = jedis.type("gsy");
        Map map = jedis.hgetAll("gsy");
        System.out.println(s+":"+s1+":"+s2+":"+map);
        jedis.close();
    }
}
