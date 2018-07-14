package team.market.common.util;


public class ConvertClazzUtil {
	 
	public  Object convertInteger(String paramvalue){
		if(paramvalue != null) {
			return (Object)Integer.parseInt(paramvalue);
		}
		return null;
	}
	public Object convertDouble(String paramvalue){
		if(paramvalue != null) {
			return (Object)Double.parseDouble(paramvalue);
		}
		return null;
	}
	public Object convertShort(String paramvalue){
		if(paramvalue != null) {
			return (Object)Short.parseShort(paramvalue);
		}
		return null;
	}
	public Object convertLong(String paramvalue){
		if(paramvalue != null) {
			return (Object)Long.parseLong(paramvalue);	
		}
		return null;
	}
	public Object convertString(String paramvalue){
		return paramvalue;
	}
	public Object convertbyte(String paramvalue){
		if(paramvalue != null) {
			return (Object)Byte.parseByte(paramvalue);
		}
		return null;
	}
}
