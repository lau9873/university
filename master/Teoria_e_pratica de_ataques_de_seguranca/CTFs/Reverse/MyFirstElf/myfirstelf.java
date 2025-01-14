public class myfirstelf{
    public static void main(String[] args){
        byte[] local_38 = new byte [44];
        int local_c;
        long param_1;
        local_38[0] = 0x52;
        local_38[1] = 0x59;
        local_38[2] = 0x4d;
        local_38[3] = 0x5c;
        local_38[4] = 0x69;
        local_38[5] = 0x62;
        local_38[6] = 0x2b;
        local_38[7] = 0x77;
        local_38[8] = 0x7d;
        local_38[9] = 0x11;
        local_38[10] = 0x49;
        local_38[11] = 0x14;
        local_38[12] = 0x75;
        local_38[13] = 0x59;
        local_38[14] = 0;
        local_38[15] = 0x6c;
        local_38[16] = 0x44;
        local_38[17] = 10;
        local_38[18] = 0x4a;
        local_38[19] = 0xc;
        local_38[20] = 0x30;
        local_38[21] = 0x36;
        local_38[22] = 0x7b;
        local_38[23] = 0x14;
        local_38[24] = 0x7d;
        local_38[25] = 0x3f;
        local_38[26] = 0x33;
        local_38[27] = 0x66;
        local_38[28] = 0x34;
        local_38[29] = 0x6e;
        local_38[30] = 0x53;
        local_38[31] = 0x11;
        local_38[32] = 0x57;
        local_38[33] = 7;
        local_38[34] = 0xb;
        local_38[35] = 0x12;
        local_c = 0;
        while (!(0x23 < local_c)) {
            param_1 = ((local_38[local_c] )^ (local_c + 2) * 3) ;
            // System.out.println(' ' + local_38[local_c]  + " " + (local_c + 2) * 3 + ' '+ param_1);
            System.out.print(param_1 + " ");
            local_c = local_c + 1;
        }

    }  
 } 