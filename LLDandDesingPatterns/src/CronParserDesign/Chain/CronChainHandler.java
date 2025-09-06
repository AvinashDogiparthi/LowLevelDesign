package CronParserDesign.Chain;

import java.util.List;
import java.util.Map;

public abstract class CronChainHandler {

    protected CronChainHandler nextHandler;

    public abstract String getParserName();

    public abstract List<Integer> getAllValues();

    public abstract void Handle(String arr[], int index, Map<String, List<Integer>> result);

    public void setNextHandler(CronChainHandler cronChainHandler) {
        this.nextHandler = cronChainHandler;
    }

    public abstract boolean isInputWithInConstraints(String value);
}
