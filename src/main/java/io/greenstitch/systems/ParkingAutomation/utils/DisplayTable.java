package io.greenstitch.systems.ParkingAutomation.utils;

import java.util.ArrayList;
import java.util.List;

/***
 * Displays the parking status of the parking lot in tabular format
 * 
 * @param columnSize -> size of the column in the table
 * @param headers    -> list of headers for the table {Slot no, Registration
 *                   Number, Color}
 * @param details    -> list of details for the table for individual parking
 *                   slots
 * 
 */

public class DisplayTable {
    private String header;
    private List<String> rows;
    private int columnSize;

    public DisplayTable(int columnSize) {
        this.columnSize = columnSize;
        this.header = "";
        this.rows = new ArrayList<String>();
    }

    public void addHeader(List<String> headers) {
        StringBuilder headerBuilder = new StringBuilder();
        for (String head : headers) {
            int headerSize = head.length();
            if (columnSize > headerSize) {
                headerBuilder.append(head + " ".repeat(this.columnSize - headerSize));
            }
        }
        this.header = headerBuilder.toString();
    }

    public void addRow(List<String> details) {
        StringBuilder rowBuilder = new StringBuilder();
        for (String data : details) {
            int dataSize = data.length();
            if (columnSize > dataSize) {
                rowBuilder.append(data + " ".repeat(this.columnSize - dataSize));
            }
        }
        this.rows.add(rowBuilder.toString());
    }

    public void display() {
        System.out.println(this.header);
        for (String row : this.rows) {
            System.out.println(row);
        }
    }
}
