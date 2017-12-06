public class Pacient {
    private String name;
    private String sorname;
    private String yearBirthday;
    private String monthBirthday;
    public Pacient(String name, String sorname, String yearBirthday, String monthBirthday){
        this.name = name;
        this.sorname = sorname;
        this.yearBirthday = yearBirthday;
        this.monthBirthday = monthBirthday;
    }
    public String getName(){
        return name;
    }
    public String getSorname(){
        return sorname;
    }
    public String getYearBirthday() { return yearBirthday; }
    public String getMonthBirthday() { return monthBirthday; }

}
