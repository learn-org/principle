package com.learn.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: lxj
 * @Date: 2021/5/14
 * @Description: 路径中非 / 加密
 */
public class CommonPathUtils {
	private static final Logger LOG = LoggerFactory.getLogger(CommonPathUtils.class);
	private static final String PATH_DELIMITER = "/";

	public static String encodeRemotePath(String urlPath) throws Exception {
		StringBuilder pathBuilder = new StringBuilder();
		String[] pathSegmentsArr = urlPath.split(PATH_DELIMITER);

		for (String pathSegment : pathSegmentsArr) {
			if (!pathSegment.isEmpty()) {
				try {
					pathBuilder.append(PATH_DELIMITER).append(URLEncoder.encode(pathSegment, "UTF-8").replace("+", "%20"));
				} catch (UnsupportedEncodingException e) {
					LOG.error("Unsupported ecnode exception:{}", e.getMessage());
					throw e;
				}
			}
		}
		if (urlPath.endsWith(PATH_DELIMITER)) {
			pathBuilder.append(PATH_DELIMITER);
		}
		return pathBuilder.toString();
	}
}
