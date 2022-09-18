package com.dong.vote.demo.result;

import java.io.Serializable;

/**
 * @author: dongxiaohua
 * @date: 2022-09-18 14:43:24
 */
public class ServerResponse<T> implements Serializable {
  private static final long serialVersionUID = -5779099698619126715L;

  private int code;

  private String msg;

  private T data;

  public ServerResponse(){}

  public ServerResponse(int code,String msg){
    this.code = code;
    this.msg = msg;
  }

  public static <T> ServerResponse<T> createBySuccess(int code,String msg){
    return new ServerResponse<>(code,msg);
  }
}
