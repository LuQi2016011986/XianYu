package utils;

import java.util.Map;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;

/**
 * 提供UUID，实现表单数据封装到bean中
 *
 * @author Administrator
 *
 */
public class CommonsUtils {
	/**
	 * 返回一个UUID
	 *
	 * @return
	 */
	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();

	}

	/**
	 * 把表单数据封装到bean中
	 */
	public static <T> T toBean(Map data, Class<T> clazz) {
		try {
			T bean = clazz.newInstance();
			BeanUtils.populate(bean, data);
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
