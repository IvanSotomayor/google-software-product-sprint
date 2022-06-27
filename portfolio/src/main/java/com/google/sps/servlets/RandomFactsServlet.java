package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

@WebServlet("/random")
public class RandomFactsServlet extends HttpServlet {
    String[] facts = {"Fact1", "Fact2", "Fact3", "Fact4"};
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;");
        Gson gson = new Gson();
        String factsJson = gson.toJson(facts);
        response.getWriter().println(factsJson);
    }
}

