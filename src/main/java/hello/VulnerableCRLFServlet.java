package hello;

import java.nio.charset.Charset;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

public class VulnerableCRLFServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userInput = request.getParameter("input");

        // Vulnerable code: User input is directly added to the header
        response.setHeader("X-Custom-Header", URLEncoder.encode(userInput, Charset.defaultCharset()));
        response.getWriter().write("Header set with user input.");
    }
}