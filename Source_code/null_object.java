package Source_code;

class nullMovie extends Movie{

    nullMovie() {
        super(null, null, null, null,0);
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
