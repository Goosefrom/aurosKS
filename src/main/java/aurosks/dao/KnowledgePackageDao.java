package aurosks.dao;

import aurosks.model.KnowledgePackage;

import java.util.List;

public interface KnowledgePackageDao {
    KnowledgePackage create(KnowledgePackage knowledgePackage);

    void delete(Long id);

    KnowledgePackage get(Long id);

    List<KnowledgePackage> getAll();

}
