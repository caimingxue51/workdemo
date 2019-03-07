package com.test.demo.worktest;

import java.io.Serializable;
import java.util.Date;

public class SxTaskCmdListLog implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7003530949255399675L;
	private String serialId;
	@Deprecated
	private String templateId;
	private String nctCode;//指令模板ID
	private String status;
	private Date createTime;
	private Date finishTime;
	private String cmdSendLog;
	private String cmdRecvLog;
	private Date sendTime;
	private Date recvTime;
	private String partitionCode;
	private String wcmdcCode;
	private String taskId;
	private String paramList;
	private String priority;
	
	private String redisClusterCode;

	public String getRedisClusterCode() {
		return redisClusterCode;
	}

	public void setRedisClusterCode(String redisClusterCode) {
		this.redisClusterCode = redisClusterCode;
	}
	
	public String getSerialId() {
		return serialId;
	}
	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}
	public String getTemplateId() {
		return templateId;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	public String getNctCode() {
		return nctCode;
	}
	public void setNctCode(String nctCode) {
		this.nctCode = nctCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	public String getCmdSendLog() {
		return cmdSendLog;
	}
	public void setCmdSendLog(String cmdSendLog) {
		this.cmdSendLog = cmdSendLog;
	}
	public String getCmdRecvLog() {
		return cmdRecvLog;
	}
	public void setCmdRecvLog(String cmdRecvLog) {
		this.cmdRecvLog = cmdRecvLog;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public Date getRecvTime() {
		return recvTime;
	}
	public void setRecvTime(Date recvTime) {
		this.recvTime = recvTime;
	}
	public String getPartitionCode() {
		return partitionCode;
	}
	public void setPartitionCode(String partitionCode) {
		this.partitionCode = partitionCode;
	}
	public String getWcmdcCode() {
		return wcmdcCode;
	}
	public void setWcmdcCode(String wcmdcCode) {
		this.wcmdcCode = wcmdcCode;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getParamList() {
		return paramList;
	}
	public void setParamList(String paramList) {
		this.paramList = paramList;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
}
