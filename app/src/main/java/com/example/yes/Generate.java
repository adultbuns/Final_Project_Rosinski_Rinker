package com.example.yes;

public class Generate {

    /**
     *
     * @return the Web API insult
     */
    public static String webInsult() {
        String out = "Generated insult";
        return out;
    }

    /**
     *
     * @return the Web API complement
     */
    public static String webComplement() {
        String out = "Generated Complement";
        return out;
    }

    /**
     *
     * @return a big set of text. the complement will be part of it.
     */
    public static String complementBlock() {
        return webComplement();
    }

    /**
     *
     * @return a block of text. the complement will be part of it.
     */
    public static String insultBlock() {
        return webInsult();
    }

}
