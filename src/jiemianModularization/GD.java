package jiemianModularization;



public class GD extends CD {

	@Override
	public void setAddTab() {
		this.addTab("商场销售管理面板", p1);
	}
	
	@Override
	public void setAdd() {
		GDI gdi = new GDI();
		p1.add(gdi);
		p1.add(new GDH(p1,gdi));
	}
}
