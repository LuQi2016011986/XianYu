package entity;

/** 
 *  订单类
 */   
public class Order {
    public String orderId;
    public int state;
    public String goodId;
    public String purchaser;
    public String seller;
    public int level;
    public String comment;
    public String date;

    public String getOrderId(){
        return orderId;
    }

    public void setOrderId(String orderId){
        this.orderId = orderId;
    }

    public int getState(){
        return state;
    }

    public void setState(int state){
        this.state = state;
    }

    public String getGoodId(){
        return goodId;
    }

    public void setGoodId(String goodId){
        this.goodId = goodId;
    }

    public String getPurchaser(){
        return purchaser;
    }

    public void setPurchaser(String purchaser){
        this.purchaser = purchaser;
    }

    public String getSeller(){
        return seller;
    }

    public void setSeller(String seller){
        this.seller = seller;
    }

    public int getLevel(){
        return level;
    }

    public void setLevel(int level){
        this.level = level;
    }

    public String getComment(){
        return comment;
    }

    public void setComment(String comment){
        this.comment = comment;
    }

    public String getDate(){
        return date;
    }

    public void setDate(String date){
        this.date = date;
    }
}
