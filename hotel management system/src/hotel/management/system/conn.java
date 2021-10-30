package hotel.management.system;
import java.sql.*;
public class conn {
    Statement s;Connection c;
    public conn(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql:///projecthms","root","3844");
            s=c.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
