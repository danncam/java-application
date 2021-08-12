package OO;
public class Student extends Person
{
    protected String course, cr;
    
    public void setStudent(String course, String cr)
    {
        setCourse(course);
        setCr(cr);
    }
    public void setCourse(String course) {
        this.course = course;
    }

    public void setCr(String cr) {
        if(Byte.parseByte(cr) < 0 || Byte.parseByte(cr) > 10)
        this.cr = cr;
    }

    public String getCourse() {
        return course;
    }

    public String getCr() {
        return cr;
    }

    
}
