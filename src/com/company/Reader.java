package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

public class Reader {
    private boolean _eof = false;
    private BufferedReader _fileReader;

    public Reader(int day) throws FileNotFoundException {
        String currentDirectory = Paths.get(".").toAbsolutePath().normalize().toString();
        String fileInput = currentDirectory + "\\data\\day-" + day + ".txt";
        System.out.println("Reading " + fileInput);
        FileReader fr = new FileReader(fileInput);
        _fileReader = new BufferedReader(fr);
    }

    public String nextLine() throws IOException {
        if (_eof) {
            return null;
        }
        String nextResult = _fileReader.readLine();

        if (nextResult == null) {
            _eof = true;
        }

        return nextResult;
    }

    public boolean EOF() {
        return _eof;
    }
}
