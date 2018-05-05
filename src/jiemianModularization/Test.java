package jiemianModularization;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

public class Test extends JFrame{
	/**
	 * 定义一个变量，为了标识是触发的是哪个按钮，以此调用不同的面板放入I区
	 */
public static int jb0 = -1;

	public Test() {
		
		this.setVisible(false);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);//设置布局管理器为空
		this.setSize(1313, 800);
		this.setBackground(Color.blue);
		this.setLocationRelativeTo(null);//居中窗口
		this.setTitle("丹尼斯商城管理系统V2.0");
		this.setResizable(false);
		//实现全部完成后将此行加入到构造方法体中，将setVisible放到最后
		this.add(new K(this));
		
//	      //添加图片
//			ImageIcon	image = new ImageIcon("Dennis0.png");
//	      JLabel jlIcon = new JLabel(image);
//	      jlIcon.setBounds(204, 120, 1090, 593);        
//	      this.add(jlIcon);
		
	}
	public static void main(String[] args) {
		
		//Test t =  new Test();
		new Login(new Test());
		
		
	}
}
