package jiemianModularization;

import javax.swing.JPanel;

public class FDH extends CDH{
	
	public FDH(JPanel p1, FDI fdi) {
		super(p1,fdi);
	}

	@Override
	public void setWay() {
		H[0].setText("���Ա��");
		H[1].setText("��ѯԱ��");
		H[2].setText("ע��Ա��");
		H[3].setText("�޸�Ա��");
		H[4].setText("ע��Ա��");
	}
}
