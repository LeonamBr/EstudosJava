package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbException;

public class Program {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement ps = null;
		
		try {

			conn = DB.getConnection();

			ps = conn.prepareStatement("UPDATE seller SET BaseSalary = BaseSalary + ? WHERE (Id = ?)");
			
			ps.setDouble(1, 1000.00);
			ps.setInt(2, 7);
			
			int rowsAffected = ps.executeUpdate();
			
			System.out.println("Pronto!! linhas afetadas: " + rowsAffected);

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(ps);
			DB.closeConnection();
		}

	}

}
