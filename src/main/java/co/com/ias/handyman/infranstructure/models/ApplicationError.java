package co.com.ias.handyman.infranstructure.models;

import java.util.Map;

public class ApplicationError {
    private final String errorCode;
    private final String message;
    private final Map<String, String> metaData;

    public ApplicationError(String errorCode, String message, Map<String, String> metaData) {
        this.errorCode = errorCode;
        this.message = message;
        this.metaData = metaData;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

    public Map<String, String> getMetaData() {
        return metaData;
    }
}
