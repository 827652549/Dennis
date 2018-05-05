package jiemianModularization;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import testJDialog.JDialogCDI2;
import testJDialog.JDialogCDI5;

public class CDI5 extends CDI{
//	JPanel jp[] = new JPanel[8];//其中jp[7]是按钮组的面板
//	JLabel jl[] = new JLabel[8];//其中jl[7]是标题
//	JTextField jtf[] = new JTextField[7];
//	JButton jb[] = new JButton[2];
//
//	CDI5(){
//		//实例化流布局面板
//		int jpY=100;
//		for (int i = 0; i < jp.length; i++) {
//			jp[i] = new JPanel(new FlowLayout());
//			jp[i].setBorder(BorderFactory.createLineBorder(Color.red));//给面板添加边框
//			jp[i].setSize(300, 50);
//			jp[i].setLocation(xRealCenter(jp[i]), jpY);//设置面板位置
//			jpY=jpY+50;//间隔设定
//			jp[i].setBackground(null);//面板设置为透明色
//		}
//		
//		//设置标签jl[]详细参数
//		for (int i = 0; i < jl.length-1; i++) {
//			jl[i] = new JLabel();
//			jl[i].setBorder(BorderFactory.createLineBorder(Color.red));
//			jl[i].setFont(new Font("黑体", Font.PLAIN, 30));
//			
//			
//		}
//		//单独设置标题
//		jl[7] = new JLabel();
//		jl[7].setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
//		jl[7].setFont(new Font("楷体", Font.PLAIN, 40));
//		jl[7].setText("  商场更新商品");
//		jl[7].setSize(320, 50);
//		jl[7].setLocation(xRealCenter(jl[7]), 50);
//		this.add(jl[7]);
//		
//		jl[0].setText("编号");
//		jl[1].setText("商品");
//		jl[2].setText("厂商");
//		jl[3].setText("类别");
//		jl[4].setText("进价");
//		jl[5].setText("数量");
//		jl[6].setText("售价");
//		
//		for (int i = 0; i < jtf.length; i++) {
//			jtf[i] = new JTextField();
//			jtf[i].setPreferredSize(new Dimension(200, 40));
//			
//		}
//
//		
//		for (int i = 0; i < jb.length; i++) {		
//			jb[i] = new JButton();
//			jb[i].setFont(new Font("黑体", Font.PLAIN, 20));
//		}
//		
//		jb[0].setText("退出");
//		jb[1].setText("确定");
//		
//		
//		for (int i = 0; i < 8; i++) {
//			if(i<7){
//				jp[i].add(jl[i]);
//				jp[i].add(jtf[i]);			
//			}else{//当最后一组按钮时
//				jp[i].add(jb[0]);
//				jp[i].add(jb[1]);
//			}
//			this.add(jp[i]);
//		}
//
//		this.setBackground(Color.lightGray);
//}
	

	JLabel jl;
	JTextField jtf;
	JButton jb ;
	String value ;
	
	CDI5(){
		
		jl = new JLabel("    请输入你要修改商品的编号:");
		jl.setBorder(BorderFactory.createLineBorder(Color.red));
		jl.setFont(new Font("黑体", Font.PLAIN, 30));
		
		jtf = new JTextField();
		
		
		jb = new JButton("查询");
		jb.setFont(new Font("黑体", Font.PLAIN, 20));
		jb.addActionListener(new ActionListener() {
		
			
			@Override
			public void actionPerformed(ActionEvent e) {
				value =  jtf.getText();
				new JDialogCDI5(value);
				
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
