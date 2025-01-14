package org.catacombae.xml.apx;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/xml/apx/Token.class
 */
/* loaded from: hfsx_dmglib.jar:org/catacombae/xml/apx/Token.class */
public class Token {
    public int kind;
    public int beginLine;
    public int beginColumn;
    public int endLine;
    public int endColumn;
    public String image;
    public Token next;
    public Token specialToken;

    public String toString() {
        return this.image;
    }

    public static final Token newToken(int ofKind) {
        switch (ofKind) {
            default:
                return new Token();
        }
    }
}
