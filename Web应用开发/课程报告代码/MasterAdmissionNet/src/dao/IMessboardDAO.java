package dao;

import java.util.List;

import vo.Messboard;

public interface IMessboardDAO {
	public boolean doCreate(Messboard messboard) throws Exception ;//ִ�����ݵĲ������
	public List<Messboard> findAll() throws Exception ;//������� �Ĳ�ѯ����
}
