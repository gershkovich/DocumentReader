package com.company;

import com.google.common.io.BaseEncoding;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException
    {

        File sourceImage = new File("/Users/petergershkovich/Downloads/JPatholInform613-8110107_223141.pdf");
        File sourceImage64 = new File("source3.txt");
        File destImage = new File("sample_report_conv.pdf");


        BufferedInputStream in = null;
        BufferedWriter out = null;
        try {

            in = new BufferedInputStream(new FileInputStream(sourceImage));

            out = new BufferedWriter(new FileWriter(sourceImage64));

            encodeStream(in, out);

            out.flush();


        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally {
            if (in != null)
                in.close();
            if (out != null)
                out.close();
        }

    }

    private static void encodeFile(File inputFile, File outputFile) throws IOException {
        BufferedInputStream in = null;
        BufferedWriter out = null;
        try {
            in = new BufferedInputStream(new FileInputStream(inputFile));
            out = new BufferedWriter(new FileWriter(outputFile));
            encodeStream(in, out);
            out.flush();
        } finally {
            if (in != null)
                in.close();
            if (out != null)
                out.close();
        }
    }

    private static void encodeStream(InputStream in, BufferedWriter out) throws IOException {
        int lineLength = 76;
        byte[] buf = new byte[lineLength / 4 * 3];
        while (true) {
            int len = in.read(buf);
            if (len <= 0)
            break;
            out.write(BaseEncoding.base64().encode(buf, 0, len));
           // out.newLine();
        }
    }

    static String encodeArray(byte[] in) throws IOException {
        StringBuffer out = new StringBuffer();
        out.append(BaseEncoding.base64().encode(in, 0, in.length));
        return out.toString();
    }

    static byte[] decodeArray(String in) throws IOException {
        byte[] buf = BaseEncoding.base64().decode(in);
        return buf;
    }

    private static void decodeFile(File inputFile, File outputFile) throws IOException {
        BufferedReader in = null;
        BufferedOutputStream out = null;
        try {
            in = new BufferedReader(new FileReader(inputFile));
            out = new BufferedOutputStream(new FileOutputStream(outputFile));
            decodeStream(in, out);
            out.flush();
        } finally {
            if (in != null)
                in.close();
            if (out != null)
                out.close();
        }
    }

    private static void decodeStream(BufferedReader in, OutputStream out) throws IOException {
        while (true) {
            String s = in.readLine();
            if (s == null)
                break;
            byte[] buf = BaseEncoding.base64().decode(s);
            out.write(buf);
        }
    }
}
