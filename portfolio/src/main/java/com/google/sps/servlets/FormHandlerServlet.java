package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Get the value entered in the form.
    String nameValue = request.getParameter("name-input");
    String emailValue = request.getParameter("email-input");
    String messageValue = request.getParameter("message-input");

    // Print the value so you can see it in the server logs.
    System.out.println("Name: " + nameValue);
    System.out.println("Email: " + emailValue);
    System.out.println("Message: " + messageValue);

    // Write the value to the response so the user can see it.
    response.getWriter().println("<h1> Thank you, I'll be in touch with you ASAP :) <h1>");
  }
}

