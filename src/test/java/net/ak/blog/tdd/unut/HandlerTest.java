package net.ak.blog.tdd.unut;

import net.ak.blog.tdd.server.Handler;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author Akira Koyasu <mail@akirakoyasu.net>
 */
public class HandlerTest {
    @Rule
    public final JUnitRuleMockery context = new JUnitRuleMockery();
    private final HttpServletResponse response = context.mock(HttpServletResponse.class);
    private final StringWriter writer = new StringWriter();

    @Test
    public void handleTest() throws IOException, ServletException {
        context.checking(new Expectations() {{
            oneOf(response).setContentType("text/html;charset=utf-8");
            oneOf(response).setStatus(HttpServletResponse.SC_OK);
            oneOf(response).getWriter(); will(returnValue(new PrintWriter(writer)));
        }});

        Handler h = new Handler();
        h.handle(null, null, response);

        assertThat(writer.toString(), equalTo("<h1>Welcome!</h1>"));
    }
}
