package jiemianModularization;



public class GD extends CD {

	@Override
	public void setAddTab() {
		this.addTab("�̳����۹������", p1);
	}
	
	@Override
	public void setAdd() {
		GDI gdi = new GDI();
		p1.add(gdi);
		p1.add(new GDH(p1,gdi));
	}
}
