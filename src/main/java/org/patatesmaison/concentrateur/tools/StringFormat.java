package org.patatesmaison.concentrateur.tools;


import org.springframework.util.StringUtils;

public class StringFormat {

    public StringFormat() {
        // Hide default constructor
    }

    public static String getContent(String[] content, int position) {
        String result = "";

        if (content != null && content.length > position) {
            result = content[position];
        }
        return result;
    }

}
