package com.dgrm.dto;

public class TestVO {
	
	
	private String seq, contents, reg_datetime, upd_datetime; 	

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getReg_datetime() {
		return reg_datetime;
	}

	public void setReg_datetime(String reg_datetime) {
		this.reg_datetime = reg_datetime;
	}

	public String getUpd_datetime() {
		return upd_datetime;
	}

	public void setUpd_datetime(String upd_datetime) {
		this.upd_datetime = upd_datetime;
	}

	@Override
	public String toString() {
		return "TestVO [seq=" + seq + ", contents=" + contents + ", reg_datetime=" + reg_datetime + ", upd_datetime="
				+ upd_datetime + "]";
	}

	
	
	

	
	
}
