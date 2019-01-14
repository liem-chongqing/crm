package com.bdqn.crm.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

/**
 * 用户实现类
 * 持久层（持久化）
 */
public class LoadConfig {

	public static String dbDriver;
	public static String dbUrl;
	public static String dbUser;
	public static String dbPassword;
	public static String defaultPassword;


	private static final String CONFIG_PATH = "config.properties";

	static {
		getConfig();
	}


	private static void resolve(Properties properties){
		dbDriver = properties.getProperty("jdbc.driver");
		dbUrl = properties.getProperty("jdbc.url");
		dbUser = properties.getProperty("jdbc.user");
		dbPassword = properties.getProperty("jdbc.password");
		defaultPassword = properties.getProperty("default.password");
	}


	public static void getConfig() {
		try {
			Properties properties = new Properties();
			properties.load(LoadConfig.class.getClassLoader().getResourceAsStream(CONFIG_PATH));
			resolve(properties);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("配置文件读取异常");
		}
	}





}
