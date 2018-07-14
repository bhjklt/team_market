package team.market.common.pojo;

import team.market.common.auth.AuthorizingInfo;
import team.market.common.auth.Permission;
import team.market.common.auth.Role;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class User implements Serializable, AuthorizingInfo {

    public final static Integer SYSTEM_USER = 0X00;
    public final static Integer MERCHANT_USER = 0x01;
    public final static Integer CUSTOMER_USER = 0x02;

    private static final long serialVersionUID = 6150975380497946378L;

    private String id;
    private String identityId;
    private String username;
    private String password;
    private int type;
    private Date createTime;
    private Set<Permission> permissions;
    private Set<Role> roles;

    public User() {
    }

    public User(String id, String identityId, String username, String password, int type, Date createTime) {
        this.id = id;
        this.identityId = identityId;
        this.username = username;
        this.password = password;
        this.type = type;
        this.createTime = createTime;
    }

    public String getIdentityId() {
        return identityId;
    }

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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPrincipal() {
        return this.username;
    }

    public String getCredentials() {
        return this.password;
    }

    public Set<Permission> getPermissions() {
        return this.permissions;
    }

    public Set<Role> getRoles() {
        return this.roles;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}
