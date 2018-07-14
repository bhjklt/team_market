package team.market.common.handle;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import team.market.common.config.DBConf;

import java.util.HashMap;
import java.util.Map;

public class SaxHandler extends DefaultHandler {

    private Map<String,DBConf> dbConfs = null;

    private DBConf dbConf = null;

    //当前节点名称
    private String currentName = null;
    //根节点名称
    private String nodeName = null;

    public SaxHandler(String nodeName) {
        this.nodeName = nodeName;
    }

    //开始解析文档
    @Override
    public void startDocument() throws SAXException {
        dbConfs = new HashMap<String, DBConf>();
    }

    //开始解析节点
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentName = qName;
        if (nodeName.equals(qName)) {
            dbConf = new DBConf();
            dbConf.setId(attributes.getValue("id"));
        }

    }

    //保存节点内容
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String nodeContent = new String(ch, start, length);
        if ("url".equals(currentName)) {
            dbConf.setUrl(nodeContent);
        }
        if ("username".equals(currentName)) {
            dbConf.setUsername(nodeContent);
        }
        if ("password".equals(currentName)) {
            dbConf.setPassword(nodeContent);
        }
        if ("driverClassName".equals(currentName)) {
            dbConf.setDriverClassName(nodeContent);
        }
    }

    //结束解析节点
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (nodeName.equals(qName)) {
            dbConfs.put(dbConf.getId(),dbConf);
        }
        currentName = null;
    }

    //文档解析结束
    @Override
    public void endDocument() throws SAXException {
        System.out.println("--文档解析结束--");
    }

    //获取集合
    public Map<String,DBConf> getDbConfs() {
        return dbConfs;
    }


}
