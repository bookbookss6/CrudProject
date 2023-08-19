package com.spring.simple.utils;

import com.spring.simple.page.vo.PageVO;

public class PageVOUtils {
	
	//home.jsp 에 있는 page가 어딘지에 따라 offset 결정됨
	public static PageVO initByCurrentPage(int currentPage)
	{
		PageVO page = new PageVO();
		
		int offset = 0;
		if(currentPage == 1)
		{
			offset = 0;
		}
		else
		{
			offset = 5 * ( currentPage - 1 );
		}
		
		page.setMaxSize(5);
		page.setOffset(offset);
		
		return page;
	}
}
