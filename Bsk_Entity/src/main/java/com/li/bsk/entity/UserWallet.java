package com.li.bsk.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author li
 * @since 2019-03-25
 */
@TableName("user_wallet")
public class UserWallet extends Model<UserWallet> {

    private static final long serialVersionUID = 1L;

	@TableId(value="wallet_id", type= IdType.AUTO)
	private Integer walletId;
	@TableField("wallet_totalmoney")
	private BigDecimal walletTotalmoney;


	public Integer getWalletId() {
		return walletId;
	}

	public void setWalletId(Integer walletId) {
		this.walletId = walletId;
	}

	public BigDecimal getWalletTotalmoney() {
		return walletTotalmoney;
	}

	public void setWalletTotalmoney(BigDecimal walletTotalmoney) {
		this.walletTotalmoney = walletTotalmoney;
	}

	@Override
	protected Serializable pkVal() {
		return this.walletId;
	}

}
