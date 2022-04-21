package com.example.REST_server;

public class Notes {
	private String uid;
	private String source_id;
	private String[] conversations;
	private String with_uid;
	private String[] notes;
	private String nid;
	private String to_type;
	private String to_user_id;
	private String to_id;
	private String description;
	private String date_created;
	
	public Notes (String uid, String nid, String to_type, String to_user_id, String to_id, String description, String date_created) {
		this.uid = uid;
		this.nid = nid;
		this.to_type = to_type;
		this.to_user_id = to_user_id;
		this.to_id = to_id;
		this.description = description;
		this.date_created = date_created;
	}

	
	public String getUid() {
		return uid;
	}
	public String getSource_id() {
		return source_id;
	}
	public String[] getConversations() {
		return conversations;
	}
	public String getWith_uid() {
		return with_uid;
	}
	public String[] getNotes() {
		return notes;
	}
	public String getNid() {
		return nid;
	}
	public String getTo_type() {
		return to_type;
	}
	public String getTo_user_id() {
		return to_user_id;
	}
	public String getToid() {
		return to_id;
	}
	public String getDescription() {
		return description;
	}
	public String getDate_created() {
		return date_created;
	}
}
