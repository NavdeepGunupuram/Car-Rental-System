package project;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class Car {
    String model, number, price, status;
    
    Car(String model, String number, String price) {
        this.model = model;
        this.number = number;
        this.price = price;
        this.status = "AVAILABLE";
    }
}

public class gui_project {
    private ArrayList<Car> cars = new ArrayList<>();
    private JFrame frame;
    private JTextArea displayArea;
    
    public gui_project() {
        frame = new JFrame("Cab Booking System");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        frame.add(scrollPane, BorderLayout.CENTER);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3));
        
        JButton addCarBtn = new JButton("Add Car");
        JButton bookCarBtn = new JButton("Book Car");
        JButton showCarsBtn = new JButton("Show Cars");
        
        addCarBtn.addActionListener(e -> addCar());
        bookCarBtn.addActionListener(e -> bookCar());
        showCarsBtn.addActionListener(e -> showCars());
        
        panel.add(addCarBtn);
        panel.add(bookCarBtn);
        panel.add(showCarsBtn);
        
        frame.add(panel, BorderLayout.SOUTH);
        
        frame.setVisible(true);
    }
    
    private void addCar() {
        String model = JOptionPane.showInputDialog("Enter Car Model:");
        String number = JOptionPane.showInputDialog("Enter Car Number:");
        String price = JOptionPane.showInputDialog("Enter Rental Price per Day:");
        
        if (model != null && number != null && price != null) {
            cars.add(new Car(model, number, price));
            displayArea.append("Added: " + model + " - " + number + " - " + price + "\n");
        }
    }
    
    private void bookCar() {
        String model = JOptionPane.showInputDialog("Enter Car Model to Book:");
        if (model == null) return;
        
        for (Car car : cars) {
            if (car.model.equalsIgnoreCase(model) && car.status.equals("AVAILABLE")) {
                car.status = "BOOKED";
                displayArea.append("Car " + model + " booked. Price: " + car.price + "\n");
                return;
            }
        }
        
        JOptionPane.showMessageDialog(frame, "Car not available or incorrect model name.");
    }
    
    private void showCars() {
        displayArea.setText("Available Cars:\n");
        for (Car car : cars) {
            displayArea.append(car.model + " - " + car.number + " - " + car.price + " - " + car.status + "\n");
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(gui_project::new);
    }
}

