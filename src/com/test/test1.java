package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbc.ConnectionFactory;

public class test1 {
	public static void main(String[] args) {
		try {
			Connection conn=ConnectionFactory.getInstance().getConnection();
			String sql = "select * from user where name like '%李%'";
//			String sql = "insert into user (id,name,account) values (6,'李',4)";
//			String sql = "delete from user where name='3'";
//			String sql = "update user set id=120,account=999 where name='3'";
			PreparedStatement ps=conn.prepareStatement(sql);
		//	ps.executeUpdate();
		//	ps.setString(1, "'%"+"李"+"%'");
			ResultSet result= ps.executeQuery();
			while(result.next()){
				System.out.println(result.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
