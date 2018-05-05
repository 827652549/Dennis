package jiemianModularization;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import testJDialog.JDialogCDI17;
import testJDialog.JDialogCDI18;

public class CDI18 extends CDI{
	

	JLabel jl;
	JTextField jtf;

	private JButton jb ;
	
	CDI18(){
		
		jl = new JLabel("  请输入你要查询的年份：\nXXXX");
		jl.setBorder(BorderFactory.createLineBorder(Color.red));
		jl.setFont(new Font("黑体", Font.PLAIN, 30));
		
		jtf = new JTextField();
		
		jb = new JButton("查询");
		jb.setFont(new Font("黑体", Font.PLAIN, 20));
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new JDialogCDI18(jtf.getText());
				
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
