package ${{ values.groupId }}.repository;

import org.springframework.data.repository.CrudRepository;
import ${{ values.groupId }}.domain.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {
}
