package controllers;

import javax.inject.Inject;

import play.data.Form;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.user;
import views.html.action;
import views.html.helper.form;
import models.User;


public class Application extends Controller{

	 private final Form<User> myForm ;
	
	FormFactory formFactory;
	
	@Inject
	Application(FormFactory formFactory){
		this.formFactory = formFactory;
		this.myForm = this.formFactory.form(User.class);
	}
	
		
	public Result index() {
		return ok(index.render());
	}
		
	public Result handleForms() {
		 DynamicForm requestData = formFactory.form().bindFromRequest();
		 String username = requestData.get("username");
		 return ok(views.html.handleForms.render(username));
	}
	
	public Result submit() {
		Form<User> newUser = formFactory.form(User.class).bindFromRequest();
		if(newUser.hasErrors()) {
			return badRequest(user.render(myForm));
		}
		newUser.get().save();
		flash("Username : " + newUser.get().firstName+" has been created");
		return ok(action.render(User.getAllUser()));
	}
	
	public Result blank() {
		return ok(user.render(myForm));
	}
	

	
}
