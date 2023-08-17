package com.workToolKit.github.example.util.exception;

import com.workToolKit.github.example.util.result.ICodeMsg;

/**
 * @author jiashuai.xujs
 * @date 2021/8/20 13:47
 */
public class BusinessException extends RuntimeException {

    private ICodeMsg codeMsg;

    public BusinessException(ICodeMsg codeMsg){
        super("error code:" + codeMsg.getErrcode() +", error msg:" + codeMsg.getErrmsg());
        this.codeMsg = codeMsg;
    }

    public BusinessException(String message){
        super(message);
    }

    public ICodeMsg getCodeMsg(){
        return this.codeMsg;
    }
}
