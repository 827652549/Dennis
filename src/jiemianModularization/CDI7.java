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
import testJDialog.JDialogCDI7;

//购物记录
public class CDI7 extends CDI{
	
	JLabel jl;
	JTextField jtf;

	private JButton jb ;
	
	CDI7(){
		
		jl = new JLabel("    请输入你要查询VIP的编号:");
		jl.setBorder(BorderFactory.createLineBorder(Color.red));
		jl.setFont(new Font("黑体", Font.PLAIN, 30));
		
		jtf = new JTextField();
		
		jb = new JButton("查询");
		jb.setFont(new Font("黑体", Font.PLAIN, 20));
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new JDialogCDI7(jtf.getText());
				
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
