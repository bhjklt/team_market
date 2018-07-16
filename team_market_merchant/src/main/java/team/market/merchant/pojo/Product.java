package team.market.merchant.pojo;


import team.market.common.annontation.ColumnIgnore;
import team.market.common.annontation.ColumnName;
import team.market.common.annontation.Table;

import java.io.Serializable;
import java.util.Date;

@Table("MC_PRODUCT")
public class Product implements Serializable {

    private static final long serialVersionUID = -8281539444668575519L;

    private String id;
    private String sId;
    private String name;
    private String description;
    private String images;
    private Double price;
    private Integer quantity;
    private Date createTime;

    public Product() {
    }

    public Product(String id, String sId, String name, String description, String images, Double price, Integer quantity, Date createTime) {
        this.id = id;
        this.sId = sId;
        this.name = name;
        this.description = description;
        this.images = images;
        this.price = price;
        this.quantity = quantity;
        this.createTime = createTime;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @ColumnIgnore
    public Date getCreateTime() {
        return createTime;
    }

    @ColumnName("create_time")
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
