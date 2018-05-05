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
 * ����ʵ�֣�����������������壬��ÿ����������ȥ��Ȼ�����þ����趨����λ��
 * @author Junking
 *
 */
public class CDI3 extends CDI{
		
	JLabel jl1,jl2;
	JTextField jtf1,jtf2;
	JButton jb1,jb2 ;
	JPanel jp1,jp2,jp3;//����3�������Ͼ���
	CDI3(){
		//ʵ�������������
		jp1 = new JPanel(new FlowLayout());
		jp2 = new JPanel(new FlowLayout());
		jp3 = new JPanel(new FlowLayout());
		
		//�������ӱ߿�
		jp1.setBorder(BorderFactory.createLineBorder(Color.red));
		jp2.setBorder(BorderFactory.createLineBorder(Color.red));
		jp3.setBorder(BorderFactory.createLineBorder(Color.red));

		
		
		
		jp1.setSize(600, 50);
		jp2.setSize(600, 50);
		jp3.setSize(300, 50);
		
		//�������λ��
		jp1.setLocation(xRealCenter(jp1), 100);
		jp2.setLocation(xRealCenter(jp2), 200);
		jp3.setLocation(xRealCenter(jp3), 300);
		
		
		//�������Ϊ͸��ɫ
		jp1.setBackground(null);
		jp2.setBackground(null);
		jp3.setBackground(null);

		//���ñ�ǩjl1��ϸ����
		jl1 = new JLabel("��������Ʒ��ţ�");
		jl1.setBorder(BorderFactory.createLineBorder(Color.red));
		jl1.setFont(new Font("����", Font.PLAIN, 30));
		
		//����jtf1��ϸ����
		jtf1 = new JTextField();
		jtf1.setPreferredSize(new Dimension(200, 40));
		
		jb1 = new JButton("ȡ��");
		jb1.setFont(new Font("����", Font.PLAIN, 20));
		
		jl2 = new JLabel("��������Ʒ������");
		jl2.setBorder(BorderFactory.createLineBorder(Color.red));
		jl2.setFont(new Font("����", Font.PLAIN, 30));
		
		
		jtf2 = new JTextField();
		jtf2.setPreferredSize(new Dimension(200, 40));
		
		
		jb2 = new JButton("ȷ��");
		jb2.setFont(new Font("����", Font.PLAIN, 20));
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int jtf01 = 0;//�����ı���ı��
				int jtf02 = 0;//�����ı������Ҫ���ӵ�ֵ
				
				//�ж��Ƿ���ϸ�ʽ
				if(isSure(jtf1.getText())){
					jtf01 = Integer.parseInt(jtf1.getText());
						if(isSure(jtf2.getText())){
							jtf02 = getValue(jtf01) + Integer.parseInt(jtf2.getText());
							JOptionPane.showMessageDialog(null, "�������ɣ�");							
						}
						else return;
				}else return;
				
				SQL sql = new SQL("commodity");
				sql.SQLconnect();
				
				PreparedStatement psql = null;
				//Ԥ������£��޸ģ����ݣ������յ�sal��Ϊ5000.0
				
					try {
						psql = sql.con.prepareStatement("update commodity set nums = ? where id = ?");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				try {
					psql.setInt(1,jtf02);//����
					psql.setInt(2,jtf01);     //���  
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}      
				try {
					psql.executeUpdate();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				sql.SQLover();
				
			}
		});
		
		
		//�����������ӵ���Ӧ��ǩ��
		jp1.add(jl1);
		jp1.add(jtf1);
		
		jp2.add(jl2);
		jp2.add(jtf2);
		
		jp3.add(jb1);
		jp3.add(jb2);
		

		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.setBackground(Color.cyan);
		
		
	}
	
	public static boolean isSure(String value){
		//�ж��Ƿ�Ϊ���ֲ����ж��Ƿ����
		if(new IsNums().isNumeric(value)&&value.length()<=11&&value.length()>=0)
		{
			
			return true;
		}else {
			JOptionPane.showMessageDialog(null, "��������ȷ��ʽ����Ʒ���", "��ѯ����", JOptionPane.CLOSED_OPTION, null);
			return false;
		}
	}
	
	/**
	 * ����Ĳ����Ƕ�Ӧ���
	 * �ռ�ԭ��Ӧ����
	 * @return
	 */
	public int getValue(int id){
		int valueReal = -1;
		SQL sql = new SQL("commodity");//���ӵ����ݱ�

		try {
			sql.stm = sql.con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sqlWords = "select * from commodity where id = "+id;
		/**
		 * ���仰��Ż�ȡ�Ľ���� executeQueryͨ������ѡ�����
		 */
		try {
			sql.rs = sql.stm.executeQuery(sqlWords);
			sql.rs.next();
			valueReal = sql.rs.getInt("nums");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//����������浽rs�й�ʹ��
		
		return valueReal;
	}
	
	
}
