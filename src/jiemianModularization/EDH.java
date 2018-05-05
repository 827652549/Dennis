package jiemianModularization;

import javax.swing.JButton;
import javax.swing.JPanel;

public class EDH extends CDH{
	public EDH(JPanel p1,EDI edi) {
		super(p1,edi);
	}

	@Override
	public void setWay() {
		H[0].setText("浏览VIP");
		H[1].setText("购物记录");
		H[2].setText("注册VIP");
		H[3].setText("查看修改");
		H[4].setText("注销VIP");
	}
	
	@Override
	public void setListener(JButton H) {
		H.addActionListener(new Listener());
		
	}
	
	
	
}
