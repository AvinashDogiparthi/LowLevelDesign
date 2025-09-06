package CronParserDesign.ParsingStratergy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import CronParserDesign.Chain.*;
import CronParserDesign.Constants.*;
import CronParserDesign.Exceptions.*;
import CronParserDesign.ParsingStratergy.*;
import CronParserDesign.Constants.*;
import CronParserDesign.Utils.*;

import static CronParserDesign.Constants.cronExpressionConstants.STAR;

public class RangeAndStepParsingStratergy implements ParsingStratergy {

    @Override
    public void parse(String partialString, CronChainHandler handler, Map<String, List<Integer>> result) {
        List<Integer> vals = new ArrayList<>();
        String arr[] = partialString.split("/");
        String range = arr[0];
        String step = arr.length == 2 ? arr[1] : null;

        //process range
        String arr2[] = range.split("-");
        String from = arr2[0];
        String to = arr2.length == 2 ? arr2[1] : null;

        if (STAR.equals(from)) {
            ParsingStratergy parsingStratergy = ParsingStratergiesFactory.getParsingStratergy(from);
            parsingStratergy.parse(from, handler, result);
        } else {
            if (ExpressionDetermineUtils.months.contains(from) && ExpressionDetermineUtils.months.contains(to)) {
                from = String.valueOf(ExpressionDetermineUtils.months.indexOf(from) + 1);
                to = String.valueOf(ExpressionDetermineUtils.months.indexOf(to) + 1);
            } else if (ExpressionDetermineUtils.months.contains(from) || ExpressionDetermineUtils.months.contains(to)) {
                throw new InvalidCronExpression("invalid");
            }
            if (ExpressionDetermineUtils.days.contains(from) && ExpressionDetermineUtils.days.contains(to)) {
                from = String.valueOf(ExpressionDetermineUtils.days.indexOf(from) + 1);
                to = String.valueOf(ExpressionDetermineUtils.days.indexOf(to) + 1);
            } else if (ExpressionDetermineUtils.days.contains(from) || ExpressionDetermineUtils.days.contains(to)) {
                throw new InvalidCronExpression("invalid");
            }
            int fromVal;
            int toVal;
            try {
                fromVal = Integer.parseInt(from);
                toVal = Integer.parseInt(to);
            } catch (NumberFormatException e) {
                throw new InvalidCronExpression("");
            }
            int increment = 1;
            if (!Objects.equals(step, null)) {
                try {
                    increment = Integer.parseInt(step);
                } catch (NumberFormatException e) {
                    throw new InvalidCronExpression("");
                }
            }
            for (int i = fromVal; i <= toVal - 1; i += increment) {
                vals.add(i);
            }
        }

        result.computeIfAbsent(handler.getParserName(), k -> new ArrayList<>()).addAll(vals);
    }
}
