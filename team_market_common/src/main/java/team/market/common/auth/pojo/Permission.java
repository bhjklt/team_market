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

    public Permission(String id, String description, String permission) {
        this(id, description, permission, null);
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

//    insert into MC_PERMISSION(ID, DESCRIPTION, PERMISSION) values ('0', 'CREATE STORE', 'A_STORE:CREATE');
//    insert into MC_PERMISSION(ID, DESCRIPTION, PERMISSION) values ('1', 'MODIFY STORE', 'A_STORE:MODIFY');
//    insert into MC_PERMISSION(ID, DESCRIPTION, PERMISSION) values ('2', 'DELETE STORE', 'A_STORE:DELETE');
//    insert into MC_PERMISSION(ID, DESCRIPTION, PERMISSION) values ('3', 'CREATE AD_FORM', 'A_AD_FORM:CREATE');
//    insert into MC_PERMISSION(ID, DESCRIPTION, PERMISSION) values ('4', 'CREATE PRODUCT', 'MC_PRODUCT:CREATE');
//    insert into MC_PERMISSION(ID, DESCRIPTION, PERMISSION) values ('5', 'MODIFY PRODUCT', 'MC_PRODUCT:MODIFY');
//    insert into MC_PERMISSION(ID, DESCRIPTION, PERMISSION) values ('6', 'DELETE PRODUCT', 'MC_PRODUCT:DELETE');
//    insert into MC_PERMISSION(ID, DESCRIPTION, PERMISSION) values ('7', 'CREATE STORE INFORMATION', 'MC_STOREINFORMATION:CREATE');
//    insert into MC_PERMISSION(ID, DESCRIPTION, PERMISSION) values ('8', 'MODIFY STORE INFORMATION', 'MC_STOREINFORMATION:MODIFY');
//    commit;

    public static final class DefaultPermission {
        public static final Permission CREATE_STORE = new Permission("0", "CREATE STORE", "A_STORE:CREATE");
        public static final Permission MODIFY_STORE = new Permission("1", "MODIFY STORE", "A_STORE:MODIFY");
        public static final Permission DELETE_STORE = new Permission("2", "DELETE STORE", "A_STORE:DELETE");
        public static final Permission CREATE_AD_FORM = new Permission("3", "CREATE AD_FORM", "A_AD_FORM:CREATE");
        public static final Permission CREATE_PRODUCT = new Permission("4", "CREATE PRODUCT", "MC_PRODUCT:CREATE");
        public static final Permission MODIFY_PRODUCT = new Permission("5", "MODIFY PRODUCT", "MC_PRODUCT:MODIFY");
        public static final Permission DELETE_PRODUCT = new Permission("6", "DELETE PRODUCT", "MC_PRODUCT:DELETE");
        public static final Permission CREATE_STORE_INFORMATION = new Permission("7", "CREATE STORE INFORMATION", "MC_STOREINFORMATION:CREATE");
        public static final Permission MODIFY_STORE_INFORMATION = new Permission("8", "MODIFY STORE INFORMATION", "MC_STOREINFORMATION:MODIFY");
    }

}
