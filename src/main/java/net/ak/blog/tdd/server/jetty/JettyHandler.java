package net.ak.blog.tdd.server.jetty;

import net.ak.blog.tdd.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Akira Koyasu <mail@akirakoyasu.net>
 */
public class JettyHandler extends AbstractHandler {
    private final Handler delegate = new Handler();

    @Override
    public void handle(String target, Request baseRequest,
           HttpServletRequest request, HttpServletResponse response) throws IOException {
        baseRequest.setHandled(true);
        delegate.handle(target, request, response);
    }
}
