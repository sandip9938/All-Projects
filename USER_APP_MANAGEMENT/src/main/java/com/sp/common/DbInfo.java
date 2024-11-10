package com.sp.common;

/**
 * This class holds the database connection information for the application.
 */
public class DbInfo {
    public static final String driver = "oracle.jdbc.driver.OracleDriver"; // JDBC Driver
    public static final String dburl = "jdbc:oracle:thin:@localhost:1521:orcl"; // Database URL
    public static final String uname = "system"; // Database username
    public static final String upwd = "root"; // Database password
}

