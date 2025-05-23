package R_IssueResolvingSystem.AgentStrategy;

import R_IssueResolvingSystem.Agent.Agent;

import java.util.Map;

public class AgentWithImmediateResponse implements AgentStrategy{

    @Override
    public Agent assignAnAgent(Map<Integer, Agent> availableAgentMap) {
        Agent agent = null;

        if(availableAgentMap.isEmpty()){
            System.out.println("AgentWithImmediateResponse::assignAnAgent ------- No agent is available");
        } else {
            int minimumTicketsAssingedAgent = Integer.MAX_VALUE;

            for(Agent iterableAgent : availableAgentMap.values()){
                if(iterableAgent.issuesList().size() < minimumTicketsAssingedAgent){
                    minimumTicketsAssingedAgent = iterableAgent.issuesList().size();
                    agent = iterableAgent;
                }
            }

            System.out.println("AgentWithMoreExperience::assignAnAgent ------ Successfully figured out an agent who can response immediately : "+agent.getAgentId());
        }

        return agent;
    }
}
