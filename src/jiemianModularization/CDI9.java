package jiemianModularization;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import testJDialog.JDialogCDI5;
import testJDialog.JDialogCDI7;

//查看修改（VIP）
public class CDI9 extends CDI{
	String value ;
	JLabel jl;
	JTextField jtf;

	private JButton jb ;
	
	CDI9(){
		
		jl = new JLabel("    请输入你要修改的VIP编号:");
		jl.setBorder(BorderFactory.createLineBorder(Color.red));
		jl.setFont(new Font("黑体", Font.PLAIN, 30));
		
		jtf = new JTextField();
		
		jb = new JButton("修改");
		jb.setFont(new Font("黑体", Font.PLAIN, 20));
jb.addActionListener(new ActionListener() {
		
			
			@Override
			public void actionPerformed(ActionEvent e) {
				value =  jtf.getText();
				new JDialogCDI9(value);
				
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
