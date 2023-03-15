package aurosks.dao.implementation;

import aurosks.dao.KnowledgePackageSetDao;
import aurosks.model.KnowledgePackage;
import aurosks.model.KnowledgePackageSet;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class KnowledgePackageSetDaoImpl implements KnowledgePackageSetDao {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public KnowledgePackageSet create(KnowledgePackageSet knowledgePackageSet) {
        String query = "insert into knowledge_package_sets (title) values(?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement createStatement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            createStatement.setString(1, knowledgePackageSet.getTitle());
            return createStatement;
        }, keyHolder);
        knowledgePackageSet.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());
        if (knowledgePackageSet.getKnowledgePackageList() != null) {
            assignKnowledgePackages(knowledgePackageSet);
        }
        return knowledgePackageSet;
    }

    @Override
    public void addKnowledgePackage(Long setId, Long packageId) {
        String query = "insert into knowledge_packages_knowledge_package_sets " +
                "(knowledge_package_id, knowledge_package_set_id) values(?, ?)";
        jdbcTemplate.update(query, packageId, setId);
    }

    @Override
    public void delete(Long id) {
        String query = "delete from knowledge_package_sets where id = ?";
        jdbcTemplate.update(query, id);
    }

    @Override
    public List<KnowledgePackageSet> getAll() {
        String query = "select * from knowledge_package_sets";
        return jdbcTemplate.query(query,
                new BeanPropertyRowMapper<>(KnowledgePackageSet.class));

    }

    @Override
    public List<KnowledgePackage> getKnowledgePackages(Long id) {
        String query = "select * from knowledge_packages kp " +
                "right join knowledge_packages_knowledge_package_sets kps on kp.id = kps.knowledge_package_id " +
                "where kps.knowledge_package_set_id = ?";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(KnowledgePackage.class), id);
    }

    private void assignKnowledgePackages(KnowledgePackageSet knowledgePackageSet) {
        String query = "insert into knowledge_packages_knowledge_package_sets " +
                "(knowledge_package_id, knowledge_package_set_id) values(?, ?)";
        for (KnowledgePackage knowledgePackage : knowledgePackageSet.getKnowledgePackageList()) {
            jdbcTemplate.update(query, knowledgePackage.getId(), knowledgePackageSet.getId());
        }
    }
}
