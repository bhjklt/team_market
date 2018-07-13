package team.market.common.pojo;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    public final static Integer SYSTEM_USER = 0X00;
    public final static Integer MERCHANT_USER = 0x01;
    public final static Integer CUSTOMER_USER = 0x02;

    private static final long serialVersionUID = 6150975380497946378L;

    private String id;
    private String username;
    private String password;
    private int type;
    private String name;
    private String idCardNumber;
    private String idCardPic;
    private Date createTime;

    public User() {
    }

    public User(String id, String username, String password, int type, String name, String idCardNumber, String idCardPic, Date createTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.type = type;
        this.name = name;
        this.idCardNumber = idCardNumber;
        this.idCardPic = idCardPic;
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getIdCardPic() {
        return idCardPic;
    }

    public void setIdCardPic(String idCardPic) {
        this.idCardPic = idCardPic;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
