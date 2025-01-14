package org.catacombae.xml.apx;

import com.j256.ormlite.field.DatabaseFieldConfigLoader;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.IOException;
import java.io.PrintStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/xml/apx/APXParserTokenManager.class
 */
/* loaded from: hfsx_dmglib.jar:org/catacombae/xml/apx/APXParserTokenManager.class */
public class APXParserTokenManager implements APXParserConstants {
    public PrintStream debugStream;
    static final long[] jjbitVec0 = {-2, -1, -1, -1};
    static final long[] jjbitVec2 = {0, 0, -1, -1};
    static final long[] jjbitVec3 = {0, -16384, -17590038560769L, 8388607};
    static final long[] jjbitVec4 = {0, 0, 0, -36028797027352577L};
    static final long[] jjbitVec5 = {9219994337134247935L, 9223372036854775294L, -1, -274156627316187121L};
    static final long[] jjbitVec6 = {16777215, -65536, -576458553280167937L, 3};
    static final long[] jjbitVec7 = {0, 0, -17179879616L, 4503588160110591L};
    static final long[] jjbitVec8 = {-8194, -536936449, -65533, 234134404065073567L};
    static final long[] jjbitVec9 = {-562949953421312L, -8547991553L, 127, 1979120929931264L};
    static final long[] jjbitVec10 = {576460743713488896L, -562949953419266L, 9007199254740991999L, 412319973375L};
    static final long[] jjbitVec11 = {2594073385365405664L, 17163091968L, 271902628478820320L, 844440767823872L};
    static final long[] jjbitVec12 = {247132830528276448L, 7881300924956672L, 2589004636761075680L, 4294967296L};
    static final long[] jjbitVec13 = {2579997437506199520L, 15837691904L, 270153412153034720L, 0};
    static final long[] jjbitVec14 = {283724577500946400L, 12884901888L, 283724577500946400L, 13958643712L};
    static final long[] jjbitVec15 = {288228177128316896L, 12884901888L, 0, 0};
    static final long[] jjbitVec16 = {3799912185593854L, 63, 2309621682768192918L, 31};
    static final long[] jjbitVec17 = {0, 4398046510847L, 0, 0};
    static final long[] jjbitVec18 = {0, 0, -4294967296L, 36028797018898495L};
    static final long[] jjbitVec19 = {5764607523034749677L, 12493387738468353L, -756383734487318528L, 144405459145588743L};
    static final long[] jjbitVec20 = {-1, -1, -4026531841L, 288230376151711743L};
    static final long[] jjbitVec21 = {-3233808385L, 4611686017001275199L, 6908521828386340863L, 2295745090394464220L};
    static final long[] jjbitVec22 = {83837761617920L, 0, 7, 0};
    static final long[] jjbitVec23 = {4389456576640L, -2, -8587837441L, 576460752303423487L};
    static final long[] jjbitVec24 = {35184372088800L, 0, 0, 0};
    static final long[] jjbitVec25 = {-1, -1, 274877906943L, 0};
    static final long[] jjbitVec26 = {-1, -1, 68719476735L, 0};
    static final long[] jjbitVec27 = {0, 0, 36028797018963968L, -36028797027352577L};
    static final long[] jjbitVec28 = {16777215, -65536, -576458553280167937L, 196611};
    static final long[] jjbitVec29 = {-1, 12884901951L, -17179879488L, 4503588160110591L};
    static final long[] jjbitVec30 = {-8194, -536936449, -65413, 234134404065073567L};
    static final long[] jjbitVec31 = {-562949953421312L, -8547991553L, -4899916411759099777L, 1979120929931286L};
    static final long[] jjbitVec32 = {576460743713488896L, -277081224642561L, 9007199254740991999L, 288017070894841855L};
    static final long[] jjbitVec33 = {-864691128455135250L, 281268803485695L, -3186861885341720594L, 1125692414638495L};
    static final long[] jjbitVec34 = {-3211631683292264476L, 9006925953907079L, -869759877059465234L, 281204393786303L};
    static final long[] jjbitVec35 = {-878767076314341394L, 281215949093263L, -4341532606274353172L, 280925229301191L};
    static final long[] jjbitVec36 = {-4327961440926441490L, 281212990012895L, -4327961440926441492L, 281214063754719L};
    static final long[] jjbitVec37 = {-4323457841299070996L, 281212992110031L, 0, 0};
    static final long[] jjbitVec38 = {576320014815068158L, 67076095, 4323293666156225942L, 67059551};
    static final long[] jjbitVec39 = {-4422530440275951616L, -558551906910465L, 215680200883507167L, 0};
    static final long[] jjbitVec40 = {0, 0, 0, 9126739968L};
    static final long[] jjbitVec41 = {17732914942836896L, -2, -6876561409L, 8646911284551352319L};
    static final long[] jjbitVec42 = {-2, -1, -1, 9223372032576585727L};
    static final long[] jjbitVec43 = {-1, -1, -1, 4611686018427387903L};
    static final int[] jjnextStates = {9, 10, 3, 4, 7, 16, 17, 25, 20, 21, 23, 18, 19, 26, 27, 13, 14};
    public static final String[] jjstrLiteralImages = {"", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, SimpleComparison.LESS_THAN_OPERATION, "</", "<?", "<?xml", "<!DOCTYPE", "<!--", "<![CDATA[", null, null, "?>", SimpleComparison.EQUAL_TO_OPERATION, "\"", "'", DatabaseFieldConfigLoader.FIELD_NAME_VERSION, "encoding", "standalone", null, null, "\"", null, "'", "=\"", "\"", "='", "'", "1.0", "=\"", "\"", "='", "'", "yes", "no", null, SimpleComparison.GREATER_THAN_OPERATION, null, null, null, null, "[", null, "]", null, "-->", "--", null, "?>", null, null, null, null, SimpleComparison.EQUAL_TO_OPERATION, null, "\"", "'", "/>", SimpleComparison.GREATER_THAN_OPERATION, null, "\"", "'", null, null, null, "]]>", null};
    public static final String[] lexStateNames = {"WithinCData", "Attribute", "WithinTag", "WithinPIContent", "WithinPI", "Comment", "WithinIntSubset", "WithinDoctypeDecl", "WithinXMLDecl_Standalone", "WithinXMLDecl_Version", "WithinXMLDecl_SquoteString", "WithinXMLDecl_DquoteString", "WithinXMLDecl", "DEFAULT"};
    public static final int[] jjnewLexState = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2, 2, 4, 12, 7, 5, 0, -1, -1, 13, -1, 11, 10, 9, -1, 8, -1, -1, 12, -1, 12, -1, 12, -1, 12, -1, -1, 12, -1, 12, -1, -1, -1, 13, -1, -1, -1, -1, 6, -1, 7, -1, 13, -1, -1, 13, -1, -1, 3, -1, -1, -1, 1, 1, 13, 13, -1, 2, 2, -1, -1, -1, 13, -1};
    static final long[] jjtoToken = {-51791400009793535L, 65279};
    static final long[] jjtoSkip = {36028801313964032L, 256};
    protected SimpleCharStream input_stream;
    private final int[] jjrounds;
    private final int[] jjstateSet;
    protected char curChar;
    int curLexState;
    int defaultLexState;
    int jjnewStateCnt;
    int jjround;
    int jjmatchedPos;
    int jjmatchedKind;

    public void setDebugStream(PrintStream ds) {
        this.debugStream = ds;
    }

    private final int jjStopStringLiteralDfa_1(int pos, long active0, long active1) {
        switch (pos) {
            default:
                return -1;
        }
    }

    private final int jjStartNfa_1(int pos, long active0, long active1) {
        return jjMoveNfa_1(jjStopStringLiteralDfa_1(pos, active0, active1), pos + 1);
    }

    private final int jjStopAtPos(int pos, int kind) {
        this.jjmatchedKind = kind;
        this.jjmatchedPos = pos;
        return pos + 1;
    }

    private final int jjStartNfaWithStates_1(int pos, int kind, int state) {
        this.jjmatchedKind = kind;
        this.jjmatchedPos = pos;
        try {
            this.curChar = this.input_stream.readChar();
            return jjMoveNfa_1(state, pos + 1);
        } catch (IOException e2) {
            return pos + 1;
        }
    }

    private final int jjMoveStringLiteralDfa0_1() {
        switch (this.curChar) {
            case '\"':
                return jjStopAtPos(0, 73);
            case '\'':
                return jjStopAtPos(0, 74);
            default:
                return jjMoveNfa_1(0, 0);
        }
    }

    private final void jjCheckNAdd(int state) {
        if (this.jjrounds[state] != this.jjround) {
            int[] iArr = this.jjstateSet;
            int i2 = this.jjnewStateCnt;
            this.jjnewStateCnt = i2 + 1;
            iArr[i2] = state;
            this.jjrounds[state] = this.jjround;
        }
    }

    private final void jjAddStates(int start, int end) {
        int i2;
        do {
            int[] iArr = this.jjstateSet;
            int i3 = this.jjnewStateCnt;
            this.jjnewStateCnt = i3 + 1;
            iArr[i3] = jjnextStates[start];
            i2 = start;
            start++;
        } while (i2 != end);
    }

    private final void jjCheckNAddTwoStates(int state1, int state2) {
        jjCheckNAdd(state1);
        jjCheckNAdd(state2);
    }

    private final void jjCheckNAddStates(int start, int end) {
        int i2;
        do {
            jjCheckNAdd(jjnextStates[start]);
            i2 = start;
            start++;
        } while (i2 != end);
    }

    private final void jjCheckNAddStates(int start) {
        jjCheckNAdd(jjnextStates[start]);
        jjCheckNAdd(jjnextStates[start + 1]);
    }

    private final int jjMoveNfa_1(int startState, int curPos) {
        int startsAt = 0;
        this.jjnewStateCnt = 12;
        int i2 = 1;
        this.jjstateSet[0] = startState;
        int kind = Integer.MAX_VALUE;
        while (true) {
            int i3 = this.jjround + 1;
            this.jjround = i3;
            if (i3 == Integer.MAX_VALUE) {
                ReInitRounds();
            }
            if (this.curChar < '@') {
                long l = 1 << this.curChar;
                do {
                    i2--;
                    switch (this.jjstateSet[i2]) {
                        case 0:
                            if (((-1152922329240567809L) & l) != 0) {
                                if (kind > 76) {
                                    kind = 76;
                                }
                            } else if (this.curChar == '&') {
                                jjAddStates(0, 1);
                            }
                            if (((-1152921796664623105L) & l) != 0) {
                                if (kind > 75) {
                                    kind = 75;
                                    break;
                                }
                            } else if (this.curChar == '&') {
                                int[] iArr = this.jjstateSet;
                                int i4 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i4 + 1;
                                iArr[i4] = 3;
                                break;
                            }
                            break;
                        case 1:
                            if (((-1152922329240567809L) & l) != 0 && kind > 76) {
                                kind = 76;
                                break;
                            }
                            break;
                        case 2:
                            if (this.curChar == '&') {
                                int[] iArr2 = this.jjstateSet;
                                int i5 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i5 + 1;
                                iArr2[i5] = 3;
                                break;
                            }
                            break;
                        case 3:
                            if (this.curChar == ':') {
                                jjCheckNAddTwoStates(4, 5);
                                break;
                            }
                            break;
                        case 4:
                            if ((576284830442979328L & l) != 0) {
                                jjCheckNAddTwoStates(4, 5);
                                break;
                            }
                            break;
                        case 5:
                            if (this.curChar == ';' && kind > 77) {
                                kind = 77;
                                break;
                            }
                            break;
                        case 6:
                            if (this.curChar == '&') {
                                jjAddStates(0, 1);
                                break;
                            }
                            break;
                        case 8:
                            if ((287948901175001088L & l) != 0) {
                                jjCheckNAddTwoStates(8, 5);
                                break;
                            }
                            break;
                        case 9:
                            if (this.curChar == '#') {
                                int[] iArr3 = this.jjstateSet;
                                int i6 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i6 + 1;
                                iArr3[i6] = 7;
                                break;
                            }
                            break;
                        case 10:
                            if (this.curChar == '#') {
                                jjCheckNAdd(11);
                                break;
                            }
                            break;
                        case 11:
                            if ((287948901175001088L & l) != 0) {
                                jjCheckNAddTwoStates(11, 5);
                                break;
                            }
                            break;
                    }
                } while (i2 != startsAt);
            } else if (this.curChar < 128) {
                long l2 = 1 << (this.curChar & '?');
                do {
                    i2--;
                    switch (this.jjstateSet[i2]) {
                        case 0:
                            if (kind > 76) {
                                kind = 76;
                            }
                            if (kind > 75) {
                                kind = 75;
                                break;
                            }
                            break;
                        case 1:
                            if (kind > 76) {
                                kind = 76;
                                break;
                            }
                            break;
                        case 3:
                        case 4:
                            if ((576460745995190270L & l2) != 0) {
                                jjCheckNAddTwoStates(4, 5);
                                break;
                            }
                            break;
                        case 7:
                            if (this.curChar == 'x') {
                                jjCheckNAdd(8);
                                break;
                            }
                            break;
                        case 8:
                            if ((541165879422L & l2) != 0) {
                                jjCheckNAddTwoStates(8, 5);
                                break;
                            }
                            break;
                    }
                } while (i2 != startsAt);
            } else {
                int hiByte = this.curChar >> '\b';
                int i1 = hiByte >> 6;
                long l1 = 1 << (hiByte & 63);
                int i22 = (this.curChar & 255) >> 6;
                long l22 = 1 << (this.curChar & '?');
                do {
                    i2--;
                    switch (this.jjstateSet[i2]) {
                        case 0:
                            if (jjCanMove_0(hiByte, i1, i22, l1, l22) && kind > 75) {
                                kind = 75;
                            }
                            if (jjCanMove_0(hiByte, i1, i22, l1, l22) && kind > 76) {
                                kind = 76;
                                break;
                            }
                            break;
                        case 1:
                            if (jjCanMove_0(hiByte, i1, i22, l1, l22) && kind > 76) {
                                kind = 76;
                                break;
                            }
                            break;
                        case 3:
                            if (jjCanMove_1(hiByte, i1, i22, l1, l22)) {
                                jjCheckNAddTwoStates(4, 5);
                                break;
                            }
                            break;
                        case 4:
                            if (jjCanMove_2(hiByte, i1, i22, l1, l22)) {
                                jjCheckNAddTwoStates(4, 5);
                                break;
                            }
                            break;
                    }
                } while (i2 != startsAt);
            }
            if (kind != Integer.MAX_VALUE) {
                this.jjmatchedKind = kind;
                this.jjmatchedPos = curPos;
                kind = Integer.MAX_VALUE;
            }
            curPos++;
            int i7 = this.jjnewStateCnt;
            i2 = i7;
            int i8 = startsAt;
            this.jjnewStateCnt = i8;
            int i9 = 12 - i8;
            startsAt = i9;
            if (i7 == i9) {
                return curPos;
            }
            try {
                this.curChar = this.input_stream.readChar();
            } catch (IOException e2) {
                return curPos;
            }
        }
    }

    private final int jjStopStringLiteralDfa_6(int pos, long active0) {
        switch (pos) {
            default:
                return -1;
        }
    }

    private final int jjStartNfa_6(int pos, long active0) {
        return jjMoveNfa_6(jjStopStringLiteralDfa_6(pos, active0), pos + 1);
    }

    private final int jjStartNfaWithStates_6(int pos, int kind, int state) {
        this.jjmatchedKind = kind;
        this.jjmatchedPos = pos;
        try {
            this.curChar = this.input_stream.readChar();
            return jjMoveNfa_6(state, pos + 1);
        } catch (IOException e2) {
            return pos + 1;
        }
    }

    private final int jjMoveStringLiteralDfa0_6() {
        switch (this.curChar) {
            case ']':
                return jjStopAtPos(0, 56);
            default:
                return jjMoveNfa_6(0, 0);
        }
    }

    private final int jjMoveNfa_6(int startState, int curPos) {
        int startsAt = 0;
        this.jjnewStateCnt = 1;
        int i2 = 1;
        this.jjstateSet[0] = startState;
        int kind = Integer.MAX_VALUE;
        while (true) {
            int i3 = this.jjround + 1;
            this.jjround = i3;
            if (i3 == Integer.MAX_VALUE) {
                ReInitRounds();
            }
            if (this.curChar < '@') {
                long j = 1 << this.curChar;
                do {
                    i2--;
                    switch (this.jjstateSet[i2]) {
                        case 0:
                            kind = 57;
                            int[] iArr = this.jjstateSet;
                            int i4 = this.jjnewStateCnt;
                            this.jjnewStateCnt = i4 + 1;
                            iArr[i4] = 0;
                            break;
                    }
                } while (i2 != startsAt);
            } else if (this.curChar < 128) {
                long l = 1 << (this.curChar & '?');
                do {
                    i2--;
                    switch (this.jjstateSet[i2]) {
                        case 0:
                            if (((-536870913) & l) != 0) {
                                kind = 57;
                                int[] iArr2 = this.jjstateSet;
                                int i5 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i5 + 1;
                                iArr2[i5] = 0;
                                break;
                            }
                            break;
                    }
                } while (i2 != startsAt);
            } else {
                int hiByte = this.curChar >> '\b';
                int i1 = hiByte >> 6;
                long l1 = 1 << (hiByte & 63);
                int i22 = (this.curChar & 255) >> 6;
                long l2 = 1 << (this.curChar & '?');
                do {
                    i2--;
                    switch (this.jjstateSet[i2]) {
                        case 0:
                            if (jjCanMove_0(hiByte, i1, i22, l1, l2)) {
                                if (kind > 57) {
                                    kind = 57;
                                }
                                int[] iArr3 = this.jjstateSet;
                                int i6 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i6 + 1;
                                iArr3[i6] = 0;
                                break;
                            }
                            break;
                    }
                } while (i2 != startsAt);
            }
            if (kind != Integer.MAX_VALUE) {
                this.jjmatchedKind = kind;
                this.jjmatchedPos = curPos;
                kind = Integer.MAX_VALUE;
            }
            curPos++;
            int i7 = this.jjnewStateCnt;
            i2 = i7;
            int i8 = startsAt;
            this.jjnewStateCnt = i8;
            int i9 = 1 - i8;
            startsAt = i9;
            if (i7 == i9) {
                return curPos;
            }
            try {
                this.curChar = this.input_stream.readChar();
            } catch (IOException e2) {
                return curPos;
            }
        }
    }

    private final int jjStopStringLiteralDfa_7(int pos, long active0) {
        switch (pos) {
            default:
                return -1;
        }
    }

    private final int jjStartNfa_7(int pos, long active0) {
        return jjMoveNfa_7(jjStopStringLiteralDfa_7(pos, active0), pos + 1);
    }

    private final int jjStartNfaWithStates_7(int pos, int kind, int state) {
        this.jjmatchedKind = kind;
        this.jjmatchedPos = pos;
        try {
            this.curChar = this.input_stream.readChar();
            return jjMoveNfa_7(state, pos + 1);
        } catch (IOException e2) {
            return pos + 1;
        }
    }

    private final int jjMoveStringLiteralDfa0_7() {
        switch (this.curChar) {
            case '>':
                return jjStopAtPos(0, 49);
            case '[':
                return jjStopAtPos(0, 54);
            default:
                return jjMoveNfa_7(0, 0);
        }
    }

    private final int jjMoveNfa_7(int startState, int curPos) {
        int startsAt = 0;
        this.jjnewStateCnt = 34;
        int i2 = 1;
        this.jjstateSet[0] = startState;
        int kind = Integer.MAX_VALUE;
        while (true) {
            int i3 = this.jjround + 1;
            this.jjround = i3;
            if (i3 == Integer.MAX_VALUE) {
                ReInitRounds();
            }
            if (this.curChar < '@') {
                long l = 1 << this.curChar;
                do {
                    i2--;
                    switch (this.jjstateSet[i2]) {
                        case 0:
                            if ((4294977024L & l) != 0) {
                                if (kind > 55) {
                                    kind = 55;
                                    break;
                                }
                            } else if (this.curChar == ':') {
                                if (kind > 48) {
                                    kind = 48;
                                }
                                jjCheckNAdd(1);
                                break;
                            }
                            break;
                        case 1:
                            if ((576284830442979328L & l) != 0) {
                                if (kind > 48) {
                                    kind = 48;
                                }
                                jjCheckNAdd(1);
                                break;
                            }
                            break;
                        case 3:
                            if ((4294977024L & l) != 0) {
                                jjAddStates(2, 4);
                                break;
                            }
                            break;
                        case 4:
                            if (this.curChar == '\"') {
                                jjCheckNAddTwoStates(5, 6);
                                break;
                            }
                            break;
                        case 5:
                            if (((-17179869185L) & l) != 0) {
                                jjCheckNAddTwoStates(5, 6);
                                break;
                            }
                            break;
                        case 6:
                            if (this.curChar == '\"' && kind > 50) {
                                kind = 50;
                                break;
                            }
                            break;
                        case 7:
                            if (this.curChar == '\'') {
                                jjCheckNAddTwoStates(8, 9);
                                break;
                            }
                            break;
                        case 8:
                            if (((-549755813889L) & l) != 0) {
                                jjCheckNAddTwoStates(8, 9);
                                break;
                            }
                            break;
                        case 9:
                            if (this.curChar == '\'' && kind > 50) {
                                kind = 50;
                                break;
                            }
                            break;
                        case 16:
                            if ((4294977024L & l) != 0) {
                                jjAddStates(5, 7);
                                break;
                            }
                            break;
                        case 17:
                            if (this.curChar == '\"') {
                                jjCheckNAddTwoStates(18, 19);
                                break;
                            }
                            break;
                        case 18:
                            if (((-5764607819386969088L) & l) != 0) {
                                jjCheckNAddTwoStates(18, 19);
                                break;
                            }
                            break;
                        case 19:
                            if (this.curChar == '\"') {
                                jjCheckNAdd(20);
                                break;
                            }
                            break;
                        case 20:
                            if ((4294977024L & l) != 0) {
                                jjCheckNAddStates(8, 10);
                                break;
                            }
                            break;
                        case 21:
                            if (this.curChar == '\"') {
                                jjCheckNAddTwoStates(22, 6);
                                break;
                            }
                            break;
                        case 22:
                            if (((-17179869185L) & l) != 0) {
                                jjCheckNAddTwoStates(22, 6);
                                break;
                            }
                            break;
                        case 23:
                            if (this.curChar == '\'') {
                                jjCheckNAddTwoStates(24, 9);
                                break;
                            }
                            break;
                        case 24:
                            if (((-549755813889L) & l) != 0) {
                                jjCheckNAddTwoStates(24, 9);
                                break;
                            }
                            break;
                        case 25:
                            if (this.curChar == '\'') {
                                jjCheckNAddTwoStates(26, 27);
                                break;
                            }
                            break;
                        case 26:
                            if (((-5764608369142782976L) & l) != 0) {
                                jjCheckNAddTwoStates(26, 27);
                                break;
                            }
                            break;
                        case 27:
                            if (this.curChar == '\'') {
                                jjCheckNAdd(20);
                                break;
                            }
                            break;
                        case 33:
                            if ((4294977024L & l) != 0 && kind > 55) {
                                kind = 55;
                                break;
                            }
                            break;
                    }
                } while (i2 != startsAt);
            } else if (this.curChar < 128) {
                long l2 = 1 << (this.curChar & '?');
                do {
                    i2--;
                    switch (this.jjstateSet[i2]) {
                        case 0:
                            if ((576460745995190270L & l2) != 0) {
                                if (kind > 48) {
                                    kind = 48;
                                }
                                jjCheckNAdd(1);
                            }
                            if (this.curChar == 'P') {
                                int[] iArr = this.jjstateSet;
                                int i4 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i4 + 1;
                                iArr[i4] = 31;
                                break;
                            } else if (this.curChar == 'S') {
                                int[] iArr2 = this.jjstateSet;
                                int i5 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i5 + 1;
                                iArr2[i5] = 13;
                                break;
                            }
                            break;
                        case 1:
                            if ((576460745995190270L & l2) != 0) {
                                if (kind > 48) {
                                    kind = 48;
                                }
                                jjCheckNAdd(1);
                                break;
                            }
                            break;
                        case 2:
                            if (this.curChar == 'M') {
                                int[] iArr3 = this.jjstateSet;
                                int i6 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i6 + 1;
                                iArr3[i6] = 3;
                                break;
                            }
                            break;
                        case 5:
                            jjCheckNAddTwoStates(5, 6);
                            break;
                        case 8:
                            jjCheckNAddTwoStates(8, 9);
                            break;
                        case 10:
                            if (this.curChar == 'E') {
                                int[] iArr4 = this.jjstateSet;
                                int i7 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i7 + 1;
                                iArr4[i7] = 2;
                                break;
                            }
                            break;
                        case 11:
                            if (this.curChar == 'T') {
                                int[] iArr5 = this.jjstateSet;
                                int i8 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i8 + 1;
                                iArr5[i8] = 10;
                                break;
                            }
                            break;
                        case 12:
                            if (this.curChar == 'S') {
                                int[] iArr6 = this.jjstateSet;
                                int i9 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i9 + 1;
                                iArr6[i9] = 11;
                                break;
                            }
                            break;
                        case 13:
                            if (this.curChar == 'Y') {
                                int[] iArr7 = this.jjstateSet;
                                int i10 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i10 + 1;
                                iArr7[i10] = 12;
                                break;
                            }
                            break;
                        case 14:
                            if (this.curChar == 'S') {
                                int[] iArr8 = this.jjstateSet;
                                int i11 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i11 + 1;
                                iArr8[i11] = 13;
                                break;
                            }
                            break;
                        case 15:
                            if (this.curChar == 'C') {
                                int[] iArr9 = this.jjstateSet;
                                int i12 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i12 + 1;
                                iArr9[i12] = 16;
                                break;
                            }
                            break;
                        case 18:
                            if ((576460745995190271L & l2) != 0) {
                                jjAddStates(11, 12);
                                break;
                            }
                            break;
                        case 22:
                            jjCheckNAddTwoStates(22, 6);
                            break;
                        case 24:
                            jjCheckNAddTwoStates(24, 9);
                            break;
                        case 26:
                            if ((576460745995190271L & l2) != 0) {
                                jjAddStates(13, 14);
                                break;
                            }
                            break;
                        case 28:
                            if (this.curChar == 'I') {
                                int[] iArr10 = this.jjstateSet;
                                int i13 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i13 + 1;
                                iArr10[i13] = 15;
                                break;
                            }
                            break;
                        case 29:
                            if (this.curChar == 'L') {
                                int[] iArr11 = this.jjstateSet;
                                int i14 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i14 + 1;
                                iArr11[i14] = 28;
                                break;
                            }
                            break;
                        case 30:
                            if (this.curChar == 'B') {
                                int[] iArr12 = this.jjstateSet;
                                int i15 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i15 + 1;
                                iArr12[i15] = 29;
                                break;
                            }
                            break;
                        case 31:
                            if (this.curChar == 'U') {
                                int[] iArr13 = this.jjstateSet;
                                int i16 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i16 + 1;
                                iArr13[i16] = 30;
                                break;
                            }
                            break;
                        case 32:
                            if (this.curChar == 'P') {
                                int[] iArr14 = this.jjstateSet;
                                int i17 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i17 + 1;
                                iArr14[i17] = 31;
                                break;
                            }
                            break;
                    }
                } while (i2 != startsAt);
            } else {
                int hiByte = this.curChar >> '\b';
                int i1 = hiByte >> 6;
                long l1 = 1 << (hiByte & 63);
                int i22 = (this.curChar & 255) >> 6;
                long l22 = 1 << (this.curChar & '?');
                do {
                    i2--;
                    switch (this.jjstateSet[i2]) {
                        case 0:
                            if (jjCanMove_1(hiByte, i1, i22, l1, l22)) {
                                if (kind > 48) {
                                    kind = 48;
                                }
                                jjCheckNAdd(1);
                                break;
                            }
                            break;
                        case 1:
                            if (jjCanMove_2(hiByte, i1, i22, l1, l22)) {
                                if (kind > 48) {
                                    kind = 48;
                                }
                                jjCheckNAdd(1);
                                break;
                            }
                            break;
                        case 5:
                            if (jjCanMove_0(hiByte, i1, i22, l1, l22)) {
                                jjCheckNAddTwoStates(5, 6);
                                break;
                            }
                            break;
                        case 8:
                            if (jjCanMove_0(hiByte, i1, i22, l1, l22)) {
                                jjCheckNAddTwoStates(8, 9);
                                break;
                            }
                            break;
                        case 22:
                            if (jjCanMove_0(hiByte, i1, i22, l1, l22)) {
                                jjCheckNAddTwoStates(22, 6);
                                break;
                            }
                            break;
                        case 24:
                            if (jjCanMove_0(hiByte, i1, i22, l1, l22)) {
                                jjCheckNAddTwoStates(24, 9);
                                break;
                            }
                            break;
                    }
                } while (i2 != startsAt);
            }
            if (kind != Integer.MAX_VALUE) {
                this.jjmatchedKind = kind;
                this.jjmatchedPos = curPos;
                kind = Integer.MAX_VALUE;
            }
            curPos++;
            int i18 = this.jjnewStateCnt;
            i2 = i18;
            int i19 = startsAt;
            this.jjnewStateCnt = i19;
            int i20 = 34 - i19;
            startsAt = i20;
            if (i18 == i20) {
                return curPos;
            }
            try {
                this.curChar = this.input_stream.readChar();
            } catch (IOException e2) {
                return curPos;
            }
        }
    }

    private final int jjStopStringLiteralDfa_11(int pos, long active0) {
        switch (pos) {
            default:
                return -1;
        }
    }

    private final int jjStartNfa_11(int pos, long active0) {
        return jjMoveNfa_11(jjStopStringLiteralDfa_11(pos, active0), pos + 1);
    }

    private final int jjStartNfaWithStates_11(int pos, int kind, int state) {
        this.jjmatchedKind = kind;
        this.jjmatchedPos = pos;
        try {
            this.curChar = this.input_stream.readChar();
            return jjMoveNfa_11(state, pos + 1);
        } catch (IOException e2) {
            return pos + 1;
        }
    }

    private final int jjMoveStringLiteralDfa0_11() {
        switch (this.curChar) {
            case '\"':
                return jjStopAtPos(0, 34);
            default:
                return jjMoveNfa_11(0, 0);
        }
    }

    private final int jjMoveNfa_11(int startState, int curPos) {
        int startsAt = 0;
        this.jjnewStateCnt = 1;
        int i2 = 1;
        this.jjstateSet[0] = startState;
        int kind = Integer.MAX_VALUE;
        while (true) {
            int i3 = this.jjround + 1;
            this.jjround = i3;
            if (i3 == Integer.MAX_VALUE) {
                ReInitRounds();
            }
            if (this.curChar < '@') {
                long l = 1 << this.curChar;
                do {
                    i2--;
                    switch (this.jjstateSet[i2]) {
                        case 0:
                            if (((-17179869185L) & l) != 0) {
                                kind = 33;
                                int[] iArr = this.jjstateSet;
                                int i4 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i4 + 1;
                                iArr[i4] = 0;
                                break;
                            }
                            break;
                    }
                } while (i2 != startsAt);
            } else if (this.curChar < 128) {
                long j = 1 << (this.curChar & '?');
                do {
                    i2--;
                    switch (this.jjstateSet[i2]) {
                        case 0:
                            kind = 33;
                            int[] iArr2 = this.jjstateSet;
                            int i5 = this.jjnewStateCnt;
                            this.jjnewStateCnt = i5 + 1;
                            iArr2[i5] = 0;
                            break;
                    }
                } while (i2 != startsAt);
            } else {
                int hiByte = this.curChar >> '\b';
                int i1 = hiByte >> 6;
                long l1 = 1 << (hiByte & 63);
                int i22 = (this.curChar & 255) >> 6;
                long l2 = 1 << (this.curChar & '?');
                do {
                    i2--;
                    switch (this.jjstateSet[i2]) {
                        case 0:
                            if (jjCanMove_0(hiByte, i1, i22, l1, l2)) {
                                if (kind > 33) {
                                    kind = 33;
                                }
                                int[] iArr3 = this.jjstateSet;
                                int i6 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i6 + 1;
                                iArr3[i6] = 0;
                                break;
                            }
                            break;
                    }
                } while (i2 != startsAt);
            }
            if (kind != Integer.MAX_VALUE) {
                this.jjmatchedKind = kind;
                this.jjmatchedPos = curPos;
                kind = Integer.MAX_VALUE;
            }
            curPos++;
            int i7 = this.jjnewStateCnt;
            i2 = i7;
            int i8 = startsAt;
            this.jjnewStateCnt = i8;
            int i9 = 1 - i8;
            startsAt = i9;
            if (i7 == i9) {
                return curPos;
            }
            try {
                this.curChar = this.input_stream.readChar();
            } catch (IOException e2) {
                return curPos;
            }
        }
    }

    private final int jjStopStringLiteralDfa_5(int pos, long active0) {
        switch (pos) {
            case 0:
                if ((active0 & 864691128455135232L) != 0) {
                    this.jjmatchedKind = 60;
                    return -1;
                }
                return -1;
            case 1:
                if ((active0 & 864691128455135232L) != 0 && this.jjmatchedPos == 0) {
                    this.jjmatchedKind = 60;
                    this.jjmatchedPos = 0;
                    return -1;
                }
                return -1;
            default:
                return -1;
        }
    }

    private final int jjStartNfa_5(int pos, long active0) {
        return jjMoveNfa_5(jjStopStringLiteralDfa_5(pos, active0), pos + 1);
    }

    private final int jjStartNfaWithStates_5(int pos, int kind, int state) {
        this.jjmatchedKind = kind;
        this.jjmatchedPos = pos;
        try {
            this.curChar = this.input_stream.readChar();
            return jjMoveNfa_5(state, pos + 1);
        } catch (IOException e2) {
            return pos + 1;
        }
    }

    private final int jjMoveStringLiteralDfa0_5() {
        switch (this.curChar) {
            case '-':
                return jjMoveStringLiteralDfa1_5(864691128455135232L);
            default:
                return jjMoveNfa_5(0, 0);
        }
    }

    private final int jjMoveStringLiteralDfa1_5(long active0) {
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '-':
                    if ((active0 & 576460752303423488L) != 0) {
                        this.jjmatchedKind = 59;
                        this.jjmatchedPos = 1;
                    }
                    return jjMoveStringLiteralDfa2_5(active0, 288230376151711744L);
                default:
                    return jjStartNfa_5(0, active0);
            }
        } catch (IOException e2) {
            jjStopStringLiteralDfa_5(0, active0);
            return 1;
        }
    }

    private final int jjMoveStringLiteralDfa2_5(long old0, long active0) {
        long active02 = active0 & old0;
        if (active02 == 0) {
            return jjStartNfa_5(0, old0);
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '>':
                    if ((active02 & 288230376151711744L) != 0) {
                        return jjStopAtPos(2, 58);
                    }
                    break;
            }
            return jjStartNfa_5(1, active02);
        } catch (IOException e2) {
            jjStopStringLiteralDfa_5(1, active02);
            return 2;
        }
    }

    private final int jjMoveNfa_5(int startState, int curPos) {
        int startsAt = 0;
        this.jjnewStateCnt = 1;
        int i2 = 1;
        this.jjstateSet[0] = startState;
        int kind = Integer.MAX_VALUE;
        while (true) {
            int i3 = this.jjround + 1;
            this.jjround = i3;
            if (i3 == Integer.MAX_VALUE) {
                ReInitRounds();
            }
            if (this.curChar < '@') {
                long l = 1 << this.curChar;
                do {
                    i2--;
                    switch (this.jjstateSet[i2]) {
                        case 0:
                            if (((-4294957568L) & l) != 0) {
                                kind = 60;
                                break;
                            }
                            break;
                    }
                } while (i2 != startsAt);
            } else if (this.curChar < 128) {
                long j = 1 << (this.curChar & '?');
                do {
                    i2--;
                    switch (this.jjstateSet[i2]) {
                        case 0:
                            kind = 60;
                            break;
                    }
                } while (i2 != startsAt);
            } else {
                int hiByte = this.curChar >> '\b';
                int i1 = hiByte >> 6;
                long l1 = 1 << (hiByte & 63);
                int i22 = (this.curChar & 255) >> 6;
                long l2 = 1 << (this.curChar & '?');
                do {
                    i2--;
                    switch (this.jjstateSet[i2]) {
                        case 0:
                            if (jjCanMove_3(hiByte, i1, i22, l1, l2) && kind > 60) {
                                kind = 60;
                                break;
                            }
                            break;
                    }
                } while (i2 != startsAt);
            }
            if (kind != Integer.MAX_VALUE) {
                this.jjmatchedKind = kind;
                this.jjmatchedPos = curPos;
                kind = Integer.MAX_VALUE;
            }
            curPos++;
            int i4 = this.jjnewStateCnt;
            i2 = i4;
            int i5 = startsAt;
            this.jjnewStateCnt = i5;
            int i6 = 1 - i5;
            startsAt = i6;
            if (i4 == i6) {
                return curPos;
            }
            try {
                this.curChar = this.input_stream.readChar();
            } catch (IOException e2) {
                return curPos;
            }
        }
    }

    private final int jjStopStringLiteralDfa_12(int pos, long active0) {
        switch (pos) {
            default:
                return -1;
        }
    }

    private final int jjStartNfa_12(int pos, long active0) {
        return jjMoveNfa_12(jjStopStringLiteralDfa_12(pos, active0), pos + 1);
    }

    private final int jjStartNfaWithStates_12(int pos, int kind, int state) {
        this.jjmatchedKind = kind;
        this.jjmatchedPos = pos;
        try {
            this.curChar = this.input_stream.readChar();
            return jjMoveNfa_12(state, pos + 1);
        } catch (IOException e2) {
            return pos + 1;
        }
    }

    private final int jjMoveStringLiteralDfa0_12() {
        switch (this.curChar) {
            case '\"':
                return jjStopAtPos(0, 27);
            case '\'':
                return jjStopAtPos(0, 28);
            case '=':
                return jjStopAtPos(0, 26);
            case '?':
                return jjMoveStringLiteralDfa1_12(33554432L);
            case 'e':
                return jjMoveStringLiteralDfa1_12(1073741824L);
            case 's':
                return jjMoveStringLiteralDfa1_12(2147483648L);
            case 'v':
                return jjMoveStringLiteralDfa1_12(536870912L);
            default:
                return jjMoveNfa_12(0, 0);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final int jjMoveStringLiteralDfa1_12(long active0) {
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '>':
                    if ((active0 & 33554432) != 0) {
                        return jjStopAtPos(1, 25);
                    }
                    break;
                case 'e':
                    return jjMoveStringLiteralDfa2_12(active0, 536870912L);
                case 'n':
                    return jjMoveStringLiteralDfa2_12(active0, 1073741824L);
                case 't':
                    return jjMoveStringLiteralDfa2_12(active0, 2147483648L);
            }
            return jjStartNfa_12(0, active0);
        } catch (IOException e2) {
            jjStopStringLiteralDfa_12(0, active0);
            return 1;
        }
    }

    private final int jjMoveStringLiteralDfa2_12(long old0, long active0) {
        long active02 = active0 & old0;
        if (active02 == 0) {
            return jjStartNfa_12(0, old0);
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case 'a':
                    return jjMoveStringLiteralDfa3_12(active02, 2147483648L);
                case 'c':
                    return jjMoveStringLiteralDfa3_12(active02, 1073741824L);
                case 'r':
                    return jjMoveStringLiteralDfa3_12(active02, 536870912L);
                default:
                    return jjStartNfa_12(1, active02);
            }
        } catch (IOException e2) {
            jjStopStringLiteralDfa_12(1, active02);
            return 2;
        }
    }

    private final int jjMoveStringLiteralDfa3_12(long old0, long active0) {
        long active02 = active0 & old0;
        if (active02 == 0) {
            return jjStartNfa_12(1, old0);
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case 'n':
                    return jjMoveStringLiteralDfa4_12(active02, 2147483648L);
                case 'o':
                    return jjMoveStringLiteralDfa4_12(active02, 1073741824L);
                case 's':
                    return jjMoveStringLiteralDfa4_12(active02, 536870912L);
                default:
                    return jjStartNfa_12(2, active02);
            }
        } catch (IOException e2) {
            jjStopStringLiteralDfa_12(2, active02);
            return 3;
        }
    }

    private final int jjMoveStringLiteralDfa4_12(long old0, long active0) {
        long active02 = active0 & old0;
        if (active02 == 0) {
            return jjStartNfa_12(2, old0);
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case 'd':
                    return jjMoveStringLiteralDfa5_12(active02, 3221225472L);
                case 'i':
                    return jjMoveStringLiteralDfa5_12(active02, 536870912L);
                default:
                    return jjStartNfa_12(3, active02);
            }
        } catch (IOException e2) {
            jjStopStringLiteralDfa_12(3, active02);
            return 4;
        }
    }

    private final int jjMoveStringLiteralDfa5_12(long old0, long active0) {
        long active02 = active0 & old0;
        if (active02 == 0) {
            return jjStartNfa_12(3, old0);
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case 'a':
                    return jjMoveStringLiteralDfa6_12(active02, 2147483648L);
                case 'i':
                    return jjMoveStringLiteralDfa6_12(active02, 1073741824L);
                case 'o':
                    return jjMoveStringLiteralDfa6_12(active02, 536870912L);
                default:
                    return jjStartNfa_12(4, active02);
            }
        } catch (IOException e2) {
            jjStopStringLiteralDfa_12(4, active02);
            return 5;
        }
    }

    private final int jjMoveStringLiteralDfa6_12(long old0, long active0) {
        long active02 = active0 & old0;
        if (active02 == 0) {
            return jjStartNfa_12(4, old0);
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case 'l':
                    return jjMoveStringLiteralDfa7_12(active02, 2147483648L);
                case 'n':
                    if ((active02 & 536870912) != 0) {
                        return jjStopAtPos(6, 29);
                    }
                    return jjMoveStringLiteralDfa7_12(active02, 1073741824L);
                default:
                    return jjStartNfa_12(5, active02);
            }
        } catch (IOException e2) {
            jjStopStringLiteralDfa_12(5, active02);
            return 6;
        }
    }

    private final int jjMoveStringLiteralDfa7_12(long old0, long active0) {
        long active02 = active0 & old0;
        if (active02 == 0) {
            return jjStartNfa_12(5, old0);
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case 'o':
                    return jjMoveStringLiteralDfa8_12(active02, 2147483648L);
                case 'g':
                    if ((active02 & 1073741824) != 0) {
                        return jjStopAtPos(7, 30);
                    }
                    break;
            }
            return jjStartNfa_12(6, active02);
        } catch (IOException e2) {
            jjStopStringLiteralDfa_12(6, active02);
            return 7;
        }
    }

    private final int jjMoveStringLiteralDfa8_12(long old0, long active0) {
        long active02 = active0 & old0;
        if (active02 == 0) {
            return jjStartNfa_12(6, old0);
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case 'n':
                    return jjMoveStringLiteralDfa9_12(active02, 2147483648L);
                default:
                    return jjStartNfa_12(7, active02);
            }
        } catch (IOException e2) {
            jjStopStringLiteralDfa_12(7, active02);
            return 8;
        }
    }

    private final int jjMoveStringLiteralDfa9_12(long old0, long active0) {
        long active02 = active0 & old0;
        if (active02 == 0) {
            return jjStartNfa_12(7, old0);
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case 'e':
                    if ((active02 & 2147483648L) != 0) {
                        return jjStopAtPos(9, 31);
                    }
                    break;
            }
            return jjStartNfa_12(8, active02);
        } catch (IOException e2) {
            jjStopStringLiteralDfa_12(8, active02);
            return 9;
        }
    }

    private final int jjMoveNfa_12(int startState, int curPos) {
        int startsAt = 0;
        this.jjnewStateCnt = 1;
        int i2 = 1;
        this.jjstateSet[0] = startState;
        int kind = Integer.MAX_VALUE;
        while (true) {
            int i3 = this.jjround + 1;
            this.jjround = i3;
            if (i3 == Integer.MAX_VALUE) {
                ReInitRounds();
            }
            if (this.curChar < '@') {
                long l = 1 << this.curChar;
                do {
                    i2--;
                    switch (this.jjstateSet[i2]) {
                        case 0:
                            if ((4294977024L & l) != 0) {
                                kind = 32;
                                break;
                            }
                            break;
                    }
                } while (i2 != startsAt);
            } else if (this.curChar < 128) {
                long j = 1 << (this.curChar & '?');
                do {
                    i2--;
                    switch (this.jjstateSet[i2]) {
                    }
                } while (i2 != startsAt);
            } else {
                int hiByte = this.curChar >> '\b';
                int i4 = hiByte >> 6;
                long j2 = 1 << (hiByte & 63);
                int i5 = (this.curChar & 255) >> 6;
                long j3 = 1 << (this.curChar & '?');
                do {
                    i2--;
                    switch (this.jjstateSet[i2]) {
                    }
                } while (i2 != startsAt);
            }
            if (kind != Integer.MAX_VALUE) {
                this.jjmatchedKind = kind;
                this.jjmatchedPos = curPos;
                kind = Integer.MAX_VALUE;
            }
            curPos++;
            int i6 = this.jjnewStateCnt;
            i2 = i6;
            int i7 = startsAt;
            this.jjnewStateCnt = i7;
            int i8 = 1 - i7;
            startsAt = i8;
            if (i6 == i8) {
                return curPos;
            }
            try {
                this.curChar = this.input_stream.readChar();
            } catch (IOException e2) {
                return curPos;
            }
        }
    }

    private final int jjStopStringLiteralDfa_4(int pos, long active0) {
        switch (pos) {
            default:
                return -1;
        }
    }

    private final int jjStartNfa_4(int pos, long active0) {
        return jjMoveNfa_4(jjStopStringLiteralDfa_4(pos, active0), pos + 1);
    }

    private final int jjStartNfaWithStates_4(int pos, int kind, int state) {
        this.jjmatchedKind = kind;
        this.jjmatchedPos = pos;
        try {
            this.curChar = this.input_stream.readChar();
            return jjMoveNfa_4(state, pos + 1);
        } catch (IOException e2) {
            return pos + 1;
        }
    }

    private final int jjMoveStringLiteralDfa0_4() {
        switch (this.curChar) {
            case '?':
                return jjMoveStringLiteralDfa1_4(2305843009213693952L);
            default:
                return jjMoveNfa_4(0, 0);
        }
    }

    private final int jjMoveStringLiteralDfa1_4(long active0) {
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '>':
                    if ((active0 & 2305843009213693952L) != 0) {
                        return jjStopAtPos(1, 61);
                    }
                    break;
            }
            return jjStartNfa_4(0, active0);
        } catch (IOException e2) {
            jjStopStringLiteralDfa_4(0, active0);
            return 1;
        }
    }

    private final int jjMoveNfa_4(int startState, int curPos) {
        int startsAt = 0;
        this.jjnewStateCnt = 8;
        int i2 = 1;
        this.jjstateSet[0] = startState;
        int kind = Integer.MAX_VALUE;
        while (true) {
            int i3 = this.jjround + 1;
            this.jjround = i3;
            if (i3 == Integer.MAX_VALUE) {
                ReInitRounds();
            }
            if (this.curChar < '@') {
                long l = 1 << this.curChar;
                do {
                    i2--;
                    switch (this.jjstateSet[i2]) {
                        case 0:
                            if ((4294977024L & l) != 0) {
                                if (kind > 64) {
                                    kind = 64;
                                    break;
                                }
                            } else if (this.curChar == ':') {
                                if (kind > 63) {
                                    kind = 63;
                                }
                                jjCheckNAdd(6);
                                break;
                            }
                            break;
                        case 3:
                            if (this.curChar == ':') {
                                if (kind > 62) {
                                    kind = 62;
                                }
                                jjCheckNAddTwoStates(3, 4);
                                break;
                            }
                            break;
                        case 4:
                            if ((576284830442979328L & l) != 0) {
                                if (kind > 62) {
                                    kind = 62;
                                }
                                jjCheckNAddTwoStates(3, 4);
                                break;
                            }
                            break;
                        case 5:
                            if (this.curChar == ':') {
                                if (kind > 63) {
                                    kind = 63;
                                }
                                jjCheckNAdd(6);
                                break;
                            }
                            break;
                        case 6:
                            if ((576284830442979328L & l) != 0) {
                                if (kind > 63) {
                                    kind = 63;
                                }
                                jjCheckNAdd(6);
                                break;
                            }
                            break;
                        case 7:
                            if ((4294977024L & l) != 0) {
                                kind = 64;
                                break;
                            }
                            break;
                    }
                } while (i2 != startsAt);
            } else if (this.curChar < 128) {
                long l2 = 1 << (this.curChar & '?');
                do {
                    i2--;
                    switch (this.jjstateSet[i2]) {
                        case 0:
                            if ((576460745995190270L & l2) != 0) {
                                if (kind > 63) {
                                    kind = 63;
                                }
                                jjCheckNAdd(6);
                            }
                            if ((72057594054705152L & l2) != 0) {
                                int[] iArr = this.jjstateSet;
                                int i4 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i4 + 1;
                                iArr[i4] = 1;
                                break;
                            }
                            break;
                        case 1:
                            if ((35184372097024L & l2) != 0) {
                                int[] iArr2 = this.jjstateSet;
                                int i5 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i5 + 1;
                                iArr2[i5] = 2;
                                break;
                            }
                            break;
                        case 2:
                            if ((17592186048512L & l2) != 0) {
                                if (kind > 62) {
                                    kind = 62;
                                }
                                jjCheckNAdd(3);
                                break;
                            }
                            break;
                        case 3:
                        case 4:
                            if ((576460745995190270L & l2) != 0) {
                                if (kind > 62) {
                                    kind = 62;
                                }
                                jjCheckNAddTwoStates(3, 4);
                                break;
                            }
                            break;
                        case 5:
                        case 6:
                            if ((576460745995190270L & l2) != 0) {
                                if (kind > 63) {
                                    kind = 63;
                                }
                                jjCheckNAdd(6);
                                break;
                            }
                            break;
                    }
                } while (i2 != startsAt);
            } else {
                int hiByte = this.curChar >> '\b';
                int i1 = hiByte >> 6;
                long l1 = 1 << (hiByte & 63);
                int i22 = (this.curChar & 255) >> 6;
                long l22 = 1 << (this.curChar & '?');
                do {
                    i2--;
                    switch (this.jjstateSet[i2]) {
                        case 0:
                            if (jjCanMove_1(hiByte, i1, i22, l1, l22)) {
                                if (kind > 63) {
                                    kind = 63;
                                }
                                jjCheckNAdd(6);
                                break;
                            }
                            break;
                        case 3:
                            if (jjCanMove_1(hiByte, i1, i22, l1, l22)) {
                                if (kind > 62) {
                                    kind = 62;
                                }
                                jjCheckNAddTwoStates(3, 4);
                                break;
                            }
                            break;
                        case 4:
                            if (jjCanMove_2(hiByte, i1, i22, l1, l22)) {
                                if (kind > 62) {
                                    kind = 62;
                                }
                                jjCheckNAddTwoStates(3, 4);
                                break;
                            }
                            break;
                        case 6:
                            if (jjCanMove_2(hiByte, i1, i22, l1, l22)) {
                                if (kind > 63) {
                                    kind = 63;
                                }
                                jjCheckNAdd(6);
                                break;
                            }
                            break;
                    }
                } while (i2 != startsAt);
            }
            if (kind != Integer.MAX_VALUE) {
                this.jjmatchedKind = kind;
                this.jjmatchedPos = curPos;
                kind = Integer.MAX_VALUE;
            }
            curPos++;
            int i6 = this.jjnewStateCnt;
            i2 = i6;
            int i7 = startsAt;
            this.jjnewStateCnt = i7;
            int i8 = 8 - i7;
            startsAt = i8;
            if (i6 == i8) {
                return curPos;
            }
            try {
                this.curChar = this.input_stream.readChar();
            } catch (IOException e2) {
                return curPos;
            }
        }
    }

    private final int jjStopStringLiteralDfa_13(int pos, long active0) {
        switch (pos) {
            default:
                return -1;
        }
    }

    private final int jjStartNfa_13(int pos, long active0) {
        return jjMoveNfa_13(jjStopStringLiteralDfa_13(pos, active0), pos + 1);
    }

    private final int jjStartNfaWithStates_13(int pos, int kind, int state) {
        this.jjmatchedKind = kind;
        this.jjmatchedPos = pos;
        try {
            this.curChar = this.input_stream.readChar();
            return jjMoveNfa_13(state, pos + 1);
        } catch (IOException e2) {
            return pos + 1;
        }
    }

    private final int jjMoveStringLiteralDfa0_13() {
        switch (this.curChar) {
            case '<':
                this.jjmatchedKind = 16;
                return jjMoveStringLiteralDfa1_13(8257536L);
            default:
                return jjMoveNfa_13(0, 0);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final int jjMoveStringLiteralDfa1_13(long active0) {
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '!':
                    return jjMoveStringLiteralDfa2_13(active0, 7340032L);
                case '/':
                    if ((active0 & 131072) != 0) {
                        return jjStopAtPos(1, 17);
                    }
                    break;
                case '?':
                    if ((active0 & 262144) != 0) {
                        this.jjmatchedKind = 18;
                        this.jjmatchedPos = 1;
                    }
                    return jjMoveStringLiteralDfa2_13(active0, 524288L);
            }
            return jjStartNfa_13(0, active0);
        } catch (IOException e2) {
            jjStopStringLiteralDfa_13(0, active0);
            return 1;
        }
    }

    private final int jjMoveStringLiteralDfa2_13(long old0, long active0) {
        long active02 = active0 & old0;
        if (active02 == 0) {
            return jjStartNfa_13(0, old0);
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '-':
                    return jjMoveStringLiteralDfa3_13(active02, 2097152L);
                case 'D':
                    return jjMoveStringLiteralDfa3_13(active02, 1048576L);
                case '[':
                    return jjMoveStringLiteralDfa3_13(active02, 4194304L);
                case 'x':
                    return jjMoveStringLiteralDfa3_13(active02, 524288L);
                default:
                    return jjStartNfa_13(1, active02);
            }
        } catch (IOException e2) {
            jjStopStringLiteralDfa_13(1, active02);
            return 2;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final int jjMoveStringLiteralDfa3_13(long old0, long active0) {
        long active02 = active0 & old0;
        if (active02 == 0) {
            return jjStartNfa_13(1, old0);
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '-':
                    if ((active02 & 2097152) != 0) {
                        return jjStopAtPos(3, 21);
                    }
                    break;
                case 'C':
                    return jjMoveStringLiteralDfa4_13(active02, 4194304L);
                case 'O':
                    return jjMoveStringLiteralDfa4_13(active02, 1048576L);
                case 'm':
                    return jjMoveStringLiteralDfa4_13(active02, 524288L);
            }
            return jjStartNfa_13(2, active02);
        } catch (IOException e2) {
            jjStopStringLiteralDfa_13(2, active02);
            return 3;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final int jjMoveStringLiteralDfa4_13(long old0, long active0) {
        long active02 = active0 & old0;
        if (active02 == 0) {
            return jjStartNfa_13(2, old0);
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case 'C':
                    return jjMoveStringLiteralDfa5_13(active02, 1048576L);
                case 'D':
                    return jjMoveStringLiteralDfa5_13(active02, 4194304L);
                case 'l':
                    if ((active02 & 524288) != 0) {
                        return jjStopAtPos(4, 19);
                    }
                    break;
            }
            return jjStartNfa_13(3, active02);
        } catch (IOException e2) {
            jjStopStringLiteralDfa_13(3, active02);
            return 4;
        }
    }

    private final int jjMoveStringLiteralDfa5_13(long old0, long active0) {
        long active02 = active0 & old0;
        if (active02 == 0) {
            return jjStartNfa_13(3, old0);
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case 'A':
                    return jjMoveStringLiteralDfa6_13(active02, 4194304L);
                case 'T':
                    return jjMoveStringLiteralDfa6_13(active02, 1048576L);
                default:
                    return jjStartNfa_13(4, active02);
            }
        } catch (IOException e2) {
            jjStopStringLiteralDfa_13(4, active02);
            return 5;
        }
    }

    private final int jjMoveStringLiteralDfa6_13(long old0, long active0) {
        long active02 = active0 & old0;
        if (active02 == 0) {
            return jjStartNfa_13(4, old0);
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case 'T':
                    return jjMoveStringLiteralDfa7_13(active02, 4194304L);
                case 'Y':
                    return jjMoveStringLiteralDfa7_13(active02, 1048576L);
                default:
                    return jjStartNfa_13(5, active02);
            }
        } catch (IOException e2) {
            jjStopStringLiteralDfa_13(5, active02);
            return 6;
        }
    }

    private final int jjMoveStringLiteralDfa7_13(long old0, long active0) {
        long active02 = active0 & old0;
        if (active02 == 0) {
            return jjStartNfa_13(5, old0);
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case 'A':
                    return jjMoveStringLiteralDfa8_13(active02, 4194304L);
                case 'P':
                    return jjMoveStringLiteralDfa8_13(active02, 1048576L);
                default:
                    return jjStartNfa_13(6, active02);
            }
        } catch (IOException e2) {
            jjStopStringLiteralDfa_13(6, active02);
            return 7;
        }
    }

    private final int jjMoveStringLiteralDfa8_13(long old0, long active0) {
        long active02 = active0 & old0;
        if (active02 == 0) {
            return jjStartNfa_13(6, old0);
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case 'E':
                    if ((active02 & 1048576) != 0) {
                        return jjStopAtPos(8, 20);
                    }
                    break;
                case '[':
                    if ((active02 & 4194304) != 0) {
                        return jjStopAtPos(8, 22);
                    }
                    break;
            }
            return jjStartNfa_13(7, active02);
        } catch (IOException e2) {
            jjStopStringLiteralDfa_13(7, active02);
            return 8;
        }
    }

    private final int jjMoveNfa_13(int startState, int curPos) {
        int startsAt = 0;
        this.jjnewStateCnt = 16;
        int i2 = 1;
        this.jjstateSet[0] = startState;
        int kind = Integer.MAX_VALUE;
        while (true) {
            int i3 = this.jjround + 1;
            this.jjround = i3;
            if (i3 == Integer.MAX_VALUE) {
                ReInitRounds();
            }
            if (this.curChar < '@') {
                long l = 1 << this.curChar;
                do {
                    i2--;
                    switch (this.jjstateSet[i2]) {
                        case 0:
                            if (((-1152921779484753921L) & l) != 0) {
                                if (kind > 23) {
                                    kind = 23;
                                }
                            } else if (this.curChar == '&') {
                                jjAddStates(15, 16);
                            }
                            if ((4294977024L & l) != 0) {
                                if (kind > 15) {
                                    kind = 15;
                                    break;
                                }
                            } else if (this.curChar == '&') {
                                int[] iArr = this.jjstateSet;
                                int i4 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i4 + 1;
                                iArr[i4] = 7;
                                break;
                            }
                            break;
                        case 1:
                            if (((-1152921779484753921L) & l) != 0 && kind > 23) {
                                kind = 23;
                                break;
                            }
                            break;
                        case 3:
                            if (((-5764607797912141825L) & l) != 0 && kind > 23) {
                                kind = 23;
                                break;
                            }
                            break;
                        case 6:
                            if (this.curChar == '&') {
                                int[] iArr2 = this.jjstateSet;
                                int i5 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i5 + 1;
                                iArr2[i5] = 7;
                                break;
                            }
                            break;
                        case 7:
                            if (this.curChar == ':') {
                                jjCheckNAddTwoStates(8, 9);
                                break;
                            }
                            break;
                        case 8:
                            if ((576284830442979328L & l) != 0) {
                                jjCheckNAddTwoStates(8, 9);
                                break;
                            }
                            break;
                        case 9:
                            if (this.curChar == ';' && kind > 24) {
                                kind = 24;
                                break;
                            }
                            break;
                        case 10:
                            if (this.curChar == '&') {
                                jjAddStates(15, 16);
                                break;
                            }
                            break;
                        case 12:
                            if ((287948901175001088L & l) != 0) {
                                jjCheckNAddTwoStates(12, 9);
                                break;
                            }
                            break;
                        case 13:
                            if (this.curChar == '#') {
                                int[] iArr3 = this.jjstateSet;
                                int i6 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i6 + 1;
                                iArr3[i6] = 11;
                                break;
                            }
                            break;
                        case 14:
                            if (this.curChar == '#') {
                                jjCheckNAdd(15);
                                break;
                            }
                            break;
                        case 15:
                            if ((287948901175001088L & l) != 0) {
                                jjCheckNAddTwoStates(15, 9);
                                break;
                            }
                            break;
                    }
                } while (i2 != startsAt);
            } else if (this.curChar < 128) {
                long l2 = 1 << (this.curChar & '?');
                do {
                    i2--;
                    switch (this.jjstateSet[i2]) {
                        case 0:
                            if (((-536870913) & l2) != 0) {
                                if (kind > 23) {
                                    kind = 23;
                                }
                            } else if (this.curChar == ']') {
                                int[] iArr4 = this.jjstateSet;
                                int i7 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i7 + 1;
                                iArr4[i7] = 1;
                            }
                            if (this.curChar == ']') {
                                int[] iArr5 = this.jjstateSet;
                                int i8 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i8 + 1;
                                iArr5[i8] = 2;
                                break;
                            }
                            break;
                        case 1:
                            if (((-536870913) & l2) != 0 && kind > 23) {
                                kind = 23;
                                break;
                            }
                            break;
                        case 2:
                            if (this.curChar == ']') {
                                int[] iArr6 = this.jjstateSet;
                                int i9 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i9 + 1;
                                iArr6[i9] = 3;
                                break;
                            }
                            break;
                        case 3:
                            if (kind > 23) {
                                kind = 23;
                                break;
                            }
                            break;
                        case 4:
                            if (this.curChar == ']') {
                                int[] iArr7 = this.jjstateSet;
                                int i10 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i10 + 1;
                                iArr7[i10] = 2;
                                break;
                            }
                            break;
                        case 5:
                            if (this.curChar == ']') {
                                int[] iArr8 = this.jjstateSet;
                                int i11 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i11 + 1;
                                iArr8[i11] = 1;
                                break;
                            }
                            break;
                        case 7:
                        case 8:
                            if ((576460745995190270L & l2) != 0) {
                                jjCheckNAddTwoStates(8, 9);
                                break;
                            }
                            break;
                        case 11:
                            if (this.curChar == 'x') {
                                jjCheckNAdd(12);
                                break;
                            }
                            break;
                        case 12:
                            if ((541165879422L & l2) != 0) {
                                jjCheckNAddTwoStates(12, 9);
                                break;
                            }
                            break;
                    }
                } while (i2 != startsAt);
            } else {
                int hiByte = this.curChar >> '\b';
                int i1 = hiByte >> 6;
                long l1 = 1 << (hiByte & 63);
                int i22 = (this.curChar & 255) >> 6;
                long l22 = 1 << (this.curChar & '?');
                do {
                    i2--;
                    switch (this.jjstateSet[i2]) {
                        case 0:
                        case 1:
                        case 3:
                            if (jjCanMove_0(hiByte, i1, i22, l1, l22) && kind > 23) {
                                kind = 23;
                                break;
                            }
                            break;
                        case 7:
                            if (jjCanMove_1(hiByte, i1, i22, l1, l22)) {
                                jjCheckNAddTwoStates(8, 9);
                                break;
                            }
                            break;
                        case 8:
                            if (jjCanMove_2(hiByte, i1, i22, l1, l22)) {
                                jjCheckNAddTwoStates(8, 9);
                                break;
                            }
                            break;
                    }
                } while (i2 != startsAt);
            }
            if (kind != Integer.MAX_VALUE) {
                this.jjmatchedKind = kind;
                this.jjmatchedPos = curPos;
                kind = Integer.MAX_VALUE;
            }
            curPos++;
            int i12 = this.jjnewStateCnt;
            i2 = i12;
            int i13 = startsAt;
            this.jjnewStateCnt = i13;
            int i14 = 16 - i13;
            startsAt = i14;
            if (i12 == i14) {
                return curPos;
            }
            try {
                this.curChar = this.input_stream.readChar();
            } catch (IOException e2) {
                return curPos;
            }
        }
    }

    private final int jjMoveStringLiteralDfa0_8() {
        switch (this.curChar) {
            case '\"':
                return jjStopAtPos(0, 43);
            case '\'':
                return jjStopAtPos(0, 45);
            case '=':
                return jjMoveStringLiteralDfa1_8(21990232555520L);
            case 'n':
                return jjMoveStringLiteralDfa1_8(140737488355328L);
            case 'y':
                return jjMoveStringLiteralDfa1_8(70368744177664L);
            default:
                return 1;
        }
    }

    private final int jjMoveStringLiteralDfa1_8(long active0) {
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '\"':
                    if ((active0 & 4398046511104L) != 0) {
                        return jjStopAtPos(1, 42);
                    }
                    return 2;
                case '\'':
                    if ((active0 & 17592186044416L) != 0) {
                        return jjStopAtPos(1, 44);
                    }
                    return 2;
                case 'e':
                    return jjMoveStringLiteralDfa2_8(active0, 70368744177664L);
                case 'o':
                    if ((active0 & 140737488355328L) != 0) {
                        return jjStopAtPos(1, 47);
                    }
                    return 2;
                default:
                    return 2;
            }
        } catch (IOException e2) {
            return 1;
        }
    }

    private final int jjMoveStringLiteralDfa2_8(long old0, long active0) {
        long active02 = active0 & old0;
        if (active02 == 0) {
            return 2;
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case 's':
                    if ((active02 & 70368744177664L) != 0) {
                        return jjStopAtPos(2, 46);
                    }
                    return 3;
                default:
                    return 3;
            }
        } catch (IOException e2) {
            return 2;
        }
    }

    private final int jjStopStringLiteralDfa_10(int pos, long active0) {
        switch (pos) {
            default:
                return -1;
        }
    }

    private final int jjStartNfa_10(int pos, long active0) {
        return jjMoveNfa_10(jjStopStringLiteralDfa_10(pos, active0), pos + 1);
    }

    private final int jjStartNfaWithStates_10(int pos, int kind, int state) {
        this.jjmatchedKind = kind;
        this.jjmatchedPos = pos;
        try {
            this.curChar = this.input_stream.readChar();
            return jjMoveNfa_10(state, pos + 1);
        } catch (IOException e2) {
            return pos + 1;
        }
    }

    private final int jjMoveStringLiteralDfa0_10() {
        switch (this.curChar) {
            case '\'':
                return jjStopAtPos(0, 36);
            default:
                return jjMoveNfa_10(0, 0);
        }
    }

    private final int jjMoveNfa_10(int startState, int curPos) {
        int startsAt = 0;
        this.jjnewStateCnt = 1;
        int i2 = 1;
        this.jjstateSet[0] = startState;
        int kind = Integer.MAX_VALUE;
        while (true) {
            int i3 = this.jjround + 1;
            this.jjround = i3;
            if (i3 == Integer.MAX_VALUE) {
                ReInitRounds();
            }
            if (this.curChar < '@') {
                long l = 1 << this.curChar;
                do {
                    i2--;
                    switch (this.jjstateSet[i2]) {
                        case 0:
                            if (((-549755813889L) & l) != 0) {
                                kind = 35;
                                int[] iArr = this.jjstateSet;
                                int i4 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i4 + 1;
                                iArr[i4] = 0;
                                break;
                            }
                            break;
                    }
                } while (i2 != startsAt);
            } else if (this.curChar < 128) {
                long j = 1 << (this.curChar & '?');
                do {
                    i2--;
                    switch (this.jjstateSet[i2]) {
                        case 0:
                            kind = 35;
                            int[] iArr2 = this.jjstateSet;
                            int i5 = this.jjnewStateCnt;
                            this.jjnewStateCnt = i5 + 1;
                            iArr2[i5] = 0;
                            break;
                    }
                } while (i2 != startsAt);
            } else {
                int hiByte = this.curChar >> '\b';
                int i1 = hiByte >> 6;
                long l1 = 1 << (hiByte & 63);
                int i22 = (this.curChar & 255) >> 6;
                long l2 = 1 << (this.curChar & '?');
                do {
                    i2--;
                    switch (this.jjstateSet[i2]) {
                        case 0:
                            if (jjCanMove_0(hiByte, i1, i22, l1, l2)) {
                                if (kind > 35) {
                                    kind = 35;
                                }
                                int[] iArr3 = this.jjstateSet;
                                int i6 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i6 + 1;
                                iArr3[i6] = 0;
                                break;
                            }
                            break;
                    }
                } while (i2 != startsAt);
            }
            if (kind != Integer.MAX_VALUE) {
                this.jjmatchedKind = kind;
                this.jjmatchedPos = curPos;
                kind = Integer.MAX_VALUE;
            }
            curPos++;
            int i7 = this.jjnewStateCnt;
            i2 = i7;
            int i8 = startsAt;
            this.jjnewStateCnt = i8;
            int i9 = 1 - i8;
            startsAt = i9;
            if (i7 == i9) {
                return curPos;
            }
            try {
                this.curChar = this.input_stream.readChar();
            } catch (IOException e2) {
                return curPos;
            }
        }
    }

    private final int jjStopStringLiteralDfa_3(int pos, long active0) {
        switch (pos) {
            case 0:
                if ((active0 & 2305843009213693952L) != 0) {
                    this.jjmatchedKind = 65;
                    return -1;
                }
                return -1;
            default:
                return -1;
        }
    }

    private final int jjStartNfa_3(int pos, long active0) {
        return jjMoveNfa_3(jjStopStringLiteralDfa_3(pos, active0), pos + 1);
    }

    private final int jjStartNfaWithStates_3(int pos, int kind, int state) {
        this.jjmatchedKind = kind;
        this.jjmatchedPos = pos;
        try {
            this.curChar = this.input_stream.readChar();
            return jjMoveNfa_3(state, pos + 1);
        } catch (IOException e2) {
            return pos + 1;
        }
    }

    private final int jjMoveStringLiteralDfa0_3() {
        switch (this.curChar) {
            case '?':
                return jjMoveStringLiteralDfa1_3(2305843009213693952L);
            default:
                return jjMoveNfa_3(0, 0);
        }
    }

    private final int jjMoveStringLiteralDfa1_3(long active0) {
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '>':
                    if ((active0 & 2305843009213693952L) != 0) {
                        return jjStopAtPos(1, 61);
                    }
                    break;
            }
            return jjStartNfa_3(0, active0);
        } catch (IOException e2) {
            jjStopStringLiteralDfa_3(0, active0);
            return 1;
        }
    }

    private final int jjMoveNfa_3(int startState, int curPos) {
        int startsAt = 0;
        this.jjnewStateCnt = 1;
        int i2 = 1;
        this.jjstateSet[0] = startState;
        int kind = Integer.MAX_VALUE;
        while (true) {
            int i3 = this.jjround + 1;
            this.jjround = i3;
            if (i3 == Integer.MAX_VALUE) {
                ReInitRounds();
            }
            if (this.curChar < '@') {
                long l = 1 << this.curChar;
                do {
                    i2--;
                    switch (this.jjstateSet[i2]) {
                        case 0:
                            if (((-4294957568L) & l) != 0) {
                                kind = 65;
                                break;
                            }
                            break;
                    }
                } while (i2 != startsAt);
            } else if (this.curChar < 128) {
                long j = 1 << (this.curChar & '?');
                do {
                    i2--;
                    switch (this.jjstateSet[i2]) {
                        case 0:
                            kind = 65;
                            break;
                    }
                } while (i2 != startsAt);
            } else {
                int hiByte = this.curChar >> '\b';
                int i1 = hiByte >> 6;
                long l1 = 1 << (hiByte & 63);
                int i22 = (this.curChar & 255) >> 6;
                long l2 = 1 << (this.curChar & '?');
                do {
                    i2--;
                    switch (this.jjstateSet[i2]) {
                        case 0:
                            if (jjCanMove_3(hiByte, i1, i22, l1, l2) && kind > 65) {
                                kind = 65;
                                break;
                            }
                            break;
                    }
                } while (i2 != startsAt);
            }
            if (kind != Integer.MAX_VALUE) {
                this.jjmatchedKind = kind;
                this.jjmatchedPos = curPos;
                kind = Integer.MAX_VALUE;
            }
            curPos++;
            int i4 = this.jjnewStateCnt;
            i2 = i4;
            int i5 = startsAt;
            this.jjnewStateCnt = i5;
            int i6 = 1 - i5;
            startsAt = i6;
            if (i4 == i6) {
                return curPos;
            }
            try {
                this.curChar = this.input_stream.readChar();
            } catch (IOException e2) {
                return curPos;
            }
        }
    }

    private final int jjStopStringLiteralDfa_0(int pos, long active0, long active1) {
        switch (pos) {
            case 0:
                if ((active1 & 16384) != 0) {
                    this.jjmatchedKind = 79;
                    return -1;
                }
                return -1;
            case 1:
                if ((active1 & 16384) != 0 && this.jjmatchedPos == 0) {
                    this.jjmatchedKind = 79;
                    this.jjmatchedPos = 0;
                    return -1;
                }
                return -1;
            default:
                return -1;
        }
    }

    private final int jjStartNfa_0(int pos, long active0, long active1) {
        return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0, active1), pos + 1);
    }

    private final int jjStartNfaWithStates_0(int pos, int kind, int state) {
        this.jjmatchedKind = kind;
        this.jjmatchedPos = pos;
        try {
            this.curChar = this.input_stream.readChar();
            return jjMoveNfa_0(state, pos + 1);
        } catch (IOException e2) {
            return pos + 1;
        }
    }

    private final int jjMoveStringLiteralDfa0_0() {
        switch (this.curChar) {
            case ']':
                return jjMoveStringLiteralDfa1_0(16384L);
            default:
                return jjMoveNfa_0(0, 0);
        }
    }

    private final int jjMoveStringLiteralDfa1_0(long active1) {
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case ']':
                    return jjMoveStringLiteralDfa2_0(active1, 16384L);
                default:
                    return jjStartNfa_0(0, 0L, active1);
            }
        } catch (IOException e2) {
            jjStopStringLiteralDfa_0(0, 0L, active1);
            return 1;
        }
    }

    private final int jjMoveStringLiteralDfa2_0(long old1, long active1) {
        long active12 = active1 & old1;
        if (active12 == 0) {
            return jjStartNfa_0(0, 0L, old1);
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '>':
                    if ((active12 & 16384) != 0) {
                        return jjStopAtPos(2, 78);
                    }
                    break;
            }
            return jjStartNfa_0(1, 0L, active12);
        } catch (IOException e2) {
            jjStopStringLiteralDfa_0(1, 0L, active12);
            return 2;
        }
    }

    private final int jjMoveNfa_0(int startState, int curPos) {
        int startsAt = 0;
        this.jjnewStateCnt = 1;
        int i2 = 1;
        this.jjstateSet[0] = startState;
        int kind = Integer.MAX_VALUE;
        while (true) {
            int i3 = this.jjround + 1;
            this.jjround = i3;
            if (i3 == Integer.MAX_VALUE) {
                ReInitRounds();
            }
            if (this.curChar < '@') {
                long l = 1 << this.curChar;
                do {
                    i2--;
                    switch (this.jjstateSet[i2]) {
                        case 0:
                            if (((-4294957568L) & l) != 0) {
                                kind = 79;
                                break;
                            }
                            break;
                    }
                } while (i2 != startsAt);
            } else if (this.curChar < 128) {
                long j = 1 << (this.curChar & '?');
                do {
                    i2--;
                    switch (this.jjstateSet[i2]) {
                        case 0:
                            kind = 79;
                            break;
                    }
                } while (i2 != startsAt);
            } else {
                int hiByte = this.curChar >> '\b';
                int i1 = hiByte >> 6;
                long l1 = 1 << (hiByte & 63);
                int i22 = (this.curChar & 255) >> 6;
                long l2 = 1 << (this.curChar & '?');
                do {
                    i2--;
                    switch (this.jjstateSet[i2]) {
                        case 0:
                            if (jjCanMove_3(hiByte, i1, i22, l1, l2) && kind > 79) {
                                kind = 79;
                                break;
                            }
                            break;
                    }
                } while (i2 != startsAt);
            }
            if (kind != Integer.MAX_VALUE) {
                this.jjmatchedKind = kind;
                this.jjmatchedPos = curPos;
                kind = Integer.MAX_VALUE;
            }
            curPos++;
            int i4 = this.jjnewStateCnt;
            i2 = i4;
            int i5 = startsAt;
            this.jjnewStateCnt = i5;
            int i6 = 1 - i5;
            startsAt = i6;
            if (i4 == i6) {
                return curPos;
            }
            try {
                this.curChar = this.input_stream.readChar();
            } catch (IOException e2) {
                return curPos;
            }
        }
    }

    private final int jjStopStringLiteralDfa_2(int pos, long active0, long active1) {
        switch (pos) {
            default:
                return -1;
        }
    }

    private final int jjStartNfa_2(int pos, long active0, long active1) {
        return jjMoveNfa_2(jjStopStringLiteralDfa_2(pos, active0, active1), pos + 1);
    }

    private final int jjStartNfaWithStates_2(int pos, int kind, int state) {
        this.jjmatchedKind = kind;
        this.jjmatchedPos = pos;
        try {
            this.curChar = this.input_stream.readChar();
            return jjMoveNfa_2(state, pos + 1);
        } catch (IOException e2) {
            return pos + 1;
        }
    }

    private final int jjMoveStringLiteralDfa0_2() {
        switch (this.curChar) {
            case '\"':
                return jjStopAtPos(0, 68);
            case '\'':
                return jjStopAtPos(0, 69);
            case '/':
                return jjMoveStringLiteralDfa1_2(64L);
            case '=':
                return jjStopAtPos(0, 66);
            case '>':
                return jjStopAtPos(0, 71);
            default:
                return jjMoveNfa_2(0, 0);
        }
    }

    private final int jjMoveStringLiteralDfa1_2(long active1) {
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '>':
                    if ((active1 & 64) != 0) {
                        return jjStopAtPos(1, 70);
                    }
                    break;
            }
            return jjStartNfa_2(0, 0L, active1);
        } catch (IOException e2) {
            jjStopStringLiteralDfa_2(0, 0L, active1);
            return 1;
        }
    }

    private final int jjMoveNfa_2(int startState, int curPos) {
        int startsAt = 0;
        this.jjnewStateCnt = 3;
        int i2 = 1;
        this.jjstateSet[0] = startState;
        int kind = Integer.MAX_VALUE;
        while (true) {
            int i3 = this.jjround + 1;
            this.jjround = i3;
            if (i3 == Integer.MAX_VALUE) {
                ReInitRounds();
            }
            if (this.curChar < '@') {
                long l = 1 << this.curChar;
                do {
                    i2--;
                    switch (this.jjstateSet[i2]) {
                        case 0:
                            if ((4294977024L & l) != 0) {
                                if (kind > 72) {
                                    kind = 72;
                                    break;
                                }
                            } else if (this.curChar == ':') {
                                if (kind > 67) {
                                    kind = 67;
                                }
                                jjCheckNAdd(1);
                                break;
                            }
                            break;
                        case 1:
                            if ((576284830442979328L & l) != 0) {
                                if (kind > 67) {
                                    kind = 67;
                                }
                                jjCheckNAdd(1);
                                break;
                            }
                            break;
                        case 2:
                            if ((4294977024L & l) != 0) {
                                kind = 72;
                                break;
                            }
                            break;
                    }
                } while (i2 != startsAt);
            } else if (this.curChar < 128) {
                long l2 = 1 << (this.curChar & '?');
                do {
                    i2--;
                    switch (this.jjstateSet[i2]) {
                        case 0:
                        case 1:
                            if ((576460745995190270L & l2) != 0) {
                                if (kind > 67) {
                                    kind = 67;
                                }
                                jjCheckNAdd(1);
                                break;
                            }
                            break;
                    }
                } while (i2 != startsAt);
            } else {
                int hiByte = this.curChar >> '\b';
                int i1 = hiByte >> 6;
                long l1 = 1 << (hiByte & 63);
                int i22 = (this.curChar & 255) >> 6;
                long l22 = 1 << (this.curChar & '?');
                do {
                    i2--;
                    switch (this.jjstateSet[i2]) {
                        case 0:
                            if (jjCanMove_1(hiByte, i1, i22, l1, l22)) {
                                if (kind > 67) {
                                    kind = 67;
                                }
                                jjCheckNAdd(1);
                                break;
                            }
                            break;
                        case 1:
                            if (jjCanMove_2(hiByte, i1, i22, l1, l22)) {
                                if (kind > 67) {
                                    kind = 67;
                                }
                                jjCheckNAdd(1);
                                break;
                            }
                            break;
                    }
                } while (i2 != startsAt);
            }
            if (kind != Integer.MAX_VALUE) {
                this.jjmatchedKind = kind;
                this.jjmatchedPos = curPos;
                kind = Integer.MAX_VALUE;
            }
            curPos++;
            int i4 = this.jjnewStateCnt;
            i2 = i4;
            int i5 = startsAt;
            this.jjnewStateCnt = i5;
            int i6 = 3 - i5;
            startsAt = i6;
            if (i4 == i6) {
                return curPos;
            }
            try {
                this.curChar = this.input_stream.readChar();
            } catch (IOException e2) {
                return curPos;
            }
        }
    }

    private final int jjMoveStringLiteralDfa0_9() {
        switch (this.curChar) {
            case '\"':
                return jjStopAtPos(0, 38);
            case '\'':
                return jjStopAtPos(0, 40);
            case '1':
                return jjMoveStringLiteralDfa1_9(2199023255552L);
            case '=':
                return jjMoveStringLiteralDfa1_9(687194767360L);
            default:
                return 1;
        }
    }

    private final int jjMoveStringLiteralDfa1_9(long active0) {
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '\"':
                    if ((active0 & 137438953472L) != 0) {
                        return jjStopAtPos(1, 37);
                    }
                    return 2;
                case '\'':
                    if ((active0 & 549755813888L) != 0) {
                        return jjStopAtPos(1, 39);
                    }
                    return 2;
                case '.':
                    return jjMoveStringLiteralDfa2_9(active0, 2199023255552L);
                default:
                    return 2;
            }
        } catch (IOException e2) {
            return 1;
        }
    }

    private final int jjMoveStringLiteralDfa2_9(long old0, long active0) {
        long active02 = active0 & old0;
        if (active02 == 0) {
            return 2;
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '0':
                    if ((active02 & 2199023255552L) != 0) {
                        return jjStopAtPos(2, 41);
                    }
                    return 3;
                default:
                    return 3;
            }
        } catch (IOException e2) {
            return 2;
        }
    }

    private static final boolean jjCanMove_0(int hiByte, int i1, int i2, long l1, long l2) {
        switch (hiByte) {
            case 0:
                return (jjbitVec2[i2] & l2) != 0;
            default:
                if ((jjbitVec0[i1] & l1) != 0) {
                    return true;
                }
                return false;
        }
    }

    private static final boolean jjCanMove_1(int hiByte, int i1, int i2, long l1, long l2) {
        switch (hiByte) {
            case 0:
                return (jjbitVec4[i2] & l2) != 0;
            case 1:
                return (jjbitVec5[i2] & l2) != 0;
            case 2:
                return (jjbitVec6[i2] & l2) != 0;
            case 3:
                return (jjbitVec7[i2] & l2) != 0;
            case 4:
                return (jjbitVec8[i2] & l2) != 0;
            case 5:
                return (jjbitVec9[i2] & l2) != 0;
            case 6:
                return (jjbitVec10[i2] & l2) != 0;
            case 9:
                return (jjbitVec11[i2] & l2) != 0;
            case 10:
                return (jjbitVec12[i2] & l2) != 0;
            case 11:
                return (jjbitVec13[i2] & l2) != 0;
            case 12:
                return (jjbitVec14[i2] & l2) != 0;
            case 13:
                return (jjbitVec15[i2] & l2) != 0;
            case 14:
                return (jjbitVec16[i2] & l2) != 0;
            case 15:
                return (jjbitVec17[i2] & l2) != 0;
            case 16:
                return (jjbitVec18[i2] & l2) != 0;
            case 17:
                return (jjbitVec19[i2] & l2) != 0;
            case 30:
                return (jjbitVec20[i2] & l2) != 0;
            case 31:
                return (jjbitVec21[i2] & l2) != 0;
            case 33:
                return (jjbitVec22[i2] & l2) != 0;
            case 48:
                return (jjbitVec23[i2] & l2) != 0;
            case 49:
                return (jjbitVec24[i2] & l2) != 0;
            case 159:
                return (jjbitVec25[i2] & l2) != 0;
            case 215:
                return (jjbitVec26[i2] & l2) != 0;
            default:
                if ((jjbitVec3[i1] & l1) != 0) {
                    return true;
                }
                return false;
        }
    }

    private static final boolean jjCanMove_2(int hiByte, int i1, int i2, long l1, long l2) {
        switch (hiByte) {
            case 0:
                return (jjbitVec27[i2] & l2) != 0;
            case 1:
                return (jjbitVec5[i2] & l2) != 0;
            case 2:
                return (jjbitVec28[i2] & l2) != 0;
            case 3:
                return (jjbitVec29[i2] & l2) != 0;
            case 4:
                return (jjbitVec30[i2] & l2) != 0;
            case 5:
                return (jjbitVec31[i2] & l2) != 0;
            case 6:
                return (jjbitVec32[i2] & l2) != 0;
            case 9:
                return (jjbitVec33[i2] & l2) != 0;
            case 10:
                return (jjbitVec34[i2] & l2) != 0;
            case 11:
                return (jjbitVec35[i2] & l2) != 0;
            case 12:
                return (jjbitVec36[i2] & l2) != 0;
            case 13:
                return (jjbitVec37[i2] & l2) != 0;
            case 14:
                return (jjbitVec38[i2] & l2) != 0;
            case 15:
                return (jjbitVec39[i2] & l2) != 0;
            case 16:
                return (jjbitVec18[i2] & l2) != 0;
            case 17:
                return (jjbitVec19[i2] & l2) != 0;
            case 30:
                return (jjbitVec20[i2] & l2) != 0;
            case 31:
                return (jjbitVec21[i2] & l2) != 0;
            case 32:
                return (jjbitVec40[i2] & l2) != 0;
            case 33:
                return (jjbitVec22[i2] & l2) != 0;
            case 48:
                return (jjbitVec41[i2] & l2) != 0;
            case 49:
                return (jjbitVec24[i2] & l2) != 0;
            case 159:
                return (jjbitVec25[i2] & l2) != 0;
            case 215:
                return (jjbitVec26[i2] & l2) != 0;
            default:
                if ((jjbitVec3[i1] & l1) != 0) {
                    return true;
                }
                return false;
        }
    }

    private static final boolean jjCanMove_3(int hiByte, int i1, int i2, long l1, long l2) {
        switch (hiByte) {
            case 0:
                return (jjbitVec2[i2] & l2) != 0;
            case 255:
                return (jjbitVec43[i2] & l2) != 0;
            default:
                if ((jjbitVec42[i1] & l1) != 0) {
                    return true;
                }
                return false;
        }
    }

    public APXParserTokenManager(SimpleCharStream stream) {
        this.debugStream = System.out;
        this.jjrounds = new int[34];
        this.jjstateSet = new int[68];
        this.curLexState = 13;
        this.defaultLexState = 13;
        this.input_stream = stream;
    }

    public APXParserTokenManager(SimpleCharStream stream, int lexState) {
        this(stream);
        SwitchTo(lexState);
    }

    public void ReInit(SimpleCharStream stream) {
        this.jjnewStateCnt = 0;
        this.jjmatchedPos = 0;
        this.curLexState = this.defaultLexState;
        this.input_stream = stream;
        ReInitRounds();
    }

    private final void ReInitRounds() {
        this.jjround = -2147483647;
        int i2 = 34;
        while (true) {
            int i3 = i2;
            i2--;
            if (i3 > 0) {
                this.jjrounds[i2] = Integer.MIN_VALUE;
            } else {
                return;
            }
        }
    }

    public void ReInit(SimpleCharStream stream, int lexState) {
        ReInit(stream);
        SwitchTo(lexState);
    }

    public void SwitchTo(int lexState) {
        if (lexState >= 14 || lexState < 0) {
            throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", 2);
        }
        this.curLexState = lexState;
    }

    protected Token jjFillToken() {
        Token t = Token.newToken(this.jjmatchedKind);
        t.kind = this.jjmatchedKind;
        String im = jjstrLiteralImages[this.jjmatchedKind];
        t.image = im == null ? this.input_stream.GetImage() : im;
        t.beginLine = this.input_stream.getBeginLine();
        t.beginColumn = this.input_stream.getBeginColumn();
        t.endLine = this.input_stream.getEndLine();
        t.endColumn = this.input_stream.getEndColumn();
        return t;
    }

    public Token getNextToken() {
        int curPos = 0;
        while (true) {
            try {
                this.curChar = this.input_stream.BeginToken();
                switch (this.curLexState) {
                    case 0:
                        this.jjmatchedKind = Integer.MAX_VALUE;
                        this.jjmatchedPos = 0;
                        curPos = jjMoveStringLiteralDfa0_0();
                        break;
                    case 1:
                        this.jjmatchedKind = Integer.MAX_VALUE;
                        this.jjmatchedPos = 0;
                        curPos = jjMoveStringLiteralDfa0_1();
                        break;
                    case 2:
                        this.jjmatchedKind = Integer.MAX_VALUE;
                        this.jjmatchedPos = 0;
                        curPos = jjMoveStringLiteralDfa0_2();
                        break;
                    case 3:
                        this.jjmatchedKind = Integer.MAX_VALUE;
                        this.jjmatchedPos = 0;
                        curPos = jjMoveStringLiteralDfa0_3();
                        break;
                    case 4:
                        this.jjmatchedKind = Integer.MAX_VALUE;
                        this.jjmatchedPos = 0;
                        curPos = jjMoveStringLiteralDfa0_4();
                        break;
                    case 5:
                        this.jjmatchedKind = Integer.MAX_VALUE;
                        this.jjmatchedPos = 0;
                        curPos = jjMoveStringLiteralDfa0_5();
                        break;
                    case 6:
                        this.jjmatchedKind = Integer.MAX_VALUE;
                        this.jjmatchedPos = 0;
                        curPos = jjMoveStringLiteralDfa0_6();
                        break;
                    case 7:
                        this.jjmatchedKind = Integer.MAX_VALUE;
                        this.jjmatchedPos = 0;
                        curPos = jjMoveStringLiteralDfa0_7();
                        break;
                    case 8:
                        this.jjmatchedKind = Integer.MAX_VALUE;
                        this.jjmatchedPos = 0;
                        curPos = jjMoveStringLiteralDfa0_8();
                        break;
                    case 9:
                        this.jjmatchedKind = Integer.MAX_VALUE;
                        this.jjmatchedPos = 0;
                        curPos = jjMoveStringLiteralDfa0_9();
                        break;
                    case 10:
                        this.jjmatchedKind = Integer.MAX_VALUE;
                        this.jjmatchedPos = 0;
                        curPos = jjMoveStringLiteralDfa0_10();
                        break;
                    case 11:
                        this.jjmatchedKind = Integer.MAX_VALUE;
                        this.jjmatchedPos = 0;
                        curPos = jjMoveStringLiteralDfa0_11();
                        break;
                    case 12:
                        this.jjmatchedKind = Integer.MAX_VALUE;
                        this.jjmatchedPos = 0;
                        curPos = jjMoveStringLiteralDfa0_12();
                        break;
                    case 13:
                        this.jjmatchedKind = Integer.MAX_VALUE;
                        this.jjmatchedPos = 0;
                        curPos = jjMoveStringLiteralDfa0_13();
                        break;
                }
                if (this.jjmatchedKind != Integer.MAX_VALUE) {
                    if (this.jjmatchedPos + 1 < curPos) {
                        this.input_stream.backup((curPos - this.jjmatchedPos) - 1);
                    }
                    if ((jjtoToken[this.jjmatchedKind >> 6] & (1 << (this.jjmatchedKind & 63))) != 0) {
                        Token matchedToken = jjFillToken();
                        if (jjnewLexState[this.jjmatchedKind] != -1) {
                            this.curLexState = jjnewLexState[this.jjmatchedKind];
                        }
                        return matchedToken;
                    } else if (jjnewLexState[this.jjmatchedKind] != -1) {
                        this.curLexState = jjnewLexState[this.jjmatchedKind];
                    }
                } else {
                    int error_line = this.input_stream.getEndLine();
                    int error_column = this.input_stream.getEndColumn();
                    String error_after = null;
                    boolean EOFSeen = false;
                    try {
                        this.input_stream.readChar();
                        this.input_stream.backup(1);
                    } catch (IOException e2) {
                        EOFSeen = true;
                        error_after = curPos <= 1 ? "" : this.input_stream.GetImage();
                        if (this.curChar == '\n' || this.curChar == '\r') {
                            error_line++;
                            error_column = 0;
                        } else {
                            error_column++;
                        }
                    }
                    if (!EOFSeen) {
                        this.input_stream.backup(1);
                        error_after = curPos <= 1 ? "" : this.input_stream.GetImage();
                    }
                    throw new TokenMgrError(EOFSeen, this.curLexState, error_line, error_column, error_after, this.curChar, 0);
                }
            } catch (IOException e3) {
                this.jjmatchedKind = 0;
                Token matchedToken2 = jjFillToken();
                return matchedToken2;
            }
        }
    }
}
