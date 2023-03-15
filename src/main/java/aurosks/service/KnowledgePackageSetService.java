package aurosks.service;

import aurosks.dto.request.KPSRequest;
import aurosks.dto.response.KPResponse;
import aurosks.dto.response.KPSResponse;
import aurosks.model.KnowledgePackageSet;

import java.util.List;

public interface KnowledgePackageSetService {

    KnowledgePackageSet create(KPSRequest KPSRequest);

    void delete(Long id);

    List<KPSResponse> getAll();

    List<KPResponse> getAllById(Long id);

}
