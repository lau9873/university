package org.catacombae.hfsexplorer.testcode;

import java.util.regex.Pattern;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/testcode/TestRegexp.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/testcode/TestRegexp.class */
public class TestRegexp {
    public static void main(String[] args) {
        String regexp = args[0];
        String testString = args[1];
        System.out.println(Pattern.matches(regexp, testString));
    }
}
