package com.white.enums;

import java.io.Serializable;

/**
 * 常用Enum
 *
 * @author: White
 * @date: 2018/6/12
 */
public abstract class CommonEnums implements Serializable {

    public enum DATA_STATUS {
        /** 有效 */
        VALID,
        /** 无效 */
        INVALID;
    }

    public enum IF {
        /** 是 */
        Y,
        /** 否 */
        N;
    }
}
