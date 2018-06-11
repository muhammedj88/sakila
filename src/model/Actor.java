package model;

import java.sql.Timestamp;

public class Actor {
	
	public Actor(int id, String fname, String lname, Timestamp last_update) {
		super();
		setId(id);
		setFname(fname);
		setLname(lname);
		setLast_update(last_update);
	}
	public Actor() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Actor [id=" + id + ", fname=" + fname + ", lname=" + lname + ", last_update=" + last_update + "]";
	}
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public Timestamp getLast_update() {
		return last_update;
	}
	public void setLast_update(Timestamp last_update) {
		this.last_update = last_update;
	}
	private String fname;
	private String lname;
	private Timestamp last_update;

}
