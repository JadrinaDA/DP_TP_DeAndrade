package com.company;

public class PolicyCheckRequestHandler extends RequestHandler{

    @Override
    public void handleRequest(WebRequest request) {
        User user = request.getLoggedUser();
        String path = request.getPath();
        boolean can_access = (path == "/home") || (path == "/dashboard" && user.isAdmin());
        if (can_access)
        {
            this.successorHandleRequest(request);
        }
        else {
            System.out.println("Status 403 : user is not authorized to access this content");
        }
    }
}
