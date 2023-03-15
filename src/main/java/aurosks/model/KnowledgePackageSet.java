package aurosks.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KnowledgePackageSet {
    private Long id;
    private String title;
    private List<KnowledgePackage> knowledgePackageList;
}
