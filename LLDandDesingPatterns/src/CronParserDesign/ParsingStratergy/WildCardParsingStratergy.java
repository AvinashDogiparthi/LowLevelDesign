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

import static CronParserDesign.Constants.TimeMeasurmentConstants.DAY_OF_MONTH;
import static CronParserDesign.Constants.TimeMeasurmentConstants.DAY_OF_WEEK;
import static CronParserDesign.Constants.cronExpressionConstants.QUESTION_MARK;
import static CronParserDesign.Constants.cronExpressionConstants.STAR;

public class WildCardParsingStratergy implements ParsingStratergy {

    @Override
    public void parse(String partialString, CronChainHandler handler, Map<String, List<Integer>> result) {
        List<Integer> vals = new ArrayList<>();
        if (QUESTION_MARK.equals(partialString) && (DAY_OF_WEEK.equals(handler.getParserName()) || DAY_OF_MONTH.equals(handler.getParserName()))) {

        } else if (QUESTION_MARK.equals(partialString)) {
            throw new InvalidCronExpression("either day of week or day of month should be optional");
        } else if (STAR.equals(partialString)) {
            vals.addAll(handler.getAllValues());
        }
        result.computeIfAbsent(handler.getParserName(), k -> new ArrayList<>()).addAll(vals);
    }
}
