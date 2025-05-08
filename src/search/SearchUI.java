package search;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class SearchUI {
    private JPanel mainPanel;
    private JTextField textFieldArray;
    private JTextField textFieldTarget;
    private JButton buttonSearch;
    private JButton buttonClear;
    private JLabel resultLabel;

    public SearchUI() {
        buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int[] array = Arrays.stream(textFieldArray.getText().split(","))
                            .map(String::trim)
                            .mapToInt(Integer::parseInt)
                            .toArray();
                    Arrays.sort(array);
                    int target = Integer.parseInt(textFieldTarget.getText());

                    SearchMethod search = new InterpolatedSearch();
                    int index = search.search(array, target);

                    resultLabel.setText(index != -1 ?
                            "Elemento encontrado en el índice: " + index :
                            "Elemento no encontrado.");
                } catch (Exception ex) {
                    resultLabel.setText("Error en los datos ingresados.");
                }
            }
        });

        buttonClear.addActionListener(e -> {
            textFieldArray.setText("");
            textFieldTarget.setText("");
            resultLabel.setText("Resultado:");
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Búsqueda Interpolada");
        frame.setContentPane(new SearchUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}