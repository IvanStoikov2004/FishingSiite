package com.company;
import java.io.IOException;
import java.sql.*;
import  java.sql.Statement;
//import com.sun.jdi.connect.spi.Connection;
import  java.sql.Connection;
import java.util.Scanner;
public class Main {

    private static void insertClient( int Id, String firstName,String secondName,String email,String password) throws SQLException {
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Fishing", "root", "Ivan0877449404");
        PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO user  ( id, firstname,secondName,email,password) Values(?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            // ps.setInt(1, id_client);
            ps.setInt(1, Id);
            ps.setString(2, firstName);
            ps.setString(3, secondName);
            ps.setString(4, email);
            ps.setString(5, password);
            ps.execute();
            System.out.println("Data has be inserted");
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }






    public static void main(String[] args) throws SQLException {
	// write your code here
Scanner input=new Scanner(System.in);
        System.out.println();
        System.out.println();

        System.out.println("Insert id");
        int id= input.nextInt();
        System.out.println("Insert your first name");
        String firstName= input.next();
        System.out.println("Insert your second name");
        String secondName= input.next();
        System.out.println("Your email is:");
        String email= input.next();
        System.out.println("Your password is:");
        String password= input.next();
        insertClient(id,firstName,secondName,email,password);

    }
}
