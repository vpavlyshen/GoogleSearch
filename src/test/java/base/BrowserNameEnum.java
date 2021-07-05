package base;

public enum BrowserNameEnum  {
        CHROME("Chrome"),
        FIREFOX("Firefox"),
        OPERA("Opera"),
        EDGE("Edge");

        private final String browserName;

        private BrowserNameEnum(String browserName) {
            this.browserName = browserName;
        }

        public String getBrowserName() {
            return this.browserName;
        }
    }


