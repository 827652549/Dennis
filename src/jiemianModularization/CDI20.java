package jiemianModularization;

import java.sql.SQLException;

/**
 * 浏览全部：将每一天的销售额汇总成总表格（从第一天开始）
 * 
 * @author Junking
 *
 */
public class CDI20 extends CDI1 {
	public CDI20() {
	}

	@Override
	public Object[] makeTableHead() {
		String[] columnNames = { "日期", "进货总额", "销售总额", "利润" };
		return (Object[]) columnNames;
	}

	@Override
	public Object[][] makeTableDate() throws SQLException {
		row = 0;// 行数
		final int COLUMN = 4;// 列数
		sql = new SQL("sale");// 连接到数据表
		sql.SQLselect();// 执行选择语句返回rs
		row = getRow(sql.rs);
		Object[][] obj = new Object[row][COLUMN]; // new
													// Object[][]第一个参数是行，第二个参数是列

		doResultSet(sql.rs, obj);

		return obj;
	}
}
