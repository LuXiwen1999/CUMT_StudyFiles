import java.sql.Connection ;
import java.sql.DriverManager ;
import java.sql.SQLException ;
public class ConnectionDemo{
	// ����MySQL�����ݿ���������
	public static final String DBDRIVER = "com.mysql.cj.jdbc.Driver" ;
	// ����MySQL���ݿ�����ӵ�ַ
	public static final String DBURL = "jdbc:mysql://localhost:3306/masterschool?serverTimezone=GMT" ;
	// MySQL���ݿ�������û���
	public static final String DBUSER = "EricLu";
	// MySQL���ݿ����������
	public static final String DBPASS = "lu168681816" ;
	
	public static void main(String args[]){
		Connection conn = null ;		// ���ݿ�����
		try{
			Class.forName(DBDRIVER) ;	// ������������
			System.out.println("���������ɹ�");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("��������ʧ��");
		}
		try{
			conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS) ;
		}catch(SQLException e){
			e.printStackTrace() ;
		}
		
		System.out.println(conn) ;	// �����ʱ���Դ�ӡ��ʾ��������
		
		try{
			conn.close() ;			// ���ݿ�ر�
		}catch(SQLException e){
			e.printStackTrace() ;
		}
	}
};
