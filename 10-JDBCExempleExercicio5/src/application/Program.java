package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class Program {

	public static void main(String[] args) {

		Connection conn = null;
		Statement st = null;

		try {

			conn = DB.getConnection();
			
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			
			int row1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 where DepartmentId = 1");
			
			int i =1;
			if (i<2) {
				throw new DbException("Um erro falso aqui!");
			}
			
			int row2 = st.executeUpdate("UPDATE seller SET BaseSalary = 4090 where DepartmentId = 2");
			
			conn.commit();
			
			System.out.println("row1 " + row1);
			System.out.println("row1 " + row2);
			

		} catch (SQLException e) {
			try {
				conn.rollback();
				throw new DbException("Transação levou Rollbakc porque: " + e.getMessage());
			} catch (SQLException e1) {
				throw new DbException("Erro fazendo rollback");
			}
		}finally {	
			DB.closeStatement(st);
			DB.closeConnection();
		}

	}

}
