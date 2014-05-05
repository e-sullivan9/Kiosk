package Backend;


import com.healthmarketscience.jackcess.ColumnBuilder;
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

public class Data {

    private static Database dbopen;
    private static Set<String> tableNames;

    public Data() throws IOException {

    }

    public static Database open() throws IOException {
        try {
            dbopen = DatabaseBuilder.open(new File("kioskdb1.mdb"));

        } catch (IOException e) {
            e.printStackTrace();
        }        return dbopen;
    }

    public static Table chooseTable(String table) throws IOException {
        return dbopen.getTable(table);
    }

    public static void closeData() throws IOException {
        dbopen.close();
    }

    public static void getTableNames() throws IOException {
        tableNames = dbopen.getTableNames();
        System.out.println(tableNames);
    }
}
