package cn.itcast.entity;

public class LinkMan {
	private Integer lkmid;
	private String lkmName;
	private String lkmPhone;
	private String lkmMobile;
    private String lkmGender;
    private Customer customer;
    
    
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getLkmGender() {
		return lkmGender;
	}

	public void setLkmGender(String lkmGender) {
		this.lkmGender = lkmGender;
	}

	public Integer getLkmid() {
		return lkmid;
	}

	public void setLkmid(Integer lkmid) {
		this.lkmid = lkmid;
	}

	public String getLkmName() {
		return lkmName;
	}

	public void setLkmName(String lkmName) {
		this.lkmName = lkmName;
	}

	public String getLkmPhone() {
		return lkmPhone;
	}

	public void setLkmPhone(String lkmPhone) {
		this.lkmPhone = lkmPhone;
	}

	public String getLkmMobile() {
		return lkmMobile;
	}

	public void setLkmMobile(String lkmMobile) {
		this.lkmMobile = lkmMobile;
	}

}
