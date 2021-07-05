package frontend.pages.google.components;

import java.util.ArrayList;

public class GoogleSearchResults extends ArrayList<GoogleSearchResult> {

    public GoogleSearchResult getFirst() {
        return this.get(0);
    }
}
