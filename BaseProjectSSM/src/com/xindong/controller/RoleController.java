package com.xindong.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xindong.page.admin.Page;
import com.xindong.pojo.admin.Authority;
import com.xindong.pojo.admin.Menu;
import com.xindong.pojo.admin.Role;
import com.xindong.service.admin.AuthorityService;
import com.xindong.service.admin.MenuService;
import com.xindong.service.admin.RoleService;


/**
 * ��ɫrole������
 * @author llq
 *
 */
@RequestMapping("/admin/role")
@Controller
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private AuthorityService authorityService;
	
	@Autowired
	private MenuService menuService;
	
	/**
	 * ��ɫ�б�ҳ��
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/list",method= RequestMethod.GET)
	public ModelAndView list(ModelAndView model){
		model.setViewName("/role/list");
		return model;
	}
	
	
	/**
	 * ��ȡ��ɫ�б�
	 * @param page
	 * @param name
	 * @return
	 */
	@RequestMapping(value="/list",method= RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getList(Page page,
			@RequestParam(name="name",required=false,defaultValue="") String name
			){
		Map<String, Object> ret = new HashMap<String, Object>();
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("name", name);
		queryMap.put("offset", page.getOffset());
		queryMap.put("pageSize", page.getRows());
		ret.put("rows", roleService.findList(queryMap));
		ret.put("total", roleService.getTotal(queryMap));
		return ret;
	}
	
	/**
	 * ��ɫ���
	 * @param role
	 * @return
	 */
	@RequestMapping(value="/add",method= RequestMethod.POST)
	@ResponseBody
	public Map<String, String> add(Role role){
		Map<String, String> ret = new HashMap<String, String>();
		if(role == null){
			ret.put("type", "error");
			ret.put("msg", "����д��ȷ�Ľ�ɫ��Ϣ��");
			return ret;
		}
		if(StringUtils.isEmpty(role.getName())){
			ret.put("type", "error");
			ret.put("msg", "����д��ɫ���ƣ�");
			return ret;
		}
		if(roleService.add(role) <= 0){
			ret.put("type", "error");
			ret.put("msg", "��ɫ���ʧ�ܣ�����ϵ����Ա��");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "��ɫ��ӳɹ���");
		return ret;
	}
	
	/**
	 * ��ɫ�޸�
	 * @param role
	 * @return
	 */
	@RequestMapping(value="/edit",method= RequestMethod.POST)
	@ResponseBody
	public Map<String, String> edit(Role role){
		Map<String, String> ret = new HashMap<String, String>();
		if(role == null){
			ret.put("type", "error");
			ret.put("msg", "����д��ȷ�Ľ�ɫ��Ϣ��");
			return ret;
		}
		if(StringUtils.isEmpty(role.getName())){
			ret.put("type", "error");
			ret.put("msg", "����д��ɫ���ƣ�");
			return ret;
		}
		if(roleService.edit(role) <= 0){
			ret.put("type", "error");
			ret.put("msg", "��ɫ�޸�ʧ�ܣ�����ϵ����Ա��");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "��ɫ�޸ĳɹ���");
		return ret;
	}
	
	/**
	 * ɾ����ɫ��Ϣ
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete",method= RequestMethod.POST)
	@ResponseBody
	public Map<String, String> delete(Long id){
		Map<String, String> ret = new HashMap<String, String>();
		if(id == null){
			ret.put("type", "error");
			ret.put("msg", "��ѡ��Ҫɾ���Ľ�ɫ��");
			return ret;
		}
		try {
			if(roleService.delete(id) <= 0){
				ret.put("type", "error");
				ret.put("msg", "ɾ��ʧ�ܣ�����ϵ����Ա��");
				return ret;
			}
		} catch (Exception e) {
			// TODO: handle exception
			ret.put("type", "error");
			ret.put("msg", "�ý�ɫ�´���Ȩ�޻����û���Ϣ������ɾ����");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "��ɫɾ���ɹ���");
		return ret;
	}
	
	/**
	 * ��ȡ���еĲ˵���Ϣ
	 * @return
	 */
	@RequestMapping(value="/get_all_menu",method= RequestMethod.POST)
	@ResponseBody
	public List<Menu> getAllMenu(){
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("offset", 0);
		queryMap.put("pageSize", 99999);
		return menuService.findList(queryMap);
	}
	
	/**
	 * ���Ȩ��
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/add_authority",method= RequestMethod.POST)
	@ResponseBody
	public Map<String, String> addAuthority(
			@RequestParam(name="ids",required=true) String ids,
			@RequestParam(name="roleId",required=true) Long roleId
			){
		Map<String,String> ret = new HashMap<String, String>();
		if(StringUtils.isEmpty(ids)){
			ret.put("type", "error");
			ret.put("msg", "��ѡ����Ӧ��Ȩ�ޣ�");
			return ret;
		}
		if(roleId == null){
			ret.put("type", "error");
			ret.put("msg", "��ѡ����Ӧ�Ľ�ɫ��");
			return ret;
		}
		if(ids.contains(",")){
			ids = ids.substring(0,ids.length()-1);
		}
		String[] idArr = ids.split(",");
		if(idArr.length > 0){
			authorityService.deleteByRoleId(roleId);
		}
		for(String id:idArr){
			Authority authority = new Authority();
			authority.setMenuId(Long.valueOf(id));
			authority.setRoleId(roleId);
			authorityService.add(authority);
		}
		ret.put("type", "success");
		ret.put("msg", "Ȩ�ޱ༭�ɹ���");
		return ret;
	}
	
	/**
	 * ��ȡĳ����ɫ������Ȩ��
	 * @param roleId
	 * @return
	 */
	@RequestMapping(value="/get_role_authority",method= RequestMethod.POST)
	@ResponseBody
	public List<Authority> getRoleAuthority(
			@RequestParam(name="roleId",required=true) Long roleId
		){
		return authorityService.findListByRoleId(roleId);
	}
}
