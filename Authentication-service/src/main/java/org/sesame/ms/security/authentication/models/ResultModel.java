package org.sesame.ms.security.authentication.models;


public class ResultModel {
    private int code;
    private String message;
    private String token;
    private UserCredentiel data;

 

    public ResultModel() {
		super();
	}


    
    public ResultModel(ResultStatus status, UserCredentiel data, String message, String token) {
        this.code = status.getCode();
        this.data = data;
        this.message = message != null ? message : status.getMessage();
        this.token=token;

    }
  
    
    public ResultModel(ResultStatus status, UserCredentiel data) {
        this.code = status.getCode();
        this.data = data;
    }

    public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public UserCredentiel getData() {
		return data;
	}


	public void setData(UserCredentiel data) {
		this.data = data;
	}


	 

    
    public static ResultModel _200( String message, UserCredentiel data,String token) {
        return new ResultModel(ResultStatus.SUCCESS,data,message,token);
    }


    public static ResultModel _403(String message, UserCredentiel data,String token) {
        return new ResultModel(ResultStatus.FORBIDDEN,  data, message,token);
    }

    public static ResultModel _404(String message, UserCredentiel data,String token) {
        return new ResultModel(ResultStatus.NOT_FOUND, data, message,token);
    }

    public static ResultModel _400(String message, UserCredentiel data,String token) {
        return new ResultModel(ResultStatus.BAD_REQUEST, data, message,token);
    }

    public static ResultModel _500(String message, UserCredentiel data,String token) {
        return new ResultModel(ResultStatus.INTERNAL_SERVER_ERROR, data, message,token);
    }

    public static ResultModel unauthorized(String message, UserCredentiel data,String token) {
        return new ResultModel(ResultStatus.UNAUTHORIZED, data, message,token);
    }



}