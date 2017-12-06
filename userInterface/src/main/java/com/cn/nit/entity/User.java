package com.cn.nit.entity;
// Generated 2016-11-15 21:31:56 by Hibernate Tools 3.5.0.Final

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * TbUser generated by hbm2java
 */
@Entity
@Table(name = "tb_user", catalog = "campuschange")
public class User implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 355136361323954753L;
	private Integer userId;
	private String userName;
	private String userSex;
	private Date createDate;
	private Date modifyDate;
	private String email;
	private String userPwd;
	private String phone;
	private String dateStr;
	public User() {
	}

	public User(String userName,String userSex, Date createDate, Date modifyDate, String email, String userPwd, String phone) {
		this.userName = userName;
		this.userSex = userSex;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.email = email;
		this.userPwd = userPwd;
		this.phone = phone;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "UserId", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "UserName", length = 50)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CreateDate", length = 19)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ModifyDate", length = 19)
	public Date getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Column(name = "Email", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "UserPwd")
	public String getUserPwd() {
		return this.userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
	
	@Column(name = "userSex", length = 20)
	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	@Column(name = "Phone", length = 50)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Transient
	public String getDateStr() {
		return dateStr;
	}
	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}
}
