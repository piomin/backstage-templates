package ${{ values.groupId }}.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import ${{ values.groupId }}.domain.Person;
import ${{ values.groupId }}.repository.PersonRepository;
import ${{ values.groupId }}.repository.PersonViewRepository;
import ${{ values.groupId }}.view.PersonView;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private static final Logger LOG = LoggerFactory.getLogger(PersonController.class);
    private final PersonRepository repository;
    private final PersonViewRepository viewRepository;

    public PersonController(PersonRepository repository, PersonViewRepository viewRepository) {
        this.repository = repository;
        this.viewRepository = viewRepository;
    }

    @GetMapping
    public List<PersonView> getAll() {
        LOG.info("Get all persons");
        return (List<PersonView>) viewRepository.findAll();
    }

    @GetMapping("/{id}")
    public PersonView getById(@PathVariable("id") Integer id) {
        LOG.info("Get person by id={}", id);
        return viewRepository.findOne(id);
    }

    @GetMapping("/age/{age}")
    public PersonView getByAgeGreaterThan(@PathVariable("age") int age) {
        LOG.info("Get person by age={}", age);
        return viewRepository.findByAgeGreaterThan(age);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        LOG.info("Delete person by id={}", id);
        repository.deleteById(id);
    }

    @PostMapping
    public Person addNew(@RequestBody Person person) {
        LOG.info("Add new person: {}", person);
        return repository.save(person);
    }

    @PutMapping
    public void update(@RequestBody Person person) {
        repository.save(person);
    }
}
