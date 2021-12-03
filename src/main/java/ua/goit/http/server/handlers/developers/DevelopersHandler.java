/**
 * Module 5. HTTP
 *
 * @autor Valentin Mozul
 * @version of 23.11.2021
 */

package ua.goit.http.server.handlers.developers;

import com.sun.net.httpserver.HttpExchange;
import ua.goit.http.server.handlers.AbstractHandler;
import ua.goit.model.Developers;
import ua.goit.http.server.service.DevelopersService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DevelopersHandler extends AbstractHandler {

    private static final DevelopersService developersService = DevelopersService.getInstance();

    @Override
    protected String getTempLateName() {
        return "developers";
    }

    @Override
    protected void get(HttpExchange exchange){
        List<Developers> developers = developersService.getAll();
        String rowsTemplates = developers.stream()
                        .map(developers1 -> {
                            Map<String, String> params = new HashMap<>();
                            params.put("id", developers1.getId().toString());
                            params.put("name_", developers1.getName_());
                            params.put("age", String.valueOf(developers1.getAge()));
                            params.put("gender", developers1.getGender());
                            params.put("salary", String.valueOf(developers1.getSalary()));
                           return templateHandler.handleTemplate("table-row", params);
                        })
                                .collect(Collectors.joining());

        handleResponse(exchange, Map.of("tableRows", rowsTemplates));
    }
}
