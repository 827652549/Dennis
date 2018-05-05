package jiemianModularization;


public class FD extends CD {

	
	@Override
	public void setAddTab() {
		this.addTab("商场人事管理面板", p1);
	}
	
	@Override
	public void setAdd() {
		FDI fdi  =new FDI();
		p1.add(fdi);
		p1.add(new FDH(p1,fdi));
	}

}
