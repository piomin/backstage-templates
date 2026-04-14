package ${{ values.groupId }}.ai;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;
import io.quarkiverse.langchain4j.mcp.runtime.McpToolBox;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
@RegisterAiService
public interface ${{values.domainName}}Service {

    @SystemMessage("""
        You are a helpful assistant that generates realistic data.
        Return a single number.
        """)
    @UserMessage("""
        Put your prompt here.
        """)
    @McpToolBox("mcp-service")
    int yourMethod(int personId);

    @UserMessage("""
        Put your prompt here.
        """)
    @McpToolBox("mcp-service")
    String yourMethod2(int personId);

}
