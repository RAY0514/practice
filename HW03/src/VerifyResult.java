public class VerifyResult {
    private Boolean isVerifySuccess;
    private String id;
    private String message;

    public Boolean getVerifySuccess() {
        return isVerifySuccess;
    }

    public void setVerifySuccess(Boolean verifySuccess) {
        isVerifySuccess = verifySuccess;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "content{" +
                "  id ='" + id + '\'' +
                ", isVerifySuccess =" + isVerifySuccess + '\'' +
                ", message =" + message +
                '}';
    }
}
