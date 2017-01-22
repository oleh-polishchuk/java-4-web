package com.geekhub.lesson11;

import com.geekhub.lesson10.Config;
import com.geekhub.lesson10.Helper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertNotEquals;

public class HelperTest {

    Helper helper = null;

    @Before
    public void setUpTest() {
        helper = new Helper(new Config());
    }

    @Test
    public void getLinks() {
        ArrayList<String> expected = new ArrayList<>();
        expected.add("https://habrahabr.ru/");
        ArrayList<String> actual = new ArrayList<>();
        actual.add("https://habrahabr.ru/");
        try {
            actual = helper.getLinks();
        } catch (IOException e) {
            System.out.println(e);
        }
        assertNotEquals(expected, actual);
    }
}
