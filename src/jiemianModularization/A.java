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
			jb[i].setFont(new Font("����", Font.PLAIN, 17));
			this.add(jb[i]);
		}
			jb[0].setText("ע���û�");
			jb[0].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int i=JOptionPane.showConfirmDialog(null,"ȷ��Ҫע�����û���","���������ѡ��",JOptionPane.YES_NO_OPTION);
					if(i==0)
					{
						jf.dispose();
						new Login(jf);
					}
					
				}
			});
			jb[1].setText("�˳�ϵͳ");
			jb[1].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int i=JOptionPane.showConfirmDialog(null,"ȷ��Ҫ�˳���","���������ѡ��",JOptionPane.YES_NO_OPTION);
					if(i==0)
					System.exit(0);
					
				}
			});
			jb[2].setText("ϵͳ����");
			jb[2].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "�ù����д��������������ע�����汾��");
					
				}
			});
			jb[3].setText("����");
			jb[3].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					
					JOptionPane.showMessageDialog(null, "1���������Ϊѧϰ����ʹ�ã�����+������ҵ��;��Υ���߱���˾�ؽ�����\n"
							+ "2�����汾Ϊ2.0,���ྫ�ʹ��ܵȴ����º�ʹ�á�\n"
							+ "3���������ϸ������ϵ������ԱQQ��827652549");
					
				}
			});
		
		this.setLayout(new FlowLayout(FlowLayout.LEFT));

		this.setBounds(0, 0, 1300,50);
		this.setBackground(Color.orange);
	}
}
