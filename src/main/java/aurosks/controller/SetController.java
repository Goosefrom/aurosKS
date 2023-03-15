package aurosks.controller;

import aurosks.service.KnowledgePackageSetService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/set")
public class SetController {

    private final ObjectMapper mapper = new ObjectMapper();
    private final KnowledgePackageSetService service;


    @GetMapping("/{id}")
    public String getAllKPacsByKPacSetId(@PathVariable Long id, Model model) throws JsonProcessingException {
        model.addAttribute("knowledgePackageListAssignToSet", mapper.writeValueAsString(service.getAllById(id)));
        return "set";
    }

}
