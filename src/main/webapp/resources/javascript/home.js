function gotoCreatePost()
{
	location.href='/simple/post/create';
}
function gotoPageLeft(page,keyword)
{
	let changedPage = 1;
	
	if( page <= 5)
	{
		changedPage = 1;
	}
	else
	{
		if(page % 5 === 1)
		{	
			changedPage = parseInt(page) - 1;
		}
		else if(page % 5 === 2)
		{
			changedPage = parseInt(page) - 2;
		}
		else if(page % 5 === 3)
		{
			changedPage = parseInt(page) - 3;
		}
		else if(page % 5 === 4)
		{
			changedPage = parseInt(page) - 4;
		}
		else if(page % 5 === 0)
		{
			changedPage = parseInt(page) - 5;
		}
		else{
		
		}
	}
	
	if(typeof keyword === 'undefined')
	{
		location.href=`/simple/home?page=${changedPage}&keyword=`;
	}
	else
	{
		location.href=`/simple/home?page=${changedPage}&keyword=${keyword}`;
	}
	
}

function gotoPageRight(page,keyword)
{

	let changedPage = 1;
	
	if( page <= 5)
	{
		changedPage = 6;
	}
	else
	{
		if(page % 5 === 1)
		{	
			changedPage = parseInt(page) + 5;
		}
		else if(page % 5 === 2)
		{
			changedPage = parseInt(page) + 4;
		}
		else if(page % 5 === 3)
		{
			changedPage = parseInt(page) + 3;
		}
		else if(page % 5 === 4)
		{
			changedPage = parseInt(page) + 2;
		}
		else if(page % 5 === 0)
		{
			changedPage = parseInt(page) + 1;
		}
		else
		{
		
		}
	}
	
	if(typeof keyword === 'undefined')
	{
		location.href=`/simple/home?page=${changedPage}&keyword=`;
	}
	else
	{
		location.href=`/simple/home?page=${changedPage}&keyword=${keyword}`;
	}

}