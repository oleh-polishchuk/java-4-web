package com.geekhub.lesson11;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ConfigTest.class,
        CrawlerTest.class,
        HelperTest.class
})
public class AllTests {

}
