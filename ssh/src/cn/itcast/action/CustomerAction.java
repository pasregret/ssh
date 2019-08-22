package cn.itcast.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


import cn.itcast.entity.Customer;
import cn.itcast.entity.Dict;
import cn.itcast.entity.PageBean;
import cn.itcast.service.CustomerService;

@SuppressWarnings("all")
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	private Customer customer = new Customer();
	public Customer getModel() {
		
		return customer;
	}
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public String toAddPage() {
		List<Dict> listDict = customerService.findAllDictLevel();
		ServletActionContext.getRequest().setAttribute("listDict", listDict);
		return "toAddPage";
		
	}
	public String add() {
		customerService.save(customer);
		
		return "add";
	}
	
	
	
	private List<Customer> list;
	public List<Customer> getList() {
		return list;
	}
	public String list() {
		List<Customer> list = customerService.findAll();
		
		ServletActionContext.getRequest().setAttribute("list", list);			
		return "list";
	}
	//
	
	public String delete() {
		int cid=customer.getCid();
		Customer c=customerService.findOne(cid);
		if(c != null) {
			customerService.delete(c);
		
		}return "delete";

	}
	
	//
	public String showCustomer() {
		List<Dict> listDict = customerService.findAllDictLevel();
		ServletActionContext.getRequest().setAttribute("listDict", listDict);
		int cid=customer.getCid();
		Customer c=customerService.findOne(cid);
		ServletActionContext.getRequest().setAttribute("customer", c);
		return "showCustomer";
		
	}
	
	//
	public String update() {
		customerService.update(customer);
		return "update";		
	}
	//
	private Integer currentPage;

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	//
	public String findPage() {
		PageBean pageBean =customerService.findPage(currentPage);
		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		return "findPage";
	}
	//
	public String listcondition() {
		
		if(customer.getCustName()!=null && !"".equals(customer.getCustName())) {
			List<Customer> list= customerService.findConditain(customer);
			ServletActionContext.getRequest().setAttribute("list", list);
		}else {
			list();
		}
		
		return "listcondition";
		
	}
	
	//
	public String toSelectCustomerPage() {
		
		List<Dict> listDict = customerService.findAllDictLevel();
		ServletActionContext.getRequest().setAttribute("listDict", listDict);
		
		return"toSelectCustomerPage";
	}
	//
	public String moreCondition() {
		List<Customer> list= customerService.findMoreCondition(customer);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "moreCondition";
	}
	//
	public String toSelectCustomerSource() {
		List<Customer> list= customerService.selectCustomerSource();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "toSelectCustomerSource";
	}
//
	public String toSelectCustomerLevel() {
		List<Customer> list= customerService.SelectCustomerLevel();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "toSelectCustomerLevel";
	}

}
