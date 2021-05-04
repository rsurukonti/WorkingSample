package com.company;


public class MusicEntity {

    private String title_of_song;
    private String interpreter;
    private String album;
    private String year_of_publication;
    private String comment;
    private String genre;



    public String getTitle_of_song() {
        return title_of_song;
    }

    public void setTitle_of_song(String title_of_song) {
        this.title_of_song = title_of_song;
    }

    public String getInterpreter() {
        return interpreter;
    }

    public void setInterpreter(String interpreter) {
        this.interpreter = interpreter;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear_of_publication() {
        return year_of_publication;
    }

    public void setYear_of_publication(String year_of_publication) {
        this.year_of_publication = year_of_publication;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

