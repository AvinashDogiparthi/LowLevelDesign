package R_IssueResolvingSystem.AgentStrategy;

public class AgentStrategyFactory {

    public static AgentStrategy getStrategy(AgentStrategyEnum agentStrategyEnum){

        if(agentStrategyEnum == AgentStrategyEnum.IMMEDIATE){
            return new AgentWithImmediateResponse();
        }

        return new AgentWithMoreExperience();
    }
}
