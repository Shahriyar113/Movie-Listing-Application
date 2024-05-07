package Source_code;

import java.util.ArrayList;

class nullMovie extends Movie{

    public nullMovie() {
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
