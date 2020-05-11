package com.system.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName TestLogBack
 * @Description TODO
 * @Author wk
 * @Date 2020/5/8 0008 15:32
 * @Version 1.0
 */
public class TestLogBack {
    private static Logger log = LoggerFactory.getLogger(TestLogBack.class);
    public static void main(String[] args) {
        log.trace("这是TRACE");
        log.debug("这是DEBUG");
        log.info("这是info");
        log.warn("这是warn");
        log.error("这是error(");
    }
}
