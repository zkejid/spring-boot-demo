package com.github.zkejid.springdemo.entities;

import java.io.Serializable;

/**
 * Web method call result
 */
public enum CallResult implements Serializable {
    /**
     * In the case, the call is determined as successful
     */
    SUCCESS,
    /**
     * In the case, the call is determined as failed
     */
    FAIL
}
