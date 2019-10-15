package app.en;

/**
 * Description goes here.
 *
 * @author patrick.kwan
 * @version 0.1
 * @since 15/10/2019
 */
public enum ENUM_STATUS_CODE {
    SUCCESS,
    CANCELLED,
    FAILED,
    APPROVED,
    CANCELLED_AUTOMATIC,
    CANCELLED_MANUAL,
    ACTIVE,
    IN_PROGRESS,
    SENT,
    IN_PROCESS,
    FINISHED;

    private ENUM_STATUS_CODE() {
    }
}