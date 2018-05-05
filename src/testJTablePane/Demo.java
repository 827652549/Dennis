package testJTablePane;

import java.awt.BorderLayout;




import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Demo {

	public static void main(String[] args) {
	       
	        JTabbedPane tabpane = new JTabbedPane();//创建一个选项卡
	        JPanel p1 = new JPanel();//创建第一个选项卡下的面板
	        JPanel p2 = new JPanel();//创建第二个选项卡下的面板
	        p1.add(new JButton("Helloa,i am 1"));//匿名实现添加一个初始化的按钮
	        p2.add(new JLabel("Welcome 2"));//匿名实现添加一个初始化的标签
	        tabpane.addTab("选项卡1", p1);
	        tabpane.addTab("选项卡2", p2);
	        tabpane.setSelectedIndex(0);//默认显示到第0个选项卡
	        JFrame f = new JFrame();
	        f.setTitle("选项卡面板的使用示例");
	        f.setBounds(200,50,400,400);
	        f.add(tabpane);
	        f.setVisible(true);
	        
	}


	}

