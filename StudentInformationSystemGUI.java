package projectttt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentInformationSystemGUI extends JFrame {

    // Components for CRUD
    private JTextField studentIdField, studentNameField, studentAgeField, studentCourseField;
    private DefaultListModel<String> studentListModel;
    private JList<String> studentList;

    public StudentInformationSystemGUI() {
        // Set up the main frame
        setTitle("Student Information System");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Title panel with a bold title
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(60, 179, 113));
        JLabel titleLabel = new JLabel("Student Information System");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);

        // Center form panel for input fields
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(5, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Input fields for student details
        studentIdField = new JTextField();
        studentNameField = new JTextField();
        studentAgeField = new JTextField();
        studentCourseField = new JTextField();

        formPanel.add(new JLabel("Student ID:"));
        formPanel.add(studentIdField);
        formPanel.add(new JLabel("Student Name:"));
        formPanel.add(studentNameField);
        formPanel.add(new JLabel("Student Age:"));
        formPanel.add(studentAgeField);
        formPanel.add(new JLabel("Course:"));
        formPanel.add(studentCourseField);

        add(formPanel, BorderLayout.CENTER);

        // South panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JButton addButton = new JButton("Add Student");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");
        JButton clearButton = new JButton("Clear Fields");

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(clearButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // West panel for the student list
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BorderLayout());
        listPanel.setBorder(BorderFactory.createTitledBorder("Student List"));

        studentListModel = new DefaultListModel<>();
        studentList = new JList<>(studentListModel);
        JScrollPane listScrollPane = new JScrollPane(studentList);

        listPanel.add(listScrollPane, BorderLayout.CENTER);
        add(listPanel, BorderLayout.EAST);

        // Action listeners for buttons
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateStudent();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteStudent();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        setVisible(true);
    }

    // Method to add a student to the list
    private void addStudent() {
        String studentId = studentIdField.getText();
        String studentName = studentNameField.getText();
        String studentAge = studentAgeField.getText();
        String studentCourse = studentCourseField.getText();

        if (studentId.isEmpty() || studentName.isEmpty() || studentAge.isEmpty() || studentCourse.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String studentInfo = studentId + " - " + studentName + " (" + studentAge + " years old, " + studentCourse + ")";
        studentListModel.addElement(studentInfo);
        clearFields();
    }

    // Method to update selected student
    private void updateStudent() {
        int selectedIndex = studentList.getSelectedIndex();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "Select a student to update!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String studentId = studentIdField.getText();
        String studentName = studentNameField.getText();
        String studentAge = studentAgeField.getText();
        String studentCourse = studentCourseField.getText();

        if (studentId.isEmpty() || studentName.isEmpty() || studentAge.isEmpty() || studentCourse.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String updatedStudentInfo = studentId + " - " + studentName + " (" + studentAge + " years old, " + studentCourse + ")";
        studentListModel.setElementAt(updatedStudentInfo, selectedIndex);
        clearFields();
    }

    // Method to delete selected student
    private void deleteStudent() {
        int selectedIndex = studentList.getSelectedIndex();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "Select a student to delete!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        studentListModel.removeElementAt(selectedIndex);
    }

    // Method to clear the input fields
    private void clearFields() {
        studentIdField.setText("");
        studentNameField.setText("");
        studentAgeField.setText("");
        studentCourseField.setText("");
        studentList.clearSelection();
    }

    public static void main(String[] args) {
        new StudentInformationSystemGUI();
    }
}
 