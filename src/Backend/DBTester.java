package Backend;
import com.healthmarketscience.jackcess.Row;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Audi
 */
public class DBTester {
    public static void main(String[] szArg)
    {
        Admin_Updated admin = new Admin_Updated();
        File file = new File("kioskdb1.accdb");
        try
        {
            
          admin.openDatabase(file);
          ArrayList<ArrayList<String>> table = admin.read("visits");
          System.out.println("\n\nAll Users Data\n\n");
          for(ArrayList user : table)
          {
              for(Object string : user)
                  System.out.println(string);
          }
          
          table = admin.read("visits","steve@whatever.com");
          System.out.println("\n\nSteve's Data\n\n");
          for(ArrayList user : table)
          {
              for(Object string : user)
                  System.out.println(string);
          }
            admin.closeDatabase();//Always close the database when done with it!
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
