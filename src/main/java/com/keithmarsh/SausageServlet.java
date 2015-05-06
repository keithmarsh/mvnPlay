package com.keithmarsh;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SausageServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
   Logger log = Logger.getLogger(this.getClass().getName());
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     response.getWriter().println("Hello World!");
     response.getWriter().close();
     log.info("KJM " + request.getPathInfo()); 
	}
}
