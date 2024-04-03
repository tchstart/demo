package org.example.vo;

/**
 * @author tchstart
 * @data 2024-04-03
 */
public class ResultInfo<T> {
    private String message;
    private String code;
    private T data;


    public ResultInfo(String message, String code, T data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public static ResultInfo error(String message) {
        return new ResultInfo(message,"502",null);
    }
}
