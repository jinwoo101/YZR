package net.nigne.yzrproject.domain;

public class PageMaker {
	
	long totalArticles = 175;
	int startPage;
	int endPage;
	
	int pagePerBlock = 10;
	
	boolean next = false;
	boolean prev = false;
	
	Criteria criteria;
	
	public PageMaker(Criteria cri, long replyTotal){
		criteria = cri;
		totalArticles = replyTotal;
		process();
	}
	
	public long getTotalArticles() {
		return totalArticles;
	}

	public void setTotalArticles(int totalArticles) {
		this.totalArticles = totalArticles;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getPagePerBlock() {
		return pagePerBlock;
	}

	public void setPagePerBlock(int pagePerBlock) {
		this.pagePerBlock = pagePerBlock;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public Criteria getCriteria() {
		return criteria;
	}

	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}

	private void process(){
		// ��ü ����������
		int totalPages = (int)Math.ceil(totalArticles / (double)pagePerBlock);
		
		// ��û�� ������
		int currentPage = criteria.getPage(); // 11
		
		// ������ ��ȣ�� ������ ����
		endPage = (int)(Math.ceil(currentPage / (double)pagePerBlock) * pagePerBlock);	// 10 , 20(totlaPages)
		
		// ������ ��ȣ�� ���۵Ǵ� ����
		startPage = endPage - pagePerBlock + 1;	// 1 , 11 , 21 , 31
		
		if(endPage > totalPages){
			endPage = totalPages;
		}
		
		// ���� ������ ��ư ����
		if(startPage > 1){
			prev = true;
		}
		
		// ���� ������ ��ư ����
		if(endPage < totalPages){
			next = true;
		}
		
	}
}
