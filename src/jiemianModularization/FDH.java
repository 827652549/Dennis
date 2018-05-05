package jiemianModularization;

import javax.swing.JPanel;

public class FDH extends CDH{
	
	public FDH(JPanel p1, FDI fdi) {
		super(p1,fdi);
	}

	@Override
	public void setWay() {
		H[0].setText("浏览员工");
		H[1].setText("查询员工");
		H[2].setText("注册员工");
		H[3].setText("修改员工");
		H[4].setText("注销员工");
	}
}
