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
		this.setFont(new Font("����", Font.PLAIN, 25));
        setAddTab();
        this.setSelectedIndex(0);//Ĭ����ʾ����0��ѡ�
        this.setBounds(0, 0, 1300, 710);
        this.setBackground(null);
        
        jp[0].add(new CD());
        jp[1].add(new ED());
        jp[2].add(new FD());
        jp[3].add(new GD());
        this.updateUI();
	}
	
	public void setAddTab(){
		this.addTab("��Ʒ��Ϣ����ģ��", jp[0]);
        this.addTab("VIP��Ϣ����ģ��", jp[1]);
        this.addTab("�̳����¹���ģ��", jp[2]);
        this.addTab("�̳����۹���ģ��", jp[3]);
	}
}
