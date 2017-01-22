package com.geekhub.lesson11;

import com.geekhub.lesson10.Crawler;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class CrawlerTest {

    Crawler crawler = null;

    @Before
    public void setUpTest() {
        crawler = new Crawler();
    }

    @Test
    public void getContentByLinkReturnNotNull() throws IOException {
        String actual = crawler.getContentByLink("https://habrahabr.ru/post/318118/");
        assertTrue("We expect that returned content is not null", actual.length() > 0);
    }

    @Test
    public void getContentByBadLinkReturnNull() throws IOException {
        String actual = crawler.getContentByLink("");
        assertTrue("We expect that returned content is null", actual == null);
    }
}
