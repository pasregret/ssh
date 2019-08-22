package cn.itcast.dao;

import java.util.List;

import cn.itcast.entity.Customer;
import cn.itcast.entity.Dict;
import cn.itcast.entity.PageBean;

public interface CustomerDao extends BaseDao<Customer> {





	

	List<Customer> findConditain(Customer customer);

	List<Customer> findMoreCondition(Customer customer);

	List<Dict> findAllDictLevel();

	List<Customer> selectCustomerSource();

	List<Customer> selectCustomerLevel();

	









}
