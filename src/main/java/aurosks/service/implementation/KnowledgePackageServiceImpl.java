package aurosks.service.implementation;

import aurosks.dao.KnowledgePackageDao;
import aurosks.dto.request.KPRequest;
import aurosks.mapper.KnowledgePackageMapper;
import aurosks.model.KnowledgePackage;
import aurosks.service.KnowledgePackageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KnowledgePackageServiceImpl implements KnowledgePackageService {

    private final KnowledgePackageMapper mapper;
    private final KnowledgePackageDao knowledgePackageDao;

    @Override
    public KnowledgePackage create(KPRequest KPRequest) {
        return knowledgePackageDao.create(mapper.toModel(KPRequest));
    }

    @Override
    public void delete(Long id) {
        knowledgePackageDao.delete(id);

    }

    @Override
    public List<KnowledgePackage> getAll() {
        return knowledgePackageDao.getAll();
    }

}
