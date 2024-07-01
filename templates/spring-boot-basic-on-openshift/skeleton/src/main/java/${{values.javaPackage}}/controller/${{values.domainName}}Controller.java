package ${{ values.groupId }}.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import ${{ values.groupId }}.domain.${{ values.domainName }};

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("${{ values.apiPath }}")
public class ${{ values.domainName }}Controller {

    private final Logger LOG = LoggerFactory.getLogger(${{ values.domainName }}Controller.class);
    private final List<${{ values.domainName }}> objs = new ArrayList<>();

    @GetMapping
    public List<${{ values.domainName }}> findAll() {
        return objs;
    }

    @GetMapping("/{id}")
    public ${{ values.domainName }} findById(@PathVariable("id") Long id) {
        ${{ values.domainName }} obj = objs.stream().filter(it -> it.getId().equals(id))
                .findFirst()
                .orElseThrow();
        LOG.info("Found: {}", obj.getId());
        return obj;
    }

    @PostMapping
    public ${{ values.domainName }} add(@RequestBody ${{ values.domainName }} obj) {
        obj.setId((long) (objs.size() + 1));
        LOG.info("Added: {}", obj);
        objs.add(obj);
        return obj;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        ${{ values.domainName }} obj = objs.stream().filter(it -> it.getId().equals(id)).findFirst().orElseThrow();
        objs.remove(obj);
        LOG.info("Removed: {}", id);
    }

    @PutMapping
    public void update(@RequestBody ${{ values.domainName }} obj) {
        ${{ values.domainName }} objTmp = objs.stream()
                .filter(it -> it.getId().equals(obj.getId()))
                .findFirst()
                .orElseThrow();
        objs.set(objs.indexOf(objTmp), obj);
        LOG.info("Updated: {}", obj.getId());
    }

}