package hello;

import java.nio.charset.Charset;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/crlf")
public class VulnerableCRLFServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the user input from a query parameter without sanitization
        String user = request.getParameter("user");

        // Vulnerable: Directly using the user input in the HTTP response header
        response.setHeader("X-User", user);

        // Respond with a simple message without using the user input
        response.getWriter().println("Hello, visitor!");
    }
}
