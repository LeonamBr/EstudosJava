package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbIntegrityException;

public class Program {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement ps = null;

		try {

			conn = DB.getConnection();

			ps = conn.prepareStatement("DELETE FROM seller WHERE ID = ?" , Statement.RETURN_GENERATED_KEYS);
			
			ps.setInt(1, 7);
			
			int rowAffected = ps.executeUpdate();
			
			System.out.println("Feito! Linhas afetadas: " + rowAffected);

		} catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		}finally {	
			DB.closeStatement(ps);
			DB.closeConnection();
		}

	}

}
