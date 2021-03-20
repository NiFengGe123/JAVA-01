package io.kimmking.rpcfx.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Copyright (C), 2021
 * FileName: RpcfxException
 * Author:   xzw
 * Date:     2021/3/20 23:37
 * Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RpcfxException extends Exception{

    private int code;

    private String msg;
}
