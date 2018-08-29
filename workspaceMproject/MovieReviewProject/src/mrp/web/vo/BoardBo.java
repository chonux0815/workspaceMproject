package mrp.web.vo;

public class BoardBo {
	private int d_code;
	private int d_boardcode;
	private String d_author;
	private String d_content;
	private int ref;
	private int re_step;
	private int re_level;
	
	
	public int getD_code() {
		return d_code;
	}
	public void setD_code(int d_code) {
		this.d_code = d_code;
	}
	public int getD_boardcode() {
		return d_boardcode;
	}
	public void setD_boardcode(int d_boardcode) {
		this.d_boardcode = d_boardcode;
	}
	public String getD_author() {
		return d_author;
	}
	public void setD_author(String d_author) {
		this.d_author = d_author;
	}
	public String getD_content() {
		return d_content;
	}
	public void setD_content(String d_content) {
		this.d_content = d_content;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getRe_step() {
		return re_step;
	}
	public void setRe_step(int re_step) {
		this.re_step = re_step;
	}
	public int getRe_level() {
		return re_level;
	}
	public void setRe_level(int re_level) {
		this.re_level = re_level;
	}
}
