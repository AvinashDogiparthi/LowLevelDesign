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

import static CronParserDesign.Constants.TimeMeasurmentConstants.YEAR;

public class YearParser extends CronChainHandler {

    public String getParserName() {
        return YEAR;
    }

    public static List<Integer> allYears = new ArrayList<>();

    static {
        for (int i = 2025; i <= 2200; i++) {
            allYears.add(i);
        }
    }

    @Override
    public List<Integer> getAllValues() {
        return allYears;
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
            return Integer.parseInt(value) >= 2025 && Integer.parseInt(value) <= 2300;
        } catch (NumberFormatException e) {
            throw new InvalidCronExpression(e.getMessage());
        }
    }
}
