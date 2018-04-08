package com.ljs.demo.common.constant;

import java.util.UUID;

public class GetUuid {

    public GetUuid() {
    }

    public static final String uuid = UUID.randomUUID().toString().replaceAll("-", "");
}
