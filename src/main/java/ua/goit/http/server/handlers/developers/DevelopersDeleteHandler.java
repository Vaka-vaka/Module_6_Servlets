/**
 * Module 5. HTTP
 *
 * @autor Valentin Mozul
 * @version of 24.11.2021
 */

package ua.goit.http.server.handlers.developers;

import com.sun.net.httpserver.HttpExchange;
import ua.goit.http.server.handlers.AbstractHandler;
import ua.goit.http.server.service.DevelopersService;
import ua.goit.model.Developers;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DevelopersDeleteHandler extends AbstractHandler {

    private static final DevelopersService developersService = DevelopersService.getInstance();

    @Override
    protected String getTempLateName() {
        return "";
    }

    @Override
    protected void get(HttpExchange exchange) throws IOException {
        Map<String, String> urlParams = getUrlParams(exchange);
        String id = urlParams.get("id");
        if(id == null) {
            throw new RuntimeException("Need id for developers");
        }
        Developers developers = new Developers();
        developers.setId(Long.parseLong(id));
        developersService.delete(developers);
        exchange.getResponseHeaders().set("Location", "/developers");
        exchange.sendResponseHeaders(301, 0L);
        exchange.close();
    }
}
