package Backend;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Calendar;
import java.util.Collections;

import com.healthmarketscience.jackcess.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import java.lang.Integer;

import static org.joda.time.DateTime.*;
import static org.joda.time.LocalTime.*;

import org.joda.time.format.DateTimeFormat;

public class User {
    private boolean follow;
    private String reason;
    private String location;
    private String email;
    private String fName;
    private String lName;
    private String role;
    private String phone;
    private String specialist;
    
    public User(boolean follow, String reason, String location, String email,
            String fName, String lname, String role, String phone)
    {
        this.follow = follow;
        this.reason = reason;
        this.location = location;
        this.email = email;
        this.fName = fName;
        this.lName = lName;
        this.role = role;
        this.phone = phone;
    }

    public void setSpecialist(String specialist)
    {
        this.specialist = specialist;
    }
    
	DateTimeFormat timeForm;
	DateTimeFormat dateForm;
	DateTime dt = new DateTime();

	public void newVisit(Table tab) throws IOException {
		
		Calendar cal = Calendar.getInstance();
		LocalDate date = new LocalDate();
		Data.open();
		
		newUser(Data.chooseTable("user"), fName, lName, email, phone, role);
		tab.addRow(location, email, Column.AUTO_NUMBER, date.toDate(), reason,
				follow, cal.getTime(), specialist);
	}

	public static boolean checkUser(Table tab, String email) throws IOException {
		Boolean state = false;
		Row row = CursorBuilder.findRow(tab,
				Collections.singletonMap("email", email));
		if (row != null) {
			// Entry exists
			state = true;
		} else {
			// Entry doesn't exist
			state = false;
		}
		return state;
	}

	public static void newUser(Table tab, String fName, String lName, String email,
			String phone, String role) throws IOException {
		if (checkUser(tab, email) == false) {
			tab.addRow(fName, lName, email, phone, role);
		}
	}

		// TODO Auto-generated method stub
		
	}

