package org.example.approachOne;

public class IDGenerator {

    private Integer id;

    public IDGenerator(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        synchronized (this) {
            id = id + 1;
        }
        return id;
    }

}
