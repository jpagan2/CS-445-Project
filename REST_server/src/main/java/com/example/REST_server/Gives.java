package com.example.REST_server;

public class Gives {
	private final String uid;
	private final String gid;
	private String type;
	private String description;
	private String start_date;
	private String end_date;
	private int[] extra_zip;
	private boolean is_active;
	private String date_created;
	
	public Gives(String uid, String gid, String type, String description, String start_date, String end_date, int[] extra_zip, boolean is_active, String date_created) {
		this.uid = uid;
		this.gid = gid;
		this.type = type;
		this.description = description;
		this.start_date = start_date;
		this.end_date = end_date;
		this.extra_zip = extra_zip;
		this.is_active = is_active;
		this.date_created = date_created;
	}

	
	public String getUid() {
		return uid;
	}
	public String getAid() {
		return gid;
	}
	public String getType() {
		return type;
	}
	public String getDescription() {
		return description;
	}
	public String getStart_date() {
		return start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public int[] getExtra_zip() {
		return extra_zip;
	}
	public boolean getIs_active() {
		return is_active;
	}
	public String getDate_created() {
		return date_created;
	}
}
