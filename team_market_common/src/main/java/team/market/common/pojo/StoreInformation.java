package team.market.common.pojo;

import java.io.Serializable;

public class StoreInformation implements Serializable {

    private static final long serialVersionUID = -3645630957086653497L;

    private String id;
    private String sId;
    private String open;
    private String close;
    private Double deliveryArea;
    private String description;
    private String images;

    public StoreInformation() {
    }

    public StoreInformation(String id, String sId, String open, String close, Double deliveryArea, String description, String images) {
        this.id = id;
        this.sId = sId;
        this.open = open;
        this.close = close;
        this.deliveryArea = deliveryArea;
        this.description = description;
        this.images = images;
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

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public Double getDeliveryArea() {
        return deliveryArea;
    }

    public void setDeliveryArea(Double deliveryArea) {
        this.deliveryArea = deliveryArea;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

}
