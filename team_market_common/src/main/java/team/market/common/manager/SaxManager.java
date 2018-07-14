package team.market.common.manager;

import team.market.common.config.DBConf;
import team.market.common.handle.SaxHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;
import java.util.Map;

public class SaxManager {

    public static Map<String,DBConf> getDbConfs(InputStream inputStream){
        // 创建一个解析XML的工厂对象
        SAXParserFactory factory = SAXParserFactory.newInstance();

        SaxHandler handler = null;

        //得到SAX的解析器
        try {
            SAXParser parser = factory.newSAXParser();

            handler = new team.market.common.handle.SaxHandler("dbConf");

            //InputStream inputStream = new FileInputStream(path);

            parser.parse(inputStream, handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回数据集合
        return ((SaxHandler) handler).getDbConfs();
    }

}
