package org.catacombae.xml.apx;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/xml/apx/ParseException.class
 */
/* loaded from: hfsx_dmglib.jar:org/catacombae/xml/apx/ParseException.class */
public class ParseException extends Exception {
    protected boolean specialConstructor;
    public Token currentToken;
    public int[][] expectedTokenSequences;
    public String[] tokenImage;
    protected String eol;

    public ParseException(Token currentTokenVal, int[][] expectedTokenSequencesVal, String[] tokenImageVal) {
        super("");
        this.eol = System.getProperty("line.separator", "\n");
        this.specialConstructor = true;
        this.currentToken = currentTokenVal;
        this.expectedTokenSequences = expectedTokenSequencesVal;
        this.tokenImage = tokenImageVal;
    }

    public ParseException() {
        this.eol = System.getProperty("line.separator", "\n");
        this.specialConstructor = false;
    }

    public ParseException(String message) {
        super(message);
        this.eol = System.getProperty("line.separator", "\n");
        this.specialConstructor = false;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String retval;
        if (!this.specialConstructor) {
            return super.getMessage();
        }
        StringBuffer expected = new StringBuffer();
        int maxSize = 0;
        for (int i2 = 0; i2 < this.expectedTokenSequences.length; i2++) {
            if (maxSize < this.expectedTokenSequences[i2].length) {
                maxSize = this.expectedTokenSequences[i2].length;
            }
            for (int j = 0; j < this.expectedTokenSequences[i2].length; j++) {
                expected.append(this.tokenImage[this.expectedTokenSequences[i2][j]]).append(" ");
            }
            if (this.expectedTokenSequences[i2][this.expectedTokenSequences[i2].length - 1] != 0) {
                expected.append("...");
            }
            expected.append(this.eol).append("    ");
        }
        String retval2 = "Encountered \"";
        Token tok = this.currentToken.next;
        int i3 = 0;
        while (true) {
            if (i3 >= maxSize) {
                break;
            }
            if (i3 != 0) {
                retval2 = retval2 + " ";
            }
            if (tok.kind == 0) {
                retval2 = retval2 + this.tokenImage[0];
                break;
            }
            retval2 = retval2 + add_escapes(tok.image);
            tok = tok.next;
            i3++;
        }
        String retval3 = (retval2 + "\" at line " + this.currentToken.next.beginLine + ", column " + this.currentToken.next.beginColumn) + "." + this.eol;
        if (this.expectedTokenSequences.length == 1) {
            retval = retval3 + "Was expecting:" + this.eol + "    ";
        } else {
            retval = retval3 + "Was expecting one of:" + this.eol + "    ";
        }
        return retval + expected.toString();
    }

    protected String add_escapes(String str) {
        StringBuffer retval = new StringBuffer();
        for (int i2 = 0; i2 < str.length(); i2++) {
            switch (str.charAt(i2)) {
                case 0:
                    break;
                case '\b':
                    retval.append("\\b");
                    break;
                case '\t':
                    retval.append("\\t");
                    break;
                case '\n':
                    retval.append("\\n");
                    break;
                case '\f':
                    retval.append("\\f");
                    break;
                case '\r':
                    retval.append("\\r");
                    break;
                case '\"':
                    retval.append("\\\"");
                    break;
                case '\'':
                    retval.append("\\'");
                    break;
                case '\\':
                    retval.append("\\\\");
                    break;
                default:
                    char ch = str.charAt(i2);
                    if (ch < ' ' || ch > '~') {
                        String s = "0000" + Integer.toString(ch, 16);
                        retval.append("\\u" + s.substring(s.length() - 4, s.length()));
                        break;
                    } else {
                        retval.append(ch);
                        break;
                    }
                    break;
            }
        }
        return retval.toString();
    }
}
