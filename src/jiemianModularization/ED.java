package jiemianModularization;

public class ED extends CD{
	@Override
	public void setAddTab() {
		
		this.addTab("VIP��Ϣ���", p1);
		
	}
	
	@Override
	public void setAdd() {
		EDI edi0 = new EDI();
		p1.add(edi0);
		
		p1.add(new EDH(p1,edi0));
	}
	
	
}
