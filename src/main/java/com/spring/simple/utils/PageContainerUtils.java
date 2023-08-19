package com.spring.simple.utils;

// home.jsp 에 사용되는 클래스  <div class="page_container"> 참조
public class PageContainerUtils {

	public static int[] getLinkPages(int currentPage)
	{
		int one = 1, two =2  , three = 3 , four =4 , five = 5;
		
		if(currentPage >= 6)
		{
			if(currentPage % 5 == 1)
			{
				one = currentPage;
				two = currentPage + 1;
				three = currentPage + 2;
				four = currentPage + 3;
				five = currentPage + 4;
			}
			if(currentPage % 5 == 2)
			{
				one = currentPage - 1;
				two = currentPage;
				three = currentPage + 1;
				four = currentPage + 2;
				five = currentPage + 3;
			}
			if(currentPage % 5 == 3)
			{
				one = currentPage - 2;
				two = currentPage - 1;
				three = currentPage;
				four = currentPage + 1;
				five = currentPage + 2;
			}
			if(currentPage % 5 == 4)
			{
				one = currentPage - 3;
				two = currentPage - 2;
				three = currentPage - 1;
				four = currentPage;
				five = currentPage + 1;
			}
			if(currentPage % 5 == 0)
			{
				one = currentPage - 4;
				two = currentPage - 3;
				three = currentPage - 2;
				four = currentPage - 1;
				five = currentPage;
			}
		}
		
		return new int[] {one,two,three,four,five};
	}
}
