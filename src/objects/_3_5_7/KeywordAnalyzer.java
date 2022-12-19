package objects._3_5_7;

public abstract class KeywordAnalyzer implements TextAnalyzer {

    @Override
    public Label processText(String text) {


        for (String keyword : getKeywords()) {
            if (text.contains(keyword)) {
                return getLabel();
            }
        }
        return Label.OK;
    }

    protected abstract String[] getKeywords();

    protected abstract Label getLabel();
}
