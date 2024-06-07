package ${{ values.groupId }}.repository;

import com.blazebit.persistence.spring.data.repository.EntityViewRepository;
import org.springframework.transaction.annotation.Transactional;
import ${{ values.groupId }}.view.PersonView;

@Transactional(readOnly = true)
public interface PersonViewRepository extends EntityViewRepository<PersonView, Integer> {
    PersonView findByAgeGreaterThan(int age);
}
