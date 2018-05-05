package testJDialog;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import jiemianModularization.SQL;

public class JDialogCDI17 extends JPanel{
	String value;
	SQL sql;
	int row;
	int I_WIDTH = 1090;
	int I_HEIGTT = 593;
	public JDialog jd;
	public JTable jt;
	public JScrollPane jsp;
	//���������ֵ
	public JDialogCDI17(String value) {
		this.value = value;
		
		jd = new JDialog();
		jd.setTitle("�����ڲ鿴���ۼ�¼��");
		jd.setSize(1090, 593);
		jd.setLocationRelativeTo(null);
		jd.setResizable(false);// ��������
		jd.setModal(true);
		jd.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jd.setLayout(null);
        
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
		jd.add(jsp);
    
        
        jd.add(this);
        jd.setVisible(true);
        
        
        
	}
	
	/**
	 * ��ȡ��������
	 * @return
	 * @throws SQLException 
	 */
	public Object[][] makeTableDate() throws SQLException{
		row = 0;//����
		final int COLUMN = 7;//����
		sql = new SQL("record");//���ӵ����ݱ�
		sql.stm = sql.con.createStatement();
		String sqlWords = "select * from record where time like '"+value+"-__'";
		
		/**
		 * ���仰��Ż�ȡ�Ľ���� executeQueryͨ������ѡ�����
		 */
		sql.rs = sql.stm.executeQuery(sqlWords);//����������浽rs�й�ʹ��
		row = getRow(sql.rs);
		System.out.println("row:"+row);
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
		String[] columnNames = { "������id", "��Ʒid", "��Ʒ����", "��������", "��Ʒ����", "�����ܶ�","����ʱ��" };  	   
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
				System.out.println(rs.getString(i+1));
		}

		}
		sql.SQLover();
	}
}
	
	
	

