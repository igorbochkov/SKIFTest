package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import repository.inmemory.InMemoryUserRepository;
import service.UserService;

import javax.inject.Inject;

public class HomeController extends Controller {
    @Inject
    UserService userService;

    public Result login() {
        return ok(views.html.login.render());
    }

    public Result index(Integer id) {
        return ok(views.html.index.render(userService.get(id)));
    }

}
