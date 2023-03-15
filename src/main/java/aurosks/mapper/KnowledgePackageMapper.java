package aurosks.mapper;

import aurosks.dto.request.KPRequest;
import aurosks.dto.response.KPResponse;
import aurosks.model.KnowledgePackage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface KnowledgePackageMapper {

    @Mapping(target = "id", ignore = true)
    KnowledgePackage toModel(KPRequest request);

    KPResponse toResponse(KnowledgePackage model);

}
