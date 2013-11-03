package net.ak.blog.tdd.server;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Akira Koyasu <mail@akirakoyasu.net>
 */
public class Handler {
    public void handle(String target,
           HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        PrintWriter writer = response.getWriter();
        writer.print("<h1>Welcome!</h1>");
    }
}
