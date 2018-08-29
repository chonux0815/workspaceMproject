package mrp.web.vo;

public class PayList {
   private int l_num;      //PK
   private String l_name;  //유저이름
   private String l_kind;  //상품이름(=종류)
   private int l_point;    //포인트
   private String l_qty;      //수량

   
   public int getL_num() {
	return l_num;
}
public void setL_num(int l_num) {
	this.l_num = l_num;
}
public String getL_name() {
	return l_name;
}
public void setL_name(String l_name) {
	this.l_name = l_name;
}
public String getL_kind() {
	return l_kind;
}
public void setL_kind(String l_kind) {
	this.l_kind = l_kind;
}
public int getL_point() {
	return l_point;
}
public void setL_point(int l_point) {
	this.l_point = l_point;
}
public String getL_qty() {
	return l_qty;
}
public void setL_qty(String l_qty) {
	this.l_qty = l_qty;
}
}
