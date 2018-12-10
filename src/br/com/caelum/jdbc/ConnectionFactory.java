package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection() {
        try {
        	//Class.forName("com.mysql.jdbc.Driver");
            DriverManager.registerDriver(new com.mysql.jdbc.Driver()); //Essa linha foi a diferença
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/caelum", "root", "mysql");
        } catch(SQLException e){
            throw new RuntimeException(e);
        }    
    }
}
