package OO;
public class Professor extends Person
{
    protected String institute, siape, research, course;
    
    public void setProfessor(String institute, String course, String siape, String research)
    {
        setInstitute(institute);
        setCourse(course);
        setSiape(siape);
        setResearch(research);
    }
    public void setInstitute(String institute) 
    {
        this.institute = institute;
    }

    public void setResearch(String research) 
    {
        this.research = research;
    }

    public void setSiape(String siape) 
    {
        if(siape.length() == 7)
            this.siape = siape;
        else
            System.out.println("Siape inválido: diferente de 7 digitos");
    }

    public void setCourse(String course) 
    {
        this.course = course;
    }
    

    public String getInstitute() 
    {
        return institute;
    }

    public String getResearch() 
    {
        return research;
    }

    public String getSiape() 
    {
        return siape;
    }

    public String getCourse()
    {
        return course;
    }
    
    
    
    
}
