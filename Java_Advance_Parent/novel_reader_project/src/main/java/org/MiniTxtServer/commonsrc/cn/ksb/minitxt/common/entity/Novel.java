package cn.ksb.minitxt.common.entity;

public class Novel implements java.io.Serializable {

	private static final long serialVersionUID = 5037553123163544175L;
	private String name;
	private String author;
	private String desc;
	transient private String filename;
	private Classification cls;

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Classification getCls() {
		return cls;
	}

	public void setCls(Classification cls) {
		this.cls = cls;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
