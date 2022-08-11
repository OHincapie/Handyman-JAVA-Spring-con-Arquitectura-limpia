package co.com.ias.handyman.infranstructure.logSystem;

import java.time.LocalDate;

public class Log {
    private final String message;
    private final String statusCode;

    public Log(String message, String statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public void logger() {
        System.out.println("Status Code: " + statusCode + " Message: "  + message + "Date: " + LocalDate.now());
    }
}
