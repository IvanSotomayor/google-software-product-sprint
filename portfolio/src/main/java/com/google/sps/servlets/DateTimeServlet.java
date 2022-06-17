package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


/** Servlet that responds with the current date. */
@WebServlet("/dateTime")
public class DateTimeServlet extends HttpServlet {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd");
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    LocalDate localDate = LocalDate.now();
    LocalTime localTime = LocalTime.now();
    response.setContentType("text/html;");
    response.getWriter().println("Server current date and time is " + dtf.format(localDate) + " " + timeFormatter.format(localTime));
  }
}