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
 * 注册VIP
 * @author Junking
 *
 */
public class CDI8 extends CDI{
	SQL sql;
	PreparedStatement pstm;
		JPanel jp[] = new JPanel[8];//其中jp[7]是按钮组的面板
		JLabel jl[] = new JLabel[8];//其中jl[7]是标题
		JTextField jtf[] = new JTextField[7];
		JButton jb[] = new JButton[2];

		CDI8(){
			
			//实例化流布局面板
			int jpY=100;
			for (int i = 0; i < jp.length; i++) {
				jp[i] = new JPanel(new FlowLayout());
				jp[i].setBorder(BorderFactory.createLineBorder(Color.red));//给面板添加边框
				jp[i].setSize(300, 50);
				jp[i].setLocation(xRealCenter(jp[i]), jpY);//设置面板位置
				jpY=jpY+50;//间隔设定
				jp[i].setBackground(null);//面板设置为透明色
			}
			
			//设置标签jl[]详细参数
			for (int i = 0; i < jl.length-1; i++) {
				jl[i] = new JLabel();
				jl[i].setBorder(BorderFactory.createLineBorder(Color.red));
				jl[i].setFont(new Font("黑体", Font.PLAIN, 30));
				
				
			}
			//单独设置标题
			jl[7] = new JLabel();
			jl[7].setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
			jl[7].setFont(new Font("楷体", Font.PLAIN, 40));
			jl[7].setText("   注册VIP用户");
			
			jl[7].setSize(320, 50);
			jl[7].setLocation(xRealCenter(jl[7]), 50);
			this.add(jl[7]);

			
			jl[0].setText("帐号:");
			jl[1].setText("密码:");
			jl[2].setText("姓名:");
			jl[3].setText("性别:");
			jl[4].setText("住址:");
			jl[5].setText("电话:");
			jl[6].setText("折扣:");
			
			
			for (int i = 0; i < jtf.length; i++) {
				jtf[i] = new JTextField();
				jtf[i].setPreferredSize(new Dimension(200, 40));
				
			}

			
			for (int i = 0; i < jb.length; i++) {		
				jb[i] = new JButton();
				jb[i].setFont(new Font("黑体", Font.PLAIN, 20));
			}
			
			jb[0].setText("退出");
			jb[1].setText("注册VIP");
			jb[1].addActionListener(new ActionListener() {
				
				

					@Override
					public void actionPerformed(ActionEvent e) {
						sql = new SQL("VIP");
						try {
							pstm = sql.con.prepareStatement("insert into VIP values (?,?,?,?,?,?,?)");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
						try {
							//循环7次，提取7个文本框并赋值
							
								
								pstm.setString(1, jtf[0].getText()); 
								pstm.setString(2, jtf[2].getText()); 
								pstm.setString(3, jtf[3].getText()); 
								pstm.setString(4, jtf[4].getText()); 
								pstm.setString(5, jtf[5].getText()); 
								pstm.setString(6, jtf[6].getText()); 
								
								pstm.setString(7, new DynamicTime().getFormatDate2()); 
							
							
							pstm.executeUpdate();
							JOptionPane.showMessageDialog(null, "操作成功！");
							
						} catch (SQLException e1) {
							e1.printStackTrace();
							JOptionPane.showMessageDialog(null, "操作失败！");
						}             
						sql.SQLover();
					
				}
			});
			
			for (int i = 0; i < 8; i++) {
				if(i<7){
					jp[i].add(jl[i]);
					jp[i].add(jtf[i]);			
				}else{//当最后一组按钮时
					jp[i].add(jb[0]);
					jp[i].add(jb[1]);
				}
				this.add(jp[i]);
			}

			this.setBackground(Color.lightGray);
	}
		
		

		
	}

