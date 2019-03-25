package com.li.bsk.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author li
 * @since 2019-03-25
 */
@TableName("user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

	@TableId(value="user_id", type= IdType.AUTO)
	private Integer userId;
	@TableField("user_phone")
	private String userPhone;
	@TableField("user_password")
	private String userPassword;
	@TableField("user_flag")
	private Integer userFlag;


	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Integer getUserFlag() {
		return userFlag;
	}

	public void setUserFlag(Integer userFlag) {
		this.userFlag = userFlag;
	}

	@Override
	protected Serializable pkVal() {
		return this.userId;
	}

}
