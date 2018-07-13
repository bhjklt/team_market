package team.market.common.pojo;

import java.io.Serializable;
import java.util.Date;

public class StoreForm implements Serializable {

    private static final long serialVersionUID = 3333040282286833062L;

    private User user;
    private Store store;
    private Date submitTime;

    public StoreForm() {
    }

    public StoreForm(User user, Store store, Date submitTime) {
        this.user = user;
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

}
