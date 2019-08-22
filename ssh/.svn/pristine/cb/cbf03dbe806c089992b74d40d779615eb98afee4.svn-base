package cn.itcast.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.entity.Customer;
import cn.itcast.entity.LinkMan;

public class LinkManDaoImpl extends BaseDaoImpl<LinkMan> implements LinkManDao {



	@SuppressWarnings("unchecked")
	@Override
	public List<LinkMan> findCondition(LinkMan linkMan) {
		DetachedCriteria criteria = DetachedCriteria.forClass(LinkMan.class);
		criteria.add(Restrictions.like("lkmName", "%"+linkMan.getLkmName()+"%"));
	
		List<LinkMan> list = 
				(List<LinkMan>) this.getHibernateTemplate().findByCriteria(criteria);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LinkMan> findMoreCondition(LinkMan linkMan) {
		DetachedCriteria criteria = DetachedCriteria.forClass(LinkMan.class);
		if(linkMan.getLkmName()!=null && !"".equals(linkMan.getLkmName())) {
			criteria.add(Restrictions.eq("lkmName", linkMan.getLkmName()));
		}
		if(linkMan.getCustomer().getCid()!=null && linkMan.getCustomer().getCid()>0) {
			criteria.add(Restrictions.eq("customer.cid", linkMan.getCustomer().getCid()));
		}
		
		return (List<LinkMan>) this.getHibernateTemplate().findByCriteria(criteria);
	}

//	@SuppressWarnings("unchecked")
//	@Override
//	public int findCount() {
//	List<Object> list = (List<Object>) this.getHibernateTemplate().find("select count(*) from LinkMan");
//		
//		if(list != null && list.size()!=0) {
//			Object obj = list.get(0);
//			
//			Long lobj = (Long) obj;
//			int count = lobj.intValue();
//			return count;
//		}
//		return 0;
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<LinkMan> findAllPage(int begin, int pageSize) {
//		DetachedCriteria criteria = DetachedCriteria.forClass(LinkMan.class);
//		List<LinkMan> list =  (List<LinkMan>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
//		return list;
//	}


	

}
