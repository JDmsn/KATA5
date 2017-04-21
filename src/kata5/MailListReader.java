package kata5;

import java.io.BufferedReader;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MailListReader {
    
    public static ArrayList<String> readFromDb(String name) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        
        ArrayList<String> mlList = new ArrayList<>();
        Class.forName("org.sqlite.JDBC");
        Connection c = DriverManager.getConnection("jdbc:sqlite:"+name);
        
        //For online
        //Class.forName("oracle.jdbc.driver.OracleDriver");
        //Connection c = DriverManager.getConnection("jdbc:oracle:thin:@10.22.143.90:1521:orcl","system","orcl");

        Statement stnt = c.createStatement();
  
        ResultSet rst = stnt.executeQuery("SELECT * FROM MAIL");
        String ml;
        while(rst.next()) {
            ml = rst.getString("MAIL");
            if(!ml.contains("@")) continue;
            mlList.add(ml);
        }

        rst.close();
        stnt.close();
        c.close();

        return mlList;
    }
        
    public static ArrayList<String> readFromFile(String name) throws FileNotFoundException, IOException {
        ArrayList<String> mlList = new ArrayList<>();
        
        BufferedReader fileRead = new BufferedReader(new FileReader(new File(name)));
        String ml;
        while((ml=fileRead.readLine())!= null) {
            if(!ml.contains("@")) continue;
            mlList.add(ml);
        }
        
        return mlList;
    }
    
}
