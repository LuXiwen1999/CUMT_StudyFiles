package dao;

import java.util.List;

import vo.Info;;


public interface IInfoDAO {
	public boolean doCreate(Info info) throws Exception ;//ִ�����ݵĲ������

	public List<Info> findAll() throws Exception ;//������� �Ĳ�ѯ����
}
