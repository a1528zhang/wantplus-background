package com.plus.want.model;

/**
 * 包装查询结果模板，使用泛型接收
 * @author a1528zhang
 * @param <T>
 */
public class ResultTemplet<T> {
	private String exceptionName;
	private Integer state;
	private T data;
	
	public String getExceptionName() {
		return exceptionName;
	}
	public void setExceptionName(String exceptionName) {
		this.exceptionName = exceptionName;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
