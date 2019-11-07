package app.constant;

public enum StatusConstant {
    PROCESSED("processed"),APPROVED("approved"),REJECTED("rejected"),CANCELED("canceled"),SUCCESS("success");



    private String message;

    StatusConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
