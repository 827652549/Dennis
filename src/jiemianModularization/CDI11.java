package jiemianModularization;

import java.sql.SQLException;

/**
 * ���Ա��
 * @author Junking
 *
 */
public class CDI11 extends CDI1{
	
	public CDI11() {
		
		
	}
		
		@Override
		public Object[] makeTableHead() {
			String[] columnNames = {"����", "����", "�Ա�", "����", "����", "ְ��","�绰","��н","סַ","״̬","ע��ʱ��"};  	   
			
			return (Object[])columnNames;
			
		}
		
		@Override
		public Object[][] makeTableDate() throws SQLException {
			row = 0;//����
			final int COLUMN = 11;//����
			sql = new SQL("staff");//���ӵ����ݱ�
			sql.SQLselect();//ִ��ѡ����䷵��rs
			row = getRow(sql.rs);
			Object[][] obj = new Object[row][COLUMN]; //new Object[][]��һ���������У��ڶ�����������
			
			doResultSet(sql.rs, obj);
			
			
			return obj;
		}
			
	}

