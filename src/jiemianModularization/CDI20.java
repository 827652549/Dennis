package jiemianModularization;

import java.sql.SQLException;

/**
 * ���ȫ������ÿһ������۶���ܳ��ܱ�񣨴ӵ�һ�쿪ʼ��
 * 
 * @author Junking
 *
 */
public class CDI20 extends CDI1 {
	public CDI20() {
	}

	@Override
	public Object[] makeTableHead() {
		String[] columnNames = { "����", "�����ܶ�", "�����ܶ�", "����" };
		return (Object[]) columnNames;
	}

	@Override
	public Object[][] makeTableDate() throws SQLException {
		row = 0;// ����
		final int COLUMN = 4;// ����
		sql = new SQL("sale");// ���ӵ����ݱ�
		sql.SQLselect();// ִ��ѡ����䷵��rs
		row = getRow(sql.rs);
		Object[][] obj = new Object[row][COLUMN]; // new
													// Object[][]��һ���������У��ڶ�����������

		doResultSet(sql.rs, obj);

		return obj;
	}
}
