package aurosks.controller;

import aurosks.dto.request.KPRequest;
import aurosks.service.KnowledgePackageService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/kpacs")
@RequiredArgsConstructor
public class KnowledgePackageController {

    private final ObjectMapper mapper = new ObjectMapper();
    private final KnowledgePackageService service;

    @GetMapping
    public String getAll(Model model) throws JsonProcessingException {
        model.addAttribute("knowledgePackageList", mapper.writeValueAsString(service.getAll()));
        return "/kpacs";
    }

    @ModelAttribute("addRequest")
    public KPRequest getModelForCreateKnowledgePackage() {
        return new KPRequest();
    }

    @PostMapping("/add")
    public String createKnowledgePackage(@ModelAttribute("addRequest") KPRequest request) {
        service.create(request);
        return "redirect:/kpacs";
    }

    @PostMapping("/delete")
    public String deleteKnowledgePackage(@RequestParam("id") Long id) {
        service.delete(id);
        return "redirect:/kpacs";
    }
}
