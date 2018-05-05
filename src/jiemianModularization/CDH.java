package jiemianModularization;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * D选项卡中的H面板 Jpanel默认布局是FlowLayout
 * 
 * @author Junking
 *
 */
public class CDH extends JPanel {

	JPanel p;
	CDI cdi;
	JButton H[] = new JButton[5];

	CDH(JPanel p, Object o) {
		this.p = p;
		this.cdi = (CDI) o;
		cdi.setLocation(201, 0);
		H[0] = new JButton("浏览商品");
		H[1] = new JButton("查询商品");
		H[2] = new JButton("新进商品");
		H[3] = new JButton("新增商品");
		H[4] = new JButton("更新商品");

		for (int i = 0; i < H.length; i++) {
			H[i].setFont(new Font("黑体", Font.PLAIN, 25));

		}
		setWay();
		this.setLayout(new GridLayout(5, 1, 0, 25));
		/*
		 * createEmptyBorder(int top, int left, int bottom, int right)
		 * 创建一个占用空间但没有绘制的空边框，指定了顶线、左边框线、底线和右边框线的宽度。
		 */
		this.setBorder(BorderFactory.createEmptyBorder(50, 25, 50, 25));
		this.setBackground(Color.BLUE);

		this.setLocation(0, 0);
		this.setSize(200, 593);

		// 给每个按钮添加监听并将按钮添加到面板上
		for (int i = 0; i < 5; i++) {
			setListener(H[i]);
			this.add(H[i]);
		}

	}

	/**
	 * 定义一个空方法，方便子类继承重写并实现修改按钮文字
	 */
	public void setWay() {

	}

	/**
	 * 定义一个方法，方便子类重写监听器
	 */
	public void setListener(JButton H) {
		H.addActionListener(new Listener());
	}

	/**
	 * 监听所有选项卡中的按钮对象
	 * 
	 * @author Junking
	 *
	 */
	class Listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object l = new Object();

			Test.jb0 = 0;

			if (isText(e, "浏览商品")) {
				Add666(new CDI1());

			} else if (isText(e, "查询商品")) {
				Add666(new CDI2());
			} else if (isText(e, "新进商品")) {
				Add666(new CDI3());
			} else if (isText(e, "新增商品")) {
				Add666(new CDI4());
			} else if (isText(e, "更新商品")) {
				Add666(new CDI5());
			} else if (isText(e, "浏览VIP")) {
				Add666(new CDI6());
			} else if (isText(e, "购物记录")) {
				Add666(new CDI7());
			} else if (isText(e, "注册VIP")) {
				Add666(new CDI8());
			} else if (isText(e, "查看修改")) {
				Add666(new CDI9());
			} else if (isText(e, "注销VIP")) {
				Add666(new CDI10());
			} else if (isText(e, "浏览员工")) {
				Add666(new CDI11());
			} else if (isText(e, "查询员工")) {
				Add666(new CDI12());
			} else if (isText(e, "注册员工")) {
				Add666(new CDI13());
			} else if (isText(e, "修改员工")) {
				Add666(new CDI14());
			} else if (isText(e, "注销员工")) {
				Add666(new CDI15());
			} else if (isText(e, "单日查询")) {
				Add666(new CDI16());
			} else if (isText(e, "单月查询")) {
				Add666(new CDI17());
			} else if (isText(e, "年份查询")) {
				Add666(new CDI18());
			} else if (isText(e, "浏览全部")) {
				Add666(new CDI19());
			} else if (isText(e, "总额查询")) {
				Add666(new CDI20());
			} else
				System.out.println("未识别到此4*5个按钮的其中一种。");
		}
	}

	/**
	 * 判断按钮上的文字
	 */
	public boolean isText(ActionEvent e, String s) {
		Test.jb0++;
		if (((JButton) e.getSource()).getText().toString() == s) {
			System.out.println("(测试专用)您触发的按钮是"
					+ ((JButton) e.getSource()).getText().toString());
			System.out.println("这是第" + Test.jb0 + "个按钮");

			return true;

		} else {
			return false;
		}
	}

	/**
	 * 添加替换面板的方法
	 * 
	 * @param obj
	 */
	public void Add666(Object obj) {
		JPanel jp = (JPanel) obj;

		cdi.setVisible(false);

		cdi.removeAll();// 移除所有组件

		cdi.add(jp);

		cdi.setVisible(true);
	}

}