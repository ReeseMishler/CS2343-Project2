# CS2343-Project2

## Overview of the Program
This project will use a myriad of classes (some derived from abstract classes) to perform functions involving calculating the day of the week of a particular calendar day as well as extracting information from a text file and performing multiple operations on that information. 

The primary function of the program will be to take in a four-character station ID and then find the following:
 1.	The index of that station within the provided Mesonet.txt file
 2.	Find two sets of stations who’s indices average out to the index of the given station
 3.	Find and use the ACSII values of the characters making up the station ID
 4.	Find other stations with the letter value of the avg. ACSII value of the given station ID 

## DateTimeInherit Class
This class inherits from the *DateTimeAbstract* class which specifies the derived class must instantiate a *daysOfAnyMonth* method. This class will create a YearMonth object that, given a year and a month, will calculate the number of days within that month.This action is performed within the *daysOfAnyMonth* class. This information will then be passed to the *dayOfWeek* method which, using a LocalDate object, will be able to figure out the precise day of the week of a given date. That day will be passed back to the *daysOfAnyMonth* class which will use it to print the information in the project's specified format.

## PosAvg Class
This class uses three different class methods and a single constructor. The constructor takes a String a four characters which make up a station ID that will reside in the Mesonet.txt file provided. It will then store this String in a String class variable called **givenID**.

### Method: getStrArr()
This method will be used to read through the Mesonet.txt file and extract each of the station IDs within it. Each ID will be stored into an ArryList class variable called **okStations**. Once the file has been read through and all of the station IDs have been extracted, the method will return **okStations**.

### Method: indexOfStation()
This method will use the **okStations** class variable by looping through the ArrayList until it finds a string matching the class variable **givenID**. Once it finds this match, it will store the index value (plus one because the ArrayList is a 0 index list) into the class variable **idxOfGivenID**. It will then fill four other class variables with the two IDs that come before the **givenID** and the two IDs that come after it. The method will then return **idxOfGivenID**.

### Method: toString()
This *toString* method has been overridden to print off the four stations that were found to be surrounding the **givenID**. The method prints this information in the projects specified format where it details these stations as being the averages of the **givenID**.

## MesoInherit Class


## LetterAvg Class
