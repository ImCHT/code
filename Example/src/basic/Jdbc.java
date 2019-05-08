package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc {
    public static void main(String[] args){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //使用try with resource
        try(Connection c = DriverManager.getConnection("basic.jdbc:mysql://localhost:3306/tmall_springboot?useUnicode=true&characterEncoding=utf8",
                "root","admin");
            Statement s = c.createStatement();
        )
        {
			//防止sql注入
			// s.parparedStatement("insert into category values (null,'测试分类%d')");
			// s.setInt(1);
			// s.excute();
			// s.close();
            //定义SQL语句，用s执行
            for (int i = 0; i < 10; i++) {
                String sqlFormat = "insert into category values (null,'测试分类%d')";
                String sql = String.format(sqlFormat,i);
                s.execute(sql);
            }
            System.out.println("已成功执行sql语句");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
