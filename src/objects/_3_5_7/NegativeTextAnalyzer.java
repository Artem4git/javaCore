package objects._3_5_7;

public class NegativeTextAnalyzer extends KeywordAnalyzer {

    private String[] keywords = new String[]{":(", "=(", ":|"};

    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }
}
