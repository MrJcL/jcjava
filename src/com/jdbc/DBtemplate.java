package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.domain.User;

public class DBtemplate {
	
	public static Object execute(Callback c) throws SQLException{
		Connection conn=ConnectionFactory.getInstance().getConnection();
		try{
			return c.execute(conn);
		}finally{
			ConnectionFactory.closeAll(conn, null, null);
		}
	}
	/**
	 * 只适用于增删改
	 * @param sql
	 * @param setter
	 * @return 影响行数
	 * @throws Throwable 
	 */
	public static Integer executeUpdate(String sql,PreparedStatementSetter setter) throws Throwable{
		Connection conn=ConnectionFactory.getInstance().getConnection();
		PreparedStatement ps=null;
		try{
		    ps=conn.prepareStatement(sql);
		    if(setter!=null){
		    	setter.setValues(ps);
		    }
			return ps.executeUpdate();
		}finally{
			ConnectionFactory.closeAll(conn,ps, null);
		}
	}
	
	public static <T> T get(String sql,PreparedStatementSetter setter,Class<T> type) throws Throwable{
		Connection conn=ConnectionFactory.getInstance().getConnection();
		PreparedStatement ps=null;
		try{
		    ps=conn.prepareStatement(sql);
		    if(setter!=null){
		    	setter.setValues(ps);
		    }
			ResultSet rs=ps.executeQuery();
		    ResultSetMetaData metaData=rs.getMetaData();
			if(rs.next()){
				T bean=type.newInstance();
			     for(int i=1;i<=metaData.getColumnCount();i++){
			    	 BeanUtils.setProperty(bean,metaData.getColumnName(i),rs.getObject(i));
			     }
				return bean;
			}
			return null;
		}finally{
			ConnectionFactory.closeAll(conn,ps, null);
		}
	} 
	
	public static <T> List<T> list(String sql,PreparedStatementSetter setter,Class<T> type) throws Throwable{
		Connection conn=ConnectionFactory.getInstance().getConnection();
		PreparedStatement ps=null;
		try{
		    ps=conn.prepareStatement(sql);
		    if(setter!=null){
		    	setter.setValues(ps);
		    }
			ResultSet rs=ps.executeQuery();
			ResultSetMetaData metaData=rs.getMetaData();
			List<T> list=new ArrayList<T>();
			while(rs.next()){
				 T bean=type.newInstance();
			     for(int i=1;i<=metaData.getColumnCount();i++){
			    	 BeanUtils.setProperty(bean,metaData.getColumnName(i),rs.getObject(i));
			     }
			     list.add(bean);
			}
			return list;
		}finally{
			ConnectionFactory.closeAll(conn,ps, null);
		}
	} 
	
	
	public static void main(String[] args) throws Throwable {
		User user=DBtemplate.get("select name from user limit 1",null,User.class);
		System.out.println(user); 
		/*String name="test";
		int id=1;
		DBtemplate.executeUpdate("update user set name=? where id=?",new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws Throwable {
				ps.setString(1, name);
				ps.setInt(2,id);
			}
		});*/
		/*DBtemplate.execute(new Callback() {
			
			@Override
			public Object execute(Connection conn) throws SQLException {
				PreparedStatement p=conn.prepareStatement("select CURRENT_TIMESTAMP()");
				ResultSet rs=p.executeQuery();
				if(rs.next()){
					System.out.println(rs.getTimestamp(1));
				}
				return 1;
			}
		});*/
	}
}
