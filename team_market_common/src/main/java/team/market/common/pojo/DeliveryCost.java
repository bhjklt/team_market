package team.market.common.pojo;

import java.io.Serializable;

public class DeliveryCost implements Serializable {

    private static final long serialVersionUID = 2467426707216084762L;

    private String id;
    private Integer sId;
    private Double deliveryCost;
    private String from;
    private String to;

    public DeliveryCost() {
    }

    public DeliveryCost(String id, Integer sId, Double deliveryCost, String from, String to) {
        this.id = id;
        this.sId = sId;
        this.deliveryCost = deliveryCost;
        this.from = from;
        this.to = to;
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

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

}
