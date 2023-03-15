package aurosks.service.implementation;

import aurosks.dao.KnowledgePackageSetDao;
import aurosks.dto.request.KPSRequest;
import aurosks.dto.response.KPResponse;
import aurosks.dto.response.KPSResponse;
import aurosks.mapper.KnowledgePackageMapper;
import aurosks.mapper.KnowledgePackageSetMapper;
import aurosks.model.KnowledgePackageSet;
import aurosks.service.KnowledgePackageSetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KnowledgePackageSetServiceImpl implements KnowledgePackageSetService {

    private final KnowledgePackageMapper kpacMapper;

    private final KnowledgePackageSetMapper kpacSetMapper;

    private final KnowledgePackageSetDao knowledgePackageSetDao;

    @Override
    public KnowledgePackageSet create(KPSRequest KPSRequest) {
        return knowledgePackageSetDao.create(kpacSetMapper.toModel(KPSRequest));
    }

    @Override
    public void delete(Long id) {
        knowledgePackageSetDao.delete(id);
    }

    @Override
    public List<KPSResponse> getAll() {
        return knowledgePackageSetDao
                .getAll()
                .stream()
                .map(kpacSetMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<KPResponse> getAllById(Long id) {
        return knowledgePackageSetDao
                .getKnowledgePackages(id)
                .stream()
                .map(kpacMapper::toResponse)
                .collect(Collectors.toList());
    }
}
