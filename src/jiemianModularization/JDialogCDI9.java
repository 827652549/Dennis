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
	JLabel[] jl;// jl0�Ǳ���
	JTextField[] jtf ;
	SQL sql;
	
	
	public JDialogCDI9(String value) {
		jb= new JButton[2]; 
		jl = new JLabel[9];
		jtf = new JTextField[9]; // 0~5�ǲ��ɱ༭�� 6��7�ǿ��Ա༭��
		this.setTitle("���޸�����VIP��Ϣ��");
		this.setSize(430, 450);
		this.setLocationRelativeTo(null);
		this.setResizable(false);// ��������
		this.setModal(true);
		this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.setLayout(new FlowLayout());
		
		//���ñ�ǩjl[]��ϸ����
				for (int i = 0; i < jl.length; i++) {
					jl[i] = new JLabel();
					jl[i].setBorder(BorderFactory.createLineBorder(Color.red));
					jl[i].setFont(new Font("����", Font.PLAIN, 20));
					
					
				}
		
				
				
				
				jl[0].setText("���:");
				jl[1].setText("����:");
				jl[2].setText("�Ա�:");
				jl[3].setText("סַ:");
				jl[4].setText("�ֻ�:");
				jl[5].setText("�ۿ�:");
				jl[6].setText("ʱ��:");

				
				sql = new SQL("VIP");//���ӵ����ݱ�
				try {
					sql.SQLselect();//ִ��ѡ�����Ϊ������rs��ֵ
				//�ж��Ƿ�Ϊ���ֲ����ж��Ƿ����
					if(!new IsNums().isNumeric(value)&&value.length()<=11&&value.length()>=0)
					{					
						JOptionPane.showMessageDialog(null, "��������ȷ��ʽ����Ʒ���", "��ѯ����", JOptionPane.CLOSED_OPTION, null);
						return;
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("select�����쳣");
				}
				
				//��ȡ�ƶ�������һ��
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
						jtf[i].setFont(new Font("����", Font.BOLD,25));
						jtf[i].setPreferredSize(new Dimension(310, 35));
						
					}
					jtf[0].setEditable(false);
				
					sql.SQLover();
					for (int i = 0; i < jb.length; i++) {		
						jb[i] = new JButton();
						jb[i].setFont(new Font("����", Font.PLAIN, 20));
						
					}
					
					jb[0].setText("����");
					jb[0].addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							dispose();
						}
					});		
					
					jb[1].setText("����");
					jb[1].addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							int jtf01 = 0;//�����ı���ı��
							int jtf02 = 0;//�����ı������Ҫ���ӵ�ֵ
							
							//�ж��Ƿ���ϸ�ʽ
							if(CDI3.isSure(jtf[0].getText())){
								jtf01 = Integer.parseInt(jtf[0].getText());
									
							}else return;
							
							SQL sql = new SQL("VIP");
							
							
							PreparedStatement psql = null;
							//Ԥ������£��޸ģ����ݣ������յ�sal��Ϊ5000.0
							
								try {
									psql = sql.con.prepareStatement("update VIP set name = ?,sex = ?,home = ?,phone = ?,discount = ?,time = ? where id = ?");
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
							try {
								for (int i = 0; i < 6; i++) {
									
									psql.setString(i+1,jtf[i+1].getText());//��Ʒ
								}
								psql.setInt(7,jtf01);     //���  
							
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}      
							try {
								psql.executeUpdate();
								JOptionPane.showMessageDialog(null, "���³ɹ�");
								
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								JOptionPane.showMessageDialog(null, "����ʧ��");
							}
							
							sql.SQLover();
							dispose();
							
						}
					});
					
					/**
					 * һ�����Ӧһ����ǩ
					 */
					for (int j = 0; j < jtf.length-2; j++) {
						
						this.add(jl[j]);
						this.add(jtf[j]);
					}
					
					
					
					this.add(jb[0]);
					this.add(jb[1]);


					this.setVisible(true);
				}else JOptionPane.showMessageDialog(null, "δ�ҵ��ñ�ŵ�VIP");
			} catch (HeadlessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	}

