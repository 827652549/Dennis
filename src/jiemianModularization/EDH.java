package jiemianModularization;

import javax.swing.JButton;
import javax.swing.JPanel;

public class EDH extends CDH{
	public EDH(JPanel p1,EDI edi) {
		super(p1,edi);
	}

	@Override
	public void setWay() {
		H[0].setText("���VIP");
		H[1].setText("�����¼");
		H[2].setText("ע��VIP");
		H[3].setText("�鿴�޸�");
		H[4].setText("ע��VIP");
	}
	
	@Override
	public void setListener(JButton H) {
		H.addActionListener(new Listener());
		
	}
	
	
	
}
