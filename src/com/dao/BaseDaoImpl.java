package com.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

public class BaseDaoImpl<T> implements BaseDao<T>{
	
	@Autowired
	protected HibernateTemplate template;
	
	public Serializable add(T t){//template.save(t)返回值是生成的标识符，序列化对象
		return template.save(t);
	}
	
	public void delete(T t){
		template.delete(t);
	}
	
	public void update(T t){
		template.update(t);
	}
	public T get(Class<T> tClass,Serializable id){
		return template.get(tClass, id);
	}
	
	@SuppressWarnings("unchecked")
	//criterion封装的查询条件
	public List<T> list(Criterion[] criterions,Class<T> entityClass,Order ...orders){
		return template.execute(new HibernateCallback<List<T>>() {                     //template.execute方法   执行由一个给定的动作对象指定的动作 Session。
			@Override
			public List<T> doInHibernate(Session session) throws HibernateException{
				Criteria criteria = session.createCriteria(entityClass);//为给定的实体类或实体类的超类创建一个新的Criteria实例
				if(criterions!=null){
					for(Criterion criterion : criterions){
						criteria.add(criterion);//添加一个restriction以约束要检索的结果。//就是添加遍历出来的每一条查询语句
					}
				}
				if(orders!=null){
					for (Order order : orders) {
						criteria.addOrder(order);//添加其他的查询条件
					}
				}
				
				
				return criteria.list();//返回查询结果列表
			}
		});
	}
	
	
	/**
	 * 
	 * 查询每一页显示的数据
	 * @param criterions    封装好的查询条件
	 * @param pageSize	             设置每页显示几条数据
	 * @param offset        设置查询数据的开始位置
	 * @param entityClass	实体类的类类型
	 * @param orders		其他的查询条件
	 * @return
	 */
	
	public List<T> listByPage(Criterion[] criterions, int pageSize, int offset,
			Class<T> entityClass, Order... orders) {
		return template.execute(new HibernateCallback<List<T>>() {

			@SuppressWarnings("unchecked")
			@Override
			public List<T> doInHibernate(Session session)
					throws HibernateException {
				Criteria criteria = session.createCriteria(entityClass);
				if (criterions != null) {
					for (Criterion crion : criterions) {
						if(crion!=null)
							criteria.add(crion);
					}
				}
				if (orders != null) {
					for (Order order : orders) {
						criteria.addOrder(order);
					}
				}
				criteria.setFirstResult(offset);//设置分页开始位置
				criteria.setMaxResults(pageSize);//设置分页大小
				return criteria.list();        //返回从分页开始位置查，查到设置的分页大小为止。例如第二页的开始位置是10，分页大小为6，那么就查10到15这6条数据
			}

		});
	}
	
	/**
	 * 查询到的记录总数
	 * @param criterions
	 * @param entityClass
	 * @return  返回查询的总数目
	 */
	
	/*public Integer count(Criterion[] criterions,
			Class<T> entityClass) {
		return template.execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session)
					throws HibernateException {
				Criteria criteria = session.createCriteria(entityClass);
				if (criterions != null) {
					for (Criterion crion : criterions) {
						if(crion!=null)
							criteria.add(crion);
					}
				}
				criteria.setProjection(Projections.rowCount());
				Long count= (Long)criteria.uniqueResult();//确定是单条记录可以调用uniqueResult方法
				return count.intValue();
			}

		});
	}*/
	
	/**
	 * 查询到的记录总数
	 * @param criterions
	 * @param entityClass
	 * @return  返回查询的总数目
	 */
	
	@SuppressWarnings("unchecked")
	//criterion封装的查询条件
	public Integer count(Criterion[] criterions,Class<T> entityClass,Order ...orders){
		return template.execute(new HibernateCallback<Integer>() {                     //template.execute方法   执行由一个给定的动作对象指定的动作 Session。
			@Override
			public Integer doInHibernate(Session session) throws HibernateException{
				Criteria criteria = session.createCriteria(entityClass);//为给定的实体类或实体类的超类创建一个新的Criteria实例
				if(criterions!=null){
					for(Criterion criterion : criterions){
						criteria.add(criterion);//添加一个restriction以约束要检索的结果。//就是添加遍历出来的每一条查询语句
					}
				}
				if(orders!=null){
					for (Order order : orders) {
						criteria.addOrder(order);//添加其他的查询条件
					}
				}
				
				
				return criteria.list().size();//返回查询结果列表
			}
		});
	}
	
}
