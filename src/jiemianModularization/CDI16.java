package jiemianModularization;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import testJDialog.JDialogCDI16;
import testJDialog.JDialogCDI7;

public class CDI16 extends CDI{
	
		JLabel jl;
		JTextField jtf;

		private JButton jb ;
		
		CDI16(){
			
			jl = new JLabel("��������Ҫ��ѯ�����ڣ�\nXXXX-XX-XX");
			jl.setBorder(BorderFactory.createLineBorder(Color.red));
			jl.setFont(new Font("����", Font.PLAIN, 30));
			
			jtf = new JTextField();
			
			jb = new JButton("��ѯ");
			jb.setFont(new Font("����", Font.PLAIN, 20));
			jb.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new JDialogCDI16(jtf.getText());
					
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
