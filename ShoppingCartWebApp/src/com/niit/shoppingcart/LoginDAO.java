package com.niit.shoppingcart;

public class LoginDAO {
	public boolean IsValidUser(String uid,String pwd){
		if(uid.equals("niit")&& pwd.equals("niit"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
