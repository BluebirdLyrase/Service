package com.example.demo;
import java.sql.*;
public class DemoApplication {

	public static void main(String[] args) {
		String user = "root";
                String password = "1234";
                String url = "jdbc:mysql://localhost/soa";
                Statement stat= null;
                Connection con = null;
                try{
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection(url,user,password);
                stat = con.createStatement();
                ResultSet result = stat.executeQuery("SELECT DISTINCT installs FROM googleplaystore");
                while(result.next()){
                    System.err.println(result.getString(1));
                }
                }catch(Exception e){
                    System.err.println("error"+e);
                }finally{
                try{
                    stat.close();
                    con.close();
                }
                
                catch(Exception ex){
                    System.err.println("error"+ex);
                }
                }
                
                
                
	}

}
