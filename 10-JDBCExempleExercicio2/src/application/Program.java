package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;
import db.DbException;

public class Program {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		SimpleDateFormat sdf = new SimpleDateFormat("(dd/MM/yyyy)");

		try {

			conn = DB.getConnection();

			ps = conn.prepareStatement(
					"INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId) VALUES (?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, "Leonam Braga");
			ps.setString(2, "leonam@gmail.com");
			ps.setDate(3, new java.sql.Date(sdf.parse("(01/12/1989)").getTime()));
			ps.setDouble(4, 4000.00);
			ps.setInt(5, 3);

			int rowAffected = ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			

			if (rowAffected > 0) {
				while(rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Pronto!! ID = " + id);
				}	
			} else
				System.out.println("Nenhuma linha foi alterada");

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} catch (ParseException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(ps);
			DB.closeConnection();
		}

	}

}
