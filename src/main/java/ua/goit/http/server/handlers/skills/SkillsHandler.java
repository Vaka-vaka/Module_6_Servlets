/**
 * Module 5. HTTP
 *
 * @autor Valentin Mozul
 * @version of 23.11.2021
 */

package ua.goit.http.server.handlers.skills;

import com.sun.net.httpserver.HttpExchange;
import ua.goit.http.server.handlers.AbstractHandler;
import ua.goit.http.server.service.DevelopersService;
import ua.goit.http.server.service.SkillsService;
import ua.goit.model.Developers;
import ua.goit.model.Skills;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SkillsHandler extends AbstractHandler {

    private static final SkillsService skillsService = SkillsService.getInstance();

    @Override
    protected String getTempLateName() {
        return "skills";
    }

    @Override
    protected void get(HttpExchange exchange){
        List<Skills> skills = skillsService.getAll();
        String rowsTemplates = skills.stream()
                        .map(developers1 -> {
                            Map<String, String> params = new HashMap<>();
                            params.put("id", developers1.getId().toString());
                            params.put("name_", developers1.getLanguage());
                            params.put("age", String.valueOf(developers1.getLevel_skills()));
                           return templateHandler.handleTemplate("table-row", params);
                        })
                                .collect(Collectors.joining());

        handleResponse(exchange, Map.of("tableRows", rowsTemplates));
    }
}
