package testJDialog;

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
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import jiemianModularization.Login;
import jiemianModularization.PersonData;
import jiemianModularization.SQL;


public class TestJDialog extends JDialog{
	
	JButton jb[] = new JButton[2]; // jb0是退出 jb1是修改密码
	JLabel[] jl;// jl0是标题
	JTextField[] jtf ;
	
	
	
/**
 * 排版实现方式:流布局直接伸缩到使组件最佳位置，然后固定JDialog大小
 */
	public TestJDialog() {
		jl = new JLabel[9];// jl0是标题
		jtf = new JTextField[8]; // 0~5是不可编辑的 6、7是可以编辑的
		this.setTitle("您可以在此处修改您的密码");
		this.setSize(430, 430);
		this.setLocationRelativeTo(null);
		this.setResizable(false);// 锁定窗体
		this.setModal(true);
		this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.setLayout(new FlowLayout());
		

        //单独设置标题
        jl[0] = new JLabel();
        jl[0].setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
        jl[0].setFont(new Font("楷体", Font.PLAIN, 50));
        jl[0].setText("    个人详情    ");
        jl[0].setSize(new Dimension(600, 50));
		
		//设置标签jl[]详细参数
				for (int i = 1; i < jl.length; i++) {
					jl[i] = new JLabel();
					jl[i].setBorder(BorderFactory.createLineBorder(Color.red));
					if(i<7)
					jl[i].setFont(new Font("黑体", Font.PLAIN, 20));
					else{
						jl[i].setFont(new Font("黑体", Font.PLAIN, 30));
						jl[i].setForeground(Color.magenta);
						
					}
					
				}
		
				
				
				
				jl[1].setText("帐号:");
				jl[2].setText("姓名:");
				jl[3].setText("性别:");
				jl[4].setText("部门:");
				jl[5].setText("职务:");
				jl[6].setText("注册时间:");
				jl[7].setText("请输入新密码：");
				jl[8].setText("请您确认密码：");
			
				for (int i = 0; i < jtf.length; i++) {
					
					jtf[i] = new JTextField();
					if(i<6)//将前六个文本框设置为不可编辑
						jtf[i].setEditable(false);
					
					if(i>=5)
					jtf[i].setPreferredSize(new Dimension(360, 35));
					else
					jtf[i].setPreferredSize(new Dimension(310, 35));
					
				}
				//为文本框赋值
				jtf[0].setText(PersonData.Nip);
				
				jtf[1].setText(PersonData.Nname);
				
				for (int i = 0; i < jb.length; i++) {		
					jb[i] = new JButton();
					jb[i].setFont(new Font("黑体", Font.PLAIN, 20));
					
				}
				
				jb[0].setText("返回");
				jb[1].setText("修改密码");
				jb[1].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						SQL sql = new SQL("login");
						PreparedStatement psql = null;
						
						String sqlWords = "update login set password = ? where id ='"+PersonData.Nip+"'";
						
						/**
						 * 本句话存放获取的结果集 executeQuery通常用于选择语句
						 */
						try {
							psql = sql.con.prepareStatement(sqlWords);
							if(jtf[6].getText().equals(jtf[7].getText())){
								
								psql.setString(1,jtf[6].getText());//商品
								JOptionPane.showMessageDialog(null, "密码修改成功！");
								psql.executeUpdate();
							}
							else JOptionPane.showMessageDialog(null, "两次密码输入不一样");
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}//将结果集储存到rs中供使用
						
						
						
						
						
					}
				});
				
				jb[0].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				
//				jtf[6].setText("测试1");//输入密码框
//				jtf[7].setText("测试2");//核对密码框
				
				
				
				
				
				
				this.add(jl[0]);//添加标题
				
				/**
				 * 一个框对应一个标签
				 */
				for (int j = 1; j<jl.length; j++) {
					if(j <3||j>6){
						
						this.add(jl[j]);
						this.add(jtf[j-1]);
					}
					
				}
				
				
				
				this.add(jb[0]);
				this.add(jb[1]);

				this.setVisible(true);
	}


	
	
	
	
}
