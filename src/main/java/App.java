import java.util.HashMap;
import static spark.Spark.*;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import  static spark.debug.DebugScreen.enableDebugScreen;

public class App {
    static Map<String, Object> model = new HashMap<String, Object>();
    public static void main(String[] args) {
        staticFileLocation("/public");
        String layout = "templates/layout.vtl";
////heroku
        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }

        setPort(port);
////end heroku
        enableDebugScreen();


//display form
    get("/", (request, response) -> {

//       model.put("Stylists", Stylists.all());
        model.put("template", "templates/index.vtl");
        return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/newstylists", (request, response) -> {
//      Clients clients = Clients.find(Interger.parseInt(request.queryParams("clientId")));
        String firstname = request.queryParams("firstname");
        String middlename = request.queryParams("middlename");
        String lastname = request.queryParams("lastname");
        String Email = request.queryParams("Email");
        String Age = request.queryParams("Age");
        String Address = request.queryParams("Address");
        Stylists newstylists = new Stylists(firstname, middlename, lastname, Email, Age, Address);
        newstylists.save();
        response.redirect("/");
//        model.put("clients", "clients");
  //      model.put("template", "templates/index.vtl");
        return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());



        get("/", (request, response) -> {
            Stylists stylists = Stylists.find(Integer.parseInt(request.params(":id")));
            model.put("stylists", stylists);
            model.put("template", "templates/index.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());


    }
}