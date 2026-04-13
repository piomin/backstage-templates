package pl.piomin.services.ai;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;
import io.quarkiverse.langchain4j.mcp.runtime.McpToolBox;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
@RegisterAiService
public interface AccountService {

    @SystemMessage("""
        You are a helpful assistant that generates realistic data.
        Return a single number.
        """)
    @UserMessage("How many accounts has person with {personId} ID ?")
    @McpToolBox("account-service")
    int countByPersonId(int personId);

    @UserMessage("""
        How many accounts has person with {personId} ID ?
        Return person name, nationality and a total balance on his/her accounts.
        """)
    @McpToolBox("account-service")
    String balanceByPersonId(int personId);

}
