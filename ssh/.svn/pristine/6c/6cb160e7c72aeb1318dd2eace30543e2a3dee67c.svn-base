package cn.itcast.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.entity.Dict;
import cn.itcast.entity.User;
import cn.itcast.service.DictService;

@SuppressWarnings("all")
public class DictAction extends ActionSupport implements ModelDriven<Dict> {

	private Dict dict = new Dict();
	public Dict getModel() {
		return dict;
	}
	
	private DictService dictService;
	public void setDictService(DictService dictService) {
		this.dictService = dictService;
	}
	

	public String list(){
		List<Dict> list= dictService.findAll();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "list";
	}
	
//	public String delete() {
//		int did=dict.getDid();
//		Dict d=dictService.findOne(did);
//		if(d != null) {
//			dictService.delete(d);
//		
//		}return "delete";
//	
//	}
	public String toAddPage() {

		return "toAddPage";
	}
	
	public String add() {

		dictService.add(dict);
		return "add";
	}

}
