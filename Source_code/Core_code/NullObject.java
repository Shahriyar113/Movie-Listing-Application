package Source_code.Core_code;

import java.util.ArrayList;

//This "NullMovie" class is used to follow "null object pattern" to avoid null pointer exception
class NullMovie extends Movie{

    public NullMovie() {
        super(null, new ArrayList<>(), null, null,0);
    }
    
    @Override
    public String getTitle() {
        return "Movie not found";
    }

    @Override
    public String getDetails() {
        return "N/A";
    }
}
