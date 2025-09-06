package CronParserDesign.Chain;

import CronParserDesign.Chain.*;
import CronParserDesign.Constants.*;
import CronParserDesign.Exceptions.*;
import CronParserDesign.ParsingStratergy.*;
import CronParserDesign.Constants.*;
import CronParserDesign.Utils.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static CronParserDesign.Constants.TimeMeasurmentConstants.DAY_OF_MONTH;

public class DayOfMonthParser extends CronChainHandler {

    public String getParserName() {
        return DAY_OF_MONTH;
    }

    public static List<Integer> allDaysOfMonths = new ArrayList<>();

    static {
        for (int i = 1; i <= 31; i++) {
            allDaysOfMonths.add(i);
        }
    }

    @Override
    public List<Integer> getAllValues() {
        return allDaysOfMonths;
    }

    @Override
    public void Handle(String[] arr, int index, Map<String, List<Integer>> result) {
        String stringToBeParsed = arr[index];
        ParsingStratergy parsingStratergy = ParsingStratergiesFactory.getParsingStratergy(stringToBeParsed);
        parsingStratergy.parse(stringToBeParsed, this, result);
        this.nextHandler.Handle(arr, index + 1, result);
    }

    @Override
    public boolean isInputWithInConstraints(String value) {
        try {
            return Integer.parseInt(value) >= 1 && Integer.parseInt(value) <= 31;
        } catch (NumberFormatException e) {
            throw new InvalidCronExpression(e.getMessage());
        }
    }
}
