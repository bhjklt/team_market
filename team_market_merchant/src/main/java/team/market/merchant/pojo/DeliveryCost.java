package team.market.common.pojo;

import java.io.Serializable;

public class DeliveryCost implements Serializable {

    private static final long serialVersionUID = 2467426707216084762L;

    private String id;
    private Integer sId;
    private Double deliveryCost;
    private String fromTime;
    private String toTime;

    public DeliveryCost() {
    }

    public DeliveryCost(String id, Integer sId, Double deliveryCost, String fromTime, String toTime) {
        this.id = id;
        this.sId = sId;
        this.deliveryCost = deliveryCost;
        this.fromTime = fromTime;
        this.toTime = toTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Double getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(Double deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public String getFromTime() {
        return fromTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    public String getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        this.toTime = toTime;
    }

}
