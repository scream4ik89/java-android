public interface MyCollectionContract<Department, Staff > {

    //функционал для добавления директора
    void setDirector(Staff director);
    Staff getDirector();
    void removeDirector();

    //функционал для добавления отдела
    void addDepartment(Department department);
    void removeDepartment(Department department);

    //функционал для добавления сотрудника
    void addStaff(Staff staff, Department department);
    void removeStaff(Staff staff, Department department);
    void moveStaff(Staff staff, Department departmentOut, Department departmentIn);
}
