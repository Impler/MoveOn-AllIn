package cn.impler.wechat.mrgfnr.dto;

import java.io.Serializable;

import cn.impler.framework.mybatis.dao.dto.Pagination;
import net.sf.json.JSONObject;

public class Result implements Serializable{

	private static final long serialVersionUID = 5895691531475133249L;
	public static final String RESULT_CODE_KEY = "code";
	public static final String RESULT_DATA_KEY = "data";
	public static final String RESULT_MESSAGE_KEY = "message";
	public static final String RESULT_PAGE_KEY = "page";
	
	// data code 
	private ResultCode code;
	// data object
	private Object data;
	// data message
	private String message;
	// pagination info
	private Pagination page;
	
	public Result() {
		super();
	}

	public Result(ResultCode code) {
		this(code, null, null, null);
	}

	public Result(ResultCode code, Object data) {
		this(code, data, null, null);
	}
	
	public Result(ResultCode code, Object data, Pagination page) {
		this(code, data, page, null);
	}

	public Result(ResultCode code, Object data, Pagination page, String message) {
		this();
		this.code = code;
		this.data = data;
		this.page = page;
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
	
	public Pagination getPage() {
		return page;
	}

	public void setPage(Pagination page) {
		this.page = page;
	}

	public JSONObject toJson(){
		JSONObject rs = new JSONObject();
		rs.put(RESULT_CODE_KEY, null == this.code? "" : this.code.getCode());
		rs.put(RESULT_DATA_KEY, null == this.data? "" : this.data);
		rs.put(RESULT_MESSAGE_KEY, null == this.message? "" : this.message);
		if(null != this.page){
			rs.put(RESULT_PAGE_KEY, this.page);
		}
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
	
	public static Result newSuccessResult(Object data, Pagination page){
		return new Result(ResultCode.SUCCESS, data, page);
	}
	public static Result newResult(ResultCode code) {
		return new Result(code);
	}

	public static Result newResult(ResultCode code, Object data) {
		return new Result(code, data);
	}

	public static Result newResult(ResultCode code, Object data, String message) {
		return new Result(code, data, null, message);
	}
	
	public static Result newResult(ResultCode code, Object data, Pagination page, String message) {
		return new Result(code, data, page, message);
	}
}

