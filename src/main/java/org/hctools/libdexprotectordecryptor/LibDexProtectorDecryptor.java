package org.hctools.libdexprotectordecryptor;

import java.io.*;
import java.util.zip.InflaterOutputStream;

public class LibDexProtectorDecryptor
{
    static final String VERSION = LibDexProtectorDecryptor.class.getPackage().getImplementationVersion();

    public static void main(String[] args)
    {
        System.out.println("=== LibDexProtectorDecryptor v" + VERSION + " by HCTools ===\n");

        if (args.length < 1)
        {
            System.err.println("Not enough arguments! Please specify at least one encrypted library (*.so.dat) " +
                    "separated by spaces.");

            String jarName = new File(LibDexProtectorDecryptor.class
                    .getProtectionDomain().getCodeSource().getLocation().getPath()).getName();
            System.out.println("Usage: java -jar " + jarName + " [input...]");

            return;
        }

        File[] files = new File[args.length];
        for (int index = 0; index < args.length; index++)
            files[index] = new File(args[index]);

        processLib(files);
    }

    static void processLib(File[] encLibs)
    {
        for (File encLib : encLibs)
        {
            System.out.println("Processing \"" + encLib.getName() + "\"...");
            decryptLib(encLib);
        }
    }

    static void decryptLib(File encLib)
    {
        String decStr = "";
        InputStream inputStream;
        InflaterOutputStream outputStream;

        switch (encLib.getName())
        {
            case "dp.arm-v7.so.dat":
                decStr = "\u8835\u12C1\uE166\uD4BA\u40EF\u9D89\u8B21\uC2C1\u567E\u9CF5\u07DE\uDC4A\u202C";
                break;
            case "dp.arm-v8.so.dat":
                decStr = "\u5540\uB8A2\u0B20\uD7DA\u2C5B\u952A\u64CA\u868B\uE515\u83C8\uEE19\u74F2";
                break;
            case "dp.x86.so.dat":
                decStr = "\uCD2C\uF8F3\uF764\u27B9\u0B9E\u364E\u9270\u3F41\uA18E\uDC6E\u9989\u7DA2";
                break;
            case "dp.x86_64.so.dat":
                decStr = "\uDC46\u8591\uB37D\u8BA1\u7840\u2484\u2577\uBDB0\u956E\u29CE\u98DB\u30CD";
                break;
        }

        try
        {
            inputStream = new FileInputStream(encLib);
        }
        catch (FileNotFoundException exc)
        {
            System.out.println("File not found: \"" + encLib.getName() + "\"");
            exc.printStackTrace();
            return;
        }

        try
        {
            outputStream = new InflaterOutputStream(new FileOutputStream(encLib.getName() + "-decrypted"));
        }
        catch (FileNotFoundException exc)
        {
            System.out.println("File not found: \"" + encLib.getName() + "-decrypted\"");
            try
            {
                inputStream.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return;
        }

        try
        {
            DecryptUtil.Gpecd(decStr, inputStream, outputStream);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}