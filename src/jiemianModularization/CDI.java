package jiemianModularization;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JPanel;

/**
 * Dѡ��е�I���
 * @author Junking
 *
 */
public class CDI extends JPanel{
final static int I_WIDTH = 1090; 
final static int I_HEIGTT = 593; 
/**
 * xCenter��Ϊ�˻�ȡ�����Ҫ���õ�x����
 * Ϊ�˷��������null������ʵ�־��з���
 * eg��������=(�������ĳ���-��ť�ĳ���)/2
 */
public static int xCenter;

	CDI(){
		
		this.setLocation(0, 0);
		this.setSize(I_WIDTH, I_HEIGTT);
		this.setLayout(null);
		this.setBackground(Color.LIGHT_GRAY);
		
		this.setVisible(true);//��ʾ
		
		xCenter = this.getWidth()/2;
	
	
	
		
	}

    
    
	
	/**
	 * ʹ��ʱ��Ҫע�⣬������ʹ��setSize��ʹ��setLoaction
	 * @param c
	 * @return
	 */
	int  xRealCenter(Container c){
		
		return xCenter-c.getWidth()/2;
	}
	
	
	
}
