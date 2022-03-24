package  pruebas;

import  java.sql.Connection;		
import  java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import  java.sql.ResultSet;		
import  java.sql.DriverManager;		
import  java.sql.SQLException;		

public class  BaseDeDatosTest {
		@Test
    	public void BDTest() throws  ClassNotFoundException, SQLException {													
				//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"		
                String dbUrl = "jdbc:mysql://127.0.0.1:3306/ecommerce";					

				//Database Username		
				String username = "root";	
                
				//Database Password		
				String password = "";				

				//Query to Execute		
				String query = "select count(1) from clientes;";	
                
         	    //Load mysql jdbc driver		
           	    Class.forName("com.mysql.jdbc.Driver");			
           
           		//Create Connection to DB		
            	Connection con = DriverManager.getConnection(dbUrl,username,password);
          
          		//Create Statement Object		
        	   Statement stmt = con.createStatement();					
       
       			// Execute the SQL Query. Store results in ResultSet		
         		ResultSet rs= stmt.executeQuery(query);							
         
         		int count = 0;
         		
         		// While Loop to iterate through all data and print results		
				while (rs.next()){
			        		count = rs.getInt(1);
                    }		
					
				System.out.println("Cantidad de Empleados en la BD: " + count);
				System.out.println("Veredicto de la comprobación: " + (count > 0));
				
				// Captura de Pantalla
				
				Assert.assertTrue(count > 0);
				
      			 // closing DB Connection		
      			con.close();			
		}
}