package ru.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public void printError() {
        System.out.println("Active: " + this.active);
        System.out.println("Status: " + this.status);
        System.out.println("Message: " + this.message);
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public static void main(String[] args) {
        Error defaultError = new Error();
        Error error404 = new Error(true, 404, "File not found");
        Error error501 = new Error(false, 501, "Service unavailable");
        defaultError.printError();
        error404.printError();
        error501.printError();
    }
}
