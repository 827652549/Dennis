package jiemianModularization;

import javax.swing.JPanel;

public class GDH extends CDH{
	public GDH(JPanel p1,GDI gdi) {
		super(p1,gdi);
	}

	@Override
	public void setWay() {
		H[0].setText("���ղ�ѯ");
		H[1].setText("���²�ѯ");
		H[2].setText("��ݲ�ѯ");
		H[3].setText("���ȫ��");
		H[4].setText("�ܶ��ѯ");
	}
}
