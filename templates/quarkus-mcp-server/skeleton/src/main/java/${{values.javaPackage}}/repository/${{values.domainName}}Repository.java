package ${{ values.groupId }}.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import pl.piomin.services.domain.Account;

import java.util.List;

@ApplicationScoped
public class ${{ values.domainName }}Repository implements PanacheRepository<${{ values.domainName }}> {

    public List<${{ values.domainName }}> findByPersonId(Long personId) {
        return find("personId", personId).list();
    }

}
