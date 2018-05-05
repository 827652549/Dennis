package testJDialog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import jiemianModularization.IsNums;
import jiemianModularization.SQL;

public class JDialogCDI2 extends JDialog{

	JButton jb[]; 
	JLabel[] jl;// jl0�Ǳ���
	JTextField[] jtf ;
	SQL sql;
	
	
/**
 * �������ı����е�ֵ
 * �Ű�ʵ�ַ�ʽ:������ֱ��������ʹ������λ�ã�Ȼ��̶�JDialog��С
 */
	public JDialogCDI2(String value) {
		jb= new JButton[1]; 
		jl = new JLabel[9];
		jtf = new JTextField[9]; // 0~5�ǲ��ɱ༭�� 6��7�ǿ��Ա༭��
		this.setTitle("���鿴����Ʒ��Ϣ��");
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
				jl[1].setText("��Ʒ:");
				jl[2].setText("����:");
				jl[3].setText("���:");
				jl[4].setText("����:");
				jl[5].setText("����:");
				jl[6].setText("�ۼ�:");
				jl[7].setText("����ʱ��:");
				jl[8].setText("�ܽ���:");
				
				sql = new SQL("commodity");//���ӵ����ݱ�
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
				
				String sqlWords = "select * from commodity where id="+Integer.parseInt(value)+"";
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
						jtf[i].setEditable(false);
						jtf[i].setPreferredSize(new Dimension(310, 35));
						
					}
				
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
					/**
					 * һ�����Ӧһ����ǩ
					 */
					for (int j = 0; j < jtf.length; j++) {
						
						this.add(jl[j]);
						this.add(jtf[j]);
					}
					
					
					
					this.add(jb[0]);


					this.setVisible(true);
				}else JOptionPane.showMessageDialog(null, "δ�ҵ��ñ�ŵ���Ʒ��");
			} catch (HeadlessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

//
//	/**
//	 * ���ڻ�ȡ�Ƿ���ڸñ��
//	 * �ռ�ԭ��Ӧ����
//	 * @return
//	 * @throws SQLException 
//	 */
//	public boolean getValue(int id) throws SQLException{
//		SQL sql = new SQL("commodity");//���ӵ����ݱ�
//
//		try {
//			sql.stm = sql.con.createStatement();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		String sqlWords = "select * from commodity where id="+id+"";
//		/**
//		 * ���仰��Ż�ȡ�Ľ���� executeQueryͨ������ѡ�����
//		 */
//		try {
//			sql.rs = sql.stm.executeQuery(sqlWords);
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}//����������浽rs�й�ʹ��
//		
//			if(sql.rs.next())
//				return true;
//			else return false;
//		
//	}
//	
	
}
