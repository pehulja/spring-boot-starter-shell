package org.mvnsearch.spring.boot.shell;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.shell.support.logging.HandlerUtils;

import java.util.logging.Logger;

/**
 * spring shell application
 *
 * @author linux_china
 */
public class SpringShellApplication {

    public static void run(Object source, String... args) {
        run(new Object[]{source}, args);
    }

    public static void run(Object[] sources, String[] args) {
        ConfigurableApplicationContext ctx = new SpringApplication(sources).run(args);
        try {
            // Place empty array to Spring Shell
            new BootShim(new String[]{}, ctx).run();
        } finally {
            ctx.close();
            HandlerUtils.flushAllHandlers(Logger.getLogger(""));
        }
    }

}
