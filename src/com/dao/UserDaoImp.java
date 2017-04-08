package com.dao;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jdbc.DBtemplate;
import com.jdbc.PreparedStatementSetter;
import com.domain.User;

@Repository
public class UserDaoImp implements UserDao {

	@Override
	public Integer add(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer update(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User get(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	private String sql = "select * from user where name like ?";
	@Override
	public List<User> list(User user) throws Throwable {
		return DBtemplate.list(sql,new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws Throwable {
				System.out.println("--->" + user.getName());
				ps.setString(1,"%"+user.getName()+"%");
			}
		}, User.class);
	}

}
