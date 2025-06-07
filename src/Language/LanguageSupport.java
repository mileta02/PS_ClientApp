/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Language;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author milan
 */
public class LanguageSupport {
    private static Locale locale = new Locale("sr");
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("language.text", locale);
    
    
    public static void setLanguage(String language){
        if(language.contains("English") || language.contains("Engleski"))
            locale = new Locale("en");
        else
            locale = new Locale("sr");
        resourceBundle = ResourceBundle.getBundle("language.text", locale);
    }
    
    public static String getCurrentLanguageCode() {
        return locale.getLanguage(); 
    }
    
    public static String getText(String key){
        return resourceBundle.getString(key);
    }
}
