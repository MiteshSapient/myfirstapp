package controllers;

import java.util.ArrayList;
import java.util.Arrays;

import ch.qos.logback.core.joran.action.Action;
import models.User;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.action;
import views.html.about;


/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result printTable() {
    	return ok();
    }
    
    /*public Result helloAction() {
    	return ok(action.render(new ArrayList<User>().add(new User("f", "s", "d", "g"))));
		
    }*/
    
    public Result helloAbout() {
    	return ok(about.render("anotherMessage"));
    }



}
    