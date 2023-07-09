package entities;

import java.time.LocalDate;

public class HourContract {

    private LocalDate date;
    private Double valuePerHour;
    private Integer hours;

    public HourContract() {
    }

    public HourContract(LocalDate date, Double valuePerHour, Integer hours) {
        this.date = date;
        this.valuePerHour = valuePerHour;
        this.hours = hours;
    }

    public LocalDate getDate() {
        return date;
    }

    public Double getValuePerHour() {
        return valuePerHour;
    }


    public Integer getHours() {
        return hours;
    }

    public double totalValue() {
        return valuePerHour * hours;
    }

}
