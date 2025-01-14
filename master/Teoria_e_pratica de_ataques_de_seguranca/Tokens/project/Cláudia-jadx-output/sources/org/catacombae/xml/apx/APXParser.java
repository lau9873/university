package org.catacombae.xml.apx;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.Vector;
import org.catacombae.xml.Attribute;
import org.catacombae.xml.DebugXMLContentHandler;
import org.catacombae.xml.NullXMLContentHandler;
import org.catacombae.xml.XMLContentHandler;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/xml/apx/APXParser.class
 */
/* loaded from: hfsx_dmglib.jar:org/catacombae/xml/apx/APXParser.class */
public class APXParser implements APXParserConstants {
    public static final String DEFAULT_ENCODING = "US-ASCII";
    private XMLContentHandler contentHandler;
    public APXParserTokenManager token_source;
    SimpleCharStream jj_input_stream;
    public Token token;
    public Token jj_nt;
    private int jj_ntk;
    private int jj_gen;
    private final int[] jj_la1;
    private static int[] jj_la1_0;
    private static int[] jj_la1_1;
    private static int[] jj_la1_2;
    private Vector jj_expentries;
    private int[] jj_expentry;
    private int jj_kind;

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            throw new RuntimeException("The only valid argument is the name of the input file!");
        }
        APXParser encodingParser = create(new InputStreamReader(new FileInputStream(args[0]), "US-ASCII"), new NullXMLContentHandler(Charset.forName("US-ASCII")));
        String encoding = null;
        try {
            encoding = encodingParser.xmlDecl();
        } catch (ParseException e2) {
        }
        if (encoding == null) {
            encoding = "US-ASCII";
        }
        InputStreamReader usedReader = new InputStreamReader(new FileInputStream(args[0]), encoding);
        APXParser a2 = create(usedReader, new DebugXMLContentHandler(Charset.forName(encoding)));
        a2.xmlDocument();
    }

    public static APXParser create(Reader misr, XMLContentHandler xch) {
        APXParser a2 = new APXParser(misr);
        a2.contentHandler = xch;
        return a2;
    }

    public final void xmlDocument() throws ParseException {
        prolog();
        element();
        while (true) {
            switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
                case 18:
                case 21:
                    misc();
                default:
                    this.jj_la1[0] = this.jj_gen;
                    jj_consume_token(0);
                    return;
            }
        }
    }

    public final void prolog() throws ParseException {
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 19:
                xmlDecl();
                break;
            default:
                this.jj_la1[1] = this.jj_gen;
                break;
        }
        while (true) {
            switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
                case 18:
                case 21:
                    misc();
                default:
                    this.jj_la1[2] = this.jj_gen;
                    switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
                        case 20:
                            doctypeDecl();
                            while (true) {
                                switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
                                    case 18:
                                    case 21:
                                        misc();
                                    default:
                                        this.jj_la1[3] = this.jj_gen;
                                        return;
                                }
                            }
                        default:
                            this.jj_la1[4] = this.jj_gen;
                            return;
                    }
            }
        }
    }

    public final String xmlDecl() throws ParseException {
        String encoding = null;
        Boolean standalone = null;
        jj_consume_token(19);
        String version = versionInfo();
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 30:
                encoding = encodingDecl();
                break;
            default:
                this.jj_la1[5] = this.jj_gen;
                break;
        }
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 31:
                standalone = Boolean.valueOf(sdDecl());
                break;
            default:
                this.jj_la1[6] = this.jj_gen;
                break;
        }
        jj_consume_token(25);
        this.contentHandler.xmlDecl(version, encoding, standalone);
        return encoding;
    }

    public final String versionInfo() throws ParseException {
        Token versionString;
        jj_consume_token(29);
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 37:
                jj_consume_token(37);
                versionString = jj_consume_token(41);
                jj_consume_token(38);
                break;
            case 39:
                jj_consume_token(39);
                versionString = jj_consume_token(41);
                jj_consume_token(40);
                break;
            default:
                this.jj_la1[7] = this.jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
        return versionString.image;
    }

    public final String encodingDecl() throws ParseException {
        Token encoding;
        jj_consume_token(30);
        jj_consume_token(26);
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 27:
                jj_consume_token(27);
                encoding = jj_consume_token(33);
                jj_consume_token(34);
                break;
            case 28:
                jj_consume_token(28);
                encoding = jj_consume_token(35);
                jj_consume_token(36);
                break;
            default:
                this.jj_la1[8] = this.jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
        return encoding.image;
    }

    public final boolean sdDecl() throws ParseException {
        boolean b2;
        jj_consume_token(31);
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 42:
                jj_consume_token(42);
                switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
                    case 46:
                        jj_consume_token(46);
                        b2 = true;
                        break;
                    case 47:
                        jj_consume_token(47);
                        b2 = false;
                        break;
                    default:
                        this.jj_la1[9] = this.jj_gen;
                        jj_consume_token(-1);
                        throw new ParseException();
                }
                jj_consume_token(43);
                break;
            case 44:
                jj_consume_token(44);
                switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
                    case 46:
                        jj_consume_token(46);
                        b2 = true;
                        break;
                    case 47:
                        jj_consume_token(47);
                        b2 = false;
                        break;
                    default:
                        this.jj_la1[10] = this.jj_gen;
                        jj_consume_token(-1);
                        throw new ParseException();
                }
                jj_consume_token(45);
                break;
            default:
                this.jj_la1[11] = this.jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
        return b2;
    }

    public final void doctypeDecl() throws ParseException {
        jj_consume_token(20);
        Token name = jj_consume_token(48);
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 50:
                jj_consume_token(50);
                break;
            default:
                this.jj_la1[12] = this.jj_gen;
                break;
        }
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 54:
                jj_consume_token(54);
                intSubset();
                break;
            default:
                this.jj_la1[13] = this.jj_gen;
                break;
        }
        jj_consume_token(49);
        this.contentHandler.doctype(name.image, null);
    }

    public final void intSubset() throws ParseException {
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 57:
                jj_consume_token(57);
                break;
            default:
                this.jj_la1[14] = this.jj_gen;
                break;
        }
        jj_consume_token(56);
    }

    public final void misc() throws ParseException {
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 18:
                pi();
                return;
            case 21:
                comment();
                return;
            default:
                this.jj_la1[15] = this.jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
    }

    public final void comment() throws ParseException {
        StringBuilder sb = new StringBuilder();
        jj_consume_token(21);
        while (true) {
            switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
                case 60:
                    Token t = jj_consume_token(60);
                    sb.append(t.image);
                default:
                    this.jj_la1[16] = this.jj_gen;
                    jj_consume_token(58);
                    this.contentHandler.comment(sb.toString());
                    return;
            }
        }
    }

    public final void pi() throws ParseException {
        StringBuilder content = null;
        jj_consume_token(18);
        Token target = jj_consume_token(63);
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 61:
                jj_consume_token(61);
                break;
            case 64:
                jj_consume_token(64);
                content = piContent();
                break;
            default:
                this.jj_la1[17] = this.jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
        this.contentHandler.pi(target.image, content.toString());
    }

    public final StringBuilder piContent() throws ParseException {
        int i2;
        StringBuilder sb = new StringBuilder();
        while (true) {
            switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
                case 61:
                    jj_consume_token(61);
                    break;
                case 65:
                    Token t = jj_consume_token(65);
                    sb.append(t.image);
                    break;
                default:
                    this.jj_la1[18] = this.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
            }
            if (this.jj_ntk == -1) {
                i2 = jj_ntk();
                continue;
            } else {
                i2 = this.jj_ntk;
                continue;
            }
            switch (i2) {
                case 61:
                case 65:
                    break;
                default:
                    this.jj_la1[19] = this.jj_gen;
                    return sb;
            }
        }
    }

    public final void element() throws ParseException {
        LinkedList<Attribute> attributes = new LinkedList<>();
        jj_consume_token(16);
        String name = elementname();
        while (true) {
            switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
                case 67:
                    Attribute currentAttribute = attribute();
                    attributes.add(currentAttribute);
                default:
                    this.jj_la1[20] = this.jj_gen;
                    switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
                        case 70:
                            jj_consume_token(70);
                            this.contentHandler.emptyElement(name, attributes);
                            return;
                        case 71:
                            jj_consume_token(71);
                            this.contentHandler.startElement(name, attributes);
                            content();
                            etag(name);
                            return;
                        default:
                            this.jj_la1[21] = this.jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                    }
            }
        }
    }

    public final String elementname() throws ParseException {
        Token t = jj_consume_token(67);
        return t.image;
    }

    public final Attribute attribute() throws ParseException {
        LinkedList<Attribute.ValueComponent> value = new LinkedList<>();
        String name = elementname();
        jj_consume_token(66);
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 68:
                jj_consume_token(68);
                while (true) {
                    switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
                        case 75:
                        case 77:
                            switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
                                case 75:
                                    Token t = jj_consume_token(75);
                                    value.add(new Attribute.StringComponent(t.image));
                                    break;
                                case 77:
                                    Token t2 = jj_consume_token(77);
                                    value.add(new Attribute.ReferenceComponent(t2.image));
                                    break;
                                default:
                                    this.jj_la1[23] = this.jj_gen;
                                    jj_consume_token(-1);
                                    throw new ParseException();
                            }
                        default:
                            this.jj_la1[22] = this.jj_gen;
                            jj_consume_token(73);
                            break;
                    }
                }
            case 69:
                jj_consume_token(69);
                while (true) {
                    switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
                        case 76:
                        case 77:
                            switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
                                case 76:
                                    Token t3 = jj_consume_token(76);
                                    value.add(new Attribute.StringComponent(t3.image));
                                    break;
                                case 77:
                                    Token t4 = jj_consume_token(77);
                                    value.add(new Attribute.ReferenceComponent(t4.image));
                                    break;
                                default:
                                    this.jj_la1[25] = this.jj_gen;
                                    jj_consume_token(-1);
                                    throw new ParseException();
                            }
                        default:
                            this.jj_la1[24] = this.jj_gen;
                            jj_consume_token(74);
                            break;
                    }
                }
            default:
                this.jj_la1[26] = this.jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
        return new Attribute(name, new Attribute.Value(value));
    }

    public final void etag(String startName) throws ParseException {
        jj_consume_token(17);
        String name = elementname();
        jj_consume_token(71);
        if (startName.equals(name)) {
            this.contentHandler.endElement(name);
            return;
        }
        throw new ParseException("Expected \"</" + startName + "\" but got \"</" + name + "\".");
    }

    public final void content() throws ParseException {
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 23:
                charData();
                break;
            default:
                this.jj_la1[27] = this.jj_gen;
                break;
        }
        while (true) {
            switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
                case 16:
                case 18:
                case 21:
                case 22:
                case 24:
                    switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
                        case 16:
                            element();
                            break;
                        case 17:
                        case 19:
                        case 20:
                        case 23:
                        default:
                            this.jj_la1[29] = this.jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                        case 18:
                            pi();
                            break;
                        case 21:
                            comment();
                            break;
                        case 22:
                            cdSect();
                            break;
                        case 24:
                            jj_consume_token(24);
                            break;
                    }
                    switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
                        case 23:
                            charData();
                            break;
                        default:
                            this.jj_la1[30] = this.jj_gen;
                            break;
                    }
                case 17:
                case 19:
                case 20:
                case 23:
                default:
                    this.jj_la1[28] = this.jj_gen;
                    return;
            }
        }
    }

    public final void charData() throws ParseException {
        int i2;
        int beginLine = -1;
        int beginColumn = -1;
        while (true) {
            Token t = jj_consume_token(23);
            if (beginLine == -1) {
                beginLine = t.beginLine;
                beginColumn = t.beginColumn;
            }
            if (this.jj_ntk == -1) {
                i2 = jj_ntk();
                continue;
            } else {
                i2 = this.jj_ntk;
                continue;
            }
            switch (i2) {
                case 23:
                    break;
                default:
                    this.jj_la1[31] = this.jj_gen;
                    this.contentHandler.chardata(beginLine, beginColumn, t.endLine, t.endColumn);
                    return;
            }
        }
    }

    public final void cdSect() throws ParseException {
        StringBuilder cdata = new StringBuilder();
        jj_consume_token(22);
        while (true) {
            switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
                case 78:
                case 79:
                    switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
                        case 78:
                            jj_consume_token(78);
                            break;
                        case 79:
                            Token t = jj_consume_token(79);
                            cdata.append(t.image);
                            break;
                        default:
                            this.jj_la1[33] = this.jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                    }
                default:
                    this.jj_la1[32] = this.jj_gen;
                    this.contentHandler.cdata(cdata.toString());
                    return;
            }
        }
    }

    static {
        jj_la1_0();
        jj_la1_1();
        jj_la1_2();
    }

    private static void jj_la1_0() {
        jj_la1_0 = new int[]{2359296, 524288, 2359296, 2359296, 1048576, 1073741824, Integer.MIN_VALUE, 0, 402653184, 0, 0, 0, 0, 0, 0, 2359296, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8388608, 23396352, 23396352, 8388608, 8388608, 0, 0};
    }

    private static void jj_la1_1() {
        jj_la1_1 = new int[]{0, 0, 0, 0, 0, 0, 0, 160, 0, 49152, 49152, 5120, 262144, 4194304, 33554432, 0, 268435456, 536870912, 536870912, 536870912, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    }

    private static void jj_la1_2() {
        jj_la1_2 = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 2, 8, 192, 10240, 10240, 12288, 12288, 48, 0, 0, 0, 0, 0, 49152, 49152};
    }

    public APXParser(InputStream stream) {
        this(stream, null);
    }

    public APXParser(InputStream stream, String encoding) {
        this.jj_la1 = new int[34];
        this.jj_expentries = new Vector();
        this.jj_kind = -1;
        try {
            this.jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1);
            this.token_source = new APXParserTokenManager(this.jj_input_stream);
            this.token = new Token();
            this.jj_ntk = -1;
            this.jj_gen = 0;
            for (int i2 = 0; i2 < 34; i2++) {
                this.jj_la1[i2] = -1;
            }
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    public void ReInit(InputStream stream) {
        ReInit(stream, null);
    }

    public void ReInit(InputStream stream, String encoding) {
        try {
            this.jj_input_stream.ReInit(stream, encoding, 1, 1);
            this.token_source.ReInit(this.jj_input_stream);
            this.token = new Token();
            this.jj_ntk = -1;
            this.jj_gen = 0;
            for (int i2 = 0; i2 < 34; i2++) {
                this.jj_la1[i2] = -1;
            }
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    public APXParser(Reader stream) {
        this.jj_la1 = new int[34];
        this.jj_expentries = new Vector();
        this.jj_kind = -1;
        this.jj_input_stream = new SimpleCharStream(stream, 1, 1);
        this.token_source = new APXParserTokenManager(this.jj_input_stream);
        this.token = new Token();
        this.jj_ntk = -1;
        this.jj_gen = 0;
        for (int i2 = 0; i2 < 34; i2++) {
            this.jj_la1[i2] = -1;
        }
    }

    public void ReInit(Reader stream) {
        this.jj_input_stream.ReInit(stream, 1, 1);
        this.token_source.ReInit(this.jj_input_stream);
        this.token = new Token();
        this.jj_ntk = -1;
        this.jj_gen = 0;
        for (int i2 = 0; i2 < 34; i2++) {
            this.jj_la1[i2] = -1;
        }
    }

    public APXParser(APXParserTokenManager tm) {
        this.jj_la1 = new int[34];
        this.jj_expentries = new Vector();
        this.jj_kind = -1;
        this.token_source = tm;
        this.token = new Token();
        this.jj_ntk = -1;
        this.jj_gen = 0;
        for (int i2 = 0; i2 < 34; i2++) {
            this.jj_la1[i2] = -1;
        }
    }

    public void ReInit(APXParserTokenManager tm) {
        this.token_source = tm;
        this.token = new Token();
        this.jj_ntk = -1;
        this.jj_gen = 0;
        for (int i2 = 0; i2 < 34; i2++) {
            this.jj_la1[i2] = -1;
        }
    }

    private final Token jj_consume_token(int kind) throws ParseException {
        Token oldToken = this.token;
        if (oldToken.next != null) {
            this.token = this.token.next;
        } else {
            Token token = this.token;
            Token nextToken = this.token_source.getNextToken();
            token.next = nextToken;
            this.token = nextToken;
        }
        this.jj_ntk = -1;
        if (this.token.kind == kind) {
            this.jj_gen++;
            return this.token;
        }
        this.token = oldToken;
        this.jj_kind = kind;
        throw generateParseException();
    }

    public final Token getNextToken() {
        if (this.token.next != null) {
            this.token = this.token.next;
        } else {
            Token token = this.token;
            Token nextToken = this.token_source.getNextToken();
            token.next = nextToken;
            this.token = nextToken;
        }
        this.jj_ntk = -1;
        this.jj_gen++;
        return this.token;
    }

    public final Token getToken(int index) {
        Token token;
        Token t = this.token;
        for (int i2 = 0; i2 < index; i2++) {
            if (t.next != null) {
                token = t.next;
            } else {
                Token nextToken = this.token_source.getNextToken();
                token = nextToken;
                t.next = nextToken;
            }
            t = token;
        }
        return t;
    }

    private final int jj_ntk() {
        Token token = this.token.next;
        this.jj_nt = token;
        if (token == null) {
            Token token2 = this.token;
            Token nextToken = this.token_source.getNextToken();
            token2.next = nextToken;
            int i2 = nextToken.kind;
            this.jj_ntk = i2;
            return i2;
        }
        int i3 = this.jj_nt.kind;
        this.jj_ntk = i3;
        return i3;
    }

    /* JADX WARN: Type inference failed for: r0v15, types: [int[], int[][]] */
    public ParseException generateParseException() {
        this.jj_expentries.removeAllElements();
        boolean[] la1tokens = new boolean[80];
        for (int i2 = 0; i2 < 80; i2++) {
            la1tokens[i2] = false;
        }
        if (this.jj_kind >= 0) {
            la1tokens[this.jj_kind] = true;
            this.jj_kind = -1;
        }
        for (int i3 = 0; i3 < 34; i3++) {
            if (this.jj_la1[i3] == this.jj_gen) {
                for (int j = 0; j < 32; j++) {
                    if ((jj_la1_0[i3] & (1 << j)) != 0) {
                        la1tokens[j] = true;
                    }
                    if ((jj_la1_1[i3] & (1 << j)) != 0) {
                        la1tokens[32 + j] = true;
                    }
                    if ((jj_la1_2[i3] & (1 << j)) != 0) {
                        la1tokens[64 + j] = true;
                    }
                }
            }
        }
        for (int i4 = 0; i4 < 80; i4++) {
            if (la1tokens[i4]) {
                this.jj_expentry = new int[1];
                this.jj_expentry[0] = i4;
                this.jj_expentries.addElement(this.jj_expentry);
            }
        }
        ?? r0 = new int[this.jj_expentries.size()];
        for (int i5 = 0; i5 < this.jj_expentries.size(); i5++) {
            r0[i5] = (int[]) this.jj_expentries.elementAt(i5);
        }
        return new ParseException(this.token, r0, tokenImage);
    }

    public final void enable_tracing() {
    }

    public final void disable_tracing() {
    }
}
