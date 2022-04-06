package edu.stevens.friccobo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class DemoServlet extends HttpServlet {
    String message = "Hello ";

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");

        String name = req.getParameter("name");
        String subMessage = req.getParameter("subMessage");
        PrintWriter out = resp.getWriter();
        out.println("<h1>" + message + name +  "</h1><h2>"+subMessage+"</h2>" +
                """
                        <form action="/hello" method="POST">
                            <input type="text" id="message2" name="message2"/>
                            <button type="submit">Submit</button>
                        </form>
                        """);
    }

    @Override
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse resp) throws ServletException, IOException {
        String message2 = req.getParameter("message2");

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<h1>" + message2 + "</h1>");
    }
}
