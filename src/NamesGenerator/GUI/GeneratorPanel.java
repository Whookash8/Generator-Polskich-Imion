package NamesGenerator.GUI;

import NamesGenerator.Logic.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

/**
 * Created by Łukasz on 2016-05-31.
 */
public class GeneratorPanel extends JPanel
{
    JLabel nameLabel = new JLabel("Imię: ");
    JLabel surnameLabel = new JLabel("Nazwisko: ");
    JLabel ageLabel = new JLabel("Wiek: ");
    JLabel sexLabel = new JLabel("Płeć: ");
    JLabel genNameLabel = new JLabel();
    JLabel genSurnameLabel = new JLabel();
    JLabel genAgeLabel = new JLabel();
    JLabel genSexLabel = new JLabel();
    JButton generateData = new JButton("Generuj losowe dane");
    GridBagConstraints GBC = new GridBagConstraints();

    GeneratorPanel()
    {
        setLayout(new GridBagLayout());

        genNameLabel.setPreferredSize(new Dimension(200,0));

        GBC.anchor = GridBagConstraints.WEST;
        GBC.ipadx = 5;
        GBC.ipady = 20;

        add(nameLabel , GBC);
        GBC.gridx = 1;
        add(genNameLabel , GBC);

        GBC.gridx = 0;
        GBC.gridy = 1;
        add(surnameLabel , GBC);
        GBC.gridx = 1;
        add(genSurnameLabel , GBC);

        GBC.gridx = 0;
        GBC.gridy = 2;
        add(ageLabel , GBC);
        GBC.gridx = 1;
        add(genAgeLabel , GBC);

        GBC.gridx = 0;
        GBC.gridy = 3;
        add(sexLabel , GBC);
        GBC.gridx = 1;
        add(genSexLabel , GBC);

        GBC.gridx=0;
        GBC.gridy=4;
        GBC.ipady = 5;
        add(generateData , GBC);

        generateData.addActionListener(e -> {
            try
            {
                Person example = new Person();
                genNameLabel.setText(example.getName());
                genSurnameLabel.setText(example.getSurname());
                genAgeLabel.setText(example.getAge());
                genSexLabel.setText(example.getSex());

            }
            catch (FileNotFoundException e1)
            {
                e1.printStackTrace();
            }
        });
    }
}
