package R_IssueResolvingSystem.Agent;

import R_IssueResolvingSystem.AgentStrategy.AgentStrategy;
import R_IssueResolvingSystem.AgentStrategy.AgentStrategyEnum;
import R_IssueResolvingSystem.AgentStrategy.AgentWithImmediateResponse;
import R_IssueResolvingSystem.AgentStrategy.AgentWithMoreExperience;

public class AgentFactory {

    public static AgentStrategy getStrategy(AgentStrategyEnum agentStrategyEnum){

        if(agentStrategyEnum == AgentStrategyEnum.IMMEDIATE){
            return new AgentWithImmediateResponse();
        }

        return new AgentWithMoreExperience();
    }
}
