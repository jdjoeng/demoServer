package com.rest.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CommonResult {

    @ApiModelProperty(value = "응답 코드 번호")
    private String code;

    @ApiModelProperty(value = "응답 메시지")
    private String msg;

}
