package team.market.common.pojo;

import java.io.Serializable;
import java.util.Date;

public class StoreFormRecord implements Serializable {

    public final static Integer PENDING = 0x00;
    public final static Integer ACCEPT = 0x01;
    public final static Integer DECLINE = 0x02;
    public final static Integer REJECT = 0x03;

    private static final long serialVersionUID = 1189889255118778957L;

    private String id;
    private String sId;
    private String userId;
    private Integer status;
    private Date createTime;
    private Date consumeTime;
    private String consumeUId;

    public StoreFormRecord() {
    }

    public StoreFormRecord(String id, String sId, String userId, Integer status, Date createTime, Date consumeTime, String consumeUId) {
        this.id = id;
        this.sId = sId;
        this.userId = userId;
        this.status = status;
        this.createTime = createTime;
        this.consumeTime = consumeTime;
        this.consumeUId = consumeUId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getConsumeTime() {
        return consumeTime;
    }

    public void setConsumeTime(Date consumeTime) {
        this.consumeTime = consumeTime;
    }

    public String getConsumeUId() {
        return consumeUId;
    }

    public void setConsumeUId(String consumeUId) {
        this.consumeUId = consumeUId;
    }

}
