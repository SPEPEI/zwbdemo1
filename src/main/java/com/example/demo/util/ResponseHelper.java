package com.example.demo.util;

import com.example.demo.entity.JsonResult;
import com.example.demo.enums.ErrCode;

public class ResponseHelper {

    private ResponseHelper() {}

    private static final JsonResult<Object> OK = new JsonResult<>(ErrCode.OK);

    public static JsonResult<Object> ResponseOK() {
        return OK;
    }

}
