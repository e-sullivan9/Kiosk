package Backend;

import com.healthmarketscience.jackcess.ColumnBuilder;
import com.healthmarketscience.jackcess.Column;
import com.healthmarketscience.jackcess.Index;
import com.healthmarketscience.jackcess.IndexBuilder.*;
import com.healthmarketscience.jackcess.Cursor;
import com.healthmarketscience.jackcess.DataType;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.IndexBuilder;
import com.healthmarketscience.jackcess.Row;
import com.healthmarketscience.jackcess.Table;
import com.healthmarketscience.jackcess.TableBuilder;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Audi
 */
public class Admin {

    private File dbFile;
    private Database db;
    private ArrayList<AdminAccount> admins = new ArrayList<AdminAccount>();

    private Cursor cursor;
    
    /*
     *   The GUI should catch any IOException thrown by the class
     */

    public Admin() {
    	admins.add(new AdminAccount("username", "password"));
    }
    
    public void addAdmin(String username, String password)
    {
    	admins.add(new AdminAccount(username, password));
    }

    //prints out the whole table as given
    public void readTable(Table tab) throws IOException {

//        Table table = db.getTable(query);
        for (Row row : tab) {
            System.out.println(row);
        }
    }

    //also prints the whole table but with ArrayList
    public ArrayList<Row> read(Database db, String query) throws IOException {

        ArrayList<Row> rowList = new ArrayList<Row>();

        Table table = db.getTable(query);
        for (Row row : table) {
            System.out.println(row.toString());//for testing
            rowList.add(row);
        }
        return rowList;

    }
    
    
    public void checkCol(Database db, Table tab) throws IOException {

        tab = db.getTable("visits");

        ArrayList<Row> rowList = new ArrayList<Row>();

        for (Row row : tab) {
            for (Column column : tab.getColumns()) {
                String columnName = column.getName();
                Object value = row.get(columnName);
                System.out.println("Column " + columnName + "(" + column.getType() + "): "
                        + value + " (" + value.getClass() + ")");
            }
            System.out.println();
        }
    }
       
        
    
    
    
    
    
    
    
    
    
    
    

    public void deleteRow(String query, String key){
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deleteAll(String query)
            throws IOException {
    	Data.open();
        Table table = Data.chooseTable(query);
        for (Row row : table) {
            table.deleteRow(row);
        }
        Data.closeData();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deleteDatabase()
            throws IOException {
        closeDatabase();
        dbFile.delete();
        dbFile = null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void createDatabase(File dbFile)
            throws IOException {

        DatabaseBuilder.create(Database.FileFormat.V2010, new File("jTest.accdb"));

        if (db != null) {
            closeDatabase();
        }
        this.dbFile = dbFile;
        db = DatabaseBuilder.create(Database.FileFormat.V2010, dbFile);
        DatabaseBuilder.open(dbFile);
        try {
            Table visits = new TableBuilder("visits").
                    addColumn(new ColumnBuilder("visitDate").setSQLType(Types.DATE)).
                    addColumn(new ColumnBuilder("visitTime").setSQLType(Types.TIME)).
                    addColumn(new ColumnBuilder("reason").setSQLType(Types.VARCHAR)).
                    addColumn(new ColumnBuilder("followUp", DataType.BOOLEAN)).
                    addColumn(new ColumnBuilder("email").setSQLType(Types.VARCHAR)).
                    addColumn(new ColumnBuilder("ID", DataType.LONG).setAutoNumber(true)).
                    toTable(db);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            Table users = new TableBuilder("user").
                    addColumn(new ColumnBuilder("fName").setSQLType(Types.VARCHAR)).
                    addColumn(new ColumnBuilder("lName").setSQLType(Types.VARCHAR)).
                    addColumn(new ColumnBuilder("email").setSQLType(Types.VARCHAR)).
                    addColumn(new ColumnBuilder("phone").setSQLType(Types.INTEGER)).
                    addColumn(new ColumnBuilder("role").setSQLType(Types.VARCHAR)).
                    toTable(db);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void closeDatabase()
            throws IOException {
        db.close();
        db = null;
    }

    Set<String> getTableNames() throws IOException {
        Set<String> ts = db.getTableNames();
        return ts;
    }
}
