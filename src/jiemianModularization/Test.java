package jiemianModularization;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

public class Test extends JFrame{
	/**
	 * ����һ��������Ϊ�˱�ʶ�Ǵ��������ĸ���ť���Դ˵��ò�ͬ��������I��
	 */
public static int jb0 = -1;

	public Test() {
		
		this.setVisible(false);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);//���ò��ֹ�����Ϊ��
		this.setSize(1313, 800);
		this.setBackground(Color.blue);
		this.setLocationRelativeTo(null);//���д���
		this.setTitle("����˹�̳ǹ���ϵͳV2.0");
		this.setResizable(false);
		//ʵ��ȫ����ɺ󽫴��м��뵽���췽�����У���setVisible�ŵ����
		this.add(new K(this));
		
//	      //���ͼƬ
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
