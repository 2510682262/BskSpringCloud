package com.li.bsk.entity;

import java.math.BigDecimal;

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
@TableName("user_message")
public class UserMessage extends Model<UserMessage> {

    private static final long serialVersionUID = 1L;

    @TableId("mes_id")
	private Integer mesId;
	@TableField("mes_nickname")
	private String mesNickname;
	@TableField("mes_name")
	private String mesName;
	@TableField("mes_sex")
	private Integer mesSex;
	@TableField("mes_love")
	private Integer mesLove;
	@TableField("mes_instudy")
	private Integer mesInstudy;
	@TableField("mes_income")
	private BigDecimal mesIncome;


	public Integer getMesId() {
		return mesId;
	}

	public void setMesId(Integer mesId) {
		this.mesId = mesId;
	}

	public String getMesNickname() {
		return mesNickname;
	}

	public void setMesNickname(String mesNickname) {
		this.mesNickname = mesNickname;
	}

	public String getMesName() {
		return mesName;
	}

	public void setMesName(String mesName) {
		this.mesName = mesName;
	}

	public Integer getMesSex() {
		return mesSex;
	}

	public void setMesSex(Integer mesSex) {
		this.mesSex = mesSex;
	}

	public Integer getMesLove() {
		return mesLove;
	}

	public void setMesLove(Integer mesLove) {
		this.mesLove = mesLove;
	}

	public Integer getMesInstudy() {
		return mesInstudy;
	}

	public void setMesInstudy(Integer mesInstudy) {
		this.mesInstudy = mesInstudy;
	}

	public BigDecimal getMesIncome() {
		return mesIncome;
	}

	public void setMesIncome(BigDecimal mesIncome) {
		this.mesIncome = mesIncome;
	}

	@Override
	protected Serializable pkVal() {
		return this.mesId;
	}

}
