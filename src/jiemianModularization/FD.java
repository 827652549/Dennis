package jiemianModularization;


public class FD extends CD {

	
	@Override
	public void setAddTab() {
		this.addTab("�̳����¹������", p1);
	}
	
	@Override
	public void setAdd() {
		FDI fdi  =new FDI();
		p1.add(fdi);
		p1.add(new FDH(p1,fdi));
	}

}
