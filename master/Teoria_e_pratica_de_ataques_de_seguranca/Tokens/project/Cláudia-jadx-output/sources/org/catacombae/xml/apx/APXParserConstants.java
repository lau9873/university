package org.catacombae.xml.apx;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/xml/apx/APXParserConstants.class
 */
/* loaded from: hfsx_dmglib.jar:org/catacombae/xml/apx/APXParserConstants.class */
public interface APXParserConstants {
    public static final int EOF = 0;
    public static final int SINGLE_S = 1;
    public static final int CHAR = 2;
    public static final int NAME = 3;
    public static final int NAMESTART = 4;
    public static final int NAMECHAR = 5;
    public static final int LETTER = 6;
    public static final int BASECHAR = 7;
    public static final int IDEOGRAPHIC = 8;
    public static final int COMBININGCHAR = 9;
    public static final int DIGIT = 10;
    public static final int EXTENDER = 11;
    public static final int REFERENCE = 12;
    public static final int ENTITYREF = 13;
    public static final int CHARREF = 14;
    public static final int STARTTAG = 16;
    public static final int STARTCLOSINGTAG = 17;
    public static final int STARTPI = 18;
    public static final int STARTXMLDECL = 19;
    public static final int STARTDOCTYPEDECL = 20;
    public static final int STARTCOMMENT = 21;
    public static final int STARTCDATA = 22;
    public static final int CHARDATA = 23;
    public static final int DEFAULT_REFERENCE = 24;
    public static final int ENDXMLDECL = 25;
    public static final int XMLDECL_EQ = 26;
    public static final int XD_DQUOTE_OPEN = 27;
    public static final int XD_SQUOTE_OPEN = 28;
    public static final int VERSION = 29;
    public static final int ENCODING = 30;
    public static final int STANDALONE = 31;
    public static final int XD_DQUOTE_STRING = 33;
    public static final int XD_DQUOTE_CLOSE = 34;
    public static final int XD_SQUOTE_STRING = 35;
    public static final int XD_SQUOTE_CLOSE = 36;
    public static final int VERSION_DOPEN = 37;
    public static final int VERSION_DCLOSE = 38;
    public static final int VERSION_SOPEN = 39;
    public static final int VERSION_SCLOSE = 40;
    public static final int VER = 41;
    public static final int STANDALONE_DOPEN = 42;
    public static final int STANDALONE_DCLOSE = 43;
    public static final int STANDALONE_SOPEN = 44;
    public static final int STANDALONE_SCLOSE = 45;
    public static final int STANDALONE_YES = 46;
    public static final int STANDALONE_NO = 47;
    public static final int WDD_NAME = 48;
    public static final int ENDDOCTYPEDECL = 49;
    public static final int EXTERNALID = 50;
    public static final int SYSTEMLITERAL = 51;
    public static final int PUBIDLITERAL = 52;
    public static final int PUBIDCHAR = 53;
    public static final int BEGIN_INTSUBSET = 54;
    public static final int END_INTSUBSET = 56;
    public static final int WHATEVER = 57;
    public static final int ENDCOMMENT = 58;
    public static final int COMMENT_ILLEGAL = 59;
    public static final int COMMENT_CHAR = 60;
    public static final int ENDPI = 61;
    public static final int ILLEGALTARGET = 62;
    public static final int PITARGET = 63;
    public static final int WITHINPI_S = 64;
    public static final int PC_CHAR = 65;
    public static final int WT_EQ = 66;
    public static final int WT_NAME = 67;
    public static final int WT_DQUOTE = 68;
    public static final int WT_SQUOTE = 69;
    public static final int EMPTY_ENDTAG = 70;
    public static final int ENDTAG = 71;
    public static final int ATTR_DQUOTE = 73;
    public static final int ATTR_SQUOTE = 74;
    public static final int ATTR_DQUOTE_STRING = 75;
    public static final int ATTR_SQUOTE_STRING = 76;
    public static final int ATTR_REFERENCE = 77;
    public static final int ENDCDATA = 78;
    public static final int WCD_CHAR = 79;
    public static final int WithinCData = 0;
    public static final int Attribute = 1;
    public static final int WithinTag = 2;
    public static final int WithinPIContent = 3;
    public static final int WithinPI = 4;
    public static final int Comment = 5;
    public static final int WithinIntSubset = 6;
    public static final int WithinDoctypeDecl = 7;
    public static final int WithinXMLDecl_Standalone = 8;
    public static final int WithinXMLDecl_Version = 9;
    public static final int WithinXMLDecl_SquoteString = 10;
    public static final int WithinXMLDecl_DquoteString = 11;
    public static final int WithinXMLDecl = 12;
    public static final int DEFAULT = 13;
    public static final String[] tokenImage = {"<EOF>", "<SINGLE_S>", "<CHAR>", "<NAME>", "<NAMESTART>", "<NAMECHAR>", "<LETTER>", "<BASECHAR>", "<IDEOGRAPHIC>", "<COMBININGCHAR>", "<DIGIT>", "<EXTENDER>", "<REFERENCE>", "<ENTITYREF>", "<CHARREF>", "<token of kind 15>", "\"<\"", "\"</\"", "\"<?\"", "\"<?xml\"", "\"<!DOCTYPE\"", "\"<!--\"", "\"<![CDATA[\"", "<CHARDATA>", "<DEFAULT_REFERENCE>", "\"?>\"", "\"=\"", "\"\\\"\"", "\"\\'\"", "\"version\"", "\"encoding\"", "\"standalone\"", "<token of kind 32>", "<XD_DQUOTE_STRING>", "\"\\\"\"", "<XD_SQUOTE_STRING>", "\"\\'\"", "\"=\\\"\"", "\"\\\"\"", "\"=\\'\"", "\"\\'\"", "\"1.0\"", "\"=\\\"\"", "\"\\\"\"", "\"=\\'\"", "\"\\'\"", "\"yes\"", "\"no\"", "<WDD_NAME>", "\">\"", "<EXTERNALID>", "<SYSTEMLITERAL>", "<PUBIDLITERAL>", "<PUBIDCHAR>", "\"[\"", "<token of kind 55>", "\"]\"", "<WHATEVER>", "\"-->\"", "\"--\"", "<COMMENT_CHAR>", "\"?>\"", "<ILLEGALTARGET>", "<PITARGET>", "<WITHINPI_S>", "<PC_CHAR>", "\"=\"", "<WT_NAME>", "\"\\\"\"", "\"\\'\"", "\"/>\"", "\">\"", "<token of kind 72>", "\"\\\"\"", "\"\\'\"", "<ATTR_DQUOTE_STRING>", "<ATTR_SQUOTE_STRING>", "<ATTR_REFERENCE>", "\"]]>\"", "<WCD_CHAR>"};
}
