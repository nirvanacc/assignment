package com.advan.utils.result;

/**
 * Created by haiming.wang on 2018/9/18.
 */
public class ResultUtil {

    /**成功且带数据**/
    public static Result success(Object object){
        Result result = new Result();
        result.setCode(200);
        result.setMsg("请求成功");
        result.setData(object);
        return result;
    }

    /**成功但无需数据**/
    public static Result success(){
        Result result = new Result();
        result.setCode(200);
        result.setMsg("请求成功");
        return result;
    }

    /**失败，返回状态码及错误信息**/
    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

}
