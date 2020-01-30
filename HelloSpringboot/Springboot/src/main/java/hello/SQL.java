/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import net.minidev.json.parser.JSONParser;
public class SQL {
    private ArrayList<appData>  list;
    
//    private Object results = new  Object();
    

    public SQL() {
            list = new ArrayList();
    }
    
    public ArrayList<appData> findAll(){
            try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection =DriverManager.getConnection("jdbc:mysql://localhost/data?user=root&password=1234");
        // TODO code application logic here
        Statement statement = connection.createStatement( );
        ResultSet rs = statement.executeQuery("SELECT * FROM googleplaystore");
 
    while (rs.next()) {
        list.add(new appData(rs.getString("App"),rs.getString("Category"),rs.getString("Rating"),rs.getString("Reviews"),rs.getString("Size"),rs.getString("Installs"),rs.getString("Type"),rs.getString("Price"),rs.getString("Content Rating"),rs.getString("Genres"),rs.getString("Last Updated"),rs.getString("Current Ver"),rs.getString("Android Ver")));
    }
        statement.close();
        }catch(Exception e){ System.out.println("DAM:"+e);}   
             return list;
    }
//    public ArrayList<appData> getRs() {
//        return list;
//    }
}
