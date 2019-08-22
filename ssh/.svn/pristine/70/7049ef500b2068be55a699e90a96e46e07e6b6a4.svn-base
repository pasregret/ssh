package cn.itcast.action;


import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.entity.Customer;
import cn.itcast.entity.LinkMan;
import cn.itcast.entity.PageBean;
import cn.itcast.service.CustomerService;
import cn.itcast.service.LinkManService;

@SuppressWarnings("serial")
public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {
	private LinkMan linkMan=new LinkMan(); 
	public LinkMan getModel() {
		return linkMan;
	}
	//
	private File upload;
	private String uploadFileName;
	
	
	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	private LinkManService linkmanService;

	public void setLinkmanService(LinkManService linkmanService) {
		this.linkmanService = linkmanService;
	}
	private CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	//
	public String toAddPage() {
		List<Customer> list =customerService.findAll();
		ServletActionContext.getRequest().setAttribute("list",list);	
		return "toAddPage";
	}
	//
	public String addlinkMan() throws Exception {
		if(upload!=null) {
			File severFile = new File("F:\\uploadtest"+"/"+uploadFileName);
			FileUtils.copyFile(upload, severFile);
		}
		
		linkmanService.addLinkMan(linkMan);
		return "addlinkMan";
	}
	//
	public String list() {
		
		List<LinkMan> linkman= linkmanService.ListLinkMan();
		ServletActionContext.getRequest().setAttribute("linkman" ,linkman);
//		PageBean pageBean =linkmanService.findPage(currentPage);
//		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		return "list";
	}
	//
	public String showLinkMan() {

		int lkmid = linkMan.getLkmid();

		LinkMan link = linkmanService.findOne(lkmid);

		List<Customer> listCustomer = customerService.findAll();

		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("linkman", link);
		request.setAttribute("listCustomer", listCustomer);

		return "showLinkMan";
	}
	//
	public String updateLinkMan() {
		linkmanService.updateLinkMan(linkMan);
		
		return "updateLinkMan";
	}
//
	public String delete() {
		int lkmid = linkMan.getLkmid();
		LinkMan link = linkmanService.findOne(lkmid);
		if(link != null) {
			linkmanService.delete(link);
	}
		
		return "delete";
    }
	
	//
	public String listcondition() {
		if(linkMan.getLkmName()!=null &&!"".equals(linkMan.getLkmName())) {
		List<LinkMan> list=linkmanService.findCondition(linkMan);
		ServletActionContext.getRequest().setAttribute("linkman",list);
		
		}else {
			list();
		}
		return "listcondition";
	}
	
	//
	public String toSelectCustomerPage() {
		List<Customer> list = customerService.findAll();

		ServletActionContext.getRequest().setAttribute("list", list);
		return "toSelectCustomerPage";
	}
	public String moreCondition() {
		List<LinkMan> list= linkmanService.findMoreCondition(linkMan);
		ServletActionContext.getRequest().setAttribute("linkman",list);
		return "moreCondition";
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
//	public String findPage() {
//	
//		
//		return "findPage";
//	}	
	
	
	
	
	
}