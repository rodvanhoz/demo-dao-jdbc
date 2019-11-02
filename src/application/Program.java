package application;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;
import db.DbException;
import db.DbIntegrityException;
import model.entities.Department;

public class Program {

	public static void main(String[] args) {
	
		Department obj = new Department(1, "Books");
		System.out.println(obj);
		
	}

}
