/**
 * Module 5. HTTP
 *
 * @autor Valentin Mozul
 * @version of 18.11.2021
 */

package ua.goit.http.server.handlers;

import com.sun.net.httpserver.HttpExchange;

import java.util.Map;

public class UserHandler extends AbstractHandler {



    @Override
    protected String getTempLateName() {
        return "users";
    }

    @Override
    protected void get(HttpExchange exchange){
        handleResponse(exchange, Map.of(
                "usersName", "Valera",
                "usersDetail", "Kurochkin"
        ));
    }
}
