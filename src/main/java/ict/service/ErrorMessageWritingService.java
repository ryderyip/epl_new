package ict.service;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class ErrorMessageWritingService {
    public static void write(HttpServletResponse response, String title, String message) {
        try {
            PrintWriter writer = response.getWriter();
            writer.println("<h1>"+title+"</h1>\n" +
                    "    <p>\n" +
                    "        Error Message: "+message+"\n" +
                    "    </p>\n" +
                    "    <a href=\"javascript:history.back()\">Go Back</a>");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
