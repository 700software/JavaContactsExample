package com.sample;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.sample.Globals.respondPlain;

@WebServlet(
        urlPatterns = "/save-contact"
)
public class PostSaveContact extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        OurData.Contact r = id == 0 ? new OurData.Contact() : OurData.THE_MAP.get(id);

        if (r == null) {
            respondPlain(resp, 410, false, "Contact ID " + id + " has been removed.");
        }

        if (id == 0)
            id = ++OurData.autoinc;

        OurData.THE_MAP.put(id, new OurData.Contact(id, req.getParameter("nameFirst"), req.getParameter("nameLast"), req.getParameter("email")));

        respondPlain(resp, 200, true, "{\"go\":\"./?highlight=" + id + "\"}");
    }
}
