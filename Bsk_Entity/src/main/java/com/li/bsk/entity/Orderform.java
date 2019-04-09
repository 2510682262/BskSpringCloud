package com.li.bsk.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author li
 * @since 2019-04-09
 */
@TableName("orderform")
public class Orderform extends Model<Orderform> {

    private static final long serialVersionUID = 1L;

	@TableId(value="order_id", type= IdType.AUTO)
	private Integer orderId;
	@TableField("order_name")
	private String orderName;
	@TableField("addr_id")
	private Integer addrId;
	@TableField("goods_id")
	private Integer goodsId;
	@TableField("goods_num")
	private Integer goodsNum;
	@TableField("goods_details")
	private Integer goodsDetails;
	@TableField("order_price")
	private BigDecimal orderPrice;
	@TableField("order_delivetime")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date orderDelivetime;
	@TableField("order_info")
	private String orderInfo;
	@TableField("user_id")
	private Integer userId;


	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public Integer getAddrId() {
		return addrId;
	}

	public void setAddrId(Integer addrId) {
		this.addrId = addrId;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}

	public Integer getGoodsDetails() {
		return goodsDetails;
	}

	public void setGoodsDetails(Integer goodsDetails) {
		this.goodsDetails = goodsDetails;
	}

	public BigDecimal getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(BigDecimal orderPrice) {
		this.orderPrice = orderPrice;
	}

	public Date getOrderDelivetime() {
		return orderDelivetime;
	}

	public void setOrderDelivetime(Date orderDelivetime) {
		this.orderDelivetime = orderDelivetime;
	}

	public String getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(String orderInfo) {
		this.orderInfo = orderInfo;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	protected Serializable pkVal() {
		return this.orderId;
	}

}
