package jiemianModularization;

import java.sql.SQLException;

public class CDI6 extends CDI1{
	
	public CDI6() {


		  	
	}
	
	@Override
	public Object[] makeTableHead() {
		String[] columnNames = { "�ʺ�", "����", "�Ա�", "סַ", "�绰", "�ۿ�","ע��ʱ��"};  	   
		return (Object[])columnNames;
		}
	
	@Override
	public Object[][] makeTableDate() throws SQLException {
		row = 0;//����
		final int COLUMN = 7;//����
		sql = new SQL("vip");//���ӵ����ݱ�
		sql.SQLselect();//ִ��ѡ����䷵��rs
		row = getRow(sql.rs);
		Object[][] obj = new Object[row][COLUMN]; //new Object[][]��һ���������У��ڶ�����������
		
		doResultSet(sql.rs, obj);
		
		
		return obj;
	}
	
}
