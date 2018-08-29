package mrp.web.vo;

import java.util.Date;

public class User {
	private String u_id;
	private String u_passwd;
	private String u_name;
	private String u_email;
	private int u_gender;
	private String u_day;
	private int u_division;
	private String u_jang;
	private String u_gume;
	private int u_point;
	private String u_hint;

	public String getU_hint() {
		return u_hint;
	}

	public void setU_hint(String u_hint) {
		this.u_hint = u_hint;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getU_passwd() {
		return u_passwd;
	}

	public void setU_passwd(String u_pw) {
		this.u_passwd = u_pw;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_nicname) {
		this.u_name = u_nicname;
	}

	public String getU_email() {
		return u_email;
	}

	public void setU_email(String u_email) {
		this.u_email = u_email;
	}

	public int getU_gender() {
		return u_gender;
	}

	public void setU_gender(int u_gender) {
		this.u_gender = u_gender;
	}

	public String getU_day() {
		return u_day;
	}

	public void setU_day(String string) {
		this.u_day = string;
	}

	public int getU_division() {
		return u_division;
	}

	public void setU_division(int u_division) {
		this.u_division = u_division;
	}

	public String getU_jang() {
		return u_jang;
	}

	public void setU_jang(String u_jang) {
		this.u_jang = u_jang;
	}

	public String getU_gume() {
		return u_gume;
	}

	public void setU_gume(String u_gume) {
		this.u_gume = u_gume;
	}

	public int getU_point() {
		return u_point;
	}

	public void setU_point(int u_point) {
		this.u_point = u_point;
	}
}
