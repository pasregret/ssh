package cn.itcast.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.DictDao;
import cn.itcast.entity.Dict;
@Transactional
public class DictService {
	private DictDao dictDao;

	public void setDictDao(DictDao dictDao) {
		this.dictDao = dictDao;
	}

	public List<Dict> findAll() {
		
		return dictDao.findAll();
	}



	

	public Dict findOne(int did) {
		
		return dictDao.findOne(did);
	}

	public void delete(Dict d) {
		dictDao.delete(d);
		
	}

	public void add(Dict dict) {
		dictDao.add(dict);
	}
	

}
