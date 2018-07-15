package team.market.merchant.pojo;


public class Identity {

    public final static Integer NORMAL = 0x00;
    public final static Integer BINDING = 0x01;
    public final static Integer FORBIDDEN = 0x02;

    private String id;
    private String name;
    private String idCardNumber;
    private String idCardPic;
    private Integer status;

    public Identity() {

    }

    public Identity(String id,String name, String idCardNumber, String idCardPic, Integer status) {
        this.id = id;
        this.name = name;
        this.idCardNumber = idCardNumber;
        this.idCardPic = idCardPic;
        this.status = status;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
