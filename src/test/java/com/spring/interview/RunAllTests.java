package com.spring.interview;

import com.spring.interview.api.BookControllerTest;
import com.spring.interview.service.BookServiceTest;
import com.spring.interview.service.ReviewServiceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BookServiceTest.class,
        ReviewServiceTest.class,
        BookControllerTest.class
})
public class RunAllTests {
}
