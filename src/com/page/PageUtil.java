package com.page;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.dao.BaseDao;

public class PageUtil {
	public static <T> void executePaging(BaseDao<T> dao,
			Criterion[] criterions, Order[] orders, PageVO<T> page,
			Class<T> type) {
		//将查询到的每个页面应该显示的数据设置到data
		page.setData(dao.listByPage(criterions, page.getPageSize(),//传入每个页面显示多少数据和传入每个页面从那个位置开始查
				page.getOffset(), type, orders));                  //查询返回的类型按照type的反射获得
		page.setTotalRecord(dao.count(criterions, type));          //传入查询到的总数
		return;
	}
	public static Criterion likeFull(String propertyName,Object value){
		if(value!=null&&!"".equals(value)){
			return Restrictions.like(propertyName,"%"+value+"%");
		}
		return null;
	}
	
	public static Criterion likeRight(String propertyName,Object value){
		if(value!=null&&!"".equals(value)){
			return Restrictions.like(propertyName,value+"%");
		}
		return null;
	}
	
	public static Criterion likeLeft(String propertyName,Object value){
		if(value!=null&&!"".equals(value)){
			return Restrictions.like(propertyName,"%"+value);
		}
		return null;
	}
	
	
	public static Criterion eq(String propertyName,Object value){
		if(value!=null&&!"".equals(value)){
			return Restrictions.eq(propertyName,value);
		}
		return null;
	}
	
	public static Criterion lt(String propertyName,Object value){
		if(value!=null&&!"".equals(value)){
			return Restrictions.lt(propertyName,value);
		}
		return null;
	}
	
	public static Criterion le(String propertyName,Object value){
		if(value!=null&&!"".equals(value)){
			return Restrictions.le(propertyName,value);
		}
		return null;
	}
	
	public static Criterion gt(String propertyName,Object value){
		if(value!=null&&!"".equals(value)){
			return Restrictions.gt(propertyName,value);
		}
		return null;
	}
	
	public static Criterion ge(String propertyName,Object value){
		if(value!=null&&!"".equals(value)){
			return Restrictions.ge(propertyName,value);
		}
		return null;
	}
	
	
	
}
