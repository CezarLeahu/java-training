package org.example.exceptions;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import static java.util.UUID.randomUUID;

public class TempFileWriter {

    public static void writeTempFile() throws IOException {
        Writer w = new FileWriter("/tmp/" + randomUUID() + ".tmp");
        w.write("Some useless file!\n");
        w.flush();
        w.close();
    }

    public static void writeTempFileWithRegularTryCatch() {

        Writer w = null;
        try {
            w = new FileWriter("/tmp/" + randomUUID() + ".tmp");
            w.write("Some useless file!\n");
            w.flush();
        } catch (Exception e) {
            System.out.println("Some IO exception occurred while writing to the file");
        } finally {
            if (w != null) {
                try {
                    w.close();
                } catch (Exception ex) {
                    System.out.println("Some IO exception occurred when closing the stream");
                }
            }
        }
    }

    public static void writeTempFileWithTryWithResources() {

        try (Writer w = new FileWriter("/tmp/" + randomUUID() + ".tmp")) {
            w.write("Some useless file!\n");
            w.flush();
        } catch (IOException e) {
            System.out.println("Some IO exception occurred while writing or closing the file");
        }
    }

    public static void main(String... args) throws Exception {

        writeTempFile();

        writeTempFileWithRegularTryCatch();

        writeTempFileWithTryWithResources();
    }
}
