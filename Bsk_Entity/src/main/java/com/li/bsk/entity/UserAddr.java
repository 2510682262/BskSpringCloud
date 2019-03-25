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
@TableName("user_addr")
public class UserAddr extends Model<UserAddr> {

    private static final long serialVersionUID = 1L;

	@TableId(value="addr_id", type= IdType.AUTO)
	private Integer addrId;
	@TableField("addr_phone")
	private String addrPhone;
	@TableField("addr_shipping")
	private String addrShipping;
	@TableField("addr_shippinginfo")
	private String addrShippinginfo;
	@TableField("addr_default")
	private Integer addrDefault;
	@TableField("addr_name")
	private String addrName;
	@TableField("user_id")
	private Integer userId;


	public Integer getAddrId() {
		return addrId;
	}

	public void setAddrId(Integer addrId) {
		this.addrId = addrId;
	}

	public String getAddrPhone() {
		return addrPhone;
	}

	public void setAddrPhone(String addrPhone) {
		this.addrPhone = addrPhone;
	}

	public String getAddrShipping() {
		return addrShipping;
	}

	public void setAddrShipping(String addrShipping) {
		this.addrShipping = addrShipping;
	}

	public String getAddrShippinginfo() {
		return addrShippinginfo;
	}

	public void setAddrShippinginfo(String addrShippinginfo) {
		this.addrShippinginfo = addrShippinginfo;
	}

	public Integer getAddrDefault() {
		return addrDefault;
	}

	public void setAddrDefault(Integer addrDefault) {
		this.addrDefault = addrDefault;
	}

	public String getAddrName() {
		return addrName;
	}

	public void setAddrName(String addrName) {
		this.addrName = addrName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	protected Serializable pkVal() {
		return this.addrId;
	}

}
