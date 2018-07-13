package team.market.common.pojo;

import java.io.Serializable;

public class Store implements Serializable {

    private static final long serialVersionUID = -8863527932188311011L;

    private String id;
    private String name;
    private String address;
    private String license;

    public Store() {
    }

    public Store(String id, String name, String address, String license) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.license = license;
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

}
