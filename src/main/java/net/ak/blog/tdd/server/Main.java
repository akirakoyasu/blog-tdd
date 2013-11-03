package net.ak.blog.tdd.server;

import net.ak.blog.tdd.server.jetty.JettyHandler;
import org.eclipse.jetty.server.Server;

/**
 * Hello world!
 */
public class Main {
    private static Server server;
    public static void run() {
        server = new Server(8080);
        server.setHandler(new JettyHandler());

        try {
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void shutdown() {
        try {
            server.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        run();
        try {
            server.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
