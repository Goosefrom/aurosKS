package aurosks.controller;

import aurosks.dto.request.KPSRequest;
import aurosks.service.KnowledgePackageService;
import aurosks.service.KnowledgePackageSetService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/sets")
public class KnowledgePackageSetController {

    private final ObjectMapper mapper = new ObjectMapper();
    private final KnowledgePackageService knowledgePackageService;
    private final KnowledgePackageSetService knowledgePackageSetService;

    @GetMapping
    public String getAll(Model model) throws JsonProcessingException {
        model.addAttribute("knowledgePackageList", knowledgePackageService.getAll());
        model.addAttribute("knowledgePackageSetList", mapper.writeValueAsString(knowledgePackageSetService.getAll()));
        return "/sets";
    }

    @ModelAttribute("addRequest")
    public KPSRequest getModelForCreateKnowledgePackage() {
        return new KPSRequest();
    }

    @PostMapping("/add")
    public String createKnowledgePackage(@ModelAttribute("addRequest") KPSRequest request) {
        knowledgePackageSetService.create(request);
        return "redirect:/sets";
    }

    @PostMapping("/delete")
    public String deleteKnowledgePackage(@RequestParam("id") Long id) {
        knowledgePackageSetService.delete(id);
        return "redirect:/sets";
    }


}
