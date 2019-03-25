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
@TableName("shop")
public class Shop extends Model<Shop> {

    private static final long serialVersionUID = 1L;

	@TableId(value="shop_id", type= IdType.AUTO)
	private Integer shopId;
	@TableField("shop_num")
	private Integer shopNum;
	@TableField("shop_totalprice")
	private BigDecimal shopTotalprice;
	@TableField("user_id")
	private Integer userId;
	@TableField("goods_id")
	private Integer goodsId;
	@TableField("classify_id")
	private Integer classifyId;


	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public Integer getShopNum() {
		return shopNum;
	}

	public void setShopNum(Integer shopNum) {
		this.shopNum = shopNum;
	}

	public BigDecimal getShopTotalprice() {
		return shopTotalprice;
	}

	public void setShopTotalprice(BigDecimal shopTotalprice) {
		this.shopTotalprice = shopTotalprice;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getClassifyId() {
		return classifyId;
	}

	public void setClassifyId(Integer classifyId) {
		this.classifyId = classifyId;
	}

	@Override
	protected Serializable pkVal() {
		return this.shopId;
	}

}
