package cn.impler.wechat.mrgfnr.dto;

import java.io.Serializable;

import net.sf.json.JSONObject;

public class Result implements Serializable{

	private static final long serialVersionUID = 5895691531475133249L;
	public static final String RESULT_code_CODE_KEY = "code";
	public static final String RESULT_KEY = "data";
	public static final String RESULT_MESSAGE = "message";
	
	// data code 
	private ResultCode code;
	// data object
	private Object data;
	// data message
	private String message;
	
	public Result() {
		super();
	}

	public Result(ResultCode code) {
		this(code, null, null);
	}

	public Result(ResultCode code, Object data) {
		this(code, data, null);
	}

	public Result(ResultCode code, Object data, String message) {
		this();
		this.code = code;
		this.data = data;
		this.message = message;
	}
	
	public ResultCode getCode() {
		return code;
	}

	public void setCode(ResultCode code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public JSONObject toJson(){
		JSONObject rs = new JSONObject();
		rs.put(RESULT_code_CODE_KEY, null == this.code? "" : this.code.getCode());
		rs.put(RESULT_KEY, null == this.data? "" : this.data);
		rs.put(RESULT_MESSAGE, null == this.message? "" : this.message);
		return rs;
	}
	
	public static enum ResultCode{
		
		SUCCESS("0000"), Failure("9999");
		
		private String code;

		private ResultCode(String code) {
			this.code = code;
		}
		
		public String getCode(){
			return this.code;
		}
	}
	
	public static Result newSuccessResult(){
		return new Result(ResultCode.SUCCESS);
	}
	
	public static Result newSuccessResult(Object data){
		return new Result(ResultCode.SUCCESS, data);
	}
	
	public static Result newResult(ResultCode code) {
		return new Result(code);
	}

	public static Result newResult(ResultCode code, Object data) {
		return new Result(code, data);
	}

	public static Result newResult(ResultCode code, Object data, String message) {
		return new Result(code, data, message);
	}
}

