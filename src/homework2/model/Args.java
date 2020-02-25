package homework2.model;

public class Args {
    public int getDeveloperId() {
        return developerId;
    }

    public int getTesterId() {
        return testerId;
    }

    public String getErrorText() {
        return errorText;
    }

    @Override
    public String toString() {
        return "Args{" +
                "developerId=" + developerId +
                ", testerId=" + testerId +
                ", errorText='" + errorText + '\'' +
                '}';
    }

    private int developerId;
    private int testerId;
    private String errorText = "";

    static Builder newBuilder() {
        return (new Args()).new Builder();
    }

    class Builder {
        private Builder() {
        }

        Builder setDeveloperId(int developerId) {
            Args.this.developerId = developerId;
            return this;
        }

        Builder setTesterId(int testerId) {
            Args.this.testerId = testerId;
            return this;
        }

        Builder setErrorText(String errorText) {
            Args.this.errorText = errorText;
            return this;
        }

        Args build() {
            return Args.this;
        }
    }
}
