package R_IssueResolvingSystem.Agent;

import R_IssueResolvingSystem.Issue.Issue;
import R_IssueResolvingSystem.Issue.IssueTypeEnum;

import java.util.*;

public class Agent {

    private int agentId;
    private Queue<Issue> agentIssueQueue;
    private Map<IssueTypeEnum, Integer> issueTypeEnumCountMap;

    public Agent(int agentId) {
        this.agentId = agentId;
        this.agentIssueQueue = new LinkedList<>();
        this.issueTypeEnumCountMap = new HashMap<>();
    }

    public void addIssueIntoQueue(Issue issue){

        IssueTypeEnum issueTypeEnum = issue.getIssueTypeEnum();
        if(issueTypeEnumCountMap.containsKey(issueTypeEnum)){
            int currentValue = issueTypeEnumCountMap.get(issueTypeEnum);
            issueTypeEnumCountMap.put(issueTypeEnum,currentValue+1);
        } else {
            issueTypeEnumCountMap.put(issueTypeEnum,1);
        }
        this.agentIssueQueue.add(issue);
    }

    public Map<Integer,Issue> issuesList(){

        Map<Integer, Issue> issueMap = new HashMap<>();
        Iterator iterator = agentIssueQueue.iterator();
        while(iterator.hasNext()){
            Issue issue = (Issue) iterator.next();
            issueMap.put(issue.getIssueId(), issue);
        }

        return issueMap;
    }

    public int numberOfSpecifiedTicketsSolved(IssueTypeEnum issueTypeEnum){
        return issueTypeEnumCountMap.get(issueTypeEnum);
    }

    public int numberOfTicketsSolved(){
        int count = 0;

        for(int value : issueTypeEnumCountMap.values()){
            count = count + value;
        }

        return count;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }
}
