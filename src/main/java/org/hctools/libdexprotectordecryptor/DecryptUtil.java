package org.hctools.libdexprotectordecryptor;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DecryptUtil
{
    // Decompiled with JEB
    public static void Gpecd(String arg18, InputStream arg19, OutputStream arg20) throws IOException
    {
        char[] v4 = arg18.toCharArray();
        int[] v10 = new int[]{v4[0] | v4[1] << 16, v4[2] | v4[3] << 16, 0, 0};
        v10[2] = v4[4] | v4[5] << 16;
        v10[3] = v4[6] | v4[7] << 16;
        int[] v6 = new int[]{v4[8] | v4[9] << 16, v4[10] | v4[11] << 16};
        int[] v10_1 = hD(v10);
        byte[] v1 = new byte[0x2000];
        int v3 = 0;
        while (true)
        {
            int v11 = arg19.read(v1);
            if (v11 < 0)
            {
                return;
            }

            int v5 = v3 + v11;
            int v12;
            for (v12 = 0; v3 < v5; ++v12)
            {
                int v13 = v3 % 8;
                int v2 = v3 % 4;
                if (v13 == 0)
                {
                    tyhpnl(v10_1, v6);
                }

                v1[v12] = (byte) (((byte) (v6[v13 / 4] >> v2 * 8)) ^ v1[v12]);
                ++v3;
            }

            arg20.write(v1, 0, v11);
        }
    }

    // Decompiled with JEB
    private static int[] hD(int[] arg9)
    {
        int[] v3 = new int[27];
        int v0 = arg9[0];
        v3[0] = v0;
        int[] v1 = new int[]{arg9[1], arg9[2], arg9[3]};
        int v2;

        for (v2 = 0; v2 < 26; ++v2)
        {
            v1[v2 % 3] = (v1[v2 % 3] >>> 8 | v1[v2 % 3] << 24) + v0 ^ v2;
            v0 = (v0 << 3 | v0 >>> 29) ^ v1[v2 % 3];
            v3[v2 + 1] = v0;
        }

        return v3;
    }

    // Decompiled with JEB
    private static void tyhpnl(int[] arg6, int[] arg7)
    {
        int v1 = arg7[0];
        int v0 = (arg7[1] >>> 8 | arg7[1] << 24) + v1 ^ arg6[0];
        int v1_1 = (v1 << 3 | v1 >>> 29) ^ v0;
        int v0_1 = (v0 >>> 8 | v0 << 24) + v1_1 ^ arg6[1];
        int v1_2 = (v1_1 << 3 | v1_1 >>> 29) ^ v0_1;
        int v0_2 = (v0_1 >>> 8 | v0_1 << 24) + v1_2 ^ arg6[2];
        int v1_3 = (v1_2 << 3 | v1_2 >>> 29) ^ v0_2;
        int v0_3 = (v0_2 >>> 8 | v0_2 << 24) + v1_3 ^ arg6[3];
        int v1_4 = (v1_3 << 3 | v1_3 >>> 29) ^ v0_3;
        int v0_4 = (v0_3 >>> 8 | v0_3 << 24) + v1_4 ^ arg6[4];
        int v1_5 = (v1_4 << 3 | v1_4 >>> 29) ^ v0_4;
        int v0_5 = (v0_4 >>> 8 | v0_4 << 24) + v1_5 ^ arg6[5];
        int v1_6 = (v1_5 << 3 | v1_5 >>> 29) ^ v0_5;
        int v0_6 = (v0_5 >>> 8 | v0_5 << 24) + v1_6 ^ arg6[6];
        int v1_7 = (v1_6 << 3 | v1_6 >>> 29) ^ v0_6;
        int v0_7 = (v0_6 >>> 8 | v0_6 << 24) + v1_7 ^ arg6[7];
        int v1_8 = (v1_7 << 3 | v1_7 >>> 29) ^ v0_7;
        int v0_8 = (v0_7 >>> 8 | v0_7 << 24) + v1_8 ^ arg6[8];
        int v1_9 = (v1_8 << 3 | v1_8 >>> 29) ^ v0_8;
        int v0_9 = (v0_8 >>> 8 | v0_8 << 24) + v1_9 ^ arg6[9];
        int v1_10 = (v1_9 << 3 | v1_9 >>> 29) ^ v0_9;
        int v0_10 = (v0_9 >>> 8 | v0_9 << 24) + v1_10 ^ arg6[10];
        int v1_11 = (v1_10 << 3 | v1_10 >>> 29) ^ v0_10;
        int v0_11 = (v0_10 >>> 8 | v0_10 << 24) + v1_11 ^ arg6[11];
        int v1_12 = (v1_11 << 3 | v1_11 >>> 29) ^ v0_11;
        int v0_12 = (v0_11 >>> 8 | v0_11 << 24) + v1_12 ^ arg6[12];
        int v1_13 = (v1_12 << 3 | v1_12 >>> 29) ^ v0_12;
        int v0_13 = (v0_12 >>> 8 | v0_12 << 24) + v1_13 ^ arg6[13];
        int v1_14 = (v1_13 << 3 | v1_13 >>> 29) ^ v0_13;
        int v0_14 = (v0_13 >>> 8 | v0_13 << 24) + v1_14 ^ arg6[14];
        int v1_15 = (v1_14 << 3 | v1_14 >>> 29) ^ v0_14;
        int v0_15 = (v0_14 >>> 8 | v0_14 << 24) + v1_15 ^ arg6[15];
        int v1_16 = (v1_15 << 3 | v1_15 >>> 29) ^ v0_15;
        int v0_16 = (v0_15 >>> 8 | v0_15 << 24) + v1_16 ^ arg6[16];
        int v1_17 = (v1_16 << 3 | v1_16 >>> 29) ^ v0_16;
        int v0_17 = (v0_16 >>> 8 | v0_16 << 24) + v1_17 ^ arg6[17];
        int v1_18 = (v1_17 << 3 | v1_17 >>> 29) ^ v0_17;
        int v0_18 = (v0_17 >>> 8 | v0_17 << 24) + v1_18 ^ arg6[18];
        int v1_19 = (v1_18 << 3 | v1_18 >>> 29) ^ v0_18;
        int v0_19 = (v0_18 >>> 8 | v0_18 << 24) + v1_19 ^ arg6[19];
        int v1_20 = (v1_19 << 3 | v1_19 >>> 29) ^ v0_19;
        int v0_20 = (v0_19 >>> 8 | v0_19 << 24) + v1_20 ^ arg6[20];
        int v1_21 = (v1_20 << 3 | v1_20 >>> 29) ^ v0_20;
        int v0_21 = (v0_20 >>> 8 | v0_20 << 24) + v1_21 ^ arg6[21];
        int v1_22 = (v1_21 << 3 | v1_21 >>> 29) ^ v0_21;
        int v0_22 = (v0_21 >>> 8 | v0_21 << 24) + v1_22 ^ arg6[22];
        int v1_23 = (v1_22 << 3 | v1_22 >>> 29) ^ v0_22;
        int v0_23 = (v0_22 >>> 8 | v0_22 << 24) + v1_23 ^ arg6[23];
        int v1_24 = (v1_23 << 3 | v1_23 >>> 29) ^ v0_23;
        int v0_24 = (v0_23 >>> 8 | v0_23 << 24) + v1_24 ^ arg6[24];
        int v1_25 = (v1_24 << 3 | v1_24 >>> 29) ^ v0_24;
        int v0_25 = (v0_24 >>> 8 | v0_24 << 24) + v1_25 ^ arg6[25];
        int v1_26 = (v1_25 << 3 | v1_25 >>> 29) ^ v0_25;
        int v0_26 = (v0_25 >>> 8 | v0_25 << 24) + v1_26 ^ arg6[26];

        arg7[0] = (v1_26 << 3 | v1_26 >>> 29) ^ v0_26;
        arg7[1] = v0_26;
    }
}