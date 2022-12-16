package com.company;

public abstract class RequestHandler {

    protected RequestHandler successor;

    public abstract void handleRequest(WebRequest request);

    public void setSuccessor(RequestHandler successor) {
        this.successor = successor;
    }

    protected void successorHandleRequest(WebRequest request) {
        if (this.successor != null) {
            this.successor.handleRequest(request);
        }
    }
}
