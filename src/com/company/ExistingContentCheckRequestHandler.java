package com.company;
/*
* Implement a ExistingContentCheckRequestHandler which handles a WebRequest, and checks
 *        if the requested content (the path) is valid. If not, it produces the response for the webserver (404)
 *        otherwise it passes the request to the next handler
* */


public class ExistingContentCheckRequestHandler extends RequestHandler{

    @Override
    public void handleRequest(WebRequest request) {
        if (request.getPath() == "/dashboard" || request.getPath() == "/home")
        {
            this.successorHandleRequest(request);
        }
        else {
            System.out.println("Status 404 : Page missing");
        }
    }
}
