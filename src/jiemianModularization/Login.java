package jiemianModularization;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

public class Login extends JFrame {
	

	public Login(final JFrame jf) {

		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("登录");
		setBounds(600, 600, 490, 270);
		Container cp = getContentPane();// 获取当前的容器cp，在cp中添加组件
		this.setLocationRelativeTo(null);// 在屏幕中间显示(居中显示)
		cp.setLayout(null);// 设置布局管理器
		this.setResizable(false);// 锁定登录框大小

		JLabel jl = new JLabel("用户名：");
		jl.setFont(new Font("黑体", Font.PLAIN, 16));
		jl.setBounds(210, 110, 200, 18);
		final JTextField name = new JTextField();
		name.setBounds(280, 110, 200, 18);

		JLabel jl2 = new JLabel("密码：");
		jl2.setFont(new Font("Dialog", Font.PLAIN, 16));
		jl2.setBounds(210, 150, 200, 18);
		final JPasswordField password = new JPasswordField();
		password.setBounds(280, 150, 200, 18);

		ImageIcon icon = new ImageIcon("dennis.png");// 添加丹尼斯图标
		JLabel imagelable = new JLabel(icon);
		imagelable.setBounds(10, 10, 171, 213);

		ImageIcon icon2 = new ImageIcon("dennis2.png");// 添加丹尼斯字母
		JLabel imagelable2 = new JLabel(icon2);
		imagelable2.setBounds(210, 20, 268, 45);

		JButton reg = new JButton("注册");
		reg.setBounds(420, 180, 60, 18);
		reg.addActionListener(new register());

		cp.add(reg);
		cp.add(jl);
		cp.add(name);
		cp.add(jl2);
		cp.add(password);
		cp.add(imagelable);
		cp.add(imagelable2);

		JButton jb = new JButton("确定");
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (name.getText().trim().length() == 0
						|| new String(password.getPassword()).trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "用户名密码不允许为空");
					return;
				}

				try {
					if (isLogin(name, password)) {
						JOptionPane.showMessageDialog(null, "登录成功");

						dispose();// 销毁登录界面
						/**
						 * 登录到主界面
						 **/
					
						Test t = new Test();
						t.setVisible(true);
					}

					else {
						JOptionPane.showMessageDialog(null, "用户名或密码错误");
					}
				} catch (HeadlessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		jb.setBounds(280, 180, 60, 18);
		cp.add(jb);
		this.getRootPane().setDefaultButton(jb);// 为确定键添加回车响应

		final JButton button = new JButton();
		button.setText("重置");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成方法存根
				name.setText("");
				password.setText("");
			}
		});
		button.setBounds(350, 180, 60, 18);
		getContentPane().add(button);
		setVisible(true);

	}

	class register implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Register r = new Register();
		}
	}

	/**
	 * 验证账户密码是否匹配数据库中的数据，如果验证成功，则登入系统
	 * 
	 * @param name
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public boolean isLogin(JTextField name, JPasswordField password)
			throws SQLException {
		SQL s = new SQL("login");
		s.stm = s.con.createStatement();
		String sqlWords = "select * from login where id='"+ name.getText()+"'";
		/**
		 * 本句话存放获取的结果集 executeQuery通常用于选择语句
		 */
		s.rs = s.stm.executeQuery(sqlWords);//将结果集储存到rs中供使用

		while (s.rs.next()) {// 用户输入信息和数据库信息作比较
			PersonData.Nip = s.rs.getString(1);
			PersonData.Nname = s.rs.getString(2);
			PersonData.Npassword = s.rs.getString(3);
			if (name.getText().equals(PersonData.Nip)
					&& password.getText().equals(PersonData.Npassword)) {

				
				System.out.println("帐号密码验证通过！");

				return true;
			}
		}

		s.SQLover();
		System.out.println("帐号密码验证不通过！");
		return false;
	}

}