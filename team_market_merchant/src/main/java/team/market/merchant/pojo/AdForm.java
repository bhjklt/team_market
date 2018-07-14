package team.market.merchant.pojo;

import java.io.Serializable;
import java.util.Date;

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
