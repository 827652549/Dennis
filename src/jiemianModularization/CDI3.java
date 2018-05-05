package jiemianModularization;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * 布局实现：创建流布局三个面板，将每组组件添加上去，然后再用居中设定面板的位置
 * @author Junking
 *
 */
public class CDI3 extends CDI{
		
	JLabel jl1,jl2;
	JTextField jtf1,jtf2;
	JButton jb1,jb2 ;
	JPanel jp1,jp2,jp3;//负责将3组组件组合居中
	CDI3(){
		//实例化流布局面板
		jp1 = new JPanel(new FlowLayout());
		jp2 = new JPanel(new FlowLayout());
		jp3 = new JPanel(new FlowLayout());
		
		//给面板添加边框
		jp1.setBorder(BorderFactory.createLineBorder(Color.red));
		jp2.setBorder(BorderFactory.createLineBorder(Color.red));
		jp3.setBorder(BorderFactory.createLineBorder(Color.red));

		
		
		
		jp1.setSize(600, 50);
		jp2.setSize(600, 50);
		jp3.setSize(300, 50);
		
		//设置面板位置
		jp1.setLocation(xRealCenter(jp1), 100);
		jp2.setLocation(xRealCenter(jp2), 200);
		jp3.setLocation(xRealCenter(jp3), 300);
		
		
		//面板设置为透明色
		jp1.setBackground(null);
		jp2.setBackground(null);
		jp3.setBackground(null);

		//设置标签jl1详细参数
		jl1 = new JLabel("请输入商品编号：");
		jl1.setBorder(BorderFactory.createLineBorder(Color.red));
		jl1.setFont(new Font("黑体", Font.PLAIN, 30));
		
		//设置jtf1详细参数
		jtf1 = new JTextField();
		jtf1.setPreferredSize(new Dimension(200, 40));
		
		jb1 = new JButton("取消");
		jb1.setFont(new Font("黑体", Font.PLAIN, 20));
		
		jl2 = new JLabel("请输入商品数量：");
		jl2.setBorder(BorderFactory.createLineBorder(Color.red));
		jl2.setFont(new Font("黑体", Font.PLAIN, 30));
		
		
		jtf2 = new JTextField();
		jtf2.setPreferredSize(new Dimension(200, 40));
		
		
		jb2 = new JButton("确定");
		jb2.setFont(new Font("黑体", Font.PLAIN, 20));
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int jtf01 = 0;//输入文本框的编号
				int jtf02 = 0;//输入文本框的需要增加的值
				
				//判断是否符合格式
				if(isSure(jtf1.getText())){
					jtf01 = Integer.parseInt(jtf1.getText());
						if(isSure(jtf2.getText())){
							jtf02 = getValue(jtf01) + Integer.parseInt(jtf2.getText());
							JOptionPane.showMessageDialog(null, "添加已完成！");							
						}
						else return;
				}else return;
				
				SQL sql = new SQL("commodity");
				sql.SQLconnect();
				
				PreparedStatement psql = null;
				//预处理更新（修改）数据，将王刚的sal改为5000.0
				
					try {
						psql = sql.con.prepareStatement("update commodity set nums = ? where id = ?");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				try {
					psql.setInt(1,jtf02);//数量
					psql.setInt(2,jtf01);     //编号  
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}      
				try {
					psql.executeUpdate();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				sql.SQLover();
				
			}
		});
		
		
		//将各组组件添加到对应标签中
		jp1.add(jl1);
		jp1.add(jtf1);
		
		jp2.add(jl2);
		jp2.add(jtf2);
		
		jp3.add(jb1);
		jp3.add(jb2);
		

		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.setBackground(Color.cyan);
		
		
	}
	
	public static boolean isSure(String value){
		//判断是否为数字并且判断是否过长
		if(new IsNums().isNumeric(value)&&value.length()<=11&&value.length()>=0)
		{
			
			return true;
		}else {
			JOptionPane.showMessageDialog(null, "请输入正确格式的商品编号", "查询有误", JOptionPane.CLOSED_OPTION, null);
			return false;
		}
	}
	
	/**
	 * 输入的参数是对应编号
	 * 收集原对应数据
	 * @return
	 */
	public int getValue(int id){
		int valueReal = -1;
		SQL sql = new SQL("commodity");//连接到数据表

		try {
			sql.stm = sql.con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sqlWords = "select * from commodity where id = "+id;
		/**
		 * 本句话存放获取的结果集 executeQuery通常用于选择语句
		 */
		try {
			sql.rs = sql.stm.executeQuery(sqlWords);
			sql.rs.next();
			valueReal = sql.rs.getInt("nums");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//将结果集储存到rs中供使用
		
		return valueReal;
	}
	
	
}
