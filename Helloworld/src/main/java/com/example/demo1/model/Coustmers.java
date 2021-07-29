package com.example.demo1.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Coustmers {
	public Coustmers() {
		
	}
	public Coustmers(String cname,String cusername,String cpassword,int cage,String cdob,String cgender,int cid) {
	this.cpassword=cpassword;
	this.cage=cage;
	this.cusername=cusername;
	this.cname=cname;
	this.cid=cid;
	this.cage=cage;
	
	}

private  String cname;
private  String cusername;
private  String cpassword;
private  int  cage;
private  Date cdob;
private  String cgender;
@Id
private   int cid;
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public String getCusername() {
	return cusername;
}
public void setCusername(String cusername) {
	this.cusername = cusername;
}
public String getCpassword() {
	return cpassword;
}
public void setCpassword(String cpassword) {
	this.cpassword = cpassword;
}
public int getCage() {
	return cage;
}
public void setCage(int cage) {
	this.cage = cage;
}
public Date getCdob() {
	return cdob;
}
public void setCdob(Date cdob) {
	this.cdob = cdob;
}
public String getCgender() {
	return cgender;
}
public void setCgender(String cgender) {
	this.cgender = cgender;
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
@Override
public String toString() {
	return "Coustmers [cname=" + cname + ", cusername=" + cusername + ", cpassword=" + cpassword + ", cage=" + cage
			+ ", cdob=" + cdob + ", cgender=" + cgender + "]";
}	
}
