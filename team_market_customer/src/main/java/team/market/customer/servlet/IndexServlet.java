package team.market.customer.servlet;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import team.market.common.util.HttpUtil;
import team.market.common.util.JsonUtil;
import team.market.customer.dao.StoreInformationDao;
import team.market.customer.dao.impl.StoreInformationDaoImpl;
import team.market.customer.pojo.Store;
import team.market.customer.pojo.StoreInformation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Justin
 */
public class IndexServlet extends HttpServlet {

    private final static String url= "http://10.222.29.195:9090/store?method=available" ;

    private StoreInformationDao storeInformationDao = new StoreInformationDaoImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jsons = HttpUtil.doGet(url);
        System.out.println("json:"+jsons);
        ObjectMapper mapper = new ObjectMapper();
        //A端传过来的store集合
        List<Store> stores = null;
        try {
            stores = JsonUtil.json2list(jsons,Store.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //mapper.readValue(jsons,new TypeReference<List<Store>>(){});
        List<String> sids = new ArrayList<String>();
        for (int i =0; i<stores.size(); i++) {
            sids.add(stores.get(i).getId());
        }
        //MC端查询出对应的storeInformation集合
        List<StoreInformation> storeInformations = storeInformationDao.findStoreInformationsBySids(sids);
        List<StoreDetailInfomation> storeDetailInfomations = packingData(stores,storeInformations);
        request.setAttribute("storeDetailInfomations",storeDetailInfomations);
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }

    private List<StoreDetailInfomation> packingData(List<Store> stores,List<StoreInformation> storeInformations){
        List<StoreDetailInfomation> storeDetailInfomations = new ArrayList<>();
        Map<String,StoreDetailInfomation> storeDetailInfomationMap = new HashMap<>();
        for (Store store : stores) {
            StoreDetailInfomation storeDetailInfomation = new StoreDetailInfomation();
            storeDetailInfomation.setsId(store.getId());
            storeDetailInfomation.setName(store.getName());
            storeDetailInfomation.setAddress(store.getAddress());
            storeDetailInfomation.setLicense(store.getLicense());
            storeDetailInfomationMap.put(store.getId(),storeDetailInfomation);
        }
        for (StoreInformation storeInformation:storeInformations){
            StoreDetailInfomation detailInfomation = storeDetailInfomationMap.get(storeInformation.getsId());
            detailInfomation.setOpen(storeInformation.getOpen());
            detailInfomation.setClose(storeInformation.getClose());
            detailInfomation.setDeliveryArea(storeInformation.getDeliveryArea());
            detailInfomation.setDescription(storeInformation.getDescription());
            detailInfomation.setImages(storeInformation.getImages());
            storeDetailInfomations.add(detailInfomation);
        }
        return  storeDetailInfomations;
    }



    public class StoreDetailInfomation{
        private String sId;
        private String name;
        private String address;
        private String license;
        private String open;
        private String close;
        private Double deliveryArea;
        private String description;
        private String images;

        public StoreDetailInfomation() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getLicense() {
            return license;
        }

        public void setLicense(String license) {
            this.license = license;
        }

        public String getsId() {
            return sId;
        }

        public void setsId(String sId) {
            this.sId = sId;
        }

        public String getOpen() {
            return open;
        }

        public void setOpen(String open) {
            this.open = open;
        }

        public String getClose() {
            return close;
        }

        public void setClose(String close) {
            this.close = close;
        }

        public Double getDeliveryArea() {
            return deliveryArea;
        }

        public void setDeliveryArea(Double deliveryArea) {
            this.deliveryArea = deliveryArea;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getImages() {
            return images;
        }

        public void setImages(String images) {
            this.images = images;
        }
    }
}
