package com.shu.thirteenthchapter.Strings;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Formatter;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.sym.error;

/**
 * Formatter.format()
 * %[argument_index$][flags][width][.precision][t]conversion
 * Created by Administrator on 2017-06-07.
 */
public class Turtle {
    private String name;
    private Formatter f;

    public Turtle(String name, Formatter f) {
        this.name = name;
        this.f = f;
    }

    public void move(int x, int y) {
        f.format("%s The Turtle is at (%d, %d)\n", this.name, x, y);
    }

    public static class Main {
        public static void main(String[] args) throws Exception{
            PrintStream ps = System.out;
            Turtle tommy = new Turtle("tommy", new Formatter(System.out));
            Turtle john = new Turtle("john", new Formatter(ps));
            tommy.move(0, 0);
            john.move(1, 2);
            tommy.move(3, 4);
            john.move(5, 6);

            Turtle error = new Turtle("error", new Formatter(System.err));
            error.move(7,8);

            //File
            File file = new File("E://pratice.txt");
            if(!file.exists()) file.createNewFile();
            Turtle fileTurthle = new Turtle("fileTurthle", new Formatter(file));
            fileTurthle.move(10,11);
            fileTurthle.f.flush();

            //OutputStream
            Turtle OutputStreamTurthle = new Turtle("OutputStreamTurthle",
                    new Formatter(new FileOutputStream(file)));
            OutputStreamTurthle.move(20,30);
            OutputStreamTurthle.move(40,50);
            OutputStreamTurthle.f.close();
        }
    }
}/**
    error The Turtle is at (7, 8)
    tommy The Turtle is at (0, 0)
    john The Turtle is at (1, 2)
    tommy The Turtle is at (3, 4)
    john The Turtle is at (5, 6)


*///~
