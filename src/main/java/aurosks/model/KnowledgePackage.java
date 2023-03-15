package aurosks.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KnowledgePackage {
    private Long id;
    private String title;
    private String description;
    private String date;
}
