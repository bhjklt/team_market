package team.market.common.pojo;

import java.util.Date;

public class StoreForm {

    public final static Integer PENDING = 0x00;
    public final static Integer ACCEPT = 0x01;
    public final static Integer DECLINE = 0x02;
    public final static Integer REJECT = 0x03;

    private String id;
    private String sId;

    private Integer status;

    private Date createTime;
    private Date consumeTime;

}
