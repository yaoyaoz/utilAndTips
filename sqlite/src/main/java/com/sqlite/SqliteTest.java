package com.sqlite;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * sqlite数据库连接测试类
 * <p>
 * Created by yaoyao on 2019/9/16.
 */
public class SqliteTest {

    public static void main(String[] args) {

        Connection connection = null;
        Statement stmt = null;
        PreparedStatement preparedStatement = null;
        try {
            /**
             * 1、连接数据库：
             * 如果数据库不存在，那么它就会被创建，最后将返回一个数据库对象。
             */
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("Opened database successfully");

            //2、创建表
//            stmt = connection.createStatement();
//            String sql = "CREATE TABLE COMPANY " +
//                    "(ID INTEGER PRIMARY KEY  AUTOINCREMENT," +
//                    " NAME           TEXT, " +
//                    " AGE            INT, " +
//                    " ADDRESS        CHAR(50), " +
//                    " SALARY         REAL)";
//            stmt.executeUpdate(sql);

            //3、insert
            String insertSql = "insert into COMPANY (NAME,AGE,ADDRESS,SALARY) values(?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(insertSql);
            if(preparedStatement==null){
                System.out.println("sql语句错误，insertSql=" + insertSql);
            }
            DateFormat dateFormat = new SimpleDateFormat("hhmmss");
            String dateString = dateFormat.format(new Date());
            preparedStatement.setInt(1, Integer.valueOf(dateString));
            preparedStatement.setString(2, "Paul");
            preparedStatement.setInt(3, 32);
            preparedStatement.setString(4, "California");
            preparedStatement.setBigDecimal(5,new BigDecimal("20000.00"));
            int ret=preparedStatement.executeUpdate();
            System.out.println("insert ret=" + ret);


//            insertSql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
//                    "VALUES (2, 'Allen', 25, 'Texas', 15000.00 );";
//            stmt.executeUpdate(insertSql);
            System.out.println("Records created successfully");

            preparedStatement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }

    }

}
