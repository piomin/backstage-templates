package ${{ values.groupId }}.repository;

import org.springframework.data.repository.CrudRepository;
import ${{ values.groupId }}.domain.Person;

public interface ${{ values.domainName }}Repository extends CrudRepository<${{ values.domainName }}, Long> {
}