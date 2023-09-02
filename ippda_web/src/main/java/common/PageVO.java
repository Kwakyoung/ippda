package common;

import java.util.List;

public class PageVO {
	private String search, keyword="", viewType="list"; /*검색유형, 검색어, 보기형태*/
	private int totalList; //DB에서 조회해온 총 글 건수 
	private int pageList = 10; //페이지당 보여질 목록 수 
	private int blockPage = 10; //블럭당 보여질 페이지 수
	private int totalPage;
	private int totalBlock;
	private int curPage = 1;
	private int endList, beginList;
	
	private int curBlock;
	private int endPage, beginPage;
	private List<Object> list;// 현재페이지에서의 글 목록
	
	
	
	
	public String getSearch() {
		return search;
	}




	public void setSearch(String search) {
		this.search = search;
	}




	public String getKeyword() {
		return keyword;
	}




	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}




	public String getViewType() {
		return viewType;
	}




	public void setViewType(String viewType) {
		this.viewType = viewType;
	}




	public int getPageList() {
		return pageList;
	}




	public void setPageList(int pageList) {
		this.pageList = pageList;
	}




	public int getBlockPage() {
		return blockPage;
	}




	public void setBlockPage(int blockPage) {
		this.blockPage = blockPage;
	}




	public int getTotalPage() {
		return totalPage;
	}




	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}




	public int getTotalBlock() {
		return totalBlock;
	}




	public void setTotalBlock(int totalBlock) {
		this.totalBlock = totalBlock;
	}




	public int getCurPage() {
		return curPage;
	}




	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}




	public int getEndList() {
		return endList;
	}




	public void setEndList(int endList) {
		this.endList = endList;
	}




	public int getBeginList() {
		return beginList;
	}




	public void setBeginList(int beginList) {
		this.beginList = beginList;
	}




	public int getCurBlock() {
		return curBlock;
	}




	public void setCurBlock(int curBlock) {
		this.curBlock = curBlock;
	}




	public int getEndPage() {
		return endPage;
	}




	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}




	public int getBeginPage() {
		return beginPage;
	}




	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}




	public List<Object> getList() {
		return list;
	}




	public void setList(List<Object> list) {
		this.list = list;
	}




	public int getTotalList() {
		return totalList;
	}




	public void setTotalList(int totalList) {
		this.totalList = totalList;
		
		//총 페이지 수 : 8 페이지 = 
		totalPage = totalList / pageList ;
		if( totalList % pageList > 0) ++totalPage;
		
		//총 블록수 : 3 블록 = 32 / 10 = 2...2
		totalBlock = totalPage / blockPage;
		if( totalPage  % blockPage > 0 ) ++totalBlock;
		
		//각 페이지의 끝 목록번호 : 총 목록수 - (페이지번호-1) * 페이지당 보여질 목록수
		//각 페이지의 시작 목록번호 :  끝 목록번호 - (페이지당 보여질 목록수-1)
		endList = totalList - (curPage-1) * pageList;
		beginList = endList - (pageList-1);
		
		//블록번호 : 페이지번호 / 블록당 보여질 페이지수
		curBlock = curPage / blockPage;
		if( curPage % blockPage > 0) ++curBlock;
		
		endPage = curBlock * blockPage; 	//30
		beginPage = endPage -(blockPage-1); //21
		
		if( totalPage < endPage ) endPage = totalPage;
		
	}
}
