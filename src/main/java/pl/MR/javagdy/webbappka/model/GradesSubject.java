package pl.MR.javagdy.webbappka.model;

public enum GradesSubject {
    ENGLISH("English"),
    POLISH("Polish"),
    COMPUTER_SCIENCE("Computer and robots"),
    MATHEMATICS("Math"),
    PE("Wuef"),
    MUSIC_CLASS("Music");

    private String commonName;

    GradesSubject(String commonName) {
        this.commonName = commonName;
    }

    public String getCommonName(){
        return commonName;
    }
}
