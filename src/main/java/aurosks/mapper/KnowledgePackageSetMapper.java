package aurosks.mapper;

import aurosks.dao.KnowledgePackageDao;
import aurosks.dto.request.KPSRequest;
import aurosks.dto.response.KPSResponse;
import aurosks.model.KnowledgePackageSet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class KnowledgePackageSetMapper {

    @Autowired
    protected KnowledgePackageDao knowledgePackageDao;

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "knowledgePackageList",
            expression = "java(request.getKnowledgePackageIdList().stream().map(knowledgePackageDao::get).collect(java.util.stream.Collectors.toList()))")
    public abstract KnowledgePackageSet toModel(KPSRequest request);

    public abstract KPSResponse toResponse(aurosks.model.KnowledgePackageSet model);
}
