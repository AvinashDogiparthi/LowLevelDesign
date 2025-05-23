package R_IssueResolvingSystem.AgentStrategy;

import R_IssueResolvingSystem.Agent.Agent;
import R_IssueResolvingSystem.Issue.Issue;

import java.util.Map;

public class AgentWithMoreExperience implements AgentStrategy{


    @Override
    public Agent assignAnAgent(Map<Integer, Agent> availableAgentMap) {
        Agent agent = null;
        if(availableAgentMap.isEmpty()){
            System.out.println("AgentWithMoreExperience::assignAnAgent ------- No agent is available");
        } else {
            agent = anyAgent(availableAgentMap);
            int maximumTicketsSolved = agent.numberOfTicketsSolved();

            for(Agent iterableAgents : availableAgentMap.values()){
                if(iterableAgents.numberOfTicketsSolved() > maximumTicketsSolved){
                    maximumTicketsSolved = iterableAgents.numberOfTicketsSolved();
                    agent = iterableAgents;
                }
            }

            System.out.println("AgentWithMoreExperience::assignAnAgent ------ Successfully figured out an agent with more experience : "+agent.getAgentId());
        }
        return agent;
    }

    public Agent anyAgent(Map<Integer, Agent> agentMap){
        Agent agent = null;
        for(Agent tempAgent : agentMap.values()){
            agent = tempAgent;
        }

        return agent;
    }
}
