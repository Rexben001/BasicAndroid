package com.android.rexben.associateexam1;

class Sport {

    // Member variables representing the title and information about the sport.
    private String title;
    private String info;
    private int imageResource;

    /**
     * Constructor for the Sport data model.
     *
     * @param title The name if the sport.
     * @param info Information about the sport.
     */
    Sport(String title, String info, int image) {
        this.title = title;
        this.info = info;
        imageResource = image;
    }

    /**
     * Gets the title of the sport.
     *
     * @return The title of the sport.
     */
    String getTitle() {
        return title;
    }

    /**
     * Gets the info about the sport.
     *
     * @return The info about the sport.
     */
    String getInfo() {
        return info;
    }


    /**
     * Gets the image about the sport.
     *
     * @return The image about the sport.
     */
    public int getImageResource() {
        return imageResource;
    }
}

