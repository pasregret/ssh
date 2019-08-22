package cn.itcast.dao;

import java.util.List;

import cn.itcast.entity.LinkMan;

public interface LinkManDao extends BaseDao<LinkMan>{



	List<LinkMan> findCondition(LinkMan linkMan);

	List<LinkMan> findMoreCondition(LinkMan linkMan);

//	int findCount();

//	List<LinkMan> findAllPage(int begin, int pageSize);





}
