package jiemianModularization;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * 实现按钮1的对应面板
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
		jt.setRowHeight (30);//设置每行的高度为30
		jt.setBounds(0,0,I_WIDTH, I_HEIGTT);
		jt.setFont(new Font("黑体", Font.PLAIN, 17));
		JScrollPane jsp = new JScrollPane(jt);
		jsp.setBounds(0, 0,I_WIDTH, I_HEIGTT);
		
		
		this.add(jsp);
		
	}
	
	/**
	 * 获取表中数据
	 * @return
	 * @throws SQLException 
	 */
	public Object[][] makeTableDate() throws SQLException{
		row = 0;//行数
		final int COLUMN = 9;//列数
		sql = new SQL("commodity");//连接到数据表
		
		sql.SQLselect();//执行选择语句返回rs
		row = getRow(sql.rs);
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
		String[] columnNames = { "编号", "商品", "厂商", "类别", "进价", "数量","售价","进货时间","总进价" };  	   
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
		}

		}
		sql.SQLover();
	}
}
