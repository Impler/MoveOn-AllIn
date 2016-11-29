package cn.impler.wechat.mrgfnr.domain;

import java.util.Date;

import cn.impler.wechat.mrgfnr.dmo.MrgFnrEventType;

public class MrgFnrEvent {
	// serial number
	private int id;
	// the user id
	private String userId;
	// event name
	private String name;
	// event type
	private MrgFnrEventType type;
	// date of the event
	private Date date;
	// the costs
	private float fee;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MrgFnrEventType getType() {
		return type;
	}

	public void setType(MrgFnrEventType type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getFee() {
		return fee;
	}

	public void setFee(float fee) {
		this.fee = fee;
	}

	@Override
	public String toString() {
		return "MrgFnrEvent [id=" + id + ", userId=" + userId + ", name="
				+ name + ", type=" + type + ", date=" + date + ", fee=" + fee
				+ "]";
	}

}
