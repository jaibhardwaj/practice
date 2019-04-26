package com.practice.junit.maven_junit_example;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	AppTest	.class,
	AppTest2.class
})
public class AppTestSuit {

}
