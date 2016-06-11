package com.by.gameservice.db;

import java.io.IOException;
import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMapClientFactory {
	public static SqlMapClient getSqlMap() {
		SqlMapClient sqlMapClient = null;
		try {
			Reader reader = Resources.getResourceAsReader("com/by/gameservice/db/SqlMapConfig.xml");
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("读取数据库出错");
		}
		return sqlMapClient;
	}

}
