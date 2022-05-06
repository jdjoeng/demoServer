package com.rest.common;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class MapResult<T> extends CommonResult {
    private T data;
}