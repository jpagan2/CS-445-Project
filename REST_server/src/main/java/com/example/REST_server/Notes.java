package com.example.REST_server;

public class Notes {
	private final long uid;
	private final long source_id;
	private String[] conversations;
	private final long with_uid;
	private String[] notes;
	private long nid;
	private String to_type;
	private long to_user_id;
	private long to_id;
	private String description;
	private String date_created;
	
	public Notes(long uid, long source_id, String[] conversations, long with_uid, String[] notes, long nid, String to_type, long to_user_id, long to_id, String description, String date_created) {
		this.uid = uid;
		this.source_id = source_id;
		this.conversations = conversations;
		this.with_uid = with_uid;
		this.notes = notes;
		this.nid = nid;
		this.to_type = to_type;
		this.to_user_id = to_user_id;
		this.to_id = to_id;
		this.description = description;
		this.date_created = date_created;
	}

	
	public long getUid() {
		return uid;
	}
	public long getSource_id() {
		return source_id;
	}
	public String[] getConversations() {
		return conversations;
	}
	public long getWith_uid() {
		return with_uid;
	}
	public String[] getNotes() {
		return notes;
	}
	public long getNid() {
		return nid;
	}
	public String getTo_type() {
		return to_type;
	}
	public long getTo_user_id() {
		return to_user_id;
	}
	public long getToid() {
		return to_id;
	}
	public String getDescription() {
		return description;
	}
	public String getDate_created() {
		return date_created;
	}
}
