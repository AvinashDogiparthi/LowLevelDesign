package R_IssueResolvingSystem.Issue;

import R_IssueResolvingSystem.Agent.Agent;

public class Issue {

    private int issueId;
    private IssueTypeEnum issueTypeEnum;
    private Agent assignedAgent;

    public Issue(int issueId, IssueTypeEnum issueTypeEnum) {
        this.issueId = issueId;
        this.issueTypeEnum = issueTypeEnum;
    }

    public int getIssueId() {
        return issueId;
    }

    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

    public IssueTypeEnum getIssueTypeEnum() {
        return issueTypeEnum;
    }

    public void setIssueTypeEnum(IssueTypeEnum issueTypeEnum) {
        this.issueTypeEnum = issueTypeEnum;
    }

    public Agent getAssignedAgent() {
        return assignedAgent;
    }

    public void setAssignedAgent(Agent assignedAgent) {
        this.assignedAgent = assignedAgent;
    }
}
