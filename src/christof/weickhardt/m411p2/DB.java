/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christof.weickhardt.m411p2;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author christoftobias.weick
 */
public class DB {
   private static Connection c = null;
   private String table;
    public DB(String database, String table) {
        this.table = table;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            if (DB.c == null) {
                DB.c = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+database, "root", "");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.exit(0);
        }
    }

    public ArrayList<kontaktData> readData() {
        ArrayList<kontaktData> dataList = new ArrayList<>();
        kontaktData data;
        try {
            Statement stmt = c.createStatement();
            String query = "select * from "+table;
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                data = new kontaktData(rs.getInt("kid"), rs.getString("name"), rs.getString("vorname"), rs.getString("strasse"), rs.getInt("plz"), rs.getString("ort"));
                dataList.add(data);
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.exit(0);
        }

        return dataList;
    } 
    public kontaktData searchNV(String name,String vorname){
        kontaktData data;
        try {
            Statement stmt = c.createStatement();
            String query = "select * from "+table+" WHERE name='" + name + "' AND vorname='" + vorname+"'";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                data = new kontaktData(rs.getInt("kid"), rs.getString("name"), rs.getString("vorname"), rs.getString("strasse"), rs.getInt("plz"), rs.getString("ort"));
                return data;
            }
            return null;
        } catch (SQLException e) {
            System.out.println(e);
            System.exit(0);
            return null;
        }
    }
}
