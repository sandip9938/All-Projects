package com.sp.bean;

import java.io.*;

@SuppressWarnings("serial")
public class UserBean implements Serializable {
	private String userid, pwd, ufn, uln, umid, uad;
	private Long uno;

	public String getUserid() {
		return userid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUfn() {
		return ufn;
	}

	public void setUfn(String ufn) {
		this.ufn = ufn;
	}

	public String getUln() {
		return uln;
	}

	public void setUln(String uln) {
		this.uln = uln;
	}

	public String getUmid() {
		return umid;
	}

	public void setUmid(String umid) {
		this.umid = umid;
	}

	public String getUad() {
		return uad;
	}

	public void setUad(String uad) {
		this.uad = uad;
	}

	public Long getUno() {
		return uno;
	}

	public void setUno(Long uno) {
		this.uno = uno;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

}