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

public class Program {

	public static void main(String[] args) {
	
		
		Connection conn = null;
		Statement st = null;
		
		try {
			conn = DB.getConnection();
			st = conn.createStatement();
			
			conn.setAutoCommit(false);
			
			int rows1 = st.executeUpdate("update seller set BaseSalary = 2090.0 where departmentId = 1");
			
			int x = 2;
			if (x == 1) {
				throw new SQLException("Fake Error!");
			}
			
			int rows2 = st.executeUpdate("update seller set BaseSalary = 3090.0 where departmentId = 2");
			
			conn.commit();
			
			System.out.println("rows1: " + rows1);
			System.out.println("rows2: " + rows2);
			
		} catch (SQLException e) {
			try {
				conn.rollback();
				throw new DbException("Voltando Transação. Erro: " + e.getMessage());
			} catch (SQLException e1) {
				throw new DbException("Erro ao tentar rollback: " + e.getMessage());
			}
		} finally {
			DB.closeConnection();
			DB.closeStatement(st);
		}
		
	}

}
