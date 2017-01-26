package com.geekhub.lesson11;

import com.geekhub.lesson10.Config;
import com.geekhub.lesson10.Helper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class HelperTest {

    Helper helper = null;

    @Before
    public void setUpTest() {
        helper = new Helper(new Config());
    }

    @Test
    public void getLinks() {
        Properties mockedConfig = Mockito.mock(Config.class);
        when(mockedConfig.getProperty("links.path")).thenReturn("C:/workspace/java-4-web/src/main/resources/links.txt");

        ArrayList<String> expected = new ArrayList<>();
        expected.add("https://habrahabr.ru/post/318118/");
        expected.add("https://habrahabr.ru/post/317578/");
        expected.add("https://habrahabr.ru/post/317970/");
        expected.add("https://habrahabr.ru/post/317928/");

        ArrayList<String> actual = new ArrayList<>();
        try {
            actual = helper.getLinks(mockedConfig);
        } catch (IOException e) {
            System.out.println(e);
        }
        assertEquals(expected, actual);
    }
}
