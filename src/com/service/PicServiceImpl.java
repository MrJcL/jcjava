package com.service;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.PicDao;
import com.domain.Pic;
import com.page.PageUtil;
import com.page.PageVO;
@Service
public class PicServiceImpl implements PicService {
	@Autowired
	private PicDao picDao;
	@Override
	public PageVO<Pic> listPic(PageVO<Pic> page) throws Throwable {
		//System.out.println("-------->"+picDao.list());
		Criterion[] criterions={Restrictions.like("pictitle","%%")};
		Order[] orders = { Order.desc("id") };

		PageUtil.executePaging(picDao, criterions, orders, page, Pic.class);
		
		return page;
	}
	@Override
	@Transactional
	public void addPic(Pic pic) throws Throwable {
		//System.out.println("行数------->"+picDao.add(pic));
		picDao.add(pic);
	}
	@Override
	@Transactional
	public void deletePic(Pic pic) throws Throwable {
		picDao.delete(pic);
	}
	@Override
	@Transactional
	public void updatePic(Pic pic) throws Throwable {
		picDao.update(pic);
	}

}
