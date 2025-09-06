package CronParserDesign.ParsingStratergy;

import CronParserDesign.Chain.*;
import CronParserDesign.Constants.*;
import CronParserDesign.Exceptions.*;
import CronParserDesign.ParsingStratergy.*;
import CronParserDesign.Constants.*;
import CronParserDesign.Utils.*;

public class ParsingStratergiesFactory {

    private static RangeAndStepParsingStratergy rangeAndStepParsingStratergy = new RangeAndStepParsingStratergy();
    private static WildCardParsingStratergy wildCardParsingStratergy = new WildCardParsingStratergy();
    private static ListParsingStratergy listParsingStratergy = new ListParsingStratergy();
    private static SpecialCharacterParsingStratergy specialCharacterParsingStratergy = new SpecialCharacterParsingStratergy();
    private static SingleValueParsingStratergy singleValueParsingStratergy = new SingleValueParsingStratergy();

    public static ParsingStratergy getParsingStratergy(String stringToBeParsed) {
        if (ExpressionDetermineUtils.isRangeOrStepExpression(stringToBeParsed)) {
            return rangeAndStepParsingStratergy;
        } else if (ExpressionDetermineUtils.doesContainOnlyWildCard(stringToBeParsed)) {
            return wildCardParsingStratergy;
        } else if (ExpressionDetermineUtils.isCommaSeperatedListExpression(stringToBeParsed)) {
            return listParsingStratergy;
        } else if (ExpressionDetermineUtils.isOnlySpecialCharacters(stringToBeParsed)) {
            return specialCharacterParsingStratergy;
        } else if (ExpressionDetermineUtils.isSingleValue(stringToBeParsed)) {
            return singleValueParsingStratergy;
        } else {
            throw new InvalidCronExpression("second's section is in invalid format");
        }
    }
}
