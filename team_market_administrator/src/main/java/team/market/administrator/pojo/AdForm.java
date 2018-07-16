package team.market.administrator.pojo;

import team.market.common.annontation.ColumnIgnore;
import team.market.common.annontation.ColumnName;
import team.market.common.annontation.Table;

import java.io.Serializable;
import java.sql.Date;

@Table("A_AD_FORM")
public class AdForm implements Serializable {

    private static final long serialVersionUID = 1973194382458528986L;

    private String id;
    private String sId;
    private Double price;
    private Date createTime;
    private Date consumeTime;
    private String consumeUId;

    public AdForm() {
    }

    public AdForm(String id, String sId, Double price, Date createTime, Date consumeTime, String consumeUId) {
        this.id = id;
        this.sId = sId;
        this.price = price;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

}
