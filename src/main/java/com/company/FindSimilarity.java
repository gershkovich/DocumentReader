package com.company;

import java.io.IOException;

/**
 * Created by petergershkovich on 3/25/15.
 */
public class FindSimilarity
{
    public static void main(String[] args)
    {

        String x = "this is a test";

        String y = "this is a test";


        try
        {
            CosineDocumentSimilarity cosineDocumentSimilarity = new CosineDocumentSimilarity(x, y);

            double d = cosineDocumentSimilarity.getCosineSimilarity();

            System.out.println("score: " + d);

        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
