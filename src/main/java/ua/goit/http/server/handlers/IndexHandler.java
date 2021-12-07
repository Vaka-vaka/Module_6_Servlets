/**
 * Module 5. HTTP
 *
 * @autor Valentin Mozul
 * @version of 18.11.2021
 */

package ua.goit.http.server.handlers;

import com.sun.net.httpserver.HttpExchange;

public class IndexHandler extends AbstractHandler {

    @Override
    protected String getTempLateName() {
        return "index";
    }

    @Override
    protected void get(HttpExchange exchange) {
        handleResponse(exchange);
    }
}
