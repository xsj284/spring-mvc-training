package com.xsj284.training.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xsj284
 * created date: <p>2022/5/26<p>
 */
@Data
public class R<T> {
    private int code;
    private String msg;
    private T data;
    private Map<String, Object> map = new HashMap<>();

    public static <T> R<T> success(T object) {
        R<T> r = new R<>();
        r.data = object;
        r.code = 1;
        return r;
    }

    public static <T> R<T> error(String msg) {
        R<T> r = new R<>();
        r.msg = msg;
        r.code = 0;
        return r;
    }

    public R<T> add(String key, Object value) {
        this.map.put(key, value);
        return this;
    }
}
