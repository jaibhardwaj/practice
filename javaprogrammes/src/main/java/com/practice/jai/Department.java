package com.practice.jai;

public class Department
{
    private String department;

    public Department(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString()
    {
        return department;
    }

    @Override
    public boolean equals(Object o)
    {
        if(o == this)
        {
            return true;
        }

        if(o == null || o.getClass() != getClass())
        {
            return false;
        }

        Department d1 = (Department) o;

        return d1.department != null && (d1.department == this.department || d1.department.equals(this.department));
    }

    @Override
    public int hashCode()
    {
        return department != null ? department.hashCode() : 0;
    }
}
