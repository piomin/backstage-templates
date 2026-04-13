package pl.piomin.services.resource;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import pl.piomin.services.ai.AccountService;

@Path("/accounts")
public class AccountResource {

    private final AccountService accountService;

    public AccountResource(AccountService accountService) {
        this.accountService = accountService;
    }

    @POST
    @Path("/count-by-person-id/{personId}")
    public int countByPersonId(int personId) {
        return accountService.countByPersonId(personId);
    }

    @POST
    @Path("/balance-by-person-id/{personId}")
    public String balanceByPersonId(int personId) {
        return accountService.balanceByPersonId(personId);
    }

}
