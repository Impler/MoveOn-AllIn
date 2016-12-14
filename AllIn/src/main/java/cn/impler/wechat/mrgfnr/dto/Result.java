package cn.impler.wechat.mrgfnr.dto;

import java.io.Serializable;

import net.sf.json.JSONObject;

public class Result implements Serializable{

	private static final long serialVersionUID = 5895691531475133249L;
	public static final String RESULT_STATUS_CODE_KEY = "status";
	public static final String RESULT_KEY = "result";
	public static final String RESULT_MESSAGE = "msg";
	
	// result status 
	private ResultStatus status;
	// result object
	private Object result;
	// result message
	private String message;
	
	public Result() {
		super();
	}

	public Result(ResultStatus status) {
		this(status, null, null);
	}

	public Result(ResultStatus status, Object result) {
		this(status, result, null);
	}

	public Result(ResultStatus status, Object result, String message) {
		this();
		this.status = status;
		this.result = result;
		this.message = message;
	}
	
	public ResultStatus getStatus() {
		return status;
	}

	public void setStatus(ResultStatus status) {
		this.status = status;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public JSONObject toJson(){
		JSONObject rs = new JSONObject();
		rs.put(RESULT_STATUS_CODE_KEY, null == this.status? "" : this.status.getCode());
		rs.put(RESULT_KEY, null == this.result? "" : this.result);
		rs.put(RESULT_MESSAGE, null == this.message? "" : this.message);
		return rs;
	}
	
	public static enum ResultStatus{
		
		SUCCESS("0000"), Failure("9999");
		
		private String code;

		private ResultStatus(String code) {
			this.code = code;
		}
		
		public String getCode(){
			return this.code;
		}
	}
	
	public static Result newSuccessResult(){
		return new Result(ResultStatus.SUCCESS);
	}
	
	public static Result newSuccessResult(Object result){
		return new Result(ResultStatus.SUCCESS, result);
	}
	
	public static Result newResult(ResultStatus status) {
		return new Result(status);
	}

	public static Result newResult(ResultStatus status, Object result) {
		return new Result(status, result);
	}

	public static Result newResult(ResultStatus status, Object result, String message) {
		return new Result(status, result, message);
	}
}

