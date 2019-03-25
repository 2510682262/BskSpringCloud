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
@TableName("goods_img")
public class GoodsImg extends Model<GoodsImg> {

    private static final long serialVersionUID = 1L;

	@TableId(value="img_id", type= IdType.AUTO)
	private Integer imgId;
	@TableField("img_path")
	private String imgPath;
	@TableField("goods_id")
	private Integer goodsId;


	public Integer getImgId() {
		return imgId;
	}

	public void setImgId(Integer imgId) {
		this.imgId = imgId;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	@Override
	protected Serializable pkVal() {
		return this.imgId;
	}

}
