package jiemianModularization;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import testJDialog.JDialogCDI14;
import testJDialog.JDialogCDI7;

/**
 * 修改员工
 * @author Junking
 *
 */
public class CDI14 extends CDI{
	String value ;
	JLabel jl;
	JTextField jtf;

	private JButton jb ;
	
	CDI14(){
		
		jl = new JLabel("        你要修改员工的工号:");
		jl.setBorder(BorderFactory.createLineBorder(Color.red));
		jl.setFont(new Font("黑体", Font.PLAIN, 30));
		
		jtf = new JTextField();
		
		jb = new JButton("查询");
		jb.setFont(new Font("黑体", Font.PLAIN, 20));
		
		
		
		jl.setSize(500,50 );
		jtf.setSize(350, 40);
		jb.setSize(100, 40);
		
		jl.setLocation(xRealCenter(jl), 100);
		jtf.setLocation(xRealCenter(jtf), 200);
		jb.setLocation(xRealCenter(jb), 300);
		jb.setFont(new Font("黑体", Font.PLAIN, 20));
		jb.addActionListener(new ActionListener() {
				
					
					@Override
					public void actionPerformed(ActionEvent e) {
						value =  jtf.getText();
						new JDialogCDI14(value);
						
					}
				});
		
		this.add(jtf);
		this.add(jl);
		this.add(jb);
	
		
		this.setBackground(Color.YELLOW);
		
		
	}
	
}
