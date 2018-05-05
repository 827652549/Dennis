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
 * ע��VIP
 * @author Junking
 *
 */
public class CDI8 extends CDI{
	SQL sql;
	PreparedStatement pstm;
		JPanel jp[] = new JPanel[8];//����jp[7]�ǰ�ť������
		JLabel jl[] = new JLabel[8];//����jl[7]�Ǳ���
		JTextField jtf[] = new JTextField[7];
		JButton jb[] = new JButton[2];

		CDI8(){
			
			//ʵ�������������
			int jpY=100;
			for (int i = 0; i < jp.length; i++) {
				jp[i] = new JPanel(new FlowLayout());
				jp[i].setBorder(BorderFactory.createLineBorder(Color.red));//�������ӱ߿�
				jp[i].setSize(300, 50);
				jp[i].setLocation(xRealCenter(jp[i]), jpY);//�������λ��
				jpY=jpY+50;//����趨
				jp[i].setBackground(null);//�������Ϊ͸��ɫ
			}
			
			//���ñ�ǩjl[]��ϸ����
			for (int i = 0; i < jl.length-1; i++) {
				jl[i] = new JLabel();
				jl[i].setBorder(BorderFactory.createLineBorder(Color.red));
				jl[i].setFont(new Font("����", Font.PLAIN, 30));
				
				
			}
			//�������ñ���
			jl[7] = new JLabel();
			jl[7].setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
			jl[7].setFont(new Font("����", Font.PLAIN, 40));
			jl[7].setText("   ע��VIP�û�");
			
			jl[7].setSize(320, 50);
			jl[7].setLocation(xRealCenter(jl[7]), 50);
			this.add(jl[7]);

			
			jl[0].setText("�ʺ�:");
			jl[1].setText("����:");
			jl[2].setText("����:");
			jl[3].setText("�Ա�:");
			jl[4].setText("סַ:");
			jl[5].setText("�绰:");
			jl[6].setText("�ۿ�:");
			
			
			for (int i = 0; i < jtf.length; i++) {
				jtf[i] = new JTextField();
				jtf[i].setPreferredSize(new Dimension(200, 40));
				
			}

			
			for (int i = 0; i < jb.length; i++) {		
				jb[i] = new JButton();
				jb[i].setFont(new Font("����", Font.PLAIN, 20));
			}
			
			jb[0].setText("�˳�");
			jb[1].setText("ע��VIP");
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
							//ѭ��7�Σ���ȡ7���ı��򲢸�ֵ
							
								
								pstm.setString(1, jtf[0].getText()); 
								pstm.setString(2, jtf[2].getText()); 
								pstm.setString(3, jtf[3].getText()); 
								pstm.setString(4, jtf[4].getText()); 
								pstm.setString(5, jtf[5].getText()); 
								pstm.setString(6, jtf[6].getText()); 
								
								pstm.setString(7, new DynamicTime().getFormatDate2()); 
							
							
							pstm.executeUpdate();
							JOptionPane.showMessageDialog(null, "�����ɹ���");
							
						} catch (SQLException e1) {
							e1.printStackTrace();
							JOptionPane.showMessageDialog(null, "����ʧ�ܣ�");
						}             
						sql.SQLover();
					
				}
			});
			
			for (int i = 0; i < 8; i++) {
				if(i<7){
					jp[i].add(jl[i]);
					jp[i].add(jtf[i]);			
				}else{//�����һ�鰴ťʱ
					jp[i].add(jb[0]);
					jp[i].add(jb[1]);
				}
				this.add(jp[i]);
			}

			this.setBackground(Color.lightGray);
	}
		
		

		
	}

