package com.service;

import com.domain.Pic;
import com.page.PageVO;

public interface PicService {
	public PageVO<Pic> listPic(PageVO<Pic> page) throws Throwable;
	public void addPic(Pic pic) throws Throwable;
	public void deletePic(Pic pic) throws Throwable;
	public void updatePic(Pic pic) throws Throwable;
}
