package com.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CRUDOperation {
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/employee_schema";
		String userName="root";
		String pwd="Vedha@276";

		Connection con=null;
		PreparedStatement prepStmt=null;
		ResultSet res=null;
		Statement stmt=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver is loaded Successfully");

			con=DriverManager.getConnection(url,userName,pwd);
			System.out.println("Connection Established Successfully");

			String create="insert into emp(`id`,`name`,`designation`,`salary`) values(?,?,?,?)";
			prepStmt=con.prepareStatement(create);
			
			Scanner scan=new Scanner(System.in);
			System.out.println("Enter number of rows you want to insert:");
			int n=scan.nextInt();
			con.setAutoCommit(false);
			for(int i=1;i<=n;i++)
			{
				System.out.println("Enter ID");
				int id=scan.nextInt();
				System.out.println("Enter name");
				String name=scan.next();
				System.out.println("Enter Designation");
				String designation=scan.next();
				System.out.println("Enter salary");
				int salary=scan.nextInt();
				prepStmt.setInt(1,id);
				prepStmt.setString(2,name);
				prepStmt.setString(3,designation);
				prepStmt.setInt(4,salary);
				prepStmt.execute();
			}
			con.commit();
			System.out.println(n+" Rows Affected...");
			System.out.println("Creation Executed Successfully..");
			System.out.println();
			
			String read="Select * from emp";
			stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,0);
			
			res=stmt.executeQuery(read);
			
			ResultSetMetaData metaData=res.getMetaData();
			System.out.println("Details Columns and type of columns..");
			for(int i=1;i<=metaData.getColumnCount();i++)
			{
				System.out.println(metaData.getColumnName(i)+" "+metaData.getColumnTypeName(i));
			}
			System.out.println();
			while(res.next())
			{
				System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getString(3)+" "+res.getInt(4));
			}
			System.out.println("Reading Executed Successfully...");
			System.out.println();
			String update="update emp set salary=salary+salary*0.10";
			
			System.out.println(stmt.executeUpdate(update)+" Rows Affected...");
			System.out.println("Updation Executed Successfully.....");
			System.out.println();
			
			
			String delete="delete from emp where name='Raj'";
			
			System.out.println("Number of Rows Deleted "+stmt.executeUpdate(delete));
			System.out.println("Delteion Executed Successfully....");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Driver is not Loaded");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			stmt.close();
			System.out.println("Statement closed successfully..");
			res.close();
			System.out.println("ResultSet closed Successfully..");
			prepStmt.close();
			System.out.println("PreparedStatement closed successfully..");
			con.close();
			System.out.println("Connection closed successfully..");
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

}
