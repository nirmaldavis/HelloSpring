package com.nirmal.spring.hello;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	

	App app = null;
	
    @Override
	protected void setUp() throws Exception {

		super.setUp();
		app = new App();
	}

	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    public void testSayHelloWithSpring() {
    	
    	String text = "Spring World..!!";
		String helloWithSpringActual = app.sayHelloWithSpring(text );
		assertEquals("Hello, "+text, helloWithSpringActual);
		
    }
}
