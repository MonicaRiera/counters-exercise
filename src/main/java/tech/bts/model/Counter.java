package tech.bts.model;

public class Counter {
    private int value;
    private long id;
    private int formNumber;

    public Counter(long id){
        this.value = 0;
        this.formNumber = 1;
        this.id = id;
    }

    public int getValue() {
        return value;
    }


    public void addValue(int value) {
        this.formNumber = value;
        this.value += value;
    }

    public void increment(){
        this.value++;
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
