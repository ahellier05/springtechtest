package interview.hellier.heroku.SpringREST.Error;

import java.util.Date;

public class Error {

    private Date date;
    private String message;
    private String description;

    public Error(Date date, String message, String description) {
        this.date = date;
        this.message = message;
        this.description = description;
    }
}
