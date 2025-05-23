package R_IssueResolvingSystem.AgentStrategy;

import R_IssueResolvingSystem.Agent.Agent;
import R_IssueResolvingSystem.Issue.Issue;

import java.util.Map;

public interface AgentStrategy {

    Agent assignAnAgent(Map<Integer, Agent> availableAgentMap);
}
