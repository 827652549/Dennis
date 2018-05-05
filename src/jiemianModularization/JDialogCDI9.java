package jiemianModularization;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class JDialogCDI9 extends JDialog{

	JButton jb[]; 
	JLabel[] jl;// jl0是标题
	JTextField[] jtf ;
	SQL sql;
	
	
	public JDialogCDI9(String value) {
		jb= new JButton[2]; 
		jl = new JLabel[9];
		jtf = new JTextField[9]; // 0~5是不可编辑的 6、7是可以编辑的
		this.setTitle("请修改您的VIP信息：");
		this.setSize(430, 450);
		this.setLocationRelativeTo(null);
		this.setResizable(false);// 锁定窗体
		this.setModal(true);
		this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.setLayout(new FlowLayout());
		
		//设置标签jl[]详细参数
				for (int i = 0; i < jl.length; i++) {
					jl[i] = new JLabel();
					jl[i].setBorder(BorderFactory.createLineBorder(Color.red));
					jl[i].setFont(new Font("黑体", Font.PLAIN, 20));
					
					
				}
		
				
				
				
				jl[0].setText("编号:");
				jl[1].setText("姓名:");
				jl[2].setText("性别:");
				jl[3].setText("住址:");
				jl[4].setText("手机:");
				jl[5].setText("折扣:");
				jl[6].setText("时间:");

				
				sql = new SQL("VIP");//连接到数据表
				try {
					sql.SQLselect();//执行选择语句为对象中rs赋值
				//判断是否为数字并且判断是否过长
					if(!new IsNums().isNumeric(value)&&value.length()<=11&&value.length()>=0)
					{					
						JOptionPane.showMessageDialog(null, "请输入正确格式的商品编号", "查询有误", JOptionPane.CLOSED_OPTION, null);
						return;
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("select对象异常");
				}
				
				//获取制定数据那一行
				try {
					sql.stm = sql.con.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String sqlWords = "select * from VIP where id="+Integer.parseInt(value)+"";
				try {
					sql.rs = sql.stm.executeQuery(sqlWords);
					
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
			try {
				if(sql.rs.next()){
					
				
					for (int i = 0; i < jtf.length; i++) {
						
						String s = null;
						try {
							
							s = sql.rs.getString(i+1);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						jtf[i] = new JTextField(s);
						jtf[i].setFont(new Font("宋体", Font.BOLD,25));
						jtf[i].setPreferredSize(new Dimension(310, 35));
						
					}
					jtf[0].setEditable(false);
				
					sql.SQLover();
					for (int i = 0; i < jb.length; i++) {		
						jb[i] = new JButton();
						jb[i].setFont(new Font("黑体", Font.PLAIN, 20));
						
					}
					
					jb[0].setText("返回");
					jb[0].addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							dispose();
						}
					});		
					
					jb[1].setText("更新");
					jb[1].addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							int jtf01 = 0;//输入文本框的编号
							int jtf02 = 0;//输入文本框的需要增加的值
							
							//判断是否符合格式
							if(CDI3.isSure(jtf[0].getText())){
								jtf01 = Integer.parseInt(jtf[0].getText());
									
							}else return;
							
							SQL sql = new SQL("VIP");
							
							
							PreparedStatement psql = null;
							//预处理更新（修改）数据，将王刚的sal改为5000.0
							
								try {
									psql = sql.con.prepareStatement("update VIP set name = ?,sex = ?,home = ?,phone = ?,discount = ?,time = ? where id = ?");
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
							try {
								for (int i = 0; i < 6; i++) {
									
									psql.setString(i+1,jtf[i+1].getText());//商品
								}
								psql.setInt(7,jtf01);     //编号  
							
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}      
							try {
								psql.executeUpdate();
								JOptionPane.showMessageDialog(null, "更新成功");
								
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								JOptionPane.showMessageDialog(null, "更新失败");
							}
							
							sql.SQLover();
							dispose();
							
						}
					});
					
					/**
					 * 一个框对应一个标签
					 */
					for (int j = 0; j < jtf.length-2; j++) {
						
						this.add(jl[j]);
						this.add(jtf[j]);
					}
					
					
					
					this.add(jb[0]);
					this.add(jb[1]);


					this.setVisible(true);
				}else JOptionPane.showMessageDialog(null, "未找到该编号的VIP");
			} catch (HeadlessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	}

