package jiemianModularization;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JPanel;

/**
 * D选项卡中的I面板
 * @author Junking
 *
 */
public class CDI extends JPanel{
final static int I_WIDTH = 1090; 
final static int I_HEIGTT = 593; 
/**
 * xCenter是为了获取组件需要放置的x坐标
 * 为了方便组件在null布局中实现居中放置
 * eg：纵坐标=(所在面板的长度-按钮的长度)/2
 */
public static int xCenter;

	CDI(){
		
		this.setLocation(0, 0);
		this.setSize(I_WIDTH, I_HEIGTT);
		this.setLayout(null);
		this.setBackground(Color.LIGHT_GRAY);
		
		this.setVisible(true);//显示
		
		xCenter = this.getWidth()/2;
	
	
	
		
	}

    
    
	
	/**
	 * 使用时需要注意，必须先使用setSize再使用setLoaction
	 * @param c
	 * @return
	 */
	int  xRealCenter(Container c){
		
		return xCenter-c.getWidth()/2;
	}
	
	
	
}
