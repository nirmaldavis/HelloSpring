package com.nirmal.spring.db;

import org.hsqldb.util.DatabaseManagerSwing;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nirmal.spring.db.conf.DbConfig;
import com.nirmal.spring.db.dao.EmployeeDAO;
import com.nirmal.spring.db.model.Employee;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
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
        DatabaseManagerSwing.main(new String[]{"--url", "jdbc:hsqldb:mem:testdb", "--user", "sa", "--password", "", "--noexit"});
        
        ConfigurableApplicationContext context = SpringApplication.run(DbConfig.class);
        Employee employee = new Employee(3, "Harsh", "Scrum Master");
        EmployeeDAO dao = context.getBean(EmployeeDAO.class);
        dao.save(employee);
        
        Employee employeeById = dao.getById(3);
        System.out.println("employeeById : " + employeeById);
        
        assertEquals("Harsh", employeeById.getName());
    }
}
