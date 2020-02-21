package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class TestProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestProjectApplication.class, args);

		String dbURL = "jdbc:mysql://127.0.0.1:3306/market?serverTimezone=UTC";
		String username = "root";
		String password = "1223";
		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
			if (conn!=null) {
				System.out.println("Success connection!");
			}
			else {
				System.out.println("Error connecting to db");
			}

//INSERT VALUES EXAMPLE
	//		String  sql = "INSERT INTO  Categories (CategoryName) values ('non-red meat')";
	//		int result = conn.createStatement().executeUpdate(sql);


			//update EXAMPLE
	//		sql = "UPDATE Categories SET CategoryName ='sugar' WHERE CategoryID = 4 ";
		///	result = conn.createStatement().executeUpdate(sql);
			//get values from both tables
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from InventoryList");
			while(rs.next())
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));

			ResultSet rs1=stmt.executeQuery("select * from Categories");
			while(rs1.next())
				System.out.println(rs1.getInt(1)+"  "+rs1.getString(2));


			/*conn.close();
			System.out.println("connection closed....");*/
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

}

/*

        DROP DATABASE IF EXISTS university;
        create database university;
        use university;

        CREATE TABLE Categories (
        CategoryID INT auto_increment,
        key(CategoryId),
        CategoryName CHAR(20) PRIMARY KEY
        );

        CREATE TABLE InventoryList
        (
        ProductID INT Primary KEY auto_increment,
        ProductName VARCHAR(50),
        CategoryName char(254),

        FOREIGN KEY (CategoryName) REFERENCES Categories(CategoryName)
        );
        INSERT INTO  Categories (CategoryID,CategoryName)
        values (1,"meat");

        INSERT INTO  Categories (CategoryName)
        values ("fish");

        INSERT INTO  Categories (CategoryName)
        values ("bread");
        INSERT INTO InventoryList (CategoryName,ProductName)
        values ("meat","fpork");
        INSERT INTO InventoryList (CategoryName,ProductName)
        values ("fish","salmon");
        INSERT INTO InventoryList (CategoryName,ProductName)
        values ("meat","mjaso");
        select * from  Categories ;

            String  sql = "INSERT INTO  Categories (CategoryName) values ('non-red meat')";
            int result = conn.createStatement().executeUpdate(sql);


            //update
            sql = "UPDATE Categories SET CategoryName ='sugar' WHERE CategoryID = 4 ";
            result = conn.createStatement().executeUpdate(sql);
            //get values from both tables
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("select * from InventoryList");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));

            ResultSet rs1=stmt.executeQuery("select * from Categories");
            while(rs1.next())
                System.out.println(rs1.getInt(1)+"  "+rs1.getString(2));



*/
