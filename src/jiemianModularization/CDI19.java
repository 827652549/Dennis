package jiemianModularization;

import java.sql.SQLException;

/**
 * 浏览全部：将每一天的销售额汇总成总表格（从第一天开始）
 * 
 * @author Junking
 *
 */
public class CDI19 extends CDI1 {
	public CDI19() {
	}

	@Override
	public Object[] makeTableHead() {
		String[] columnNames = { "购物者id", "商品id", "商品名称", "购买数量", "商品单价", "购买总额","交易时间"};
		return (Object[]) columnNames;
	}

	@Override
	public Object[][] makeTableDate() throws SQLException {
		row = 0;// 行数
		final int COLUMN = 7;// 列数
		sql = new SQL("record");// 连接到数据表
		sql.SQLselect();// 执行选择语句返回rs
		row = getRow(sql.rs);
		Object[][] obj = new Object[row][COLUMN]; // new
													// Object[][]第一个参数是行，第二个参数是列

		doResultSet(sql.rs, obj);

		return obj;
	}
}
