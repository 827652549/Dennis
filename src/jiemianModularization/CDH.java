package jiemianModularization;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Dѡ��е�H��� JpanelĬ�ϲ�����FlowLayout
 * 
 * @author Junking
 *
 */
public class CDH extends JPanel {

	JPanel p;
	CDI cdi;
	JButton H[] = new JButton[5];

	CDH(JPanel p, Object o) {
		this.p = p;
		this.cdi = (CDI) o;
		cdi.setLocation(201, 0);
		H[0] = new JButton("�����Ʒ");
		H[1] = new JButton("��ѯ��Ʒ");
		H[2] = new JButton("�½���Ʒ");
		H[3] = new JButton("������Ʒ");
		H[4] = new JButton("������Ʒ");

		for (int i = 0; i < H.length; i++) {
			H[i].setFont(new Font("����", Font.PLAIN, 25));

		}
		setWay();
		this.setLayout(new GridLayout(5, 1, 0, 25));
		/*
		 * createEmptyBorder(int top, int left, int bottom, int right)
		 * ����һ��ռ�ÿռ䵫û�л��ƵĿձ߿�ָ���˶��ߡ���߿��ߡ����ߺ��ұ߿��ߵĿ�ȡ�
		 */
		this.setBorder(BorderFactory.createEmptyBorder(50, 25, 50, 25));
		this.setBackground(Color.BLUE);

		this.setLocation(0, 0);
		this.setSize(200, 593);

		// ��ÿ����ť��Ӽ���������ť��ӵ������
		for (int i = 0; i < 5; i++) {
			setListener(H[i]);
			this.add(H[i]);
		}

	}

	/**
	 * ����һ���շ�������������̳���д��ʵ���޸İ�ť����
	 */
	public void setWay() {

	}

	/**
	 * ����һ������������������д������
	 */
	public void setListener(JButton H) {
		H.addActionListener(new Listener());
	}

	/**
	 * ��������ѡ��еİ�ť����
	 * 
	 * @author Junking
	 *
	 */
	class Listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object l = new Object();

			Test.jb0 = 0;

			if (isText(e, "�����Ʒ")) {
				Add666(new CDI1());

			} else if (isText(e, "��ѯ��Ʒ")) {
				Add666(new CDI2());
			} else if (isText(e, "�½���Ʒ")) {
				Add666(new CDI3());
			} else if (isText(e, "������Ʒ")) {
				Add666(new CDI4());
			} else if (isText(e, "������Ʒ")) {
				Add666(new CDI5());
			} else if (isText(e, "���VIP")) {
				Add666(new CDI6());
			} else if (isText(e, "�����¼")) {
				Add666(new CDI7());
			} else if (isText(e, "ע��VIP")) {
				Add666(new CDI8());
			} else if (isText(e, "�鿴�޸�")) {
				Add666(new CDI9());
			} else if (isText(e, "ע��VIP")) {
				Add666(new CDI10());
			} else if (isText(e, "���Ա��")) {
				Add666(new CDI11());
			} else if (isText(e, "��ѯԱ��")) {
				Add666(new CDI12());
			} else if (isText(e, "ע��Ա��")) {
				Add666(new CDI13());
			} else if (isText(e, "�޸�Ա��")) {
				Add666(new CDI14());
			} else if (isText(e, "ע��Ա��")) {
				Add666(new CDI15());
			} else if (isText(e, "���ղ�ѯ")) {
				Add666(new CDI16());
			} else if (isText(e, "���²�ѯ")) {
				Add666(new CDI17());
			} else if (isText(e, "��ݲ�ѯ")) {
				Add666(new CDI18());
			} else if (isText(e, "���ȫ��")) {
				Add666(new CDI19());
			} else if (isText(e, "�ܶ��ѯ")) {
				Add666(new CDI20());
			} else
				System.out.println("δʶ�𵽴�4*5����ť������һ�֡�");
		}
	}

	/**
	 * �жϰ�ť�ϵ�����
	 */
	public boolean isText(ActionEvent e, String s) {
		Test.jb0++;
		if (((JButton) e.getSource()).getText().toString() == s) {
			System.out.println("(����ר��)�������İ�ť��"
					+ ((JButton) e.getSource()).getText().toString());
			System.out.println("���ǵ�" + Test.jb0 + "����ť");

			return true;

		} else {
			return false;
		}
	}

	/**
	 * ����滻���ķ���
	 * 
	 * @param obj
	 */
	public void Add666(Object obj) {
		JPanel jp = (JPanel) obj;

		cdi.setVisible(false);

		cdi.removeAll();// �Ƴ��������

		cdi.add(jp);

		cdi.setVisible(true);
	}

}