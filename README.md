# U1EX02C

This Java program reads data from an XML file containing information about cars. It uses JAXB (Java Architecture for XML Binding) to parse the XML file and convert it into Java objects. The program then sorts the cars by year (from oldest to newest) and writes the formatted data into a text file named cars.txt.

The same information is printed on the console and also saved in cars.txt.

Operating system: Windows 11.

IDE: Visual Studio Code (VSCode)

Java version used:
Java(TM) SE Runtime Environment (build 1.8.0_461-b11)
Java HotSpot(TM) 64-Bit Server VM (build 25.461-b11, mixed mode)

Libraries used:
javax.xml.bind for JAXB parsing (JAXBContext, Unmarshaller, annotations)
java.util for list handling and sorting
java.io for file reading and writing

Execution instructions: 
Place the files Main.java, Car.java, Cars.java, and cars.xml in the same directory.
Ensure the XML file cars.xml follows the structure expected by JAXB (root element <cars> with multiple <car> elements).

The program will display the sorted list of cars on the console and create a text file named cars.txt in the same directory.
