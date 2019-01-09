package com.bdqn.crm.util;

import com.bdqn.crm.entity.UserInfo;
import com.bdqn.crm.service.UserService;
import com.bdqn.crm.service.impl.UserServiceImpl;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

/**
 * 用户实现类
 * 持久层（持久化）
 */
public class DBUtil {

	public static String dbDriver;
	public static String dbUrl;
	public static String dbUser;
	public static String dbPassword;

	public static Connection connection = null;
	public static PreparedStatement preparedStatement = null;
	public static ResultSet resultSet = null;

	/**
	 * 加载类就会执行
	 */
	static {
		// 加载配置文件
		getConfig();
	}

	/**
	 * 读取properties配置文件的值
	 * 永远返回的都是String类型
	 */
	public static void getConfig() {
		InputStream inStream = null;
		try {
			//构建一个读取properties配置文件的实例
			Properties properties = new Properties();
			// 底层通过流的操作把配置文件拿进来
			inStream = DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
			// 把文件交给properties对象管理（加载）
			properties.load(inStream);
			dbDriver = properties.getProperty("jdbc.driver");
			dbUrl = properties.getProperty("jdbc.url");
			dbUser = properties.getProperty("jdbc.user");
			dbPassword = properties.getProperty("jdbc.password");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("找不到文件");
		}finally {
			try {
				inStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 创建连接
	 * @return
	 */
	public static Connection getConnection() {
		try {
			Class.forName(dbDriver);
			connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("找不到类……");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("链接数据库失败……");
		}
		return connection;
	}

	public static int insert(String tableName, Object obj){
		int result = 0;
		connection = DBUtil.getConnection();
		try {
			String sql = getInsertSql(tableName, obj);
			System.out.println(sql);
			preparedStatement = connection.prepareStatement(sql);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(preparedStatement, connection);
		}
		return result;
	}



	/**
	 * 获取并且返回完整的insert  语句
	 * @param tableName
	 * @param obj
	 * @return
	 */
	public static String getInsertSql(String tableName, Object obj) {
		Class c = obj.getClass();
		Field[] fl = c.getDeclaredFields();
		StringBuffer fieldName= new StringBuffer();//属性名拼接
		StringBuffer valueName=new StringBuffer() ; //字段值拼接
		for (Field field : fl) {
			String str = field.getName(); //获取属性名
			Method[] ms = c.getDeclaredMethods(); //获取方法
			for (Method method : ms) {
				String name = method.getName();//获取方法名
				if(name.startsWith("get")&&!name.startsWith("getClass")){//过滤 筛选get方法
					String str1 = name.substring(3);  //通过方法名截取出字段名
					if(str.equalsIgnoreCase(str1)&&!"id".equalsIgnoreCase(str)){ //判断前面的属性名 是否 与截取出来的字段名相同 ，则说明顺序相同 ，则拼接
						//去掉ID
						fieldName.append("`"+BeanMapConvertUtil.camelhumpToUnderline(str) + "`,") ;
						String str2;
						try {
							str2 = method.invoke(obj, null).toString();
							String type = method.getReturnType().getSimpleName();
							if("String".equalsIgnoreCase(type)){
								valueName.append("'"+str2+"'"+",");
							} else if("Date".equalsIgnoreCase(type)){
								valueName.append("NOW(),");
							}else{
								valueName.append(str2+",");
							}
						} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		String endFieldName = fieldName.substring(0, fieldName.length()-1); //去除末尾的逗号
		String endValueName = valueName.substring(0, valueName.length()-1);
		String sql= "insert into "+tableName+"("+endFieldName+")"+" values"+"("+endValueName+")";
		return sql;
	}

	/**
	 * 封装新增、删除、修改
	 * @param sql
	 * @param pram
	 * @return
	 */
	public static int update(String sql, Object...  pram) {
		int result = 0;
		connection = DBUtil.getConnection();
		try {
			preparedStatement = connection.prepareStatement(sql);
			if(pram.length !=0 && pram != null) {
				for(int i = 0; i < pram.length;  i++) {
					preparedStatement.setObject((i+1), pram[i]);
				}
			}
			// 查看自动拼装的sql
			System.out.println(preparedStatement.toString());
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(preparedStatement, connection);
		}
		return result;
	}


	/**
	 * 封装新增、删除、修改
	 * @param sql
	 * @param pram
	 * @return
	 */
	public static int update(String sql, List<Object> pram) {
		int result = 0;
		connection = DBUtil.getConnection();
		try {
			preparedStatement = connection.prepareStatement(sql);
			if(pram.size() !=0 && pram != null) {
				for(int i = 0; i < pram.size();  i++) {
					preparedStatement.setObject((i+1), pram.get(i));
				}
			}
			// 查看自动拼装的sql
			System.out.println(preparedStatement.toString());
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(preparedStatement, connection);
		}
		return result;
	}



	/**
	 * 封装查询
	 * @param sql
	 * @param pram
	 * @return
	 */
	public static List<Map<String, Object>> query(String sql, Object... pram) {
		List<Map<String, Object>> list = new ArrayList<>();
		connection = DBUtil.getConnection();
		try {
			preparedStatement = connection.prepareStatement(sql);
			if(pram.length !=0 && pram != null) {
				for(int i = 0; i < pram.length;  i++) {
					preparedStatement.setObject((i+1), pram[i]);
				}
			}
			// 查看自动拼装的sql
			String sqlStr = preparedStatement.toString();
			System.out.println("--------------------------- SQL -----------------------------");
			System.out.println("sql: "+sqlStr.substring(sqlStr.indexOf(":")+1));
			System.out.println("-------------------------------------------------------------");
			resultSet = preparedStatement.executeQuery();
			ResultSetMetaData metaData = resultSet.getMetaData();
			int columnCount = metaData.getColumnCount();
			while(resultSet.next()) {
				Map<String, Object> map = new HashMap<>();
				for(int i=1; i<=columnCount; i++) {
					String columnLabel = metaData.getColumnLabel(i);
					Object value = resultSet.getObject(columnLabel);
					if(value != null) {
						map.put(columnLabel, value);
					}
				}
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet, preparedStatement, connection);
		}
		return list;
	}

	/**
	 * 获取单个对象 可用于登录注册验证
	 * @param sql
	 * @param paras
	 * @param cls
	 * @return
	 */
	public static <T> T get( Class<T> cls, String sql, Object... paras) {
		connection =getConnection();
		T singleObject = null;
		int index = 1;
		try {
			preparedStatement = connection.prepareStatement(sql);
			if(paras != null && paras.length >0) {
				preparedStatement.clearParameters();
				for(int i = 0;i<paras.length;i++) {
					preparedStatement.setObject(index++,paras[i]);
				}
			}
			resultSet = preparedStatement.executeQuery();
			ResultSetMetaData rsmd = resultSet.getMetaData();
			int columnCount = rsmd.getColumnCount();
			while(resultSet.next()) {
				singleObject = cls.newInstance();
				for(int i = 0;i<columnCount;i++) {
					String columnName = rsmd.getColumnName(i+1);
					Object columnValue = resultSet.getObject(columnName);
					// 下划线转换为驼峰标识
					columnName = BeanMapConvertUtil.underlineToCamelhump(columnName);
					Field field = cls.getDeclaredField(columnName);
					field.setAccessible(true);
					if(null != columnValue){
						field.set(singleObject, columnValue);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(resultSet, preparedStatement,connection);

		}
		return singleObject;

	}
	/**
	 *
	 * 查询集合
	 */
	public static<T> List<T> find(Class<T> cls ,String sql, Object... paras){
		connection = getConnection();
		T singleObject = null;
		int index = 1;
		List <T> list = new ArrayList<T>();
		try {
			preparedStatement = connection.prepareStatement(sql);
			if(paras !=null && paras.length>0) {
				preparedStatement.clearParameters();
				for(int i = 0;i<paras.length;i++) {
					preparedStatement.setObject(index++, paras[i]);
				}
			}
			resultSet = preparedStatement.executeQuery();
			ResultSetMetaData rsmd = resultSet.getMetaData();
			int columnCount = rsmd.getColumnCount();
			while(resultSet.next()) {
				singleObject = cls.newInstance();
				for(int i = 0;i<columnCount;i++) {
					String columnName = rsmd.getColumnName(i+1);
					Object columdValue = resultSet.getObject(columnName);
					// 下划线转换为驼峰标识
					columnName = BeanMapConvertUtil.underlineToCamelhump(columnName);
					Field field = cls.getDeclaredField(columnName);
					field.setAccessible(true);
					if(null != columdValue) {
						field.set(singleObject, columdValue);
					}
				}
				list.add(singleObject);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(resultSet, preparedStatement, connection);
		}

		return list;
	}


	/**
	 * 关闭resultSet
	 * @param resultSet
	 */
	public static void close(ResultSet resultSet) {
		if(resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("ResultSet关闭失败……");
			}
		}
	}

	/**
	 * 关闭preparedStatement
	 */
	public static void close(PreparedStatement preparedStatement) {
		if(preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("PreparedStatement关闭失败……");
			}
		}
	}

	/**
	 * 关闭preparedStatement
	 */
	public static void close(Connection connection) {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("Connection关闭失败……");
			}
		}
	}

	/**
	 * 关闭连接
	 * @param resultSet
	 * @param preparedStatement
	 * @param connection
	 */
	public static void close(ResultSet resultSet,  PreparedStatement preparedStatement, Connection connection) {
		close(resultSet);
		close(preparedStatement);
		close(connection);
	}

	/**
	 * 关闭连接
	 * @param preparedStatement
	 * @param connection
	 */
	public static void close(PreparedStatement preparedStatement, Connection connection) {
		close(preparedStatement);
		close(connection);
	}

}
