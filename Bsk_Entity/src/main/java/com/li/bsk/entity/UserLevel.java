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
@TableName("user_level")
public class UserLevel extends Model<UserLevel> {

    private static final long serialVersionUID = 1L;

	@TableId(value="level_id", type= IdType.AUTO)
	private Integer levelId;
	@TableField("level_name")
	private String levelName;
	@TableField("level_exp")
	private Integer levelExp;


	public Integer getLevelId() {
		return levelId;
	}

	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public Integer getLevelExp() {
		return levelExp;
	}

	public void setLevelExp(Integer levelExp) {
		this.levelExp = levelExp;
	}

	@Override
	protected Serializable pkVal() {
		return this.levelId;
	}

}
