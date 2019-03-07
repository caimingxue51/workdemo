package com.test.demo.worktest;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SxTaskOrder implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 930279338027269425L;
    public static final String RUNNING = "10A";
    public static final String INIT = "10I";

    private String taskId;
    private long orderId;
    private List<SxTaskCmdListLog> sxTaskCmdList;
    private String isKey;
    private String accNbr;
    @Deprecated
    private long neSubTypeId;
    private String nnstCode; // 网元细类Id编码
    @Deprecated
    private long neTypeId;
    private String nntCode; // 网元细类Id编码
    @Deprecated
    private long deviceId;
    private String ndCode; // 接口机Id编码
    private String status;
    private Date createTime;
    private Date finishTime;
    private long priority;
    private String areaCode;
    @Deprecated
    private long areaId;
    private String waCode; // 区域Id编码
    private String relTaskId;
    private long direction;
    private String postTask;
    private List<String> postTaskId;
    private String partitionCode;
    private String orderPriority;
    private long fromTime;// 报文头时间戳 用于顺序控制和对冲
    private String redisClusterCode;
    private String isSyn;
    private String isQuery;
    private List<String> noticeTaskIds;

    public String getRedisClusterCode() {
        return redisClusterCode;
    }

    public void setRedisClusterCode(String redisClusterCode) {
        this.redisClusterCode = redisClusterCode;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public List<SxTaskCmdListLog> getSxTaskCmdList() {
        return sxTaskCmdList;
    }

    public void setSxTaskCmdList(List<SxTaskCmdListLog> sxTaskCmdList) {
        this.sxTaskCmdList = sxTaskCmdList;
    }

    public String getIsKey() {
        return isKey;
    }

    public void setIsKey(String isKey) {
        this.isKey = isKey;
    }

    public String getAccNbr() {
        return accNbr;
    }

    public void setAccNbr(String accNbr) {
        this.accNbr = accNbr;
    }

    public long getNeSubTypeId() {
        return neSubTypeId;
    }

    public void setNeSubTypeId(long neSubTypeId) {
        this.neSubTypeId = neSubTypeId;
    }

    public String getNnstCode() {
        return nnstCode;
    }

    public void setNnstCode(String nnstCode) {
        this.nnstCode = nnstCode;
    }

    public long getNeTypeId() {
        return neTypeId;
    }

    public void setNeTypeId(long neTypeId) {
        this.neTypeId = neTypeId;
    }

    public String getNntCode() {
        return nntCode;
    }

    public void setNntCode(String nntCode) {
        this.nntCode = nntCode;
    }

    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    public String getNdCode() {
        return ndCode;
    }

    public void setNdCode(String ndCode) {
        this.ndCode = ndCode;
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

    public long getPriority() {
        return priority;
    }

    public void setPriority(long priority) {
        this.priority = priority;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public long getAreaId() {
        return areaId;
    }

    public void setAreaId(long areaId) {
        this.areaId = areaId;
    }

    public String getWaCode() {
        return waCode;
    }

    public void setWaCode(String waCode) {
        this.waCode = waCode;
    }

    public String getRelTaskId() {
        return relTaskId;
    }

    public void setRelTaskId(String relTaskId) {
        this.relTaskId = relTaskId;
    }

    public long getDirection() {
        return direction;
    }

    public void setDirection(long direction) {
        this.direction = direction;
    }

    public String getPostTask() {
        return postTask;
    }

    public void setPostTask(String postTask) {
        this.postTask = postTask;
    }

    public List<String> getPostTaskId() {
        return postTaskId;
    }

    public void setPostTaskId(List<String> postTaskId) {
        this.postTaskId = postTaskId;
    }

    public String getPartitionCode() {
        return partitionCode;
    }

    public void setPartitionCode(String partitionCode) {
        this.partitionCode = partitionCode;
    }

    public String getOrderPriority() {
        return orderPriority;
    }

    public void setOrderPriority(String orderPriority) {
        this.orderPriority = orderPriority;
    }

    public long getFromTime() {
        return fromTime;
    }

    public void setFromTime(long fromTime) {
        this.fromTime = fromTime;
    }

    public String getIsSyn() {
        return isSyn;
    }

    public void setIsSyn(String isSyn) {
        this.isSyn = isSyn;
    }

    public List<String> getNoticeTaskIds() {
        return noticeTaskIds;
    }

    public void setNoticeTaskIds(List<String> noticeTaskIds) {
        this.noticeTaskIds = noticeTaskIds;
    }

    public String getIsQuery() {
        return isQuery;
    }

    public void setIsQuery(String isQuery) {
        this.isQuery = isQuery;
    }
}