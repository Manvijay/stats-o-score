//Following class is an utility to read CSV file and it can be used from within the Android application.

package com.example.manvijay.sports_app;

/**
 * Created by Deepak on 25-03-2018.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVFile {
    InputStream inputStream;  //Declaring InputStream

    public CSVFile(InputStream inputStream){
        this.inputStream = inputStream;
    }

    public List read(){
        List resultList = new ArrayList(); // Creating a list to put the value from Csv to list
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));  //Open file
        try {
            String csvLine;
            while ((csvLine = reader.readLine()) != null) {  //Reading line by line from file
                String[] row = csvLine.split(",");  //Splitting the line to form a string Array
                resultList.add(row); // Adding String array to the List
            }
        }
        catch (IOException ex) {
            throw new RuntimeException("Error in reading CSV file: "+ex);
        }
        finally {
            try {
                inputStream.close();
            }
            catch (IOException e) {
                throw new RuntimeException("Error while closing input stream: "+e);
            }
        }
        return resultList;  // The function will return this list
    }
}
