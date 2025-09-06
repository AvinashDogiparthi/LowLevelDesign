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

import static CronParserDesign.Constants.TimeMeasurmentConstants.HOUR;

public class HourParser extends CronChainHandler {

    public String getParserName() {
        return HOUR;
    }

    public static List<Integer> allHours = new ArrayList<>();

    static {
        for (int i = 0; i <= 23; i++) {
            allHours.add(i);
        }
    }

    @Override
    public List<Integer> getAllValues() {
        return allHours;
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
            return Integer.parseInt(value) >= 0 && Integer.parseInt(value) <= 23;
        } catch (NumberFormatException e) {
            throw new InvalidCronExpression("hours format is incorrect");
        }
    }
}
