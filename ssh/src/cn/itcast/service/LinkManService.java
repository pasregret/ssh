package cn.itcast.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.LinkManDao;
import cn.itcast.entity.Customer;
import cn.itcast.entity.LinkMan;
import cn.itcast.entity.PageBean;
@Transactional
public class LinkManService {
	private LinkManDao linkmanDao;

	public void setLinkmanDao(LinkManDao linkmanDao) {
		this.linkmanDao = linkmanDao;
	}

	public void addLinkMan(LinkMan linkMan) {
	linkmanDao.add(linkMan);
		
	}


	public List<LinkMan> ListLinkMan() {
		return linkmanDao.findAll();
	}

	public void updateLinkMan(LinkMan linkMan) {
		linkmanDao.update(linkMan);
		
	}

	public LinkMan findOne(int lkmid) {
		
		return linkmanDao.findOne(lkmid);
	}

	public void delete(LinkMan link) {
		
		linkmanDao.delete(link);
	}



	public List<LinkMan> findCondition(LinkMan linkMan) {
	
		return linkmanDao.findCondition(linkMan);
	}

	public List<LinkMan> findMoreCondition(LinkMan linkMan) {
	
		return linkmanDao.findMoreCondition(linkMan);
	}
	
	
//
	public PageBean findPage(Integer currentPage) {
		PageBean pageBean = new PageBean();
		
		pageBean.setCurrentPage(currentPage);
		
		int totalCount = linkmanDao.findCount();
		pageBean.setTotalCount(totalCount);
		
		
		int pageSize = 3;
		
		
		int totalPage = 0;
		if(totalCount%pageSize==0) {
			totalPage = totalCount/pageSize;
		} else {
			totalPage = totalCount/pageSize+1;
		}
		pageBean.setTotalPage(totalPage);
		
		int begin = (currentPage-1)*pageSize;
		
		List<LinkMan> list = linkmanDao.findAllPage(begin,pageSize);
		pageBean.setListlink(list);
		
		return pageBean;
	}

}
