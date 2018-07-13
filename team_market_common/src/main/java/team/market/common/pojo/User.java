package team.market.common.pojo;

import java.util.Date;

public class User {

    public final static Integer SYSTEM_USER = 0X00;
    public final static Integer MERCHANT_USER = 0x01;
    public final static Integer CUSTOMER_USER = 0x02;

    private String id;
    private String username;
    private String password;
    private int type;
    private String name;
    private String idCardNumber;
    private String idCardPic;
    private Date createDate;

}
