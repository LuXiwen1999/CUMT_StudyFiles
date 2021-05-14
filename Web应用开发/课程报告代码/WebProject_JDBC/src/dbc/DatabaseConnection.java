package dbc;

import java.sql.Connection ;
import java.sql.DriverManager ;
import java.sql.SQLException ;

public class DatabaseConnection {
	//����MySql�����ݿ���������
	private static final String DBDRIVER="com.mysql.cj.jdbc.Driver";
	//����MySQL���ݿ�����ӵ�ַ
	private static final String DBURL="jdbc:mysql://localhost:3306/masterschool?serverTimezone=GMT";
//	MySQL���ݿ�������û���
	private static final String DBUSER="EricLu";
//	MySQL���ݿ����������
	private static final String DBPASS="lu168681816";
	private Connection conn;

	public DatabaseConnection() throws Exception{     //�޲ι��캯��
		Class.forName(DBDRIVER);
		this.conn=DriverManager.getConnection(DBURL, DBUSER, DBPASS);
	}	
	public Connection getConn() {//get ����
		return conn;
	}
	public void setConn(Connection conn) {//set ����
		this.conn = conn;
	}
	public void close() throws Exception {//close����
		if(this.conn != null){
			try{
				this.conn.close() ;
			}catch(Exception e){
				throw e ;
			}
		}
	}
}
