package org.mcrest.application.resources;

/**
 * Created by frank on 2015/3/24.
 */
public class Result {
    private String result;
    private String message;
    public Result(String result,String message){
        this.result = result;
        this.message = message;
    }
    public Result(String result){
        this.result = result;
        this.message = null;
    }

    public String getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }
}
