package org.mcrest.application.controller;


import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 * Created by frank on 2015/3/3.
 */
public class MainController extends ServerResource {
    @Get
    public String toString() {
        return "Hello MCRest.";
    }
}
