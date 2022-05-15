package com.atguigu.gmall.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wentao.xie
 * @date 2022/1/23 20:50
 * @Verssion 1.0
 * @Desc
 */
public class Result extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public static Result build(Object o, String resultCodeEnum) {
        Result r = new Result();
        r.put("msg", resultCodeEnum);
        return r;
    }

    public <T> T getData(String key, TypeReference<T> typeReference){
        Object data = get(key);
        String s = JSON.toJSONString(data);
        T t = JSON.parseObject(s, typeReference);
        return t;

    }


    public <T> T getData(TypeReference<T> typeReference){
        Object data = get("data");
        String s = JSON.toJSONString(data);
        T t = JSON.parseObject(s, typeReference);
        return t;

    }

    public Result setData(Object data){
        put("data",data);
        return this;
    }

    public Result() {
        put("code", 0);
        put("msg", "success");
    }

    public static Result error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }

    public static Result error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }

    public static Result error(int code, String msg) {
        Result r = new Result();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static Result ok(String msg) {
        Result r = new Result();
        r.put("msg", msg);
        return r;
    }

    public static Result ok(Map<String, Object> map) {
        Result r = new Result();
        r.putAll(map);
        return r;
    }

    public static Result ok() {
        return new Result();
    }

    public static Result fail(String msg) {
        Result r = new Result();
        r.put("msg", msg);
        return r;
    }

    public  Integer getCode() {

        return (Integer) this.get("code");
    }

    public static Result ok(Object msg) {
        Result r = new Result();
        r.put("msg", msg);
        return r;
    }
}
