import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Quiz extends JFrame {
    private static int width = 800;
    private static int height = 600;
    private int count = 0;
    private int curQuestion = 0;
    private String[][] q = new String[10][5];
    private int[] rightAnswers = new int[] {2, 4, 3, 4, 2, 1, 3, 4, 1, 1};
    private int[] answers = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    JButton[] ba;
    JLabel label;
    JLabel question;
//    JTextArea question;

    public Quiz() {
        super("Quiz");

        q[0][0] = "В каком году впервые состоялся конкурс «Евровидение»?";
        q[0][1] = "1975";
        q[0][2] = "1964";
        q[0][3] = "1981";
        q[0][4] = "1956";

        q[1][0] = "Сколько стран принимало участие в дебютном конкурсе «Евровидение»?";
        q[1][1] = "Пять";
        q[1][2] = "Семь";
        q[1][3] = "Двенадцать";
        q[1][4] = "Десять";

        q[2][0] = "Какой стране принадлежит рекорд по количеству выигрышей на конкурсе «Евровидение»?";
        q[2][1] = "Великобритания";
        q[2][2] = "Ирландия";
        q[2][3] = "Франция";
        q[2][4] = "Германия";

        q[3][0] = "Какое требование не предъявляется к песне на «Евровидении»?";
        q[3][1] = "Продолжительность песни не более трех минут";
        q[3][2] = "Песни должны быть новыми";
        q[3][3] = "На сцене должно быть максимум шесть исполнителей";
        q[3][4] = "Песня должна быть написан на английском языке";

        q[4][0] = "Дебют России на «Евровидении» состоялся в 1994 году. Кто же представлял нашу страну в первый раз?";
        q[4][1] = "Маша Кац";
        q[4][2] = "София Ротару";
        q[4][3] = "Алла Пугачева";
        q[4][4] = "Филипп Киркоров";

        q[5][0] = "Кто комментировал «Евровидение» в 2010 году?";
        q[5][1] = "Яна Чурикова и Дмитрий Губерниев";
        q[5][2] = "Яна Чурикова и Филипп Киркоров";
        q[5][3] = "Ольга Шелест и Дмитрий Губерниев";
        q[5][4] = "Ольга Шелест и Яна Чурикова";

        q[6][0] = "Действительно ли, что в 1998 году российского участника не допустили до конкурса?";
        q[6][1] = "Да";
        q[6][2] = "Нет";
        q[6][3] = "Россия не принимала участие";
        q[6][4] = "Не допустили по ошибке";

        q[7][0] = "Какую страну представляла канадская исполнительница Силин Дион на конкурсе «Евровидение» в 1988 году?";
        q[7][1] = "Швеция";
        q[7][2] = "Швейцария";
        q[7][3] = "Ирландия";
        q[7][4] = "Германия";

        q[8][0] = "Как известно, что страны входящие в состав «Большой четверки» проходят в финал «Евровидения» автоматически. Какие страны входят в ее состав?";
        q[8][1] = "Великобритания, Италия, Германия и Испания";
        q[8][2] = "Великобритания, Франция, Германия и Швеция";
        q[8][3] = "Великобритания, Франция, Италия и Испания";
        q[8][4] = "Великобритания, Франция, Германия и Испания";

        q[9][0] = "В каком городе Германии будет проводится конкурс «Евровидение» в нынешнем (2011) году?";
        q[9][1] = "Мюнхен";
        q[9][2] = "Берлин";
        q[9][3] = "Кельн";
        q[9][4] = "Дюссельдорф";

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(Quiz.width, Quiz.height);
        this.setLocation(d.width / 2 - Quiz.width / 2, d.height / 2 - Quiz.height / 2);
        this.getContentPane().setBackground(Color.orange);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridBagLayout());

        label = new JLabel("Вопрос 0/10");
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        label.setBackground(Color.white);
        label.setOpaque(true);

        question = new JLabel("<html><body>fajfios gotm sgimrt gstmngstiomgso iegms;oirgtm se;rgioms e;goim seriogmse ;rgiomse;rogi ookp</body></html>");
        question.setFocusable(false);
        question.setFont(new Font("Arial", Font.PLAIN, 20));
        question.setBackground(Color.white);
        question.setOpaque(true);

        //        question = new JTextArea();
//        question.setLineWrap(true);
//        question.setWrapStyleWord(true);
//        question.setFocusable(false);
//        question.setEditable(false);
//        question.setFont(new Font("Arial", Font.PLAIN, 20));
//        question.setBackground(Color.white);
//        question.setOpaque(true);

        ba = new JButton[4];
        for (int i = 0; i < ba.length; i++) {
            ba[i] = new JButton("button");
//            ba[i] = new JButton("<html><body>fajfios gotm sgimrt gstmngstiomgso iegms;oirgtm se;rgioms e;goim seriogmse ;rgiomse;rogi ookp</body></html>");
            ba[i].setFont(new Font("Arial", Font.PLAIN, 20));
            ba[i].addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    questionActionPerformed(e);
                }
            });
        }

        this.add(label, new GridBagConstraints(0, 0, 4, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(5,5,5,5), 5, 5));
        this.add(question, new GridBagConstraints(0, 1, 4, 1, 1, 0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(5,5,5,5), 0, 0));

        this.add(ba[0], new GridBagConstraints(0, 2, 2, 1, 1, 0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(5,5,5,5), 0, 0));
        this.add(ba[1], new GridBagConstraints(2, 2, 2, 1, 1, 0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(5,5,5,5), 0, 0));
        this.add(ba[2], new GridBagConstraints(0, 3, 2, 1, 1, 0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(5,5,5,5), 0, 0));
        this.add(ba[3], new GridBagConstraints(2, 3, 2, 1, 1, 0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(5,5,5,5), 0, 0));

        this.setVisible(true);

        setQuestion();
    }

    public void questionActionPerformed(ActionEvent e) {
        if (curQuestion < q.length) {
            for (int i = 0; i < 4; i++) {
                if (e.getSource().equals(ba[i])) {
                    answers[curQuestion] = i + 1;
                    break;
                }
            }
        }
        curQuestion++;
        if (curQuestion < q.length) {
            setQuestion();
        } else {
            for (int i = 0; i < q.length; i++) {
                if (answers[i] == rightAnswers[i]) {
                    count++;
                }
            }
            showResult();
        }
    }

    public void setQuestion() {
        label.setText("Вопрос " + (curQuestion + 1) + "/" + q.length);
        question.setText("<html><body>" + q[curQuestion][0] + "</body></html>");
        for (int i = 0; i < 4; i++) {
            ba[i].setText(q[curQuestion][i+1]);
        }
    }

    public void showResult() {
        question.setVisible(false);
        label.setVisible(false);
        for (int i = 0; i < 4; i++) {
            ba[i].setVisible(false);
        }

        JLabel label = new JLabel("Ваш результат: " + count + " из " + q.length + "!");
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBackground(Color.white);
        label.setOpaque(true);
        this.add(label, new GridBagConstraints(0, 0, 2, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(5,5,5,5), 0, 0));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Quiz frame = new Quiz();
            }
        });
    }
}
