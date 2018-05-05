package jiemianModularization;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class K extends JPanel{
	
	ImageIcon	image;
	JLabel jlIcon;
	JPanel jp;
	K(JFrame jf){
		
//		jp = new JPanel(null);
//		jp.setBounds(0, 0, 1300, 800);
//		jp.setBackground(null);
//		
		
		//ÃÌº”Õº∆¨
		image = new ImageIcon("Dennis0.png");
		jlIcon = new JLabel(image);
		jlIcon.setBounds(204, 165, 1090, 593);        
		this.add(jlIcon);

		
		
		this.setLayout(null);
		this.setBounds(0, 0, 1300, 800);
		this.setBackground(null);
        
		
		this.add(new A(jf));
		this.add(new B());
		this.add(new J());
	}
}


