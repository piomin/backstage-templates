package ${{ values.groupId }}.tools;

import io.quarkiverse.mcp.server.Tool;
import io.quarkiverse.mcp.server.ToolArg;
import jakarta.enterprise.context.ApplicationScoped;
import ${{ values.groupId }}.domain.${{ values.domainName }}s;
import ${{ values.groupId }}.repository.${{ values.domainName }}Repository;

@ApplicationScoped
public class ${{ values.domainName }}Tools {

    ${{ values.domainName }}Repository ${{ values.domainName }}Repository;

    public ${{ values.domainName }}Tools(${{ values.domainName }}Repository ${{ values.domainName }}Repository) {
        this.${{ values.domainName }}Repository = ${{ values.domainName }}Repository;
    }

    @Tool(description = "Find all ${{ values.domainName }}s by person ID")
    public ${{ values.domainName }}s get${{ values.domainName }}sByPersonId(
            @ToolArg(name = "personId", description = "Person ID") Long personId) {
        return new ${{ values.domainName }}s(${{ values.domainName }}Repository.findByPersonId(personId));
    }

}
