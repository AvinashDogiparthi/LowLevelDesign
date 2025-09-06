package CronParserDesign.ParsingStratergy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import CronParserDesign.Chain.*;
import CronParserDesign.Constants.*;
import CronParserDesign.Exceptions.*;
import CronParserDesign.ParsingStratergy.*;
import CronParserDesign.Constants.*;
import CronParserDesign.Utils.*;

import static CronParserDesign.Constants.TimeMeasurmentConstants.DAY_OF_WEEK;
import static CronParserDesign.Constants.TimeMeasurmentConstants.MONTH;

public class SingleValueParsingStratergy implements ParsingStratergy {

    @Override
    public void parse(String partialString, CronChainHandler handler, Map<String, List<Integer>> result) {

        List<Integer> vals = new ArrayList<>();
        if (handler.isInputWithInConstraints(partialString)) {
            if (MONTH.equals(handler.getParserName())) {
                vals.add(ExpressionDetermineUtils.months.indexOf(partialString) + 1);
            } else if (DAY_OF_WEEK.equals(handler.getParserName())) {
                vals.add(ExpressionDetermineUtils.days.indexOf(partialString) + 1);
            } else {
                vals.add(Integer.parseInt(partialString));
            }
        }
        result.computeIfAbsent(handler.getParserName(), k -> new ArrayList<>()).addAll(vals);
    }
}
