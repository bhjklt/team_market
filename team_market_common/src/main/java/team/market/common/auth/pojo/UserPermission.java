package team.market.common.auth.pojo;

import team.market.common.annontation.ColumnIgnore;
import team.market.common.annontation.ColumnName;
import team.market.common.annontation.Table;

import java.io.Serializable;
import java.util.Date;

@Table(value = "MC_USER_PERMISSIONS")
public class UserPermission implements Serializable {

    private static final long serialVersionUID = 3252651055026942611L;
    private String id;
    private String userId;
    private String pId;
    private Date currentTime;

    public UserPermission() {

    }

    public UserPermission(String id, String userId, String pId, Date currentTime) {
        this.id = id;
        this.userId = userId;
        this.pId = pId;
        this.currentTime = currentTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @ColumnName("user_id")
    public String getUserId() {
        return userId;
    }

    @ColumnName("user_id")
    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    @ColumnIgnore
    public Date getCurrentTime() {
        return currentTime;
    }

    @ColumnName("create_time")
    public void setCurrentTime(Date currentTime) {
        this.currentTime = currentTime;
    }

}
