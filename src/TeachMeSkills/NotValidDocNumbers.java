package TeachMeSkills;

public class NotValidDocNumbers {

   private String number;
   private String comment;

    public NotValidDocNumbers(String number, String comment) {
        this.number = number;
        this.comment = comment;
    }

    public NotValidDocNumbers() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

