package com.utils;
/**
 * 数据库连接工具类
 */
import java.sql.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DAO {

	private Connection conn;
	private Statement stmt;//PreparedStatement
  	private DataSource ds;
	
	public DAO()
	{
	}

	/**
		打开数据库
	*/
	public void open() 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver"); 
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/xwtj?characterEncoding=UTF-8&useUnicode=true","root","1234"); 
			stmt=conn.createStatement();
		} 
		catch (Exception ex) 
		{
		System.err.println("打开数据库时出错: " + ex.getMessage());
		}
	}

	/**
		关闭数据库，将连接返还给连接池
	*/
	public void close() 
	{
		try 
		{
		
				
		//	connMgr.freeConnection("java", conn);
			conn.close();
		} 
		catch (SQLException ex) 
		{
			System.err.println("返还连接池出错: " + ex.getMessage());
		}
	}

	/**
		执行查询
	*/
	public ResultSet executeQuery(String sql) throws SQLException
	{
		ResultSet rs = null;
		

		rs = stmt.executeQuery(sql);
		return rs;
	}

	/**
		执行增删改
	*/
	public int executeUpdate(String sql) throws SQLException
	{
		int ret = 0;
		ret = stmt.executeUpdate(sql);
		return ret;
	}

	/**
		将SQL语句加入到批处理
	*/
	public void addBatch(String sql) throws SQLException 
	{
		stmt.addBatch(sql);
	}

	/**
		执行批处理
	*/
	public int [] executeBatch() throws SQLException 
	{
		boolean isAuto=conn.getAutoCommit();
		
		conn.setAutoCommit(false);
		int [] updateCounts = stmt.executeBatch();
		
//		conn.commit();
		
//		conn.setAutoCommit(isAuto);
		//conn.setAutoCommit(true);
		return updateCounts;
	}
	public boolean getAutoCommit() throws SQLException
	{
		return conn.getAutoCommit();
	}
	public void setAutoCommit(boolean auto)  throws SQLException 
	{
		conn.setAutoCommit(auto);
	}
	
	public void commit() throws SQLException 
	{
		conn.commit();
//		this.close();
	}
	public void rollBack() throws SQLException 
	{
		conn.rollback();
//		this.close();
	}
	
}
