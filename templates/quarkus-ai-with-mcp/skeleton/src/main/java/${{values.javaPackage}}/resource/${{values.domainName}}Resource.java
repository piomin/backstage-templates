package ${{ values.groupId }}.resource;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import ${{ values.groupId }}.ai.${{values.domainName}}Service;

@Path("/${{values.domainName}}s")
public class ${{values.domainName}}Resource {

    private final ${{values.domainName}}Service ${{values.domainName}}Service;

    public ${{values.domainName}}Resource(${{values.domainName}}Service ${{values.domainName}}Service) {
        this.${{values.domainName}}Service = ${{values.domainName}}Service;
    }

    @POST
    @Path("/your-endpoint/{personId}")
    public int yourMethod(int personId) {
        // return ${{values.domainName}}Service.yourMethod(personId);
    }

}
