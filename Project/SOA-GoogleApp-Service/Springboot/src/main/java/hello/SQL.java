/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import hello.bean.*;
import java.sql.*;
import java.util.ArrayList;

public class SQL {

    private final ArrayList<categoryList> categoryList;
    private final ArrayList<content_rating> content_rating;
    private final ArrayList<appDatamin> listmin;
    private final ArrayList<appData> list;
    private final ArrayList<installs> installs;
    private final ArrayList<review> review;

    public SQL() {
        list = new ArrayList();
        listmin = new ArrayList();
        categoryList = new ArrayList();
        content_rating = new ArrayList();
        installs = new ArrayList();
        review = new ArrayList();
    }
    private String Driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost/soa?user=root&password=1234";

    public ArrayList<installs> installs() {
        Connection connection = null;
        Statement statement = null;
        installs.clear();
        try {
            Class.forName(Driver);
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT DISTINCT installs FROM googleplaystore");

            while (rs.next()) {
                installs.add(new installs(rs.getString("installs")));
            }
        } catch (Exception e) {
            System.out.println("installs e :" + e);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (Exception ex) {
                System.err.println("installs ex :" + ex);
            }
        }
        return installs;
    }

    public ArrayList<content_rating> content_rating() {
        Connection connection = null;
        Statement statement = null;
        content_rating.clear();
        try {
            Class.forName(Driver);
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT DISTINCT content_rating FROM googleplaystore");

            while (rs.next()) {
                content_rating.add(new content_rating(rs.getString("content_rating")));
            }
        } catch (Exception e) {
            System.out.println("content_rating e :" + e);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (Exception ex) {
                System.err.println("content_rating ex" + ex);
            }
        }
        return content_rating;
    }

    public ArrayList<categoryList> categoryList() {
        Connection connection = null;
        Statement statement = null;
        categoryList.clear();
        try {
            Class.forName(Driver);
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT DISTINCT Category FROM googleplaystore");

            while (rs.next()) {
                categoryList.add(new categoryList(rs.getString("Category")));
            }
        } catch (Exception e) {
            System.out.println("categoryList e :" + e);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (Exception ex) {
                System.err.println("categoryList ex :" + ex);
            }
        }
        return categoryList;
    }

    public ArrayList<appDatamin> search(String query, String name) {
        Connection connection = null;
        Statement statement = null;
        listmin.clear();
        try {
            Class.forName(Driver);
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();
            System.out.println(query);
            String stmQuery = "SELECT app,id,category,rating,price,content_rating FROM googleplaystore ";
            if (name.equals("null") && !query.equals("null")) {
                stmQuery = stmQuery + query;
            } else if (!name.equals("null") && !query.equals("null")) {
                stmQuery = stmQuery + query + " and app like '%" + name + "%'";
            } else if (!name.equals("null") && query.equals("null")) {
                stmQuery = stmQuery + "where app like '%" + name + "%'";
            }
            stmQuery = stmQuery + " group by app";
            System.out.println(stmQuery);
            ResultSet rs = statement.executeQuery(stmQuery);

            while (rs.next()) {
                String rating = "";
                if (rs.getString("Rating").equals("null")) {
                    rating = "0";
                } else {
                    rating = rs.getString("Rating");
                }
                listmin.add(new appDatamin(rs.getString("id"), rs.getString("App"), rs.getString("Category"), rating, rs.getString("Price"), rs.getString("content_rating")));
            }
        } catch (Exception e) {
            System.out.println("search e : " + e);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (Exception ex) {
                System.err.println("search e : " + ex);
            }
        }
        return listmin;

    }

    public ArrayList<appData> findOne(String id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        list.clear();
        try {
            Class.forName(Driver);
            connection = DriverManager.getConnection(url);
//            statement = connection.createStatement();
            System.out.println(id);
            String stmQuery = "SELECT * FROM googleplaystore where id = ?";
            System.out.println(stmQuery);
            preparedStatement = connection.prepareStatement(stmQuery);
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String rating = "";
                if (rs.getString("Rating").equals("null")) {
                    rating = "0";
                } else {
                    rating = rs.getString("Rating");
                }
                list.add(new appData(rs.getString("id"), rs.getString("App"), rs.getString("Category"), rating, rs.getString("Reviews"), rs.getString("Size"), rs.getString("Installs"), rs.getString("Type"), rs.getString("Price"), rs.getString("content_rating"), rs.getString("Genres"), rs.getString("last_updated"), rs.getString("current_ver"), rs.getString("android_ver")));
            }
        } catch (Exception e) {
            System.out.println("findOne e : " + e);
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (Exception ex) {
                System.err.println("findOne ex : " + ex);
            }
        }
        return list;

    }

    public ArrayList<review> review(String id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        review.clear();
        try {
            Class.forName(Driver);
            connection = DriverManager.getConnection(url);
            String stmQuery = "SELECT id,x.app,Translated_Review,Sentiment,Sentiment_Polarity"
                    + ",Sentiment_Subjectivity FROM googleplaystore_user_reviews as x "
                    + "join googleplaystore as y on x.app = y.app where id = ?";
            System.out.println(stmQuery);
            preparedStatement = connection.prepareStatement(stmQuery);
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                review.add(new review(rs.getString("x.app"), rs.getString("Translated_Review"), rs.getString("Sentiment"), rs.getString("Sentiment_Polarity"), rs.getString("Sentiment_Subjectivity")));
            }
        } catch (Exception e) {
            System.out.println("review e :" + e);
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (Exception ex) {
                System.err.println("review ex : " + ex);
            }
        }
        return review;

    }
}
