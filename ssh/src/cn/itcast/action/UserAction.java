package cn.itcast.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.entity.Customer;
import cn.itcast.entity.User;
import cn.itcast.service.UserService;

@SuppressWarnings("all")
public class UserAction extends ActionSupport implements ModelDriven<User>{
	
	private User user=new User();
	public User getModel() {
		return user;
	}
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String login() {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		User u = userService.login(user);
		if (u != null) {// 成功
			// 使用session保持登录状态
			HttpServletRequest request = ServletActionContext.getRequest();
			request.getSession().setAttribute("user", u);
			return "loginsuccess";
		} else {// 失败
			return "login";
		}

	}
	
	//
	public String list() {
		List<User> list=userService.findAll();
		ServletActionContext.getRequest().setAttribute("list", list);	
		return "list";
	}
	public String delete() {
		int uid=user.getUid();
		User u=userService.findOne(uid);
		if(u != null) {
			userService.delete(u);
		
		}return "delete";
	
	}
	//
	public String showUser() {
		int uid=user.getUid();
		User u=userService.findOne(uid);
		ServletActionContext.getRequest().setAttribute("user", u);	
		return "showUser";
	}
	
	//	
	public String update() {
		userService.update(user);
	
		return "update";
	
	}
	//
	
	public String toAddPage() {
		
		
		return "toAddPage";
	}
	
	public String add() {
		
		userService.add(user);
		return "add";
	}

}
