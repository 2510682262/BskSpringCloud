package com.li.bsk.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author li
 * @since 2019-03-25
 */
@TableName("log")
public class Log extends Model<Log> {

    private static final long serialVersionUID = 1L;

	@TableId(value="log_id", type= IdType.AUTO)
	private Integer logId;
	@TableField("log_type")
	private Integer logType;
	@TableField("log_info")
	private String logInfo;
	@TableField("user_id")
	private Integer userId;
	@TableField("log_createtime")
	private Date logCreatetime;


	public Integer getLogId() {
		return logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	public Integer getLogType() {
		return logType;
	}

	public void setLogType(Integer logType) {
		this.logType = logType;
	}

	public String getLogInfo() {
		return logInfo;
	}

	public void setLogInfo(String logInfo) {
		this.logInfo = logInfo;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getLogCreatetime() {
		return logCreatetime;
	}

	public void setLogCreatetime(Date logCreatetime) {
		this.logCreatetime = logCreatetime;
	}

	@Override
	protected Serializable pkVal() {
		return this.logId;
	}

}
