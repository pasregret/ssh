package cn.itcast.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.entity.User;

public class UserDaoImpl  extends BaseDaoImpl<User> implements UserDao{

	@SuppressWarnings("all")
	public User login(User user) {
		List<User> list = (List<User>) this.getHibernateTemplate().
				find("from User where username=? and password=?", user.getUsername(),user.getPassword());
		if(list != null && list.size()!=0) {
			User u = list.get(0);
			return u;
		}
		return null;
	}

	



}
