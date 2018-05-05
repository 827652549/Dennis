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
	
	JButton jb[] = new JButton[2]; // jb0���˳� jb1���޸�����
	JLabel[] jl;// jl0�Ǳ���
	JTextField[] jtf ;
	
	
	
/**
 * �Ű�ʵ�ַ�ʽ:������ֱ��������ʹ������λ�ã�Ȼ��̶�JDialog��С
 */
	public TestJDialog() {
		jl = new JLabel[9];// jl0�Ǳ���
		jtf = new JTextField[8]; // 0~5�ǲ��ɱ༭�� 6��7�ǿ��Ա༭��
		this.setTitle("�������ڴ˴��޸���������");
		this.setSize(430, 430);
		this.setLocationRelativeTo(null);
		this.setResizable(false);// ��������
		this.setModal(true);
		this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.setLayout(new FlowLayout());
		

        //�������ñ���
        jl[0] = new JLabel();
        jl[0].setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
        jl[0].setFont(new Font("����", Font.PLAIN, 50));
        jl[0].setText("    ��������    ");
        jl[0].setSize(new Dimension(600, 50));
		
		//���ñ�ǩjl[]��ϸ����
				for (int i = 1; i < jl.length; i++) {
					jl[i] = new JLabel();
					jl[i].setBorder(BorderFactory.createLineBorder(Color.red));
					if(i<7)
					jl[i].setFont(new Font("����", Font.PLAIN, 20));
					else{
						jl[i].setFont(new Font("����", Font.PLAIN, 30));
						jl[i].setForeground(Color.magenta);
						
					}
					
				}
		
				
				
				
				jl[1].setText("�ʺ�:");
				jl[2].setText("����:");
				jl[3].setText("�Ա�:");
				jl[4].setText("����:");
				jl[5].setText("ְ��:");
				jl[6].setText("ע��ʱ��:");
				jl[7].setText("�����������룺");
				jl[8].setText("����ȷ�����룺");
			
				for (int i = 0; i < jtf.length; i++) {
					
					jtf[i] = new JTextField();
					if(i<6)//��ǰ�����ı�������Ϊ���ɱ༭
						jtf[i].setEditable(false);
					
					if(i>=5)
					jtf[i].setPreferredSize(new Dimension(360, 35));
					else
					jtf[i].setPreferredSize(new Dimension(310, 35));
					
				}
				//Ϊ�ı���ֵ
				jtf[0].setText(PersonData.Nip);
				
				jtf[1].setText(PersonData.Nname);
				
				for (int i = 0; i < jb.length; i++) {		
					jb[i] = new JButton();
					jb[i].setFont(new Font("����", Font.PLAIN, 20));
					
				}
				
				jb[0].setText("����");
				jb[1].setText("�޸�����");
				jb[1].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						SQL sql = new SQL("login");
						PreparedStatement psql = null;
						
						String sqlWords = "update login set password = ? where id ='"+PersonData.Nip+"'";
						
						/**
						 * ���仰��Ż�ȡ�Ľ���� executeQueryͨ������ѡ�����
						 */
						try {
							psql = sql.con.prepareStatement(sqlWords);
							if(jtf[6].getText().equals(jtf[7].getText())){
								
								psql.setString(1,jtf[6].getText());//��Ʒ
								JOptionPane.showMessageDialog(null, "�����޸ĳɹ���");
								psql.executeUpdate();
							}
							else JOptionPane.showMessageDialog(null, "�����������벻һ��");
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}//����������浽rs�й�ʹ��
						
						
						
						
						
					}
				});
				
				jb[0].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				
//				jtf[6].setText("����1");//���������
//				jtf[7].setText("����2");//�˶������
				
				
				
				
				
				
				this.add(jl[0]);//��ӱ���
				
				/**
				 * һ�����Ӧһ����ǩ
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
