package team.market.customer.pojo;

public class AdStore {
    private AdForm adForm;
    private Store store;
    private User user;

    public AdForm getAdForm() {
        return adForm;
    }

    public void setAdForm(AdForm adForm) {
        this.adForm = adForm;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public AdStore(AdForm adForm, Store store) {
        this.adForm = adForm;
        this.store = store;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AdStore(){

    }

    public AdStore(AdForm adForm, Store store, User user) {
        this.adForm = adForm;
        this.store = store;
        this.user = user;
    }
}
