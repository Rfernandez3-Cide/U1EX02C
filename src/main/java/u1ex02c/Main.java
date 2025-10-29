// Roberto Fernández del Barrio //
// 43232819H....................//
// 29-10-2025...................//
package u1ex02c;

import java.io.File;
import java.io.FileWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

// Class representing the root element <cars> in the XML
@XmlRootElement(name = "cars")
class Cars {
    private List<Car> cars; // List of Car objects

    // Indicates that each <car> element in the XML corresponds to a Car object
    @XmlElement(name = "car")
    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}

// Class representing an individual car within the XML
class Car {
    private String brand; // Car brand
    private String model; // Car model
    private int year;     // Year of manufacture
    private double price; // Car price

    public Car() {
        // Empty constructor required by JAXB
    }

    @XmlElement // Maps the 'brand' field to the <brand> XML element
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @XmlElement // Maps the 'model' field to the <model> XML element
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @XmlElement // Maps the 'year' field to the <year> XML element
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @XmlElement // Maps the 'price' field to the <price> XML element
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

// Main class containing the program entry point
public class Main {
    public static void main(String[] args) {
        try {
            // Creates a File object pointing to the input XML file
            File file = new File("cars.xml");

            // Creates the JAXB context for the Cars class
            JAXBContext context = JAXBContext.newInstance(Cars.class);

            // Creates an Unmarshaller to convert XML into Java objects
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // Unmarshals (converts) the XML file into a Cars object
            Cars cars = (Cars) unmarshaller.unmarshal(file);

            // Retrieves the list of Car objects from the XML
            List<Car> list = cars.getCars();

            // Sorts the list of cars by year (ascending order)
            Collections.sort(list, Comparator.comparingInt(Car::getYear));

            // Creates a FileWriter to save the results into "cars.txt"
            FileWriter writer = new FileWriter("cars.txt");

            // Iterates through the sorted list of cars
            for (Car car : list) {
                // Formats the car data into a readable string
                String output = String.format(
                        "Brand: %s%nModel: %s%nYear: %d%nPrice: %.2f%n%n",
                        car.getBrand(),
                        car.getModel(),
                        car.getYear(),
                        car.getPrice());
                
                // Prints the formatted text to the console
                System.out.print(output);

                // Writes the formatted text to the output file
                writer.write(output);
            }

            // Closes the output file
            writer.close();

            // Displays a success message in the console
            System.out.println("Results saved to cars.txt\r\n");

        } catch (Exception e) {
            // Prints any errors that occur during execution
            e.printStackTrace();
        }
    }
}
