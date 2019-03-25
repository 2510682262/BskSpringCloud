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
@TableName("goods_classify")
public class GoodsClassify extends Model<GoodsClassify> {

    private static final long serialVersionUID = 1L;

	@TableId(value="classify_id", type= IdType.AUTO)
	private Integer classifyId;
	@TableField("details_id")
	private Integer detailsId;
	@TableField("goods_id")
	private Integer goodsId;


	public Integer getClassifyId() {
		return classifyId;
	}

	public void setClassifyId(Integer classifyId) {
		this.classifyId = classifyId;
	}

	public Integer getDetailsId() {
		return detailsId;
	}

	public void setDetailsId(Integer detailsId) {
		this.detailsId = detailsId;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	@Override
	protected Serializable pkVal() {
		return this.classifyId;
	}

}
