package net.ak.blog.tdd.functional;

import net.ak.blog.tdd.server.Main;

/**
 * @author Akira Koyasu <mail@akirakoyasu.net>
 */
public class ServerRunner {
    public static void start() {
        Main.run();
    }

    public static void stop() {
        Main.shutdown();
    }
}
