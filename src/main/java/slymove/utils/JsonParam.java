package slymove.utils;

import net.sf.json.JSONArray;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @Author : liuzhiying
 * @Date : 2019/6/17
 * @Description: 参数封装工具类
 */
public class JsonParam extends HashMap<String, Object> {

	private static final Logger logger = LoggerFactory.getLogger(JsonParam.class);

	/**
	 * 将request中所有的键值赋值到map上。(使用此方法注意,此方法只能封装简单类型的参数)
	 * 
	 * @param request
	 * @return Map封装后的参数
	 */
	public static JsonParam populateReqBean(HttpServletRequest request) {

		Enumeration names = request.getParameterNames();
		JsonParam param = new JsonParam();
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			param.put(name, request.getParameter(name).trim());
		}
		return param;
	}

	/**
	 * 将multipartRequest中所有的键值赋值到map上。(使用此方法注意,此方法只能封装简单类型的参数)
	 * 
	 * @param request
	 * @return Map封装后的参数
	 */
	public static JsonParam populateMultipartReqBean(MultipartHttpServletRequest request) {

		Enumeration names = request.getParameterNames();
		JsonParam param = new JsonParam();
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			param.put(name, request.getParameter(name).trim());
		}
		return param;
	}

	/**
	 * 将request中的所有键值赋到bean对象上。(使用此方法注意,此方法只能封装简单类型的参数)
	 * 
	 * @param bean
	 *            封装对象的实例
	 * @param request
	 *            HttpServletRequest对象
	 */
	public static void populateReqBean(Object bean, HttpServletRequest request) {

		try {
			Map param = JsonParam.populateReqBean(request);
			if (null != bean) {
				BeanUtils.populate(bean, param);
			}
		} catch (Exception e) {
			JsonParam.logger.info("populateReqBean(): 处理参数异常！");
			e.getMessage();
		}
	}

	/**
	 * 按照key获取String类型参数
	 * 
	 * @param key
	 *            键
	 * @return 返回String类型的参数
	 */
	public String getStr(String key) {

		if (this.get(key) == null)
			return "";

		return this.get(key).toString().trim();
	}

	/**
	 * 按照key获取int类型参数
	 * 
	 * @param key
	 *            键
	 * @return int类型的参数
	 */
	public Integer getInt(String key) {

		if (StringUtils.isEmpty(this.get(key)))
			return 0;

		return Integer.parseInt(this.get(key).toString().trim());
	}

	/**
	 * 按照key获取double类型参数
	 * 
	 * @param key
	 *            键
	 * @return Double类型的参数
	 */
	public double getDouble(String key) {

		if (StringUtils.isEmpty(this.get(key)))
			return -1D;

		return Double.parseDouble(this.get(key).toString().trim());
	}

	/**
	 * 按照key获取double类型参数
	 * 
	 * @param key
	 *            键
	 * @return 返回Float类型参数
	 */
	public float getFloat(String key) {

		if (StringUtils.isEmpty(this.get(key)))
			return -1F;

		return Float.parseFloat(this.get(key).toString().trim());
	}

	/**
	 * 按照key获取Long类型参数
	 * 
	 * @param key
	 *            键
	 * @return 返回Long类型的参数
	 */
	public Long getLong(String key) {

		if (this.get(key) == null)
			return -1L;

		return Long.parseLong(this.get(key).toString().trim());
	}

	/**
	 * 按照key获取Short类型参数
	 * 
	 * @param key
	 *            键
	 * @return Short类型的参数
	 */
	public Short getShort(String key) {

		if (this.get(key) == null)
			return -1;

		return Short.parseShort(this.get(key).toString().trim());
	}

	/**
	 * 按照key获取String数组类型参数 getDate(key,format)
	 * 
	 * @param key
	 * @return
	 */
	public String[] getStrArray(String key) {
		if (this.get(key) == null)
			return null;

		JSONArray jsonArray = JSONArray.fromObject(this.get(key));
		String[] strArray = new String[jsonArray.size()];
		for (int i = 0; i < jsonArray.size(); i++) {
			strArray[i] = jsonArray.getString(i);
		}
		return strArray;
	}

	/**
	 * 按照key获取String数组类型参数 getDate(key,format)
	 * 
	 * @param key
	 * @return
	 */
	public Long[] getLongArray(String key) {
		if (this.get(key) == null)
			return null;

		JSONArray jsonArray = JSONArray.fromObject(this.get(key));
		Long[] longArray = new Long[jsonArray.size()];
		for (int i = 0; i < jsonArray.size(); i++) {
			longArray[i] = jsonArray.getLong(i);
		}
		return longArray;
	}

	public List<Map<String, Object>> getList(String key) {

		if (this.get(key) == null)
			return null;

		JSONArray jsonArray = JSONArray.fromObject(this.get(key));
		List<Map<String, Object>> list = new ArrayList<>();
		for (int i = 0; i < jsonArray.size(); i++) {
			list.add((Map) jsonArray.get(i));
		}
		return list;

	}

}
