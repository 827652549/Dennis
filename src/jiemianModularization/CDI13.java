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
 * ע��Ա��
 * ���룺������дCDI4
 * @author Junking
 *
 */
public class CDI13 extends CDI{
	SQL sql;
	PreparedStatement pstm;
	JPanel jp[] = new JPanel[11];//����jp[10]�ǰ�ť������
	JLabel jl[] = new JLabel[11];//����jl[10]�Ǳ���
	JTextField jtf[] = new JTextField[10];
	JButton jb[] = new JButton[2];

	/**
	 * �����ļ��
	 */
	public int BBLENGTH = 40;
	
	

	CDI13(){
		
		
		
		//ʵ�������������
		int jpY=100;
		for (int i = 0; i < jp.length; i++) {
			jp[i] = new JPanel(new FlowLayout());
			jp[i].setBorder(BorderFactory.createLineBorder(Color.red));//�������ӱ߿�
			jp[i].setSize(300, 50);
			jp[i].setLocation(xRealCenter(jp[i]), jpY);//�������λ��
			jpY=jpY+BBLENGTH;//����趨
			jp[i].setBackground(null);//�������Ϊ͸��ɫ
		}
		
		//���ñ�ǩjl[]��ϸ����
		for (int i = 0; i < jl.length-1; i++) {
			jl[i] = new JLabel();
			jl[i].setBorder(BorderFactory.createLineBorder(Color.red));
			jl[i].setFont(new Font("����", Font.PLAIN, 30));
			
			
		}
		//�������ñ���
		jl[10] = new JLabel();
		jl[10].setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
		jl[10].setFont(new Font("����", Font.PLAIN, 40));
		jl[10].setText("   ע����Ա��");
		jl[10].setSize(320, 50);
		jl[10].setLocation(xRealCenter(jl[10]), 50);
		this.add(jl[10]);
		
		jl[0].setText("����");
		jl[1].setText("����");
		jl[2].setText("�Ա�");
		jl[3].setText("����");
		jl[4].setText("����");
		jl[5].setText("ְ��");
		jl[6].setText("�绰");
		jl[7].setText("��н");
		jl[8].setText("סַ");
		jl[9].setText("״̬");
		
		
		for (int i = 0; i < jtf.length; i++) {
			jtf[i] = new JTextField();
			jtf[i].setPreferredSize(new Dimension(200, 30));
			
		}

		
		for (int i = 0; i < jb.length; i++) {		
			jb[i] = new JButton();
			jb[i].setFont(new Font("����", Font.PLAIN, 20));
		}
	
		
		jb[0].setText("�˳�");
		jb[1].setText("ע��Ա��");
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
					pstm.setString(11, new DynamicTime().getFormatDate2()); //ע��ʱ��
					pstm.executeUpdate();
					JOptionPane.showMessageDialog(null, "�����ɹ���");
					
				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "����ʧ�ܣ�");
				}             
				sql.SQLover();
			
		}
	});
		
		
		for (int i = 0; i < 11; i++) {
			if(i<10){
				jp[i].add(jl[i]);
				jp[i].add(jtf[i]);			
			}else{//�����һ�鰴ťʱ
				jp[i].add(jb[0]);
				jp[i].add(jb[1]);
			}
			this.add(jp[i]);
		}

		this.setBackground(Color.lightGray);
		
		
	
}}
