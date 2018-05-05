package testDemo;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;


/**
 * 多线程测试添加时间
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
		p.setTitle("测试多线程专用窗体");
		p.setLocationRelativeTo(null);//居中
		DynamicTime();
		
	    
		
		p.setVisible(true);
	}
	
	
	 /**
	   * 获取格式化的时间
	   * 输出格式：2015-08-04 20:55:35
	   */
	  
	  public String getFormatDate(){
	    Date date = new Date();
	    long times = date.getTime();//时间戳
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 EEEE HH:mm:ss");
	    String dateString = formatter.format(date);
	    return dateString;
	  }
	  

	  /**
	   * 动态显示时间
	   * @param args
	   */
	  public void DynamicTime(){
		  
		  jl = new JLabel();
		  jl.setForeground(Color.RED);
		  p.add(jl);
		  //内部方法体重写run方法
		  th = new Thread(){
			  @Override
			public void run() {	
			for (;;) {
				
				jl.setText(getFormatDate());
				//p.add(jl);
				
				/*
				 * 每秒更新一次系统时间
				 * 原理：每秒钟将时间标签设置一次系统时间 
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
		  
		  //多线程开始运行
		  th.start();

	  }
	  
	
}
