import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class csvTodb {


    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, SQLException {
        String fileName = "/Users/stepurkoolksandr/HillelProMarkII2022/mvn/jdbc/src/main/students.csv";

        List<Student> lines = new CsvToBeanBuilder(new FileReader(fileName))
                .withType(Student.class)
                .withSeparator(',')
                .build()
                .parse();

        Class.forName("com.mysql.jdbc.Driver"); // driver registration
        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/hillel2023?"
                        + "useSSL=false&user=root&password=rootroot&serverTimezone=UTC");


        PreparedStatement preparedStatement = connection.prepareStatement("insert into  student (first_name, last_name) value  (?, ?)");
        for (Student s : lines) {
            preparedStatement.setString(1, s.getFirstName());
            preparedStatement.setString(2, s.getLastName());
            preparedStatement.executeUpdate();
            System.out.println("add into db value : " + s);
        }



    }
}
