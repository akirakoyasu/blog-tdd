package net.ak.blog.tdd.functional;

import net.ak.blog.tdd.server.Main;

/**
 * @author Akira Koyasu <mail@akirakoyasu.net>
 */
public class ServerRunner {
    public static void run() {
        Main.main(new String[]{});
    }

    public static void stop() {
        Main.shutdown();
    }
}
