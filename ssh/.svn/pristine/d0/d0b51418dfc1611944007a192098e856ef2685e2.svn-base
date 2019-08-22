package cn.itcast.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.UserDao;
import cn.itcast.entity.User;
@Transactional
public class UserService {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User login(User user) {
	
		return userDao.login(user);
	}

	public List<User> findAll() {
		
		return userDao.findAll();
	}

	public User findOne(int uid) {
		
		return userDao.findOne(uid);
	}

	public void delete(User u) {
		userDao.delete(u);
		
	}

	public void update(User user) {
		userDao.update(user);
		
	}

	public void add(User user) {
		userDao.add(user);

	}
	

	

	
	
	
	

}
