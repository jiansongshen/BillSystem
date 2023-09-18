import java.util.Date;

/*
 * Author: Jiansong Shen
 * Version: 1.0
 */
public class Bill implements OutcomeCase{
    private String date;
    private double outcome;
    private String reason;

    public Bill(double outcome, String reason) {
        this.outcome = outcome;
        this.reason = reason;
    }
}
