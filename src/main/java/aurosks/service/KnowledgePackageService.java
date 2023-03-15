package aurosks.service;

import aurosks.dto.request.KPRequest;
import aurosks.model.KnowledgePackage;

import java.util.List;

public interface KnowledgePackageService {

    KnowledgePackage create(KPRequest KPRequest);

    void delete(Long id);

    List<KnowledgePackage> getAll();

}
