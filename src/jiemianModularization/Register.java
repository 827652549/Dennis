package jiemianModularization;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class Register extends JDialog{
	PreparedStatement pstm;
	JTextField idReg;
	JTextField passwordReg;
	JTextField nameReg;
	
	public Register() {
		this.setLayout(new FlowLayout(FlowLayout.CENTER));				//网格式布局    
		
		this.setTitle("新用户注册");							//窗体标签  
		this.setSize(400, 280);								//窗体大小  
		this.setLocationRelativeTo(null);					//在屏幕中间显示(居中显示)  
		this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		this.setVisible(true);								//显示窗体 
		this.setResizable(false);							//锁定窗体
		
		
		JButton back = new JButton("返回");	//返回菜单按钮
		back.setFont(new Font("Dialog", Font.PLAIN, 20));
		back.setPreferredSize(new Dimension(80,30));
		
		JButton addR = new JButton("注册");	//注册按钮
		addR.setFont(new Font("Dialog", Font.PLAIN, 20));
		addR.setPreferredSize(new Dimension(80,30));
		
		JLabel id = new JLabel("账号：");
		id.setFont(new Font("Dialog", Font.PLAIN, 30));
		id.setPreferredSize(new Dimension(120,50));
		
		JLabel name = new JLabel("姓名：");
		name.setFont(new Font("Dialog", Font.PLAIN, 30));
		name.setPreferredSize(new Dimension(120,50));
		
		JLabel password = new JLabel("密码：");
		password.setFont(new Font("Dialog", Font.PLAIN, 30));
		password.setPreferredSize(new Dimension(120,50));
		
		idReg = new JTextField();
		idReg.setFont(new Font("Dialog", Font.PLAIN, 30));
		idReg.setPreferredSize(new Dimension(180,40));
		
		passwordReg = new JTextField();
		passwordReg.setFont(new Font("Dialog", Font.PLAIN,30));
		passwordReg.setPreferredSize(new Dimension(180,40));
		
		nameReg = new JTextField();
		nameReg.setFont(new Font("Dialog", Font.PLAIN, 30));
		nameReg.setPreferredSize(new Dimension(180,40));
		
		
		
		this.add(id);
		this.add(idReg);
		this.add(password);
		this.add(passwordReg);
		this.add(name);
		this.add(nameReg);
		this.add(addR);
		this.add(back);
		
		back.addActionListener(new BackLogin());
		addR.addActionListener(new register());

	
	
	}
	
	/*
	 * 响应注册按钮的
	 */
	class  register implements ActionListener{ 
		  public void actionPerformed(ActionEvent e){ 
		        SQL sql = new SQL("login");
		        try {
					pstm = sql.con.prepareStatement("insert into login values (?,?,?)");
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
		        try {
					pstm.setString(1, idReg.getText());
					pstm.setString(2, nameReg.getText());
					pstm.setString(3, passwordReg.getText());
					pstm.executeUpdate();
					JOptionPane.showMessageDialog(null, "注册成功");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "注册失败");
					
				}
		        System.out.println("注册功能执行完毕。");
				 dispose();
		  }	
	}
	
	/**
	 * 响应返回菜单按钮的,返回等到登录界面
	 */
	class  BackLogin implements ActionListener{ 
		  public void actionPerformed(ActionEvent e){ 
			 dispose();
			 
		  }	
	}
}
