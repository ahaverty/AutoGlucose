/**
 * 
 */
package com.ahaverty.autoglucose.file;

/**
 * @author Alan Haverty
 *
 */
public class RegexFileFilter implements java.io.FileFilter {

    final java.util.regex.Pattern pattern;

    public RegexFileFilter(String regex) {
        pattern = java.util.regex.Pattern.compile(regex);
    }

    public boolean accept(java.io.File f) {
        return pattern.matcher(f.getName()).find();
    }

}
