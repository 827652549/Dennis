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
	   * ��ȡ��ʽ����ʱ��
	   * �����ʽ��2018��04��09�� ����һ 20:30:22
	   */
	  
	  public String getFormatDate(){
	    Date date = new Date();
	    long times = date.getTime();//ʱ���
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy��MM��dd�� EEEE HH:mm:ss");
	    String dateString = formatter.format(date);
	    return dateString;
	  }
	  
	  /**
	   * ��ȡ��ʽ����ʱ��
	   * �����ʽ��2018-04-09
	   */
	  
	  public String getFormatDate2(){
	    Date date = new Date();
	    long times = date.getTime();//ʱ���
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    String dateString = formatter.format(date);
	    return dateString;
	  }
	  
	  /**
	   * ��̬��ʾʱ��
	   * @param args
	   */
	  public JLabel DynamicTime(JPanel j){
		  
		  jl = new JLabel();
		  jl.setForeground(Color.RED);
		  j.add(jl);
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
		  return jl;
		  
	  }

}
