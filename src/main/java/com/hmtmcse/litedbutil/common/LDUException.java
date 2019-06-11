package com.hmtmcse.litedbutil.common;

/**
 * Created by Touhid Mia on 11/09/2014.
 */
public class LDUException extends Exception {

    public LDUException(){
        super("Lite DB Util Exception");
    }

    public LDUException(String message){
        super(message);
    }
}
