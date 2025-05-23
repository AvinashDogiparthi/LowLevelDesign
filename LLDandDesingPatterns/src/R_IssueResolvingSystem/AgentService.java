package R_IssueResolvingSystem;

import R_IssueResolvingSystem.Agent.Agent;
import R_IssueResolvingSystem.Agent.AgentController;
import R_IssueResolvingSystem.AgentStrategy.AgentStrategyEnum;
import R_IssueResolvingSystem.Issue.Issue;

public class AgentService {

    private static AgentService instance = null;
    private AgentController agentController;

    private AgentService(){
        agentController = new AgentController();
    }

    public static synchronized AgentService getInstance(){
        if(instance == null){
            instance = new AgentService();
        }
        return instance;
    }

    public void createIssue(Issue issue, AgentStrategyEnum agentStrategyEnum){
        agentController.assignAnAgent(issue,agentStrategyEnum);
        System.out.println("AgentService::createIssue ---- successfully created an issue and assigned an agent");
    }

    public void createIssue(Issue issue){
        agentController.assignAnAgent(issue,AgentStrategyEnum.IMMEDIATE);
        System.out.println("AgentService::createIssue ---- successfully created an issue and assigned an agent");
    }
}
