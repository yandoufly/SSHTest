package po;

public class Option {
	
	int oid;
	
	String content;//选项内容
	
	String mark;//A B C D
	
	boolean yes;//这个选项是否是正确答案

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public boolean getYes() {
		return yes;
	}

	public void setYes(boolean yes) {
		this.yes = yes;
	}
	
	
}
