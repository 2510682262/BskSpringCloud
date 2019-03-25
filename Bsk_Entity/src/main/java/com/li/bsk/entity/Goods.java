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
@TableName("goods")
public class Goods extends Model<Goods> {

    private static final long serialVersionUID = 1L;

	@TableId(value="goods_id", type= IdType.AUTO)
	private Integer goodsId;
	@TableField("goods_name")
	private String goodsName;
	@TableField("goods_type")
	private Integer goodsType;
	@TableField("goods_sweetness")
	private String goodsSweetness;
	@TableField("goods_img")
	private String goodsImg;
	@TableField("goods_price")
	private BigDecimal goodsPrice;
	@TableField("goods_salesvolume")
	private Integer goodsSalesvolume;


	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Integer getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(Integer goodsType) {
		this.goodsType = goodsType;
	}

	public String getGoodsSweetness() {
		return goodsSweetness;
	}

	public void setGoodsSweetness(String goodsSweetness) {
		this.goodsSweetness = goodsSweetness;
	}

	public String getGoodsImg() {
		return goodsImg;
	}

	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}

	public BigDecimal getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(BigDecimal goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public Integer getGoodsSalesvolume() {
		return goodsSalesvolume;
	}

	public void setGoodsSalesvolume(Integer goodsSalesvolume) {
		this.goodsSalesvolume = goodsSalesvolume;
	}

	@Override
	protected Serializable pkVal() {
		return this.goodsId;
	}

}
