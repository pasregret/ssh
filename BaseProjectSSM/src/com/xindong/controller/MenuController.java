package com.xindong.controller;


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xindong.page.admin.Page;
import com.xindong.pojo.admin.Menu;
import com.xindong.service.admin.MenuService;


@RequestMapping("/admin/menu")
@Controller
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	
	/**
	 * �˵������б�ҳ
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/list",method= RequestMethod.GET)
	public ModelAndView list(ModelAndView model){
		model.addObject("topList", menuService.findTopList());
		model.setViewName("menu/list");
		return model;
	}
	
	/**
	 * ��ȡ�˵��б�
	 * @param page
	 * @param name
	 * @return
	 */
	@RequestMapping(value="/list",method= RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getMenuList(Page page,
			@RequestParam(name="name",required=false,defaultValue="") String name
			){
		Map<String, Object> ret = new HashMap<String, Object>();
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("offset", page.getOffset());
		queryMap.put("pageSize", page.getRows());
		queryMap.put("name", name);
		List<Menu> findList = menuService.findList(queryMap);
		ret.put("rows", findList);
		ret.put("total", menuService.getTotal(queryMap));
		return ret;
	}
	
	/**
	 * ��ȡָ��Ŀ¼�µ�ϵͳicon����
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/get_icons",method= RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getIconList(HttpServletRequest request){
		Map<String, Object> ret = new HashMap<String, Object>();
		String realPath = request.getServletContext().getRealPath("/");
		File file = new File(realPath + "\\resources\\admin\\easyui\\css\\icons");
		List<String> icons = new ArrayList<String>();
		if(!file.exists()){
			ret.put("type", "error");
			ret.put("msg", "�ļ�Ŀ¼�����ڣ�");
			return ret;
		}
		File[] listFiles = file.listFiles();
		for(File f:listFiles){
			if(f!= null && f.getName().contains("png")){
				icons.add("icon-" + f.getName().substring(0, f.getName().indexOf(".")).replace("_", "-"));
			}
		}
		ret.put("type", "success");
		ret.put("content", icons);
		return ret;
	}
	
	/**
	 * �˵����
	 * @param menu
	 * @return
	 */
	@RequestMapping(value="/add",method= RequestMethod.POST)
	@ResponseBody
	public Map<String, String> add(Menu menu){
		Map<String, String> ret = new HashMap<String, String>();
		if(menu == null){
			ret.put("type", "error");
			ret.put("msg", "����д��ȷ�Ĳ˵���Ϣ!");
			return ret;
		}
		if(StringUtils.isEmpty(menu.getName())){
			ret.put("type", "error");
			ret.put("msg", "����д�˵�����!");
			return ret;
		}
		if(StringUtils.isEmpty(menu.getIcon())){
			ret.put("type", "error");
			ret.put("msg", "����д�˵�ͼ����!");
			return ret;
		}
		if(menu.getParentId() == null){
			menu.setParentId(0l);
		}
		if(menuService.add(menu) <= 0){
			ret.put("type", "error");
			ret.put("msg", "���ʧ�ܣ�����ϵ����Ա!");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "��ӳɹ�!");
		return ret;
	}
	
	/**
	 * �˵��޸�
	 * @param menu
	 * @return
	 */
	@RequestMapping(value="/edit",method= RequestMethod.POST)
	@ResponseBody
	public Map<String, String> edit(Menu menu){
		Map<String, String> ret = new HashMap<String, String>();
		if(menu == null){
			ret.put("type", "error");
			ret.put("msg", "��ѡ����ȷ�Ĳ˵���Ϣ!");
			return ret;
		}
		if(StringUtils.isEmpty(menu.getName())){
			ret.put("type", "error");
			ret.put("msg", "����д�˵�����!");
			return ret;
		}
		if(StringUtils.isEmpty(menu.getIcon())){
			ret.put("type", "error");
			ret.put("msg", "����д�˵�ͼ����!");
			return ret;
		}
		if(menu.getParentId() == null){
			menu.setParentId(0l);
		}
		if(menuService.edit(menu) <= 0){
			ret.put("type", "error");
			ret.put("msg", "�޸�ʧ�ܣ�����ϵ����Ա!");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "�޸ĳɹ�!");
		return ret;
	}
	
	/**
	 * ɾ���˵���Ϣ
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete",method= RequestMethod.POST)
	@ResponseBody
	public Map<String, String> delete(
			@RequestParam(name="id",required=true) Long id
			){
		Map<String, String> ret = new HashMap<String, String>();
		if(id == null){
			ret.put("type", "error");
			ret.put("msg", "��ѡ��Ҫɾ���Ĳ˵���Ϣ!");
			return ret;
		}
		List<Menu> findChildernList = menuService.findChildernList(id);
		if(findChildernList != null && findChildernList.size() > 0){
			//��ʾ�÷����´����ӷ��࣬����ɾ��
			ret.put("type", "error");
			ret.put("msg", "�÷����´����ӷ��࣬����ɾ��!");
			return ret;
		}
		if(menuService.delete(id) <= 0){
			ret.put("type", "error");
			ret.put("msg", "ɾ��ʧ�ܣ�����ϵ����Ա!");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "ɾ���ɹ�!");
		return ret;
	}
}
