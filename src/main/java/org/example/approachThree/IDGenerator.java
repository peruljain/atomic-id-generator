package org.example.approachThree;

import org.example.util.FileUtil;

public class IDGenerator {
    private Integer id;
    private final Integer x;

    public IDGenerator (Integer x) {
        this.x = x;
        id = FileUtil.readCount() + x;
    }

    public Integer getId() {
        synchronized ("lock") {
            id = id + 1;
            if(id%x==0) {
                FileUtil.saveCountToFile(id);
            }
        }
        return id;
    }

}
