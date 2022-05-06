package com.rest.common;

import java.util.List;

import lombok.Data;

@Data
public class ListResult<T> extends CommonResult {
	private int count;
    private List<T> data;
}