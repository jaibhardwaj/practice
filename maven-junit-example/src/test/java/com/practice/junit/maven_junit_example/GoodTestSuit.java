package com.practice.junit.maven_junit_example;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@IncludeCategory(GoodTestCategory.class)
@ExcludeCategory(BadTestCategory.class)
@Suite.SuiteClasses({
	AppTest	.class
	//AppTest2.class
})
public class GoodTestSuit {

}
