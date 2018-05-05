package jiemianModularization;

import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class C extends JTabbedPane{
JPanel jp[] = new JPanel[4] ; 
	C(){
		for (int i = 0; i < 4; i++) {
			jp[i] = new JPanel();
			
			jp[i].setLayout(null);
			jp[i].setBackground(null);
		}
		this.setFont(new Font("黑体", Font.PLAIN, 25));
        setAddTab();
        this.setSelectedIndex(0);//默认显示到第0个选项卡
        this.setBounds(0, 0, 1300, 710);
        this.setBackground(null);
        
        jp[0].add(new CD());
        jp[1].add(new ED());
        jp[2].add(new FD());
        jp[3].add(new GD());
        this.updateUI();
	}
	
	public void setAddTab(){
		this.addTab("商品信息管理模块", jp[0]);
        this.addTab("VIP信息管理模块", jp[1]);
        this.addTab("商城人事管理模块", jp[2]);
        this.addTab("商场销售管理模块", jp[3]);
	}
}
