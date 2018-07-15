package team.market.merchant.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import team.market.common.annontation.ColumnIgnore;
import team.market.common.annontation.ColumnName;
import team.market.common.annontation.Table;
import team.market.common.auth.AuthorizingInfo;
import team.market.common.auth.pojo.Permission;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Table(value = "MC_USER")
public class User implements Serializable, AuthorizingInfo {

    public final static Integer SYSTEM_USER = 0X00;
    public final static Integer MERCHANT_USER = 0x01;
    public final static Integer CUSTOMER_USER = 0x02;

    public final static Integer NORMAL = 0x00;
    public final static Integer FORBIDDEN = 0x02;

    private static final long serialVersionUID = 6150975380497946378L;

    private String id;
    private String identityId;
    private String username;
    private String password;
    private Integer type;
    private Integer status;
    private Date createTime;
    private Set<Permission> permissions;

    public User() {
    }

    public User(String id, String identityId, String username, String password, Integer type, Integer status, Date createTime, Set<Permission> permissions) {
        this.id = id;
        this.identityId = identityId;
        this.username = username;
        this.password = password;
        this.type = type;
        this.status = status;
        this.createTime = createTime;
        this.permissions = permissions;
    }

    @ColumnName("identity_id")
    public String getIdentityId() {
        return identityId;
    }

    @ColumnName("identity_id")
    public void setIdentityId(String identityId) {
        this.identityId = identityId;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @ColumnName("create_time")
    public Date getCreateTime() {
        return createTime;
    }

    @ColumnName("create_time")
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @JsonIgnore
    @ColumnIgnore
    public String getPrincipal() {
        return this.username;
    }

    @JsonIgnore
    @ColumnIgnore
    public String getCredentials() {
        return this.password;
    }

    @ColumnIgnore
    public Set<Permission> getPermissions() {
        return this.permissions;
    }

    @ColumnIgnore
    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
