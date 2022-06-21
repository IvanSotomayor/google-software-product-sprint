package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.KeyFactory;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.Entity;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    // Get the value entered in the form.
    String nameValue = request.getParameter("name-input");
    String emailValue = request.getParameter("email-input");
    String messageValue = request.getParameter("message-input");
    long timestamp = System.currentTimeMillis();

    KeyFactory keyFactory = datastore.newKeyFactory().setKind("Form");

    FullEntity formEntity =
        Entity.newBuilder(keyFactory.newKey())
            .set("name", nameValue)
            .set("email", emailValue)
            .set("message", messageValue)
            .set("timestamp", timestamp)
            .build();
    datastore.put(formEntity);

    response.sendRedirect("/index.html");

    // Print the value so you can see it in the server logs.
    System.out.println("Name: " + nameValue);
    System.out.println("Email: " + emailValue);
    System.out.println("Message: " + messageValue);

    // Write the value to the response so the user can see it.
    response.getWriter().println("<h1> Thank you, I'll be in touch with you ASAP :) <h1>");
  }
}

