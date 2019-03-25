package com.li.bsk.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.math.BigDecimal;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author li
 * @since 2019-03-25
 */
@TableName("goods_classify_details")
public class GoodsClassifyDetails extends Model<GoodsClassifyDetails> {

    private static final long serialVersionUID = 1L;

	@TableId(value="details_id", type= IdType.AUTO)
	private Integer detailsId;
	@TableField("details_size")
	private String detailsSize;
	@TableField("details_person")
	private String detailsPerson;
	@TableField("details_tableware")
	private String detailsTableware;
	@TableField("details_time")
	private String detailsTime;
	@TableField("details_price")
	private BigDecimal detailsPrice;
	@TableField("details_name")
	private String detailsName;


	public Integer getDetailsId() {
		return detailsId;
	}

	public void setDetailsId(Integer detailsId) {
		this.detailsId = detailsId;
	}

	public String getDetailsSize() {
		return detailsSize;
	}

	public void setDetailsSize(String detailsSize) {
		this.detailsSize = detailsSize;
	}

	public String getDetailsPerson() {
		return detailsPerson;
	}

	public void setDetailsPerson(String detailsPerson) {
		this.detailsPerson = detailsPerson;
	}

	public String getDetailsTableware() {
		return detailsTableware;
	}

	public void setDetailsTableware(String detailsTableware) {
		this.detailsTableware = detailsTableware;
	}

	public String getDetailsTime() {
		return detailsTime;
	}

	public void setDetailsTime(String detailsTime) {
		this.detailsTime = detailsTime;
	}

	public BigDecimal getDetailsPrice() {
		return detailsPrice;
	}

	public void setDetailsPrice(BigDecimal detailsPrice) {
		this.detailsPrice = detailsPrice;
	}

	public String getDetailsName() {
		return detailsName;
	}

	public void setDetailsName(String detailsName) {
		this.detailsName = detailsName;
	}

	@Override
	protected Serializable pkVal() {
		return this.detailsId;
	}

}
