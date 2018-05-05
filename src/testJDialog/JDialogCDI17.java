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
	//传入输入的值
	public JDialogCDI17(String value) {
		this.value = value;
		
		jd = new JDialog();
		jd.setTitle("按日期查看销售记录：");
		jd.setSize(1090, 593);
		jd.setLocationRelativeTo(null);
		jd.setResizable(false);// 锁定窗体
		jd.setModal(true);
		jd.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jd.setLayout(null);
        
		try {
			jt = new JTable(makeTableDate(), makeTableHead());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jt.setRowHeight (30);//设置每行的高度为30
		jt.setBounds(0,0,I_WIDTH, I_HEIGTT);
		jt.setFont(new Font("黑体", Font.PLAIN, 17));
		JScrollPane jsp = new JScrollPane(jt);
		jsp.setBounds(0, 0,I_WIDTH, I_HEIGTT);
		jd.add(jsp);
    
        
        jd.add(this);
        jd.setVisible(true);
        
        
        
	}
	
	/**
	 * 获取表中数据
	 * @return
	 * @throws SQLException 
	 */
	public Object[][] makeTableDate() throws SQLException{
		row = 0;//行数
		final int COLUMN = 7;//列数
		sql = new SQL("record");//连接到数据表
		sql.stm = sql.con.createStatement();
		String sqlWords = "select * from record where time like '"+value+"-__'";
		
		/**
		 * 本句话存放获取的结果集 executeQuery通常用于选择语句
		 */
		sql.rs = sql.stm.executeQuery(sqlWords);//将结果集储存到rs中供使用
		row = getRow(sql.rs);
		System.out.println("row:"+row);
		Object[][] obj = new Object[row][COLUMN]; //new Object[][]第一个参数是行，第二个参数是列
		
		doResultSet(sql.rs, obj);
		
		
		return obj;
	}
	
	/**
	 * 自定义获取行数的方法
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	public int getRow(ResultSet rs) throws SQLException {
		rs.last();//将光标移至最后一行
		row = rs.getRow();//获取当前行一行的编号
		
		return row;
	}

	/**
	 * 生成表头
	 * @return
	 */
	public Object[] makeTableHead(){
		String[] columnNames = { "购物者id", "商品id", "商品名称", "购买数量", "商品单价", "购买总额","交易时间" };  	   
		return (Object[])columnNames;
	}
	
	/**
	 * 传入两个参数，设置对应的obj二维数组，以便于生成对应属性的表格
	 * @param rs 操作的ResultSet对象
	 * @param obj 操作的Object二维数组
	 * @throws SQLException
	 */
	public void doResultSet(ResultSet rs,Object[][] obj) throws SQLException{
		rs.beforeFirst();//将光标移至第一行前
		//为表格中的数据赋值
		while(rs.next()){
		for (int i = 0; i < obj[rs.getRow()-1].length; i++) {
			
				obj[rs.getRow()-1][i] = rs.getString(i+1);
				System.out.println(rs.getString(i+1));
		}

		}
		sql.SQLover();
	}
}
	
	
	

