package com.gjing.project.mybatisplus.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author Gjing
 **/
public enum Gender implements IEnum<Integer> {
    /**
     * 性别
     */
    MAN("男", 1),
    WO_MAN("女", 2);
    private String desc;
    private int type;

    Gender(String desc, int type) {
        this.desc = desc;
        this.type = type;
    }

    @Override
    public Integer getValue() {
        return this.type;
    }

    @JsonValue
    public String getDesc() {
        return this.desc;
    }
}
