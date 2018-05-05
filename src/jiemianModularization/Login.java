package jiemianModularization;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

public class Login extends JFrame {
	

	public Login(final JFrame jf) {

		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("��¼");
		setBounds(600, 600, 490, 270);
		Container cp = getContentPane();// ��ȡ��ǰ������cp����cp��������
		this.setLocationRelativeTo(null);// ����Ļ�м���ʾ(������ʾ)
		cp.setLayout(null);// ���ò��ֹ�����
		this.setResizable(false);// ������¼���С

		JLabel jl = new JLabel("�û�����");
		jl.setFont(new Font("����", Font.PLAIN, 16));
		jl.setBounds(210, 110, 200, 18);
		final JTextField name = new JTextField();
		name.setBounds(280, 110, 200, 18);

		JLabel jl2 = new JLabel("���룺");
		jl2.setFont(new Font("Dialog", Font.PLAIN, 16));
		jl2.setBounds(210, 150, 200, 18);
		final JPasswordField password = new JPasswordField();
		password.setBounds(280, 150, 200, 18);

		ImageIcon icon = new ImageIcon("dennis.png");// ��ӵ���˹ͼ��
		JLabel imagelable = new JLabel(icon);
		imagelable.setBounds(10, 10, 171, 213);

		ImageIcon icon2 = new ImageIcon("dennis2.png");// ��ӵ���˹��ĸ
		JLabel imagelable2 = new JLabel(icon2);
		imagelable2.setBounds(210, 20, 268, 45);

		JButton reg = new JButton("ע��");
		reg.setBounds(420, 180, 60, 18);
		reg.addActionListener(new register());

		cp.add(reg);
		cp.add(jl);
		cp.add(name);
		cp.add(jl2);
		cp.add(password);
		cp.add(imagelable);
		cp.add(imagelable2);

		JButton jb = new JButton("ȷ��");
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (name.getText().trim().length() == 0
						|| new String(password.getPassword()).trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "�û������벻����Ϊ��");
					return;
				}

				try {
					if (isLogin(name, password)) {
						JOptionPane.showMessageDialog(null, "��¼�ɹ�");

						dispose();// ���ٵ�¼����
						/**
						 * ��¼��������
						 **/
					
						Test t = new Test();
						t.setVisible(true);
					}

					else {
						JOptionPane.showMessageDialog(null, "�û������������");
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
		this.getRootPane().setDefaultButton(jb);// Ϊȷ������ӻس���Ӧ

		final JButton button = new JButton();
		button.setText("����");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO �Զ����ɷ������
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
	 * ��֤�˻������Ƿ�ƥ�����ݿ��е����ݣ������֤�ɹ��������ϵͳ
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
		 * ���仰��Ż�ȡ�Ľ���� executeQueryͨ������ѡ�����
		 */
		s.rs = s.stm.executeQuery(sqlWords);//����������浽rs�й�ʹ��

		while (s.rs.next()) {// �û�������Ϣ�����ݿ���Ϣ���Ƚ�
			PersonData.Nip = s.rs.getString(1);
			PersonData.Nname = s.rs.getString(2);
			PersonData.Npassword = s.rs.getString(3);
			if (name.getText().equals(PersonData.Nip)
					&& password.getText().equals(PersonData.Npassword)) {

				
				System.out.println("�ʺ�������֤ͨ����");

				return true;
			}
		}

		s.SQLover();
		System.out.println("�ʺ�������֤��ͨ����");
		return false;
	}

}