package com.github.zkejid.springdemo.entities;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * {@link TextEntity} creation response.
 *
 */
public class TextEntityCreateResponse implements Serializable {
    /**
     * Result of creation call.
     */
    @NotNull
    private CallResult result;
    /**
     * Error message in the case of {@link CallResult#FAIL} result. {@code null} otherwise
     */
    private String errorDescription;
    /**
     * Result of the successful call. Contains valid {@link TextEntity} object if success.
     * Contains {@code null} otherwise.
     */
    @Valid
    private TextEntity textEntity;

    /**
     * Default constructor. Object should be filled with data after creation.
     */
    public TextEntityCreateResponse() {
    }

    /**
     * Fail-case constructor. Automatically sets {@link CallResult#FAIL} result.
     * Produces valid object.
     * @param errorDescription description of an error. Should not be null.
     */
    public TextEntityCreateResponse(String errorDescription) {
        assert errorDescription != null : "errorDescription argument is null";

        this.result = CallResult.FAIL;
        this.errorDescription = errorDescription;
        this.textEntity = null;
    }

    /**
     * Success-case constructor. Automatically sets {@link CallResult#SUCCESS} result.
     * Produces valid object.
     * @param textEntity entity produced. Should not be null.
     */
    public TextEntityCreateResponse(TextEntity textEntity) {
        assert textEntity != null : "textEntity argument is null";

        this.result = CallResult.SUCCESS;
        this.errorDescription = null;
        this.textEntity = textEntity;
    }

    public CallResult getResult() {
        return result;
    }

    public void setResult(CallResult result) {
        this.result = result;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public TextEntity getTextEntity() {
        return textEntity;
    }

    public void setTextEntity(TextEntity textEntity) {
        this.textEntity = textEntity;
    }
}
