package team.market.common.auth.pojo;

import team.market.common.annontation.ColumnIgnore;
import team.market.common.annontation.ColumnName;
import team.market.common.annontation.Table;
import java.io.Serializable;
import java.sql.Date;

@Table(value = "MC_PERMISSION")
public class Permission implements Serializable {

    private static final long serialVersionUID = 1294168626837028429L;

    private String id;
    private String description;
    private String permission;
    private Date createTime;

    public Permission() {

    }

    public Permission(String permission) {
        this.permission = permission;
    }

    public Permission(String id, String description, String permission, Date createTime) {
        this.id = id;
        this.description = description;
        this.permission = permission;
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
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
