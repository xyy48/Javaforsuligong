package com.neusoft;

import com.neusoft.domain.emp;

import java.sql.*;


public class JDBCDemo5 {
    public static void main(String[] args) throws Exception{
//        1.导入驱动jar包，建立libs文件夹，右键add as library
//        2.注册驱动
        Class.forName("com.mysql.jdbc.Driver");


//        3.获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://"+
                "localhost:3306/suligong","root","123456");
//        4.定义SQL
        String sql="select * from emp";
//        5.获取数据库连接对象statement
        Statement stmt=conn.createStatement();
//        6.执行SQL
        ResultSet rs=stmt.executeQuery(sql);
//        7.处理结果
//        while (rs.next()){
//            int id = rs.getInt(1);
//            String name = rs.getString(2);
//            double balance = rs.getDouble(3);
//            System.out.println(id+"----"+name+"----"+balance);
//        }
//        while (rs.next()){
//            int EMPNO= rs.getInt("EMPNO");
//            String ENAME = rs.getString("ENAME");
//            String JOB = rs.getString("JOB");
//            int MGR= rs.getInt("MGR");
//            Date HIREDATE=rs.getDate("HIREDATE");
//            int SAL= rs.getInt("SAL");
//            int COMM= rs.getInt("COMM");
//            int DEPTNO= rs.getInt("DEPTNO");

           // System.out.println(EMPNO+"--"+ENAME+"--"+JOB+"--"+MGR+"--"+HIREDATE+"--"+SAL+"--"+COMM+"--"+DEPTNO);
       // }
        rs.next();
            int EMPNO= rs.getInt("EMPNO");
            String ENAME = rs.getString("ENAME");
            String JOB = rs.getString("JOB");
            int MGR= rs.getInt("MGR");
            Date HIREDATE=rs.getDate("HIREDATE");
            int SAL= rs.getInt("SAL");
            int COMM= rs.getInt("COMM");
            int DEPTNO= rs.getInt("DEPTNO");
            emp emp1=new emp(EMPNO,ENAME,JOB,MGR,HIREDATE,
                    SAL,COMM,DEPTNO);
        System.out.println(emp1);

//        8.释放资源
        stmt.close();
        conn.close();
    }
}
