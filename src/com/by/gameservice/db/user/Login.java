package com.by.gameservice.db.user;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.by.gameservice.db.SqlMapClientFactory;
import com.ibatis.sqlmap.client.SqlMapClient;

public class Login {

	public void loginUser(String username){
		Map<String,String> map = new HashMap<String,String>();
		map.put("username", username);
		SqlMapClient sql = SqlMapClientFactory.getSqlMap();
		Map list = null;
		try {
			list = (Map)sql.queryForObject("person.getperson", map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("list:"+list);
	}
}
