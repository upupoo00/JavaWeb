import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestMysql {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/test0311?useSSL=true";
        String username = "root";
        String password = "000524";
        //1.创建dataSource实例， 并设置数据库相关参数
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL(url);
        ((MysqlDataSource)dataSource).setUser(username);
        ((MysqlDataSource)dataSource).setPassword(password);
        // 2. 和数据库建立连接
         Connection connection =  dataSource.getConnection();
         //3. 访问数据库，需要先拼装一个sql语句
        String sql= "select *from student";
        PreparedStatement statement = connection.prepareStatement(sql);
        //4.执行 sql
        ResultSet resultSet = statement.executeQuery();
        //5.遍历结果集
        //  每次调用next方法，就可以获得一条记录
        //  进一步使用get方法，获得对应的列的数据
        while(resultSet.next()){
            System.out.println(resultSet.getInt("id"));
            System.out.println(resultSet.getInt("sn"));
            System.out.println(resultSet.getString("name"));
            System.out.println(resultSet.getString("qq_mail"));
            System.out.println(resultSet.getInt("classes_id"));
            resultSet.close();
            statement.close();
            connection.close();
        }

    }
}
