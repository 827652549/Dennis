package jiemianModularization;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class A extends JPanel{
JButton jb[] = new JButton[4];
	A(final JFrame jf){
		for (int i = 0; i < jb.length; i++) {
			jb[i] = new JButton();
			jb[i].setFont(new Font("宋体", Font.PLAIN, 17));
			this.add(jb[i]);
		}
			jb[0].setText("注销用户");
			jb[0].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int i=JOptionPane.showConfirmDialog(null,"确认要注销该用户吗？","请做出你的选择",JOptionPane.YES_NO_OPTION);
					if(i==0)
					{
						jf.dispose();
						new Login(jf);
					}
					
				}
			});
			jb[1].setText("退出系统");
			jb[1].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int i=JOptionPane.showConfirmDialog(null,"确认要退出吗？","请做出你的选择",JOptionPane.YES_NO_OPTION);
					if(i==0)
					System.exit(0);
					
				}
			});
			jb[2].setText("系统备份");
			jb[2].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "该功能有待开发，请持续关注后续版本。");
					
				}
			});
			jb[3].setText("帮助");
			jb[3].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					
					JOptionPane.showMessageDialog(null, "1、本软件仅为学习交流使用，不得+用于商业用途，违反者本公司必将纠责！\n"
							+ "2、本版本为2.0,更多精彩功能等待更新后使用。\n"
							+ "3、更多相关细节请联系开发人员QQ：827652549");
					
				}
			});
		
		this.setLayout(new FlowLayout(FlowLayout.LEFT));

		this.setBounds(0, 0, 1300,50);
		this.setBackground(Color.orange);
	}
}
