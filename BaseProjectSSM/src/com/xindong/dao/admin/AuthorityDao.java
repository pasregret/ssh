package com.xindong.dao.admin;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.xindong.pojo.admin.Authority;

/**
 * Ȩ��ʵ����dao
 * @author llq
 *
 */
@Repository
public interface AuthorityDao {
	public int add(Authority authority);
	public int deleteByRoleId(Long roleId);
	public List<Authority> findListByRoleId(Long roleId);
}
