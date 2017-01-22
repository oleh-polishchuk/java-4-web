package com.geekhub.lesson11;

import com.geekhub.lesson10.Config;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

public class ConfigTest {

    @Ignore("Config can not load config.properties")
    @Test
    public void getInstance() {
        Config expected = new Config();
        Config actual = new Config();
        assertSame("We expect that both instances are equals", expected, actual);
    }

    @Test
    public void getNotSameInstance() {
        Config expected = new Config();
        Config actual = new Config();
        assertNotSame("We expect that both instances are equals", expected, actual);
    }
}
