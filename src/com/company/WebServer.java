package com.company;
/*
Modify WebServer, it should reference the first handler of the chain of handlers,
 *        and call the chain in its method getRequest().
 *        You can create the instances of handlers and chain them in your Main, then give the first handler
 *        of the chain to the WebServer constructor

 Modify the WebServer so that it implements the WebRequestObservable interface.
 *        We should be able to register observers on the web server, and any web request made
 *        to the web server should notify all the registered observers with the WebRequest object.
 */

import java.util.ArrayList;

public class WebServer implements WebRequestObservable{

    private ArrayList<WebRequestObserver> observers = new ArrayList();
    public RequestHandler first_handler;

    public WebServer(RequestHandler first_handler)
    {
        this.first_handler = first_handler;
    }
    public void getRequest(WebRequest request) {
        this.first_handler.handleRequest(request);
        notifyObservers(request);
    }


    @Override
    public void attach(WebRequestObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void detach(WebRequestObserver observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers(WebRequest webRequest) {
        for (WebRequestObserver observer: this.observers)
        {
            observer.update(webRequest);
        }
    }
}
