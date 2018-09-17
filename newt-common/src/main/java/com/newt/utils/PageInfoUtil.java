package com.newt.utils;

import com.github.pagehelper.PageInfo;
import org.apache.poi.ss.formula.functions.T;

public class PageInfoUtil {

	public static PageInfo copy(PageInfo source, PageInfo target) {
		PageInfo<T> info = target;
		PageInfo pinfo = source;	
		info.setPageNum(pinfo.getPageNum());
		info.setPageSize(pinfo.getPageSize());
		info.setSize(pinfo.getSize());
		info.setStartRow(pinfo.getStartRow());
		info.setEndRow(pinfo.getEndRow());
		info.setTotal(pinfo.getTotal());
		info.setPages(pinfo.getPages());
		info.setPrePage(pinfo.getPrePage());
		info.setNextPage(pinfo.getNextPage());
		info.setIsFirstPage(pinfo.isIsFirstPage());
		info.setIsLastPage(pinfo.isIsLastPage());
		info.setHasPreviousPage(pinfo.isHasPreviousPage());
		info.setHasNextPage(pinfo.isHasNextPage());
		info.setNavigatePages(pinfo.getNavigatePages());
		info.setNavigateFirstPage(pinfo.getNavigateFirstPage());
		info.setNavigateLastPage(pinfo.getNavigateLastPage());
		info.setNavigatepageNums(pinfo.getNavigatepageNums());
		return info;
	}
}
