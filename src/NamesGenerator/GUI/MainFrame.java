package NamesGenerator.GUI;

import javax.swing.*;

/**
 * Created by Łukasz on 2016-05-24.
 */
public class MainFrame extends JFrame
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> new MainFrame());
    }

    MainFrame()
    {
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Polish Names Generator");

        add(new GeneratorPanel());

        pack();
        setVisible(true);
    }
}
