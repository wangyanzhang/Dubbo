package slymove.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.Serializable;

/**
 * @Author : liuzhiying
 *  * @Date : 2019/6/17
 * @Description:
 */
public class JsonData implements Serializable {

	private static final Long serialVersionUID = 1L;

	public static final String SUCCESS = "1";
	public static final String ERROR = "-1";
	public static final String EXCEPTION = "0";

	/**
	 * 请求状态码
	 */
	private String status = "-1";
	/**
	 * 错误码
	 */
	private String code = "";
	/**
	 * 错误信息
	 */
	private String errorMessage = "";
	/**
	 * 数据集合
	 */
	private transient Object data;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data1) {
		this.data = data1;
		if (data instanceof JSONArray) {
			data = JSONArray.fromObject(data);
		} else if (data instanceof JSONObject) {
			data = JSONObject.fromObject(data);
		}
	}

	@Override
	public String toString() {
		JSONObject jsonData = new JSONObject();
		jsonData.put("status", this.getStatus());
		jsonData.put("code", this.getCode());
		jsonData.put("errorMessage", this.getErrorMessage());
		jsonData.put("data", data);
		return jsonData.toString();
	}

}
