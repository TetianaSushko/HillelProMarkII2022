import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {

    public static final String serverTimeZone = "UTC";
    public static final String serverName = "localhost"; // ip address db
    public static final String databaseName ="hillel2023"; // bd name
    public static final int portNumber = 3306; // db port
    public static final String user = "root"; // login
    public static final String password = "rootroot"; // password

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        MysqlDataSource dataSource = new MysqlDataSource();

        dataSource.setUseSSL( false );
        dataSource.setServerTimezone( serverTimeZone );
        dataSource.setServerName( serverName );
        dataSource.setDatabaseName( databaseName );
        dataSource.setPortNumber( portNumber );
        dataSource.setUser( user );
        dataSource.setPassword( password );


        Connection connection =  dataSource.getConnection();

        Statement statement = connection.createStatement();

//        statement.execute("create table hillel2023.student\n" +
//                "(\n" +
//                "    first_name varchar(255) not null,\n" +
//                "    last_name  varchar(255) not null\n" +
//                ");\n");
//        statement.execute("insert into  student (first_name, last_name) value  ('Ivan', 'Ivanov')");
//
//        PreparedStatement preparedStatement = connection.prepareStatement("insert into  student (first_name, last_name) value  (?, ?)");
//        List<String> users = List.of("user 1", "user 2", "user 3", "user 4");
//        for (String u : users) {
//            preparedStatement.setString(1, u);
//            preparedStatement.setString(2, u);
//            preparedStatement.executeUpdate();
//        }

        ResultSet rs = statement.executeQuery("select * from student");

        System.out.println("Table name : " + rs.getMetaData().getTableName(2)); //true
        System.out.println("------------");
        int columnCount = rs.getMetaData().getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            System.out.print("column name : " + rs.getMetaData().getColumnName(i) + ", ");
            System.out.print("column size : " + rs.getMetaData().getColumnDisplaySize(i) + ", ");
            System.out.println("column type : " + rs.getMetaData().getColumnTypeName(i));
        }
        List<Student> student = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            student.add(new Student(id, firstName, lastName));
        }
        System.out.println(student.size());
        System.out.println("----------");

        for (Student s : student)
            System.out.println(s);;

        connection.close();
    }
}
