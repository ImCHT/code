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
        //ʹ��try with resource
        try(Connection c = DriverManager.getConnection("basic.jdbc:mysql://localhost:3306/tmall_springboot?useUnicode=true&characterEncoding=utf8",
                "root","admin");
            Statement s = c.createStatement();
        )
        {
			//��ֹsqlע��
			// s.parparedStatement("insert into category values (null,'���Է���%d')");
			// s.setInt(1);
			// s.excute();
			// s.close();
            //����SQL��䣬��sִ��
            for (int i = 0; i < 10; i++) {
                String sqlFormat = "insert into category values (null,'���Է���%d')";
                String sql = String.format(sqlFormat,i);
                s.execute(sql);
            }
            System.out.println("�ѳɹ�ִ��sql���");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
