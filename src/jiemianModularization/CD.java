package jiemianModularization;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;



public class CD extends JTabbedPane{
//	ImageIcon image = null;


	CDH cdh_1;
	CDI cdi_1;
	JPanel p1;
	JLabel jlIcon;
	CD(){
		 	
	        p1 = new JPanel();//创建第一个选项卡下的面板
	        p1.setLayout(null);
	        p1.setBackground(null);
	        setAddTab();
	        
//	        //添加图片
//			ImageIcon	image = new ImageIcon("Dennis0.png");
//	        JLabel jlIcon = new JLabel(image);
//	        jlIcon.setBounds(204, 120, 1090, 593);        
//	        p1.add(jlIcon);
	        
	        
	        this.setSelectedIndex(0);//默认显示到第0个选项卡
	        this.setBounds(0, 0, 1300, 650);
	        this.setBackground(null);
	        
	        
			setAdd();
			
	       
			this.updateUI();
	
	}
	
	public void setAddTab(){
		 this.addTab("商品信息面板", p1);
	}
	
	public void setAdd(){
		//将H和I添加到选项卡D中
		CDI cdi0 = new CDI();
		

		p1.add(cdi0);
		p1.add(new CDH(p1,cdi0));	
		
		
        
        
	}
}

//class MyJPanel extends JPanel{
//	
//	
//	public MyJPanel() {
//		// TODO Auto-generated constructor stub
//	}
//	
//
//	
///**
// * 添加图片Dennis0.png
// */
//public void paintComponent(Graphics g){
//	
//	
//Image image  = null;
//	try {
//		
//		image=ImageIO.read(new File("Dennis0.png"));
//		
//		g.drawImage(image, 201, 150, 1090, 593, this);
//		
//	} catch (Exception e) {
//		
//		// TODO Auto-generated catch block
//		
//		e.printStackTrace();
//		
//	}
//	
//	}
//}