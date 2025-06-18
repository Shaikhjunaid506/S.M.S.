package gui;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class ExamScreen {
    static int current = 0, score = 0;
    static List<String> subjects;
    static List<JRadioButton> options = new ArrayList<>();
    static ButtonGroup group = new ButtonGroup();
    static JLabel questionLabel = new JLabel();
    static JButton nextButton = new JButton("Next");
    static JFrame frame = new JFrame("Exam Portal");
    static String[] questions = new String[15];
    static String[][] optionsArray = new String[15][4];
    static int[] answers = new int[15];

    static Map<String, List<Question>> courseQuestions = new HashMap<>();
    static Map<String, String> subjectPrefixes = new HashMap<>();

    static class Question {
        String subject;
        String question;
        String[] options;
        int correctAnswer;

        public Question(String subject, String question, String[] options, int correctAnswer) {
            this.subject = subject;
            this.question = question;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }
    }

    public static void startExam(List<String> selected) {
        subjects = selected;
        initializeQuestions();
        prepareQuestions();

        questionLabel.setBounds(30, 40, 500, 30);
        int y = 80;
        for (int i = 0; i < 4; i++) {
            JRadioButton rb = new JRadioButton();
            rb.setBounds(50, y, 450, 30);
            options.add(rb);
            group.add(rb);
            frame.add(rb);
            y += 40;
        }

        nextButton.setBounds(150, 250, 120, 40);
        frame.add(questionLabel);
        frame.add(nextButton);
        frame.setSize(550, 350);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        loadQuestion(current);

        nextButton.addActionListener(e -> {
            for (int i = 0; i < 4; i++) {
                if (options.get(i).isSelected() && i == answers[current]) {
                    score++;
                }
            }
            current++;
            if (current < 15) {
                group.clearSelection();
                loadQuestion(current);
            } else {
                frame.dispose();
                ResultScreen.showResult(score, subjects);
            }
        });
    }

    private static void loadQuestion(int index) {
        questionLabel.setText((index + 1) + ") " + questions[index]);
        for (int i = 0; i < 4; i++) {
            options.get(i).setText(optionsArray[index][i]);
        }
    }

    private static void initializeQuestions() {
        subjectPrefixes.put("DSA", "DSA");
        subjectPrefixes.put("OS", "OS");
        subjectPrefixes.put("CN", "CN");
        subjectPrefixes.put("DBMS", "DBMS");
        subjectPrefixes.put("AI", "AI");
        subjectPrefixes.put("C Prog", "C Prog");
        subjectPrefixes.put("Maths", "Maths");
        subjectPrefixes.put("Networking", "Networking");
        subjectPrefixes.put("Python", "Python");
        subjectPrefixes.put("OOP", "OOP");
        subjectPrefixes.put("Marketing", "Marketing");
        subjectPrefixes.put("Finance", "Finance");
        subjectPrefixes.put("HR", "HR");
        subjectPrefixes.put("Economics", "Economics");
        subjectPrefixes.put("Statistics", "Statistics");
        subjectPrefixes.put("Anatomy", "Anatomy");
        subjectPrefixes.put("Physiology", "Physiology");
        subjectPrefixes.put("Biochem", "Biochem");
        subjectPrefixes.put("Pharma", "Pharma");
        subjectPrefixes.put("Pathology", "Pathology");

        // B.Tech Questions
        List<Question> btech = new ArrayList<>();
        btech.add(new Question("DSA", "Which data structure uses LIFO?", new String[]{"Queue", "Stack", "Array", "Linked List"}, 1));
        btech.add(new Question("DSA", "Time complexity of binary search?", new String[]{"O(n)", "O(log n)", "O(1)", "O(n^2)"}, 1));
        btech.add(new Question("OS", "Function of OS?", new String[]{"Manage hardware", "Paint UI", "Do math", "Handle money"}, 0));
        btech.add(new Question("OS", "Which is a scheduling algorithm?", new String[]{"TCP", "Priority", "FIFO", "IP"}, 1));
        btech.add(new Question("CN", "Full form of TCP?", new String[]{"Transfer Control Protocol", "Transmission Control Protocol", "Time Control Protocol", "None"}, 1));
        btech.add(new Question("CN", "Which is a network layer device?", new String[]{"Router", "Switch", "Hub", "Repeater"}, 0));
        btech.add(new Question("DBMS", "SQL is used for?", new String[]{"Drawing", "Data Management", "Design", "Styling"}, 1));
        btech.add(new Question("DBMS", "Which is a key?", new String[]{"Primary", "Major", "Minor", "Lead"}, 0));
        btech.add(new Question("AI", "What is AI?", new String[]{"Human error", "Robot ethics", "Making machines intelligent", "None"}, 2));
        btech.add(new Question("AI", "Which is AI algorithm?", new String[]{"DFS", "Linear", "KNN", "MAC"}, 2));
        courseQuestions.put("B.Tech", btech);

        // BCA Questions
        List<Question> bca = new ArrayList<>();
        bca.add(new Question("C Prog", "Which is valid C keyword?", new String[]{"int", "num", "define", "main"}, 0));
        bca.add(new Question("C Prog", "C is a?", new String[]{"OOP", "Scripting", "Procedural", "Functional"}, 2));
        bca.add(new Question("Maths", "What is derivative of x^2?", new String[]{"2x", "x", "x^2", "None"}, 0));
        bca.add(new Question("Maths", "Value of π?", new String[]{"3.14", "2.71", "1.41", "None"}, 0));
        bca.add(new Question("Networking", "IP stands for?", new String[]{"Internet Protocol", "Internet Path", "Internal Protocol", "Integrated Path"}, 0));
        bca.add(new Question("Networking", "What is MAC?", new String[]{"Media Access Control", "Machine Access", "Memory Area", "None"}, 0));
        bca.add(new Question("Python", "Which is Python data type?", new String[]{"Tuple", "Array", "Struct", "None"}, 0));
        bca.add(new Question("Python", "Python is?", new String[]{"Compiled", "Interpreted", "Assembly", "None"}, 1));
        bca.add(new Question("OOP", "OOP means?", new String[]{"Object Oriented Programming", "Only Objects", "Outer Object", "None"}, 0));
        bca.add(new Question("OOP", "Inheritance allows?", new String[]{"Reuse", "Reboot", "Restructure", "None"}, 0));
        courseQuestions.put("BCA", bca);

        // MBA Questions
        List<Question> mba = new ArrayList<>();
        mba.add(new Question("Marketing", "What is 4P in marketing?", new String[]{"Product, Price, Place, Promotion", "Plan, Push, Pull, Promote", "None", "People, Product, Place, Price"}, 0));
        mba.add(new Question("Marketing", "Brand loyalty means?", new String[]{"Cheap purchase", "Repeat buying", "Free stuff", "Advertisements"}, 1));
        mba.add(new Question("Finance", "What is ROI?", new String[]{"Return on Investment", "Rate of Increase", "Receipt of Income", "None"}, 0));
        mba.add(new Question("Finance", "Asset is?", new String[]{"Liability", "Wealth", "Debt", "None"}, 1));
        mba.add(new Question("HR", "Recruitment means?", new String[]{"Hiring", "Firing", "Training", "Funding"}, 0));
        mba.add(new Question("HR", "Appraisal is for?", new String[]{"Evaluation", "Elimination", "Examination", "Excuse"}, 0));
        mba.add(new Question("Economics", "Demand curve slopes?", new String[]{"Down", "Up", "Flat", "Vertical"}, 0));
        mba.add(new Question("Economics", "GDP means?", new String[]{"Gross Domestic Product", "Great Deal Power", "Growth Data Points", "None"}, 0));
        mba.add(new Question("Statistics", "Mean is?", new String[]{"Average", "Extreme", "Middle", "None"}, 0));
        mba.add(new Question("Statistics", "Standard deviation measures?", new String[]{"Dispersion", "Mean", "Mode", "Median"}, 0));
        courseQuestions.put("MBA", mba);

        // MBBS Questions
        List<Question> mbbs = new ArrayList<>();
        mbbs.add(new Question("Anatomy", "Bones are part of?", new String[]{"Digestive", "Skeletal", "Respiratory", "Nervous"}, 1));
        mbbs.add(new Question("Anatomy", "Number of ribs?", new String[]{"12", "24", "14", "20"}, 1));
        mbbs.add(new Question("Physiology", "Heart pumps?", new String[]{"Blood", "Water", "Air", "Lymph"}, 0));
        mbbs.add(new Question("Physiology", "Nephron is part of?", new String[]{"Brain", "Kidney", "Heart", "Lungs"}, 1));
        mbbs.add(new Question("Biochem", "DNA stands for?", new String[]{"Data Node Assembly", "Deoxyribonucleic Acid", "Digital Name Area", "None"}, 1));
        mbbs.add(new Question("Biochem", "Protein is made of?", new String[]{"Sugar", "Fat", "Amino Acids", "Water"}, 2));
        mbbs.add(new Question("Pharma", "Antibiotic is for?", new String[]{"Fever", "Infection", "Cough", "Cold"}, 1));
        mbbs.add(new Question("Pharma", "Paracetamol is?", new String[]{"Painkiller", "Vitamin", "Antibiotic", "Steroid"}, 0));
        mbbs.add(new Question("Pathology", "Study of disease is?", new String[]{"Anatomy", "Physiology", "Pathology", "Dermatology"}, 2));
        mbbs.add(new Question("Pathology", "Biopsy is?", new String[]{"X-ray", "Tissue test", "Injection", "Scan"}, 1));
        courseQuestions.put("MBBS", mbbs);
    }

    private static void prepareQuestions() {
        String course = determineCourse();
        List<Question> allQuestions = new ArrayList<>(courseQuestions.get(course));
        Map<String, List<Question>> bySubject = new HashMap<>();

        for (Question q : allQuestions) {
            bySubject.computeIfAbsent(q.subject, k -> new ArrayList<>()).add(q);
        }

        int index = 0;
        for (String subject : subjects) {
            List<Question> subjectQ = bySubject.get(subject);
            if (subjectQ != null) {
                Collections.shuffle(subjectQ);
                for (int i = 0; i < Math.min(3, subjectQ.size()) && index < 5; i++) {
                    Question q = subjectQ.get(i);
                    questions[index] = q.question;
                    optionsArray[index] = q.options;
                    answers[index] = q.correctAnswer;
                    index++;
                }
            }
        }
    }

    private static String determineCourse() {
        if (subjects.contains("DSA") || subjects.contains("OS") || subjects.contains("CN")) return "B.Tech";
        if (subjects.contains("C Prog") || subjects.contains("Python")) return "BCA";
        if (subjects.contains("Marketing") || subjects.contains("Finance")) return "MBA";
        if (subjects.contains("Anatomy") || subjects.contains("Physiology")) return "MBBS";
        return "B.Tech";
    }
}
