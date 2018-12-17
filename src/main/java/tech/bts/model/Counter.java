package tech.bts.model;

public class Counter {
    private int value;
    private long id;
    private int formNumber;

    public Counter(){
        this.value = 0;
        this.formNumber = 1;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.formNumber = value;
        this.value += value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getFormNumber() {
        return formNumber;
    }
}
