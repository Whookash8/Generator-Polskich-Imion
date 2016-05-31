package NamesGenerator.Logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Łukasz on 2016-05-31.
 */
public class Person
{
    enum SEX {Mężczyzna , Kobieta}
    private String name;
    private String surname;
    private int age;
    private String sex;
    private boolean gen;
    private int rand;
    private ArrayList<String> namesList = new ArrayList<>();
    private ArrayList<String> surnamesList = new ArrayList<>();

    public Person() throws FileNotFoundException
    {
        generateData();
    }

    private void generateData() throws FileNotFoundException
    {
        Random generator = new Random();
        gen = generator.nextBoolean();

        createData(gen);

        Random randomize = new Random();
        rand = randomize.nextInt(46) + 20;
        age = rand;

        rand = randomize.nextInt(150);
        name = namesList.get(rand);

        rand = randomize.nextInt(150);
        surname = surnamesList.get(rand);

        if (sex == SEX.Kobieta.toString())
        {
            if(surname.endsWith("i"))
            {
                surname = surname.substring(0,surname.length()-1) + "a";
            }
        }

    }

    private void createData(boolean x) throws FileNotFoundException
    {
        namesList.ensureCapacity(150);
        surnamesList.ensureCapacity(150);
        if (x==true)
        {
            sex = SEX.Mężczyzna.toString();

            File menNames = new File("C:\\Users\\Łukasz\\Desktop\\JAVA\\Projekty\\Names Generator\\src\\NamesGenerator\\Resources\\MenNames");
            Scanner scanner = new Scanner(menNames);

            while(scanner.hasNext())
            {
                namesList.add(scanner.nextLine().trim());
            }
        }
        else
        {
            sex = SEX.Kobieta.toString();

            File menNames = new File("C:\\Users\\Łukasz\\Desktop\\JAVA\\Projekty\\Names Generator\\src\\NamesGenerator\\Resources\\WomenNames");
            Scanner scanner = new Scanner(menNames);

            while(scanner.hasNext())
            {
                namesList.add(scanner.nextLine().trim());
            }
        }

        File surnames = new File("C:\\Users\\Łukasz\\Desktop\\JAVA\\Projekty\\Names Generator\\src\\NamesGenerator\\Resources\\Surnames");
        Scanner scanner = new Scanner(surnames);

        while(scanner.hasNext())
        {
            surnamesList.add(scanner.nextLine().trim());
        }
    }

    public String getName()
    {
        return name;
    }

    public String getSurname()
    {
        return surname;
    }

    public String getAge()
    {
        return Integer.toString(age);
    }

    public String getSex()
    {
        return sex;
    }
}
