package com.yongyou.util;

import java.sql.DriverManager;

import java.sql.Connection;

public class DbHelper {
	// 要通过类名直接吊，这块要用static
	private static String url = "jdbc:mysql://localhost:3306/bigdate7";// 数据库地址
	private static String userName = "root";// 数据库用户名
	private static String passWord = "lmncwj999999";// 数据库密码
	private static Connection conn = null;
	
	private DbHelper() {
		
	}
	public static Connection getConnection() {
		if(null == conn) {
			try {
				// 加载驱动
				Class.forName("com.mysql.jdbc.Driver");
				// 获取连接
				conn = DriverManager.getConnection(url,userName,passWord);
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return conn;
		
	}

}
