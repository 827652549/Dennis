package jiemianModularization;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import testJDialog.JDialogCDI7;

/**
 * ע��VIP
 * @author Junking
 *
 */
public class CDI10 extends CDI{
	JLabel jl;
	JTextField jtf;
	SQL sql;
	private JButton jb ;
	
	CDI10(){
		
		jl = new JLabel("    ��������Ҫɾ��VIP�ı��:");
		jl.setBorder(BorderFactory.createLineBorder(Color.red));
		jl.setFont(new Font("����", Font.PLAIN, 30));
		
		jtf = new JTextField();
		
		jb = new JButton("ɾ��");
		jb.setFont(new Font("����", Font.PLAIN, 20));
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sql = new SQL("VIP");
			
				//�ж��Ƿ�Ϊ���ֲ����ж��Ƿ����
					if(!new IsNums().isNumeric(jtf.getText())&&jtf.getText().length()<=11&&jtf.getText().length()>=0)
					{					
						JOptionPane.showMessageDialog(null, "��������ȷ��ʽ��VIP���", "��ѯ����", JOptionPane.CLOSED_OPTION, null);
						return;
					}
					
					PreparedStatement psql;
					//Ԥ����ɾ������
					try {
						psql = sql.con.prepareStatement("delete from VIP where id = ?");
						psql.setString(1, jtf.getText());
						psql.executeUpdate();
						psql.close();
						JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
					}
				
			}
		});
		
		
		
		jl.setSize(500,50 );
		jtf.setSize(350, 40);
		jb.setSize(100, 40);
		
		jl.setLocation(xRealCenter(jl), 100);
		jtf.setLocation(xRealCenter(jtf), 200);
		jb.setLocation(xRealCenter(jb), 300);
		
		
		this.add(jtf);
		this.add(jl);
		this.add(jb);
	
		
		this.setBackground(Color.YELLOW);
		
		
	}
	
}
