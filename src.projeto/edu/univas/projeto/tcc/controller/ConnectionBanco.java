package edu.univas.projeto.tcc.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConnectionBanco {

	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Driver não encontrado.");
			System.exit(1);
		}
	}

	public Connection getConnection() throws SQLException {
		String url = "jdbc:postgresql://localhost:5432/diskmoto";
		String user = "postgres";
		String password = "285030";
		Connection conn = DriverManager.getConnection(url, user, password);

		return conn;

	}

}








