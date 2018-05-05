package jiemianModularization;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * ʵ�ְ�ť1�Ķ�Ӧ���
 * @author Junking
 *
 */
public class CDI1 extends CDI{
	JTable jt;
	SQL sql;
	int row;
	
	
	CDI1(){
		
		try {
			jt = new JTable(makeTableDate(), makeTableHead());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jt.setRowHeight (30);//����ÿ�еĸ߶�Ϊ30
		jt.setBounds(0,0,I_WIDTH, I_HEIGTT);
		jt.setFont(new Font("����", Font.PLAIN, 17));
		JScrollPane jsp = new JScrollPane(jt);
		jsp.setBounds(0, 0,I_WIDTH, I_HEIGTT);
		
		
		this.add(jsp);
		
	}
	
	/**
	 * ��ȡ��������
	 * @return
	 * @throws SQLException 
	 */
	public Object[][] makeTableDate() throws SQLException{
		row = 0;//����
		final int COLUMN = 9;//����
		sql = new SQL("commodity");//���ӵ����ݱ�
		
		sql.SQLselect();//ִ��ѡ����䷵��rs
		row = getRow(sql.rs);
		Object[][] obj = new Object[row][COLUMN]; //new Object[][]��һ���������У��ڶ�����������
		
		doResultSet(sql.rs, obj);
		
		
		return obj;
	}
	
	/**
	 * �Զ����ȡ�����ķ���
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	public int getRow(ResultSet rs) throws SQLException {
		rs.last();//������������һ��
		row = rs.getRow();//��ȡ��ǰ��һ�еı��
		
		return row;
	}

	/**
	 * ���ɱ�ͷ
	 * @return
	 */
	public Object[] makeTableHead(){
		String[] columnNames = { "���", "��Ʒ", "����", "���", "����", "����","�ۼ�","����ʱ��","�ܽ���" };  	   
		return (Object[])columnNames;
	}
	
	/**
	 * �����������������ö�Ӧ��obj��ά���飬�Ա������ɶ�Ӧ���Եı��
	 * @param rs ������ResultSet����
	 * @param obj ������Object��ά����
	 * @throws SQLException
	 */
	public void doResultSet(ResultSet rs,Object[][] obj) throws SQLException{
		rs.beforeFirst();//�����������һ��ǰ
		//Ϊ����е����ݸ�ֵ
		while(rs.next()){
		for (int i = 0; i < obj[rs.getRow()-1].length; i++) {
			
				obj[rs.getRow()-1][i] = rs.getString(i+1);
		}

		}
		sql.SQLover();
	}
}
