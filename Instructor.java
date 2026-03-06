package SystemClassAndMain;


public class Instructor {
	private String instructorName;
    private String specialization;
    private String phone;

    public Instructor(String instructorName, String specialization, String phone) {
        this.instructorName = instructorName;
        this.specialization = specialization;
        this.phone = phone;
    }

   
    @Override
    public String toString() {
        return  "   - Name       : " + instructorName + "\n" +
                "   - Specialty  : " + specialization + "\n" +
                "   - Phone      : " + phone + "\n";
    }
}