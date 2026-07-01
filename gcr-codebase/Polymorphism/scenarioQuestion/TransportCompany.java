// File Name: TransportCompany.java

class Vehicle {

    String vehicleNumber;

    Vehicle(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    double fuelCost(int km) {
        return 0;
    }
}

class Car extends Vehicle {

    Car(String number) {
        super(number);
    }

    @Override
    double fuelCost(int km) {
        return km * 7;
    }
}

class Bus extends Vehicle {

    Bus(String number) {
        super(number);
    }

    @Override
    double fuelCost(int km) {
        return km * 15;
    }
}

class Bike extends Vehicle {

    Bike(String number) {
        super(number);
    }

    @Override
    double fuelCost(int km) {
        return km * 3;
    }
}

// Added later without changing existing code
class ElectricCar extends Vehicle {

    ElectricCar(String number) {
        super(number);
    }

    @Override
    double fuelCost(int km) {
        return km * 2;
    }
}

public class TransportCompany {

    public static void main(String[] args) {

        Vehicle[] fleet = {
                new Car("C101"),
                new Bus("B201"),
                new Bike("BK301"),
                new ElectricCar("E401")
        };

        int km = 100;

        for (Vehicle v : fleet) {

            System.out.println("-----------------------");
            System.out.println("Vehicle Number : " + v.vehicleNumber);
            System.out.println("Fuel Cost : " + v.fuelCost(km));

            if (v instanceof Car)
                System.out.println("Type : Car");

            else if (v instanceof Bus)
                System.out.println("Type : Bus");

            else if (v instanceof Bike)
                System.out.println("Type : Bike");

            else if (v instanceof ElectricCar)
                System.out.println("Type : Electric Car");
        }
    }
}