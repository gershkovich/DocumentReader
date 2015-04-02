package com.company;


        import org.apache.poi.ss.usermodel.Cell;
        import org.apache.poi.ss.usermodel.Row;
        import org.apache.poi.ss.usermodel.Sheet;
        import org.apache.poi.ss.usermodel.Workbook;
        import org.apache.poi.xssf.usermodel.XSSFWorkbook;

        import java.io.File;
        import java.io.FileInputStream;
        import java.util.*;

public class ByMonth
{

    public static void main(String[] args)
    {

        List<Publication> publications = new ArrayList<Publication>();


        try
        {
            File file = new File("/Users/pg86/Documents/api_2014.xlsx");

            Workbook wb = new XSSFWorkbook(new FileInputStream(file));

            for ( int i = 0; i < wb.getNumberOfSheets(); i++ )
            {
                Sheet sheet = wb.getSheetAt(i);

                for ( Row row : sheet )
                {
                    if ( row.getRowNum() > 0 ) //skip titles
                    {
                        Publication publication = new Publication();

                        for ( Cell cell : row )
                        {


                            switch ( cell.getColumnIndex() )
                            {
                                case 0:

                                    System.out.println(cell.toString());

                                    String authStr = cell.toString().replaceAll(" and ", ",");

                                    String[] auth = authStr.split(",");

                                    for ( String author : auth )
                                    {
                                        String[] el = author.split("\\.");

                                        if ( el.length > 1 )


                                        {
                                            publication.getAuthors().add(el[1].trim() + ", " + el[0].trim());
                                        }

                                        else
                                        {
                                            publication.getAuthors().add(el[0].trim());
                                        }
                                    }


                                    break;

                                case 1:


                                    try
                                    {
                                        publication.setYear((( Double ) cell.getNumericCellValue()).intValue());

                                    } catch ( NumberFormatException e )
                                    {

                                    }

                                    break;
                                case 2:

                                    publication.setTitle(cell.toString());

                                    break;
                                case 3:

                                    break;
                                case 4:


                                    publication.setLabel(cell.toString());

                                    break;
                                case 5:

                                    publication.setAbst(cell.toString());

                                    break;


                                default:

                                    break;

                            }

                        }

                        publications.add(publication);

                    }
                }


            }

        } catch ( Throwable t )
        {
            t.printStackTrace();
        }


        for ( Publication pub : publications )
        {
            //   System.out.println(pub);
        }

        findAuthorsByYear(publications, 2010);
//        findAuthorsByYear(publications, 2011);
//        findAuthorsByYear(publications, 2012);
//        findAuthorsByYear(publications, 2013);
//        findAuthorsByYear(publications, 2014);

    }

    private static void findAuthorsByYear(List<Publication> publications, int year)
    {

        Set<String> uniqueAuthors = new TreeSet<String>();

        int articles = 0;

        for ( Publication pub : publications )
        {

            uniqueAuthors.addAll(pub.getAuthors());

            articles ++ ;


        }

        //        for ( String auth : uniqueAuthors )
        //        {
        //            System.out.println(auth);
        //        }

        System.out.println("Pubs in : " + year + " - " + articles + "Total authors in : " + year + "\t" + uniqueAuthors.size());

    }
}
