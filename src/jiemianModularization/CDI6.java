package jiemianModularization;

import java.sql.SQLException;

public class CDI6 extends CDI1{
	
	public CDI6() {


		  	
	}
	
	@Override
	public Object[] makeTableHead() {
		String[] columnNames = { "帐号", "姓名", "性别", "住址", "电话", "折扣","注册时间"};  	   
		return (Object[])columnNames;
		}
	
	@Override
	public Object[][] makeTableDate() throws SQLException {
		row = 0;//行数
		final int COLUMN = 7;//列数
		sql = new SQL("vip");//连接到数据表
		sql.SQLselect();//执行选择语句返回rs
		row = getRow(sql.rs);
		Object[][] obj = new Object[row][COLUMN]; //new Object[][]第一个参数是行，第二个参数是列
		
		doResultSet(sql.rs, obj);
		
		
		return obj;
	}
	
}
