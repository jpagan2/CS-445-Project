package com.example.REST_server;

public class Reports {
	private String[] allReports;
	private long rid;
	private long pid;
	private String name;
	
	public Reports(String[] allReports) {
		this.allReports = allReports;
	}

	public String[] getAllReports() {
		return allReports;
	}
	public long getRid() {
		return rid;
	}
	public long getPid() {
		return pid;
	}
	public String getName() {
		return name;
	}
}
