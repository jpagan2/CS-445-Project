package com.example.REST_server;

public class Thanks {
	private long uid;
	private long tid;
	private long thank_to;
	private String description;
	private String date_created;
	
	public Thanks(long uid, long tid, long thank_to, String description, String date_created) {
		this.uid = uid;
		this.tid = tid;
		this.thank_to = thank_to;
		this.description = description;
		this.date_created = date_created;

	}

	public long getUid() {
		return uid;
	}
	public long getTid() {
		return tid;
	}
	public long getThank_to() {
		return thank_to;
	}
	public String getDescription() {
		return description;
	}
	public String getDate_created() {
		return date_created;
	}
}
