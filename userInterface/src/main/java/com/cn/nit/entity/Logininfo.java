package com.cn.nit.entity;
// Generated 2016-11-15 21:31:56 by Hibernate Tools 3.5.0.Final

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * TbLogininfo generated by hbm2java
 */
@Entity
@Table(name = "tb_logininfo", catalog = "campuschange")
public class Logininfo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3972153734511653767L;
	private Integer loginInfoId;
	private Integer userId;
	private Date loginDate;
	private String ip;
	private String userName;

	public Logininfo() {
	}

	public Logininfo(Integer userId, Date loginDate, String ip, String userName) {
		this.userId = userId;
		this.loginDate = loginDate;
		this.ip = ip;
		this.userName = userName;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "LoginInfoId", unique = true, nullable = false)
	public Integer getLoginInfoId() {
		return this.loginInfoId;
	}

	public void setLoginInfoId(Integer loginInfoId) {
		this.loginInfoId = loginInfoId;
	}

	@JoinColumn(name = "UserId")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LoginDate", length = 19)
	public Date getLoginDate() {
		return this.loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	@Column(name = "Ip", length = 50)
	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Column(name = "UserName", length = 50)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
