package testJTablePane;

import java.awt.BorderLayout;




import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Demo {

	public static void main(String[] args) {
	       
	        JTabbedPane tabpane = new JTabbedPane();//����һ��ѡ�
	        JPanel p1 = new JPanel();//������һ��ѡ��µ����
	        JPanel p2 = new JPanel();//�����ڶ���ѡ��µ����
	        p1.add(new JButton("Helloa,i am 1"));//����ʵ�����һ����ʼ���İ�ť
	        p2.add(new JLabel("Welcome 2"));//����ʵ�����һ����ʼ���ı�ǩ
	        tabpane.addTab("ѡ�1", p1);
	        tabpane.addTab("ѡ�2", p2);
	        tabpane.setSelectedIndex(0);//Ĭ����ʾ����0��ѡ�
	        JFrame f = new JFrame();
	        f.setTitle("ѡ�����ʹ��ʾ��");
	        f.setBounds(200,50,400,400);
	        f.add(tabpane);
	        f.setVisible(true);
	        
	}


	}

