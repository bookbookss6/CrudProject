package com.spring.simple.utils;

import com.spring.simple.page.vo.PageVO;

public class PageVOUtils {
	
	//home.jsp �� �ִ� page�� ������� ���� offset ������
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
