package ch.heigvd.amt.landingpagemvcapp.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Olivier Liechti (olivier.liechti@heig-vd.ch)
 */
public class RoutingFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    String path = req.getRequestURI().substring(req.getContextPath().length());
    if (isStaticAsset(path)) {
      chain.doFilter(request, response);
    } else {
      request.getRequestDispatcher("/frontController" + path).forward(request, response);
    }
  }

  @Override
  public void destroy() {
  }

  private boolean isStaticAsset(String path) {
    if (path.startsWith("/assets")) {
      return true;
    } else if (path.startsWith("/css")) {
      return true;
    } else if (path.startsWith("/fonts")) {
      return true;
    } else if (path.startsWith("/js")) {
      return true;
    }
    return false;
  }
  

}
