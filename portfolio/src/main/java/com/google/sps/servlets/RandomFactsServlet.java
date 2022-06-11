package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import com.google.gson.Gson;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@WebServlet("/random")
public class RandomFactsServlet extends HttpServlet {
    ArrayList<String> facts = new ArrayList<String>();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        facts.add("Fact1");
        facts.add("Fact2");
        facts.add("Fact3");
        facts.add("Fact4");
        String factsJson = new Gson().toJson(facts);
        response.getWriter().println("Facts: " + factsJson);
    }
}

