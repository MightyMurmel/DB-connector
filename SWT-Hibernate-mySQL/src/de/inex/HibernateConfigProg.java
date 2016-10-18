//package de.inex;
//
//import org.hibernate.Session;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.annotations.*;
//
//public class HibernateConfigProg {
//	
//	public static Session session;
//
//	static
//	{
//	Configuration config = new Configuration();
//	
////	--------- Database connection settings ----------
//	config.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
//	config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost3306/testdb");
//	config.setProperty("hibernate.connection.username", "testuser");
//	config.setProperty("hibernate.connection.password", "testpwd");
//	
////	-----JDBC connection pool (use the built-in)-----
//	config.setProperty("hibernate.connection.pool_size", "10");
//	
////	------------------ SQL dialect ------------------
//	config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//	
////	-------- Echo all executed SQL to stdout --------
//	config.setProperty("hibernate.show_sql", "true");
//	
////	-- Drop the existing tables and create new one --
//	config.setProperty("hibernate.hbm2ddl.auto", "update");
//	
////	-- Mention here all the model classes along with their package name --
////	config.getMa
//	
//	}
//}
//
//
