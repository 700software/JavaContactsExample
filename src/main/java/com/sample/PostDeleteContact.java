package com.sample;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.sample.Globals.respondPlain;

@WebServlet(
        urlPatterns = "/delete-contact"
)
public class PostDeleteContact extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        OurData.THE_MAP.remove(id);

        respondPlain(resp, 200, true, "{}");
    }
}
