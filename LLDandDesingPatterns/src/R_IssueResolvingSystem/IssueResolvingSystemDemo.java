package R_IssueResolvingSystem;

import R_IssueResolvingSystem.AgentStrategy.AgentStrategyEnum;
import R_IssueResolvingSystem.Issue.Issue;
import R_IssueResolvingSystem.Issue.IssueTypeEnum;

public class IssueResolvingSystemDemo {

    public static void main(String[] args) {
        AgentService agentService = AgentService.getInstance();

        Issue issue1 = new Issue(112, IssueTypeEnum.MEDIUM);
        agentService.createIssue(issue1);

        Issue issue2 = new Issue(113,IssueTypeEnum.MEDIUM);
        agentService.createIssue(issue2, AgentStrategyEnum.MORE_EXPERIENCE);
    }
}
