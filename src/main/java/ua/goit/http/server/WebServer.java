/**
 * Module 5. HTTP
 *
 * @autor Valentin Mozul
 * @version of 18.11.2021
 */

package ua.goit.http.server;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.goit.http.server.handlers.*;
import ua.goit.http.server.handlers.developers.*;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Map;
import java.util.concurrent.Executors;

public class WebServer {

    private static final Logger LOGGER = LogManager.getLogger(WebServer.class);

    private final Map<String, HttpHandler> handlers = Map.of(
            "/", new IndexHandler(),
            "/users", new UserHandler(),
            "/developers", new DevelopersHandler(),
            "/developers-view", new DevelopersViewHandler(),
            "/developers-create", new DevelopersCreateHandler(),
            "/developers-delete", new DevelopersDeleteHandler(),
            "/skills", new GeneralGetHandler("skills")
    );

    public void start() {
        try {
            HttpServer server = HttpServer.create(
                    new InetSocketAddress("localhost", 80), 0);
            server.setExecutor(Executors.newFixedThreadPool(10));
            server.start();
            handlers.forEach(server::createContext);
        } catch (IOException e) {
            LOGGER.error("Problem with starting web server", e);
        }
    }

    public static void main(String[] args) {
        WebServer server = new WebServer();
        server.start();
    }
}
