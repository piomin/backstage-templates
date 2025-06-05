package ${{ values.groupId }}.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import ${{ values.groupId }}.domain.${{ values.domainName }};
import ${{ values.groupId }}.repository.${{ values.domainName }}Repository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("${{ values.apiPath }}")
public class ${{ values.domainName }}Controller {

    private final Logger LOG = LoggerFactory.getLogger(${{ values.domainName }}Controller.class);

    ${{ values.domainName }}Repository repository;

    public ${{ values.domainName }}Controller(${{ values.domainName }}Repository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<${{ values.domainName }}> findAll() {
        return (List<${{ values.domainName }}>) repository.findAll();
    }

    @GetMapping("/{id}")
    public ${{ values.domainName }} findById(@PathVariable("id") Long id) {
        ${{ values.domainName }} obj = repository.findById(id).orElseThrow();
        LOG.info("Found: {}", obj.getId());
        return obj;
    }

    @PostMapping
    public ${{ values.domainName }} add(@RequestBody ${{ values.domainName }} obj) {
        obj = repository.save(obj);
        LOG.info("Added: {}", obj);
        return obj;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        repository.deleteById(id);
        LOG.info("Removed: {}", id);
    }

    @PutMapping
    public void update(@RequestBody ${{ values.domainName }} obj) {
        repository.save(obj);
        LOG.info("Updated: {}", obj.getId());
    }

}