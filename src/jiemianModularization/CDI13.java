package jiemianModularization;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 注册员工
 * 代码：整体重写CDI4
 * @author Junking
 *
 */
public class CDI13 extends CDI{
	SQL sql;
	PreparedStatement pstm;
	JPanel jp[] = new JPanel[11];//其中jp[10]是按钮组的面板
	JLabel jl[] = new JLabel[11];//其中jl[10]是标题
	JTextField jtf[] = new JTextField[10];
	JButton jb[] = new JButton[2];

	/**
	 * 组件间的间距
	 */
	public int BBLENGTH = 40;
	
	

	CDI13(){
		
		
		
		//实例化流布局面板
		int jpY=100;
		for (int i = 0; i < jp.length; i++) {
			jp[i] = new JPanel(new FlowLayout());
			jp[i].setBorder(BorderFactory.createLineBorder(Color.red));//给面板添加边框
			jp[i].setSize(300, 50);
			jp[i].setLocation(xRealCenter(jp[i]), jpY);//设置面板位置
			jpY=jpY+BBLENGTH;//间隔设定
			jp[i].setBackground(null);//面板设置为透明色
		}
		
		//设置标签jl[]详细参数
		for (int i = 0; i < jl.length-1; i++) {
			jl[i] = new JLabel();
			jl[i].setBorder(BorderFactory.createLineBorder(Color.red));
			jl[i].setFont(new Font("黑体", Font.PLAIN, 30));
			
			
		}
		//单独设置标题
		jl[10] = new JLabel();
		jl[10].setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
		jl[10].setFont(new Font("楷体", Font.PLAIN, 40));
		jl[10].setText("   注册新员工");
		jl[10].setSize(320, 50);
		jl[10].setLocation(xRealCenter(jl[10]), 50);
		this.add(jl[10]);
		
		jl[0].setText("工号");
		jl[1].setText("姓名");
		jl[2].setText("性别");
		jl[3].setText("年龄");
		jl[4].setText("部门");
		jl[5].setText("职务");
		jl[6].setText("电话");
		jl[7].setText("月薪");
		jl[8].setText("住址");
		jl[9].setText("状态");
		
		
		for (int i = 0; i < jtf.length; i++) {
			jtf[i] = new JTextField();
			jtf[i].setPreferredSize(new Dimension(200, 30));
			
		}

		
		for (int i = 0; i < jb.length; i++) {		
			jb[i] = new JButton();
			jb[i].setFont(new Font("黑体", Font.PLAIN, 20));
		}
	
		
		jb[0].setText("退出");
		jb[1].setText("注册员工");
		jb[1].addActionListener(new ActionListener() {
			
			

			@Override
			public void actionPerformed(ActionEvent e) {
				sql = new SQL("VIP");
				try {
					pstm = sql.con.prepareStatement("insert into staff values (?,?,?,?,?,?,?,?,?,?,?)");
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
				
				try {
					
					for (int i = 0; i < jtf.length; i++) {
						
						pstm.setString(i+1, jtf[i].getText()); 
					}
					pstm.setString(11, new DynamicTime().getFormatDate2()); //注册时间
					pstm.executeUpdate();
					JOptionPane.showMessageDialog(null, "操作成功！");
					
				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "操作失败！");
				}             
				sql.SQLover();
			
		}
	});
		
		
		for (int i = 0; i < 11; i++) {
			if(i<10){
				jp[i].add(jl[i]);
				jp[i].add(jtf[i]);			
			}else{//当最后一组按钮时
				jp[i].add(jb[0]);
				jp[i].add(jb[1]);
			}
			this.add(jp[i]);
		}

		this.setBackground(Color.lightGray);
		
		
	
}}
