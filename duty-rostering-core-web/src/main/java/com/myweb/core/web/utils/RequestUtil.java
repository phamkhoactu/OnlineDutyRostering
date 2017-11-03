package com.myweb.core.web.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.displaytag.tags.TableTagParameters;
import org.displaytag.util.ParamEncoder;
import com.myweb.core.web.command.AbstractCommand;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Admin on 16/7/2017.
 */
public class RequestUtil {
	public static void initSearchBean(HttpServletRequest request, AbstractCommand bean) {
		if (bean != null) {
			String sortExpression = request.getParameter(
					new ParamEncoder(bean.getTableId()).encodeParameterName(TableTagParameters.PARAMETER_SORT));
			String sortDirection = request.getParameter(
					new ParamEncoder(bean.getTableId()).encodeParameterName(TableTagParameters.PARAMETER_ORDER));
			String pageStr = request.getParameter(
					new ParamEncoder(bean.getTableId()).encodeParameterName(TableTagParameters.PARAMETER_PAGE));

			Integer page = 1;
			if (StringUtils.isNotBlank(pageStr)) {
				try {
					page = Integer.valueOf(pageStr);
				} catch (Exception e) {
					// ignore
				}
			}
			bean.setPage(page);
			bean.setSortDirection(sortDirection);
			bean.setSortExpression(sortExpression);
			bean.setFirstItem((bean.getPage() - 1) * bean.getMaxPageItems());
		}
	}
}