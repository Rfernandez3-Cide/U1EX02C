package u1ex02c;

import java.io.File;
import java.io.FileWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.xml.bind.annotation.*;
import javax.xml.bind.*;

@XmlRootElement(name = "cars")
class Cars {
    private List<Car> cars;

    @XmlElement(name = "car")
    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}

@XmlType(propOrder = { "brand", "model", "year", "price" })
class Car {
    private String brand;
    private String model;
    private int year;
    private double price;

    public Car() {
    }

    @XmlElement
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @XmlElement
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @XmlElement
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @XmlElement
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("cars.xml");
            JAXBContext context = JAXBContext.newInstance(Cars.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            Cars cars = (Cars) unmarshaller.unmarshal(file);
            List<Car> list = cars.getCars();

            Collections.sort(list, Comparator.comparingInt(Car::getYear));

            FileWriter writer = new FileWriter("cars.txt");

            for (Car car : list) {
                String output = String.format(
                        "Brand: %s%nModel: %s%nYear: %d%nPrice: %.2f%n%n",
                        car.getBrand(),
                        car.getModel(),
                        car.getYear(),
                        car.getPrice());
                System.out.print(output);
                writer.write(output);
            }

            writer.close();
            System.out.println("Results saved to cars.txt\r\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
