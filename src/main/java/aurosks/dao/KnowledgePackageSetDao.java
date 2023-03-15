package aurosks.dao;

import aurosks.model.KnowledgePackage;
import aurosks.model.KnowledgePackageSet;
import java.util.List;

public interface KnowledgePackageSetDao {
    KnowledgePackageSet create(KnowledgePackageSet knowledgePackageSet);

    void addKnowledgePackage(Long setId, Long packageId);

    void delete(Long id);

    List<KnowledgePackageSet> getAll();

    List<KnowledgePackage> getKnowledgePackages(Long id);

}
