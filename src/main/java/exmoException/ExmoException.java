package exmoException;

public class ExmoException extends Exception {

    public ExmoException() {
        super("[ERROR] - authentication required. INFO:https://exmo.me/ru/api#/authenticated_api");
    }
}
