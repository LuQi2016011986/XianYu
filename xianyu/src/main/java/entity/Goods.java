package entity;

/** 
 *  商品类
 */   
public class Goods {
	public String goodsId;
	public String userName;
	public String itemName;
	public int ifNew;// 0全新
	public String barterType;// 0是都可以，1是以物换钱，2是以物换物
	public String barter;
	public int ifBargain;// 0是可以，1是不可以
	public String cateogory;
	public String itemDescription;
	public String pictureAddress;
	public int state;// 0是正在卖，1是正在交易，2是交易已经完成
	public String date;

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getIfNew() {
		return ifNew;
	}

	public void setIfNew(int ifNew) {
		this.ifNew = ifNew;
	}

	public String getBarterType() {
		return barterType;
	}

	public void setBarterType(String barterType) {
		this.barterType = barterType;
	}

	public String getBarter() {
		return barter;
	}

	public void setBarter(String barter) {
		this.barter = barter;
	}

	public int getIfBargain() {
		return ifBargain;
	}

	public void setIfBargain(int ifBargain) {
		this.ifBargain = ifBargain;
	}

	public String getCateogory() {
		return cateogory;
	}

	public void setCateogory(String cateogory) {
		this.cateogory = cateogory;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public String getPictureAddress() {
		return pictureAddress;
	}

	public void setPictureAddress(String pictureAddress) {
		this.pictureAddress = pictureAddress;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
