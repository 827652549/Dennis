package jiemianModularization;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DynamicTime {
Thread th;
JLabel jl;	
	public DynamicTime() {
		 
	}
	
	 /**
	   * 获取格式化的时间
	   * 输出格式：2018年04月09日 星期一 20:30:22
	   */
	  
	  public String getFormatDate(){
	    Date date = new Date();
	    long times = date.getTime();//时间戳
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 EEEE HH:mm:ss");
	    String dateString = formatter.format(date);
	    return dateString;
	  }
	  
	  /**
	   * 获取格式化的时间
	   * 输出格式：2018-04-09
	   */
	  
	  public String getFormatDate2(){
	    Date date = new Date();
	    long times = date.getTime();//时间戳
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    String dateString = formatter.format(date);
	    return dateString;
	  }
	  
	  /**
	   * 动态显示时间
	   * @param args
	   */
	  public JLabel DynamicTime(JPanel j){
		  
		  jl = new JLabel();
		  jl.setForeground(Color.RED);
		  j.add(jl);
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
		  return jl;
		  
	  }

}
