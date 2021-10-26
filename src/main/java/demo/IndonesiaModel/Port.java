package demo.IndonesiaModel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Port {

    @JsonProperty("JANUARY")
    private Month january;

    @JsonProperty("FEBRUARY")
    private Month february;

    @JsonProperty("MARCH")
    private Month march;

    @JsonProperty("APRIL")
    private Month april;

    @JsonProperty("MAY")
    private Month may;

    @JsonProperty("JUNE")
    private Month june;

    @JsonProperty("JULY")
    private Month july;

    @JsonProperty("AUGUST")
    private Month august;

    @JsonProperty("SEPTEMBER")
    private Month september;

    @JsonProperty("OCTOBER")
    private Month october;

    @JsonProperty("NOVEMBER")
    private Month november;

    @JsonProperty("DECEMBER")
    private Month december;

    public Port() {
    }

    public Port(Month january, Month february, Month march,
                Month april, Month may, Month june, Month july,
                Month august, Month september, Month october,
                Month november, Month december) {
        this.january = january;
        this.february = february;
        this.march = march;
        this.april = april;
        this.may = may;
        this.june = june;
        this.july = july;
        this.august = august;
        this.september = september;
        this.october = october;
        this.november = november;
        this.december = december;
    }

    public Month getJanuary() {
        return january;
    }

    public void setJanuary(Month january) {
        this.january = january;
    }

    public Month getFebruary() {
        return february;
    }

    public void setFebruary(Month february) {
        this.february = february;
    }

    public Month getMarch() {
        return march;
    }

    public void setMarch(Month march) {
        this.march = march;
    }

    public Month getApril() {
        return april;
    }

    public void setApril(Month april) {
        this.april = april;
    }

    public Month getMay() {
        return may;
    }

    public void setMay(Month may) {
        this.may = may;
    }

    public Month getJune() {
        return june;
    }

    public void setJune(Month june) {
        this.june = june;
    }

    public Month getJuly() {
        return july;
    }

    public void setJuly(Month july) {
        this.july = july;
    }

    public Month getAugust() {
        return august;
    }

    public void setAugust(Month august) {
        this.august = august;
    }

    public Month getSeptember() {
        return september;
    }

    public void setSeptember(Month september) {
        this.september = september;
    }

    public Month getOctober() {
        return october;
    }

    public void setOctober(Month october) {
        this.october = october;
    }

    public Month getNovember() {
        return november;
    }

    public void setNovember(Month november) {
        this.november = november;
    }

    public Month getDecember() {
        return december;
    }

    public void setDecember(Month december) {
        this.december = december;
    }

    @Override
    public String toString() {
        return "Port{" +
                "january=" + january +
                ", february=" + february +
                ", march=" + march +
                ", april=" + april +
                ", may=" + may +
                ", june=" + june +
                ", july=" + july +
                ", august=" + august +
                ", september=" + september +
                ", october=" + october +
                ", november=" + november +
                ", december=" + december +
                '}';
    }
}
