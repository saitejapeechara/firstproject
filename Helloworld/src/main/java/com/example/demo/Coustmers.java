package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Coustmers {

private String cfirstname;

private String clastname;
@Id
private int id;
public String getCfirstname() {
	return cfirstname;
}
public void setCfirstname(String cfirstname) {
	this.cfirstname = cfirstname;
}
public String getClastname() {
	return clastname;
}
public void setClastname(String clastname) {
	this.clastname = clastname;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
@Override
public String toString() {
	return "Coustmers [cfirstname=" + cfirstname + ", clastname=" + clastname + ", id=" + id + "]";
}
}
