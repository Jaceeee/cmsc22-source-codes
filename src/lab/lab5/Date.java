package lab.lab5;

/**
 * Created by Juan Carlos on 12/17/2016.
 */
public class Date{
    private int year;
    private int day;
    private int month;

    Date(){
        year = 1000;
        month = 1;
        day = 1;
    }

    Date(int y, int m, int d){
        setYear(y);
        setMonth(m);
        setDay(d);
    }

    public int getYear(){
        return year;
    }

    public int getMonth(){
        return month;
    }

    public int getDay(){
        return day;
    }

    public void setYear(int y){
        if(y<1000 || y>99999){
            throw new IllegalArgumentException("The year must be greater than 1000 and less than 9999.");
        }
        if(!leapYearCheck(y)){ //if the previously set day, month and year constitute a leap year, and when we suddenly change the year
            if(month == 2 && day > 28){	//it should not be allowed
                throw new IllegalArgumentException("It's not a leap year anymore. Change elsewhere first");
            }
        }

        year = y;
    }

    public void setMonth(int m){
        if(m<1 || m>12){
            throw new IllegalArgumentException("The month must be within bounds.");
        }
        if(((m == 4 || m == 6 || m == 9 || m == 11) && day > 30) || (m == 2 && day > 28 && (leapYearCheck(year) == false))){ //if the day set is more than the maximum day for that month
            throw new IllegalArgumentException("Change day first.");
        }
        if(m == 2 && day > 29 && leapYearCheck(year)){ //if it is a leap year
            //it is a leap year only if the year is divisible by four and not divisible by 100, or if the year is divisible by 100, it must also be divisible by 100.
            throw new IllegalArgumentException("Month is in February, and it's a leap year. Change elsewhere.");
        }
        month = m;
    }

    public void setDay(int d){
        if(d<1 || d>31){
            throw new IllegalArgumentException("The day must be within bounds.");
        }
        if((d > 30 && (month == 4 || month == 6 || month == 9 || month == 11)) || (d > 28 && month == 2 &&(leapYearCheck(year) == false))){ //if the day set is more than the maximum day for that month
            throw new IllegalArgumentException("Change month first.");
        }
        if(d > 29 && month == 2 && leapYearCheck(year)){ // if it is a leap year
            //it is a leap year only if the year is divisible by four and not divisible by 100, or if the year is divisible by 100, it must also be divisible by 100.
            throw new IllegalArgumentException("Month is in February, and it's a leap year. Change elsewhere.");
        }
        day = d;
    }

    public void setDate(int y, int m, int d){
        setYear(y);
        setMonth(m);
        setDay(d);
    }

    public String toString(){
        String answer;
        answer = String.format("%02d/%02d/%d",day,month,year);
        return answer;
    }

    private boolean leapYearCheck(int year){
        if(year % 4 == 0){
            if(year % 100 != 0 || (year % 100 == 0 && year % 400 == 0)){
                return true;
            }
        }
        return false;
    }
}
