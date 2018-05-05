package jiemianModularization;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import testJDialog.JDialogCDI2;


public class CDI2 extends CDI{
	
	JLabel jl;
	JTextField jtf;
	JButton jb ;
	String value ;
	
	CDI2(){
		
		jl = new JLabel("    ��������Ҫ��ѯ��Ʒ�ı��:");
		jl.setBorder(BorderFactory.createLineBorder(Color.red));
		jl.setFont(new Font("����", Font.PLAIN, 30));
		
		jtf = new JTextField();
		
		
		jb = new JButton("��ѯ");
		jb.setFont(new Font("����", Font.PLAIN, 20));
		jb.addActionListener(new ActionListener() {
		
			
			@Override
			public void actionPerformed(ActionEvent e) {
				value =  jtf.getText();
				new JDialogCDI2(value);
				
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