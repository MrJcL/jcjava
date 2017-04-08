package com.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pic {
	@Column(length=255)
	private String pictitle;
	@Column(length=255)
	private String picinfo;
	@Column(length=255)
	private String picurl;
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pic(){
		super();
	}
	
	
	public Pic(String pictitle, String picinfo, String picurl, int id) {
		super();
		this.pictitle = pictitle;
		this.picinfo = picinfo;
		this.picurl = picurl;
		this.id = id;
	}

	@Override
	public String toString() {
		return "Pic [pictitle=" + pictitle + ", picinfo=" + picinfo + ", picurl=" + picurl + ", id=" + id + "]";
	}

	public String getPictitle() {
		return pictitle;
	}
	public void setPictitle(String pictitle) {
		this.pictitle = pictitle;
	}
	public String getPicinfo() {
		return picinfo;
	}
	public void setPicinfo(String picinfo) {
		this.picinfo = picinfo;
	}
	public String getPicurl() {
		return picurl;
	}
	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}
	
}
