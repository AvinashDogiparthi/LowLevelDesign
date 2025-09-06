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

import static CronParserDesign.Constants.TimeMeasurmentConstants.DAY_OF_WEEK;

public class DayOfWeekParser extends CronChainHandler {

    public String getParserName() {
        return DAY_OF_WEEK;
    }

    public static List<Integer> allDaysOfWeek = new ArrayList<>();

    static {
        for (int i = 1; i <= 7; i++) {
            allDaysOfWeek.add(i);
        }
    }

    @Override
    public List<Integer> getAllValues() {
        return List.of(1, 2, 3, 4, 5, 6, 7);
    }

    @Override
    public void Handle(String[] arr, int index, Map<String, List<Integer>> result) {
        String stringToBeParsed = arr[index];
        ParsingStratergy parsingStratergy = ParsingStratergiesFactory.getParsingStratergy(stringToBeParsed);
        parsingStratergy.parse(stringToBeParsed, this, result);
        if (index < arr.length - 1) {
            this.nextHandler.Handle(arr, index + 1, result);
        }
    }

    @Override
    public boolean isInputWithInConstraints(String value) {
        try {
            return Integer.parseInt(value) >= 1 && Integer.parseInt(value) <= 7;
        } catch (NumberFormatException e) {
            throw new InvalidCronExpression(e.getMessage());
        }
    }
}
