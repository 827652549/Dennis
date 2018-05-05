package jiemianModularization;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import testJDialog.TestJDialog;

public class B extends JPanel{
JButton b;
JTextField jtf1,jtf2;
JLabel jl1,jl2,jl3,jlTime;
	
	B(){
		b = new JButton("个人详情");	
		b.setFont(new Font("黑体", Font.PLAIN,20));
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TestJDialog();
				
			}
		});
		
		
		jtf1 = new JTextField();
		jtf1.setPreferredSize(new Dimension(200, 30));
		jtf1.setFont(new Font("黑体", Font.PLAIN,20));
		jtf1.setText(PersonData.Nip);
		jtf1.setEditable(false);
		jtf2 = new JTextField();
		jtf2.setPreferredSize(new Dimension(200, 30));
		jtf2.setFont(new Font("黑体", Font.PLAIN,20));
		jtf2.setText(PersonData.Nname);
		jtf2.setEditable(false);
				
		jl1 = new JLabel(" 帐号：");
		jl1.setFont(new Font("黑体", Font.PLAIN,20));
		jl2 = new JLabel(" 姓名：");
		jl2.setFont(new Font("黑体", Font.PLAIN,20));
		jl3 = new JLabel(" 时间：");
		jl3.setFont(new Font("黑体", Font.PLAIN,20));
		DynamicTime d = new DynamicTime();
		jlTime = new JLabel();
		jlTime = d.DynamicTime(this);
		jlTime.setFont(new Font("黑体", Font.PLAIN,20));
		
		this.add(jl1 );
		this.add(jtf1);
		this.add(jl2 );
		this.add(jtf2);
		this.add(b);
		this.add(jl3 );
		this.add(jlTime);
		
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setBounds(0, 50, 1300, 50);
		this.setBackground(Color.LIGHT_GRAY);
	}
}
