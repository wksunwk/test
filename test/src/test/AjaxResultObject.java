package test;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class AjaxResultObject {
	public static final String STATUS_SUCCESS = "SUCCESS";//返回成功
	public static final String STATUS_FAIL = "FAIL"; //返回的失败
	public static final String STATUS_TIMEOUT = "TIMEOUT";//登录超时错误
	
	/**
	 * 返回的状态 STATUS_SUCCESS or STATUS_FAIL
	 */
	private String status;
	/**
	 * 根据状态分别返回不同的结果
	 */
	private Object result;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
	public boolean isSuccess(){
		return AjaxResultObject.STATUS_SUCCESS.equals(status);
	}
	public boolean isFail(){
		return AjaxResultObject.STATUS_FAIL.equals(status);
	}
	public boolean isTimeout(){
		return AjaxResultObject.STATUS_TIMEOUT.equals(status);
	}
	public String toJson(){
		return JSONObject.toJSONString(this);
	}

	static public AjaxResultObject getSimpleObject(String jsonString){
		AjaxResultObject aro = JSON.parseObject(jsonString, AjaxResultObject.class);
		return aro;
	}
	
	public static void main(String[] args){
		AjaxResultObject aro = new AjaxResultObject();
		aro.setStatus("success");
		Map map = new HashMap();
		map.put("aaa", "111");
		map.put("bbb", "222");
		map.put("ccc", "333");
		AjaxResultObject aro2 = new AjaxResultObject();
		aro2.setStatus("failure");
		map.put("key", aro2);
		aro.setResult(map);
		
		String txt = aro.toJson();
		System.out.println(txt);
		JSONObject o = JSONObject.parseObject(txt);
		AjaxResultObject oo = JSON.toJavaObject(o, AjaxResultObject.class);
		oo.setResult((Map)o.getObject("result", Map.class));
		System.out.println((Map)oo.getResult());
		AjaxResultObject ooo=((JSONObject)((Map)oo.getResult())).getObject("key",AjaxResultObject.class);
		System.out.println(ooo.getStatus());
	}
}
