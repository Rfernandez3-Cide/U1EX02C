package u1ex02c;

import java.io.File;
import java.rmi.UnmarshalException;

import javax.xml.*;

public class Main {
    @XmlRootElement
    public static class Car {
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

    public static void main(String[] args) {
        try {
            File file = new File("cars.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Car.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            Car car = (Car) unmarshaller.unmarshal(file);
            System.out.println("Brand" + car.getBrand());
            System.out.println("Brand" + car.getModel());
            System.out.println("Brand" + car.getYear());
            System.out.println("Brand" + car.getPrice());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}