package bean;

public class Student implements java.io.Serializable {
    private int student_id;
    private String student_name;
    private String course_id;
    private String course_name;

    public int getstudent_id() {
        return student_id;
    }

    public String getstudent_name() {
        return student_name;
    }

    public String getcourse_id() {
        return course_id;
    }

    public String getcourse_name() {
        return course_name;
    }

    public void setstudent_id(int student_id) {
        this.student_id = student_id;
    }

    public void setstudent_name(String student_name) {
        this.student_name = student_name;
    }

    public void setcourse_id(String course_id) {
        this.course_id = course_id;
    }

    public void setcourse_name(String course_name) {
        this.course_name = course_name;
    }
}
