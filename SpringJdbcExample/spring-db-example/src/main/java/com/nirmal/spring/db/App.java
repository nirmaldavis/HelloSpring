package com.nirmal.spring.db;

import org.hsqldb.util.DatabaseManagerSwing;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nirmal.spring.db.conf.DbConfig;
import com.nirmal.spring.db.dao.EmployeeDAO;
import com.nirmal.spring.db.model.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello Spring DB World!" );
        
        DatabaseManagerSwing.main(new String[]{"--url", "jdbc:hsqldb:mem:testdb", "--user", "sa", "--password", ""});
        
        ConfigurableApplicationContext context = SpringApplication.run(DbConfig.class);
        Employee employee = new Employee(3, "Harsh", "Scrum Master");
        EmployeeDAO dao = context.getBean(EmployeeDAO.class);
        dao.save(employee);
        
        

    }
}
