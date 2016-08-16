package com.niit.shoppingcart.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.UserDetails;

@Repository
public interface UserDetailsDAO {
	
	public boolean save(UserDetails userdatails);
	public boolean update(UserDetails userdatails);
	public boolean delete(UserDetails userdatails);
	public UserDetails get(String id);
	public List<UserDetails> list();
	

}

