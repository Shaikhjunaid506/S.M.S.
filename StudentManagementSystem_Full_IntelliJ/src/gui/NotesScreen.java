package gui;

import javax.swing.*;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class NotesScreen {
    private static final Map<String, String> SUBJECT_NOTES = new HashMap<>();

    static {
        // B.Tech subjects
        SUBJECT_NOTES.put("DSA", "Data Structures and Algorithms form the backbone of computer science.\n" +
                "It involves organizing data efficiently and developing optimal algorithms.\n" +
                "Key concepts include arrays, linked lists, trees, graphs, sorting, and searching algorithms.\n" +
                "Mastering DSA is crucial for technical interviews and solving complex computational problems efficiently.\n");
        SUBJECT_NOTES.put("OS", "Operating Systems manage computer hardware and software resources.\n" +
                "Key topics include process management, memory allocation, file systems, and concurrency.\n" +
                "Modern OS like Windows and Linux handle multitasking, user interfaces, and security.\n" +
                "Understanding OS concepts helps in system programming and performance optimization.\n");
        SUBJECT_NOTES.put("CN", "Computer Networks enable communication between devices using protocols like TCP/IP.\n" +
                "The OSI model defines networking layers from physical to application.\n" +
                "Important concepts include routing, switching, DNS, HTTP, and network security.\n" +
                "With cloud computing, networking knowledge is more valuable than ever.\n");
        SUBJECT_NOTES.put("DBMS", "Database Management Systems store and retrieve data efficiently.\n" +
                "Relational databases use SQL and follow ACID properties.\n" +
                "Topics include normalization, transactions, indexing, and query optimization.\n" +
                "NoSQL databases handle unstructured data.\n" +
                "DBMS skills are essential for backend development and data analysis.\n");
        SUBJECT_NOTES.put("AI", "Artificial Intelligence simulates human intelligence in machines.\n" +
                "It includes machine learning, neural networks, natural language processing, and computer vision.\n" +
                "AI applications range from chatbots to self-driving cars.\n" +
                "Ethical considerations are important as AI becomes more pervasive in society.\n");
        SUBJECT_NOTES.put("ML", "Machine Learning enables systems to learn from data without explicit programming.\n" +
                "Supervised, unsupervised, and reinforcement learning are key approaches.\n" +
                "Applications include recommendation systems, predictive analytics, and pattern recognition.\n" +
                "Python libraries like TensorFlow and scikit-learn are commonly used.\n");
        SUBJECT_NOTES.put("Web Dev", "Web Development involves creating websites using HTML/CSS for structure, JavaScript for interactivity.\n" +
                "Backend development uses server-side languages like Node.js or Python.\n" +
                "Modern web dev emphasizes responsive design, APIs, and security best practices.\n" +
                "Frameworks like React and Angular streamline frontend development.\n");

        // BCA subjects
        SUBJECT_NOTES.put("C Prog", "C Programming is a foundational language emphasizing efficiency and low-level access.\n" +
                "It teaches pointers, memory management, and structured programming.\n" +
                "C is used in operating systems and embedded systems.\n" +
                "Understanding C helps grasp how computers work at a fundamental level.\n");
        SUBJECT_NOTES.put("Maths", "Discrete Mathematics covers logic, set theory, combinatorics, and graph theory.\n" +
                "These concepts underpin computer science algorithms and data structures.\n" +
                "Mathematical thinking improves problem-solving skills essential for programming.\n" +
                "It's particularly important for algorithm analysis and cryptography.\n");
        SUBJECT_NOTES.put("Networking", "Networking Fundamentals include understanding protocols and IP addressing.\n" +
                "Practical skills include configuring routers and troubleshooting connections.\n" +
                "The OSI model provides a framework for understanding network communication.\n" +
                "With growing IoT devices, networking knowledge is crucial for IT professionals.\n");
        SUBJECT_NOTES.put("Python", "Python is a versatile, high-level programming language with simple syntax.\n" +
                "It's used for web development, data analysis, AI, and scripting.\n" +
                "Python's extensive libraries and readability make it ideal for beginners.\n" +
                "It remains powerful enough for complex applications and rapid prototyping.\n");
        SUBJECT_NOTES.put("OOP", "Object-Oriented Programming organizes software design around objects.\n" +
                "Key principles are encapsulation, inheritance, and polymorphism.\n" +
                "OOP languages like Java and C++ enable modular, maintainable code.\n" +
                "These concepts are fundamental for large-scale application development.\n");
        SUBJECT_NOTES.put("HTML/CSS", "HTML defines webpage structure while CSS handles presentation.\n" +
                "Modern web design emphasizes responsive layouts and accessibility.\n" +
                "CSS frameworks like Bootstrap streamline development.\n" +
                "These are essential frontend technologies for any web developer.\n");

        // MBA subjects
        SUBJECT_NOTES.put("Marketing", "Marketing involves understanding customer needs and creating value.\n" +
                "Digital marketing, branding, and market research are key areas.\n" +
                "The 4Ps framework guides product, price, place, and promotion strategies.\n" +
                "Analytics now plays a crucial role in measuring campaign effectiveness.\n");
        SUBJECT_NOTES.put("Finance", "Corporate Finance covers investment decisions and financial analysis.\n" +
                "Topics include valuation methods, risk management, and financial markets.\n" +
                "Financial literacy is essential for strategic decision-making.\n" +
                "Understanding financial statements is crucial for business evaluation.\n");
        SUBJECT_NOTES.put("HR", "Human Resource Management focuses on recruiting and retaining talent.\n" +
                "Organizational behavior and performance management are key areas.\n" +
                "HR plays strategic roles in shaping company culture.\n" +
                "Employment law knowledge is essential for compliance and risk management.\n");
        SUBJECT_NOTES.put("Economics", "Managerial Economics applies economic theory to business decisions.\n" +
                "It covers demand analysis, production costs, and market structures.\n" +
                "Understanding macroeconomic indicators helps navigate economic fluctuations.\n" +
                "Microeconomics principles inform pricing and competitive strategies.\n");
        SUBJECT_NOTES.put("Statistics", "Business Statistics involves data collection and interpretation.\n" +
                "Techniques include regression analysis and hypothesis testing.\n" +
                "Data-driven decision making is crucial in modern business.\n" +
                "Statistical software like R and SPSS are commonly used tools.\n");
        SUBJECT_NOTES.put("Mgmt", "Principles of Management cover planning, organizing, and controlling.\n" +
                "Leadership styles and organizational structures are key topics.\n" +
                "Effective management balances efficiency with employee satisfaction.\n" +
                "Change management skills are valuable in dynamic business environments.\n");
        SUBJECT_NOTES.put("Ethics", "Business Ethics examines moral principles in corporate decisions.\n" +
                "Topics include corporate social responsibility and sustainability.\n" +
                "Ethical leadership builds trust with stakeholders.\n" +
                "With growing public scrutiny, ethical practices ensure long-term success.\n");

        // MBBS subjects
        SUBJECT_NOTES.put("Anatomy", "Human Anatomy studies body structures and their relationships.\n" +
                "Gross anatomy examines organs and systems through dissection.\n" +
                "Histology focuses on tissues at microscopic level.\n" +
                "Understanding anatomy is fundamental for clinical practice and surgery.\n");
        SUBJECT_NOTES.put("Physiology", "Physiology explores how body systems function.\n" +
                "It covers mechanisms from cellular processes to organ interactions.\n" +
                "Homeostasis maintenance is a key concept in physiology.\n" +
                "Physiological knowledge is essential for understanding disease processes.\n");
        SUBJECT_NOTES.put("Biochem", "Biochemistry studies chemical processes in living organisms.\n" +
                "It covers metabolism, molecular genetics, and enzymology.\n" +
                "Biochemical pathways explain energy production and molecular diseases.\n" +
                "This knowledge underpins pharmacology and clinical diagnostics.\n");
        SUBJECT_NOTES.put("Pharma", "Pharmacology examines drug actions and effects on the body.\n" +
                "Pharmacokinetics studies what the body does to drugs.\n" +
                "Pharmacodynamics examines what drugs do to the body.\n" +
                "Understanding drug interactions is crucial for safe prescribing.\n");
        SUBJECT_NOTES.put("Pathology", "Pathology studies disease causes and their effects.\n" +
                "It involves examining tissues and bodily fluids for diagnoses.\n" +
                "Histopathology and clinical pathology are main branches.\n" +
                "Pathological knowledge helps correlate symptoms with conditions.\n");
        SUBJECT_NOTES.put("Microbio", "Medical Microbiology investigates disease-causing microorganisms.\n" +
                "It covers bacteria, viruses, fungi, and parasites.\n" +
                "Topics include infection mechanisms and antimicrobial resistance.\n" +
                "Microbiological knowledge is essential for infection control.\n");
        SUBJECT_NOTES.put("Surgery", "General Surgery principles include aseptic techniques.\n" +
                "Wound healing and perioperative care are fundamental topics.\n" +
                "Surgical specialties range from orthopedic to neurosurgery.\n" +
                "Surgical skills combine manual dexterity with clinical judgment.\n");
    }

    public static void displayNotes(String course, List<String> subjects) {
        JFrame frame = new JFrame("Subject Notes - " + course);
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        StringBuilder notes = new StringBuilder();
        for (String subject : subjects) {
            notes.append("Subject: ").append(subject).append("\n");
            notes.append(SUBJECT_NOTES.getOrDefault(subject, "Notes not available for this subject.\n")).append("\n");
        }

        textArea.setText(notes.toString());

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(20, 20, 440, 300);

        JButton examButton = new JButton("Take Exam");
        examButton.setBounds(180, 330, 120, 40);
        frame.add(scrollPane);
        frame.add(examButton);

        frame.setSize(500, 420);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        examButton.addActionListener(e -> {
            frame.dispose();
            ExamScreen.startExam(subjects);
        });
    }
}