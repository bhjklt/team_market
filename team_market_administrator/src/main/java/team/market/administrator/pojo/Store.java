package team.market.administrator.pojo;

import java.io.Serializable;

public class Store implements Serializable {

    private static final long serialVersionUID = -8863527932188311011L;

    public static final Integer AVAILABLE = 0x00;
    public static final Integer FORBIDDEN = 0x01;

    private String id;
    private String name;
    private String address;
    private String license;
    private Integer status;

    public Store() {
    }

    public Store(String id, String name, String address, String license, Integer status) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.license = license;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
