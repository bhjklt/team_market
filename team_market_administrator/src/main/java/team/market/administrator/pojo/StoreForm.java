package team.market.administrator.pojo;

import java.io.Serializable;
import java.util.Date;

public class StoreForm implements Serializable {

    private static final long serialVersionUID = 3333040282286833062L;

    private User user;
    private Identity identity;
    private Store store;
    private Date submitTime;
    private StoreFormRecord storeFormRecord;

    public StoreForm() {
    }

    public StoreForm(User user, Identity identity, Store store, Date submitTime) {
        this.user = user;
        this.identity = identity;
        this.store = store;
        this.submitTime = submitTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public Identity getIdentity() {
        return identity;
    }

    public void setIdentity(Identity identity) {
        this.identity = identity;
    }

    public StoreFormRecord getStoreFormRecord() {
        return storeFormRecord;
    }

    public void setStoreFormRecord(StoreFormRecord storeFormRecord) {
        this.storeFormRecord = storeFormRecord;
    }
}
