package ${{ values.groupId }}.domain;

import jakarta.persistence.*;

@Entity
public class ${{ values.domainName }} {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}