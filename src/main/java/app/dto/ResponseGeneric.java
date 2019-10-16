package app.dto;

/**
 * Description goes here.
 *
 * @author patrick.kwan
 * @version 0.1
 * @since 15/10/2019
 */
import java.io.Serializable;
import java.util.Date;

public class ResponseGeneric implements Serializable {
    private Date timestamp;
    private int httpStatus;
    private String path;
    private transient Object detail;

    public ResponseGeneric(Date timestamp, int httpStatus, String path, Object detail) {
        this.timestamp = timestamp;
        this.httpStatus = httpStatus;
        this.path = path;
        this.detail = detail;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getHttpStatus() {
        return this.httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Object getDetail() {
        return this.detail;
    }

    public void setDetail(Object detail) {
        this.detail = detail;
    }

    private ResponseGeneric(ResponseGeneric.Builder builder) {
        this.timestamp = builder.timestamp;
        this.httpStatus = builder.httpStatus;
        this.path = builder.path;
        this.detail = builder.detail;
    }

    public String toString() {
        return "ResponseGeneric{timestamp=" + this.timestamp + ", httpStatus=" + this.httpStatus + ", path='" + this.path + '\'' + ", detail=" + this.detail + '}';
    }

    public static class Builder {
        private Date timestamp;
        private int httpStatus;
        private String path;
        private Object detail;

        public Builder() {
        }

        public ResponseGeneric.Builder withTimestamp(Date timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public ResponseGeneric.Builder withHttpStatus(int httpStatus) {
            this.httpStatus = httpStatus;
            return this;
        }

        public ResponseGeneric.Builder withPath(String path) {
            this.path = path;
            return this;
        }

        public ResponseGeneric.Builder withDetail(Object detail) {
            this.detail = detail;
            return this;
        }

        public ResponseGeneric build() {
            return new ResponseGeneric(this);
        }
    }
}
