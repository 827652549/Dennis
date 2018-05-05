package testDemo;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;


/**
 * ���̲߳������ʱ��
 * @author Junking
 *
 */
public class MainJieMian {
	JFrame p;
	JLabel jl;
	
	Thread th;
	
	MainJieMian(){
		p = new JFrame();
		p.setLayout(new FlowLayout());
		
		p.setBounds(400, 400, 600, 500);
		p.setTitle("���Զ��߳�ר�ô���");
		p.setLocationRelativeTo(null);//����
		DynamicTime();
		
	    
		
		p.setVisible(true);
	}
	
	
	 /**
	   * ��ȡ��ʽ����ʱ��
	   * �����ʽ��2015-08-04 20:55:35
	   */
	  
	  public String getFormatDate(){
	    Date date = new Date();
	    long times = date.getTime();//ʱ���
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy��MM��dd�� EEEE HH:mm:ss");
	    String dateString = formatter.format(date);
	    return dateString;
	  }
	  

	  /**
	   * ��̬��ʾʱ��
	   * @param args
	   */
	  public void DynamicTime(){
		  
		  jl = new JLabel();
		  jl.setForeground(Color.RED);
		  p.add(jl);
		  //�ڲ���������дrun����
		  th = new Thread(){
			  @Override
			public void run() {	
			for (;;) {
				
				jl.setText(getFormatDate());
				//p.add(jl);
				
				/*
				 * ÿ�����һ��ϵͳʱ��
				 * ԭ��ÿ���ӽ�ʱ���ǩ����һ��ϵͳʱ�� 
				 */
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
			}
		  };
		  
		  //���߳̿�ʼ����
		  th.start();

	  }
	  
	
}
