package com.exam.entities;
/**
 * 功能的实体类
 * @author student
 *
 */
public class Module {

	private int mid;
	private String moduleCode;//功能代码
	private String moduleName;//功能名字
	private boolean checked;//是否已经拥有了这个功能

	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getModuleCode() {
		return moduleCode;
	}
	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public boolean getChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	@Override
	public int hashCode() {
		return mid;
	}
	
	@Override
	public boolean equals(Object obj) {
		Module m = (Module) obj;
		return this.mid==m.getMid();
	}
}
