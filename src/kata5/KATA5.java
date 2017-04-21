package kata5;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.io.IOException;

public class KATA5 {
    
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        String fileName = "C:\\Users\\moises\\Desktop\\KATA5\\KATA5\\kata5.db";
        ArrayList<String> read = MailListReader.readFromDb(fileName);
        /*for(String element : read) {
            System.out.println(element);
        }*/  
        Histogram <String> hm = MailHistogramBuilder.build(read);
        
        new HistogramDisplay(hm).execute();
        
    }

}
