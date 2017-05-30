package com.lqh.model;

@SuppressWarnings("unused")
public class Pager {
	private int pageNow;
	private int pageSize = 8;
	private int totalPage;
	private int totalSize;			//ΩË È◊‹ È
	private boolean hasFirst;
	private boolean hasPre;
	private boolean hasNext;
	private boolean hasLast;

	public Pager(int pageNow, int totalSize) {
		this.pageNow = pageNow;
		this.totalSize = totalSize;			//19
	}

	public boolean isHasPre() {
		if (this.isHasFirst()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isHasNext() {
		if (this.isHasLast()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isHasFirst() {
		if (pageNow == 1) {
			return false;
		} else {
			return true;
		}
	}

	public boolean isHasLast() {
		if (pageNow == this.getTotalPage()) {
			return false;
		} else {
			return true;
		}
	}

	public int getTotalPage() {
		totalPage = getTotalSize() / getPageSize();
		if (totalSize % pageSize != 0) {
			totalPage++;
		}
		return totalPage;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public int getPageNow() {
		return pageNow;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setHasFirst(boolean hasFirst) {
		this.hasFirst = hasFirst;
	}
	
	public void setHasPre(boolean hasPre) {
		this.hasPre = hasPre;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

	public void setHasLast(boolean hasLast) {
		this.hasLast = hasLast;
	}

}
