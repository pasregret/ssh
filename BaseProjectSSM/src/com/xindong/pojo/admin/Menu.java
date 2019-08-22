package com.xindong.pojo.admin;

import org.springframework.stereotype.Component;

/**
 * �˵�ʵ����
 * 
 * @author llq
 *
 */
@Component
public class Menu {
	private Long id;
	private Long parentId;// ����id
	private Long _parentId;// ����id,����ƥ��easyui�ĸ���id
	private String name;// �˵�����
	private String url;// ������url
	private String icon;// �˵�iconͼ��

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Long get_parentId() {
		_parentId = parentId;
		return _parentId;
	}

	public void set_parentId(Long _parentId) {
		this._parentId = _parentId;
	}
}
