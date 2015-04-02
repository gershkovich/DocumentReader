package com.company;

        import java.util.ArrayList;
        import java.util.List;

/**
 * Created by pg86 on 3/18/15.
 */
public class   Publication
{
    private List<String> authors = new ArrayList<String>();
    private Integer year;
    private String abst;
    private String label;
    private String link;
    private String title;

    public String getTitle()
    {

        return title;
    }

    public void setTitle(String title)
    {

        this.title = title;
    }

    public List<String> getAuthors()
    {

        return authors;
    }

    public void setAuthors(List<String> authors)
    {

        this.authors = authors;
    }

    public Integer getYear()
    {

        return year;
    }

    public void setYear(Integer year)
    {

        this.year = year;
    }

    public String getAbst()
    {

        return abst;
    }

    public void setAbst(String abst)
    {

        this.abst = abst;
    }

    public String getLabel()
    {

        return label;
    }

    public void setLabel(String label)
    {

        this.label = label;
    }

    public String getLink()
    {

        return link;
    }

    public void setLink(String link)
    {

        this.link = link;
    }

    public String toString()
    {

        return authors.get(0) + "\t" + year + "\t" + title + "\t" + label + "\t" + abst;
    }
}