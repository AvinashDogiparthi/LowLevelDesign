package R_IssueResolvingSystem.Agent;

import R_IssueResolvingSystem.AgentStrategy.AgentStrategy;
import R_IssueResolvingSystem.AgentStrategy.AgentStrategyEnum;
import R_IssueResolvingSystem.AgentStrategy.AgentWithImmediateResponse;
import R_IssueResolvingSystem.Issue.Issue;

import java.util.HashMap;
import java.util.Map;

public class AgentController {

    private Map<Integer, Agent> availableAgents;
    private AgentStrategy agentStrategy;

    public AgentController() {
        this.availableAgents = new HashMap<>();
        addAgents();
    }

    public void assignAnAgent(Issue issue, AgentStrategyEnum agentStrategyEnum){
        agentStrategy = AgentFactory.getStrategy(agentStrategyEnum);
        System.out.println("AgentController::assignAnAgent ----- Following agent strategy : "+agentStrategyEnum.toString());

        Agent agent = agentStrategy.assignAnAgent(availableAgents);
        agent.addIssueIntoQueue(issue);
        issue.setAssignedAgent(agent);

        System.out.println("AgentController::assignAnAgent ---- Assigned agent "+agent.getAgentId()+" for issue : "+issue.getIssueId());
    }

    public void addAgents(){
        for(int i = 0;i<100;i++){
            Agent agent = new Agent(i);
            this.availableAgents.put(i,agent);
        }
    }
}
