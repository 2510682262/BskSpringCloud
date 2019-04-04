package com.li.bsk.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author li
 * @since 2019-04-04
 */
@TableName("menu")
public class Menu extends Model<Menu> {

    private static final long serialVersionUID = 1L;

	@TableId(value="menu_id", type= IdType.AUTO)
	private Integer menuId;
	@TableField("menu_level")
	private Integer menuLevel;
	@TableField("menu_name")
	private String menuName;
	@TableField("menu_icon")
	private String menuIcon;


	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getMenuLevel() {
		return menuLevel;
	}

	public void setMenuLevel(Integer menuLevel) {
		this.menuLevel = menuLevel;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuIcon() {
		return menuIcon;
	}

	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}

	@Override
	protected Serializable pkVal() {
		return this.menuId;
	}

}
