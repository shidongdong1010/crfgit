package org.dd.activiti.util;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * 分页工具
 *
 * @author henryyan
 */
public class PageUtil {

    public static int PAGE_SIZE = 15;

    public static int[] init(Page<?> page, HttpServletRequest request) {
        int pageNumber = Integer.parseInt(StringUtils.defaultIfBlank(request.getParameter("page"), "1"));
        page.setPageNo(pageNumber);
        int pageSize = Integer.parseInt(StringUtils.defaultIfBlank(request.getParameter("rows"), String.valueOf(PAGE_SIZE)));
        page.setPageSize(pageSize);
        int firstResult = page.getFirst() - 1;
        int maxResults = page.getPageSize();
        return new int[]{firstResult, maxResults};
    }
    
    public static String getPageSql(String sql, Integer firstResult, Integer maxResults){
    	StringBuilder pageSql = new StringBuilder();
    	pageSql.append("SELECT * ");
    	pageSql.append(" FROM (SELECT tt.*, ROWNUM ro");
    	pageSql.append("  FROM (").append(sql).append(") tt");
    	pageSql.append(" WHERE ROWNUM <= ").append(maxResults).append(")");
    	pageSql.append("WHERE ro > ").append(firstResult);
    	
    	return pageSql.toString();
    }
}
