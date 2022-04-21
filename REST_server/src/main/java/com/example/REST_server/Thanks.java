package com.example.REST_server;

public class Thanks {
	private String uid;
	private String tid;
	private String thank_to;
	private String description;
	private String date_created;
	
	public Thanks(String uid, String tid, String thank_to, String description, String date_created) {
		this.uid = uid;
		this.tid = tid;
		this.thank_to = thank_to;
		this.description = description;
		this.date_created = date_created;

	}

	public String getUid() {
		return uid;
	}
	public String getTid() {
		return tid;
	}
	public String getThank_to() {
		return thank_to;
	}
	public String getDescription() {
		return description;
	}
	public String getDate_created() {
		return date_created;
	}
}
