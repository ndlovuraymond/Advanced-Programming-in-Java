package smartphone.compare;

public interface Device {
    // Abstract methods (no method body)
    String getName();
    void setName(String name);

    int getReleaseYear();
    void setReleaseYear(int releaseYear);

    double getUserRating();
    void setUserRating(double userRating);
}

