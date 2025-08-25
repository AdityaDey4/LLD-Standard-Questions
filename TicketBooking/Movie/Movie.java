package Movie;

public class Movie {

    private String name;
    private String releaseDate;
    private String language;
    private String description;

    public Movie(String name, String rd, String ln, String des) {
        this.name = name;
        this.releaseDate = rd;
        this.language = ln;
        this.description = des;
    }

    public String getName() {
        return this.name;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getLanguage() {
        return language;
    }

    public String getDescription() {
        return description;
    }
}