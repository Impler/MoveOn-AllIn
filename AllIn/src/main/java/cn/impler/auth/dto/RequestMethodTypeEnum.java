package cn.impler.auth.dto;

/**
 * request method type
 * 
 * @author impler
 * @date 2017-01-18
 */
public enum RequestMethodTypeEnum {

	/* unlimited */
	ALL(":*"),
	
	/* create operation */
	POST(":read"),
	// webdav, but useful here
	MKCOL(":read"),

	/* delete operation */
	DELETE(":delete"),

	/* update operation */
	PUT(":update"),

	/* read operation */
	// get request
	GET(":read"), HEAD(":read"), OPTIONS(":read"), TRACE(":read");

	private final String action;

	private RequestMethodTypeEnum(String action) {
		this.action = action;
	}

	public String getAction() {
		return action;
	}
	
}
