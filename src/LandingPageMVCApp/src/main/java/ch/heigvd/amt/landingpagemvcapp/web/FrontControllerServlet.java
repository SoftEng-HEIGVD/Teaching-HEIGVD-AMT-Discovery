package ch.heigvd.amt.landingpagemvcapp.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Olivier Liechti (olivier.liechti@heig-vd.ch)
 */
public class FrontControllerServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    request.setAttribute("message", "");
    List technologies = new ArrayList<String>();
    technologies.add("Java EE");
    technologies.add("Servlets");
    technologies.add("JSP");
    technologies.add("JDBC");
    technologies.add("JPA");
    technologies.add("JAX-RS");
    technologies.add("Spring");
    technologies.add("Spring Boot");
    technologies.add("Glassfish");
    technologies.add("Wildfly");
    technologies.add("Tomcat");
    request.setAttribute("technologies", technologies);
    request.getRequestDispatcher("/WEB-INF/pages/").forward(request, response);
  }



}
