package jiemianModularization;

import java.sql.SQLException;

/**
 * 浏览员工
 * @author Junking
 *
 */
public class CDI11 extends CDI1{
	
	public CDI11() {
		
		
	}
		
		@Override
		public Object[] makeTableHead() {
			String[] columnNames = {"工号", "姓名", "性别", "年龄", "部门", "职务","电话","月薪","住址","状态","注册时间"};  	   
			
			return (Object[])columnNames;
			
		}
		
		@Override
		public Object[][] makeTableDate() throws SQLException {
			row = 0;//行数
			final int COLUMN = 11;//列数
			sql = new SQL("staff");//连接到数据表
			sql.SQLselect();//执行选择语句返回rs
			row = getRow(sql.rs);
			Object[][] obj = new Object[row][COLUMN]; //new Object[][]第一个参数是行，第二个参数是列
			
			doResultSet(sql.rs, obj);
			
			
			return obj;
		}
			
	}

