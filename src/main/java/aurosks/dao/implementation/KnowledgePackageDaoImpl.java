package aurosks.dao.implementation;

import aurosks.dao.KnowledgePackageDao;
import aurosks.model.KnowledgePackage;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class KnowledgePackageDaoImpl implements KnowledgePackageDao {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private final JdbcTemplate jdbcTemplate;


    @Override
    public KnowledgePackage create(KnowledgePackage knowledgePackage) {
        String query = "insert into knowledge_packages (title, description, date) values(?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement createStatement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            createStatement.setString(1, knowledgePackage.getTitle());
            createStatement.setString(2, knowledgePackage.getDescription());
            createStatement.setString(3, FORMATTER.format(LocalDate.now()));
            return createStatement;
        }, keyHolder);
        knowledgePackage.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());
        return knowledgePackage;
    }


    @Override
    public void delete(Long id) {
        String query = "delete from knowledge_packages where id= ?";
        jdbcTemplate.update(query, id);
    }

    @Override
    public KnowledgePackage get(Long id) {
        String query = "select * from knowledge_packages where id= ?";
        Optional<KnowledgePackage> optionalKnowledgePackage = jdbcTemplate
                .query(query, new BeanPropertyRowMapper<>(KnowledgePackage.class), id)
                .stream()
                .findFirst();
        return optionalKnowledgePackage.orElse(null);
    }

    @Override
    public List<KnowledgePackage> getAll() {
        String query = "select * from knowledge_packages";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(KnowledgePackage.class));
    }

}
