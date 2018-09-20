package com.newt.pojo;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * @Description: 统一API响应结果封装
 * @author newt
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Result {
	/**
	 * 状态码
	 */
	private int code;
	/**
	 * 封装返回消息
	 */
	private String message;
	/**
	 * 封装状态
	 */
	private boolean success;
	/**
	 * 封装数据
	 */
	private Object data;
	/**
	 * 封装附加数据
	 */
	private Object attachData;

}
