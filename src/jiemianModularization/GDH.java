package jiemianModularization;

import javax.swing.JPanel;

public class GDH extends CDH{
	public GDH(JPanel p1,GDI gdi) {
		super(p1,gdi);
	}

	@Override
	public void setWay() {
		H[0].setText("单日查询");
		H[1].setText("单月查询");
		H[2].setText("年份查询");
		H[3].setText("浏览全部");
		H[4].setText("总额查询");
	}
}
