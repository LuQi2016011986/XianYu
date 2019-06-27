package entity;

import java.util.List;

/**
 * 封装分页相关的数据
 *
 * @author Administrator
 *
 */
public class Page {
	private int pageCode;// 当前页码
	private int totalPage;// 总页数
	private List<Goods> datas;
	private List<Message> datas2;
	private int totalRecord;// 总记录数
	private int pageSize = 10;// 每一页记录数 固定值

	public Page() {
	}

	public Page(int pageCode, int totalRecord) {
		this.pageCode = pageCode;
		this.totalRecord = totalRecord;
		this.pageSize = 10;
	}

	public int getPageCode() {
		return pageCode;
	}

	public void setPageCode(int pageCode) {
		this.pageCode = pageCode;
	}

	public int getTotalPage() {
		int totalPage = this.totalRecord / this.pageSize;
		if (this.totalRecord % this.pageSize == 0) {
			return totalPage;
		} else {
			return totalPage + 1;
		}
	}

	public List<Goods> getDatas() {
		return datas;
	}

	public void setDatas(List<Goods> datas) {
		this.datas = datas;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public List<Message> getDatas2() {
		return datas2;
	}

	public void setDatas2(List<Message> datas2) {
		this.datas2 = datas2;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
