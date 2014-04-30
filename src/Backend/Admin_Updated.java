package Backend;
import com.healthmarketscience.jackcess.ColumnBuilder;
import com.healthmarketscience.jackcess.Column;
import com.healthmarketscience.jackcess.IndexBuilder.*;
import com.healthmarketscience.jackcess.Cursor;
import com.healthmarketscience.jackcess.DataType;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Row;
import com.healthmarketscience.jackcess.Table;
import com.healthmarketscience.jackcess.TableBuilder;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * 
 */
public class Admin_Updated {

    private File dbFile;
    private Database db;
    private ArrayList<AdminAccount> admins = new ArrayList<AdminAccount>();

    private Cursor cursor;
    
    /*
     *   The GUI should catch any IOException thrown by the class
     */

    public Admin_Updated() {
        db = null;
    	admins.add(new AdminAccount("username", "password"));
    }
    
    public void addAdmin(String username, String password)
    {
        db = null;
    	admins.add(new AdminAccount(username, password));
    }

    //prints out the whole table as given
    public void readTable(String query) throws IOException {

        Table table = db.getTable(query);
        for (Row row : table) {
            System.out.println(row);
        }
    }
    
    public ArrayList<ArrayList<String>> read(String query,String key) throws IOException
    {
        ArrayList<ArrayList<String>> aListOfListsOfStrings = new ArrayList<ArrayList<String>>();
        Table table = db.getTable(query);
        for(Row row: table)
        {
            if(row.get("email").toString().equalsIgnoreCase(key))
            {
                ArrayList<String> userStrings = new ArrayList<String>();
                userStrings.add(row.get("visitDate").toString());
                userStrings.add(row.get("visitTime").toString());
                userStrings.add(row.get("reason").toString());
                userStrings.add(row.get("followUp").toString());
                userStrings.add(row.get("email").toString());
                userStrings.add(row.get("ID").toString());
                aListOfListsOfStrings.add(userStrings);
            }
        }
        return aListOfListsOfStrings;
    }
    //also prints the whole table but with ArrayList
    public ArrayList<ArrayList<String>> read(String query) throws IOException {

        ArrayList<ArrayList<String>> aListOfListsOfStrings = new ArrayList<ArrayList<String>>();
        Table table = db.getTable(query);
        for(Row row: table)
        {
            ArrayList<String> userStrings = new ArrayList<String>();
            userStrings.add(row.get("visitDate").toString());
            userStrings.add(row.get("visitTime").toString());
            userStrings.add(row.get("reason").toString());
            userStrings.add(row.get("followUp").toString());
            userStrings.add(row.get("email").toString());
            userStrings.add(row.get("ID").toString());
            aListOfListsOfStrings.add(userStrings);
                    
        }
        return aListOfListsOfStrings;
    }
    
    
    public void checkCol(Table tab) throws IOException {

        tab = db.getTable("visits");

       // ArrayList<Row> rowList = new ArrayList<>();

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
    public void openDatabase(File dbFile) throws IOException
    {
        //if(dbFile != null)
            //closeDatabase();
        this.dbFile = dbFile;
        db = DatabaseBuilder.open(dbFile);
    }
    public void deleteRow(String query, String key)
            throws IOException
    {
        Table table = db.getTable(query);
        for(Row row : table)
        {
            if(row.toString().contains(key))
                table.deleteRow(row);
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deleteAll(String query)
            throws IOException {
        Table table = db.getTable(query);
        for (Row row : table) {
            table.deleteRow(row);
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
/*
    public void deleteDatabase()
            throws IOException {
        closeDatabase();
        dbFile.delete();
        dbFile = null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */
/*
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
                    addColumn(new ColumnBuilder("ID", DataType.LONG).setAutoNumber(true)).setPrimaryKey().
                    toTable(db);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            Table users = new TableBuilder("user").
                    addColumn(new ColumnBuilder("fName").setSQLType(Types.VARCHAR)).
                    addColumn(new ColumnBuilder("lName").setSQLType(Types.VARCHAR)).
                    addColumn(new ColumnBuilder("email").setSQLType(Types.VARCHAR)).setPrimaryKey().
                    addColumn(new ColumnBuilder("phone").setSQLType(Types.INTEGER)).
                    addColumn(new ColumnBuilder("role").setSQLType(Types.VARCHAR)).
                    toTable(db);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
*/
    public void closeDatabase()
            throws IOException {
        db.close();
        db = null;
    }

    Set<String> getTableNames() throws IOException {
        return  db.getTableNames();
    }
}