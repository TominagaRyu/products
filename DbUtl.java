package products;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtl {
    public static Connection getConnection(){
        try{
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_exam","testuser","test");
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}