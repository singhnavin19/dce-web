package com.nav.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.core.annotation.Order;

public class NavTest {


	@BeforeClass
	public static void beforeClass() {
		System.out.println("before class");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("after class");
	}


	@Test
	@Order(3)
	public void helloTest() {
		System.out.println("helloTest");
		String s = "hello";
		assertEquals("hello", s);
		assertNotNull(s);
	}

	@Test
	@Order(2)
	public void worldTest() {
		System.out.println("worldTest");
	}

	@After
	public void after() {
		System.out.println("after");
		System.out.println("-----------------");

	}

	@Before
	public void before() {
		System.out.println("-----------------");
		System.out.println("before");
	}

}
