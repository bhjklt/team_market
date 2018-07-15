package team.market.administrator.pojo;

import team.market.common.annontation.ColumnName;
import team.market.common.annontation.Table;

import java.io.Serializable;
import java.sql.Date;


@Table("A_STORE_FORM_RECORD")
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
    @ColumnName("USER_ID")
    public String getUserId() {
        return userId;
    }

    @ColumnName("USER_ID")
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @ColumnName("CREATE_TIME")
    public Date getCreateTime() {
        return createTime;
    }
    @ColumnName("CREATE_TIME")
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    @ColumnName("CONSUME_TIME")
    public Date getConsumeTime() {
        return consumeTime;
    }
    @ColumnName("CONSUME_TIME")
    public void setConsumeTime(Date consumeTime) {
        this.consumeTime = consumeTime;
    }

    @ColumnName("CONSUME_UID")
    public String getConsumeUId() {
        return consumeUId;
    }
    @ColumnName("CONSUME_UID")
    public void setConsumeUId(String consumeUId) {
        this.consumeUId = consumeUId;
    }

    @Override
    public String toString() {
        return "StoreFormRecord{" +
                "id='" + id + '\'' +
                ", sId='" + sId + '\'' +
                ", userId='" + userId + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", consumeTime=" + consumeTime +
                ", consumeUId='" + consumeUId + '\'' +
                '}';
    }
}
