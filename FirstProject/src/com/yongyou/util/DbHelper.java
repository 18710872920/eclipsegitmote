package com.yongyou.util;

import java.sql.DriverManager;

import java.sql.Connection;

public class DbHelper {
	// Ҫͨ������ֱ�ӵ������Ҫ��static
	private static String url = "jdbc:mysql://localhost:3306/bigdate7";// ���ݿ��ַ
	private static String userName = "root";// ���ݿ��û���
	private static String passWord = "lmncwj999999";// ���ݿ�����
	private static Connection conn = null;
	
	private DbHelper() {
		
	}
	public static Connection getConnection() {
		if(null == conn) {
			try {
				// ��������
				Class.forName("com.mysql.jdbc.Driver");
				// ��ȡ����
				conn = DriverManager.getConnection(url,userName,passWord);
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return conn;
		
	}

}
