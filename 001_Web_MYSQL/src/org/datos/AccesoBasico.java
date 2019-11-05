package org.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccesoBasico {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306/primera";
		String user="root";
		String password="";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Conector correcto");
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println(con.toString());
			String consulta = "select * from clientes";
			Statement st = con.createStatement();
			ResultSet resultado = st.executeQuery(consulta);
			
			System.out.println("El result set es "+resultado);
			while(resultado.next()) {
				System.out.println(resultado.getString("nombre"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
