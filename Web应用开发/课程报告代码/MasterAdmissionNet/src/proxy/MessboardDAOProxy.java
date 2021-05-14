package proxy;

import java.util.List;

import dao.IInfoDAO;
import dao.IMessboardDAO;
import dbc.DatabaseConnection;
import impl.MessboardDAOImpl;
import vo.Info;
import vo.Messboard;

public class MessboardDAOProxy implements IMessboardDAO {
	private DatabaseConnection dbc=null;
	private IMessboardDAO dao=null;
	
	public MessboardDAOProxy() throws Exception {
		this.dbc = new DatabaseConnection();
		this.dao = new MessboardDAOImpl(this.dbc.getConn());
		System.out.println("��ȡDAO�ɹ�");
	}
	
	@Override
	public boolean doCreate(Messboard messboard) throws Exception {
		boolean flag = false;
		try {
			flag=this.dao.doCreate(messboard);
		}catch (Exception e) {
			System.out.println("�ڴ����µ�messboard��ʱ����������");
			throw e;
		}finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public List<Messboard> findAll() throws Exception {
		List<Messboard> all=null;
		try {
			all=this.dao.findAll();
			System.out.println("��ȡ�����������");
		}catch (Exception e) {
			System.out.println("���԰����ȫ���������쳣");
			throw e;
		}finally {
			this.dbc.close();
		}
		return all;
	}

}
