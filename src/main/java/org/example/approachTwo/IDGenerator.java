package org.example.approachTwo;

import org.example.util.FileUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IDGenerator {
    private Integer id;

    public IDGenerator() {
       id = FileUtil.readCount();
    }

    public Integer getId() {
        synchronized ("lock") {
            id = id + 1;
            FileUtil.saveCountToFile(id);
        }
        return id;
    }

}
