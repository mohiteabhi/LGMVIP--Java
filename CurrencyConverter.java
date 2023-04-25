//Task 1: Beginners Level Task 
// Currency Converter Application in Java

//Importing required packages
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import javax.swing.*;
public class CurrencyConverter extends JFrame implements ActionListener{
    JComboBox fromcountry,tocountry;
    JButton convert,reset,exit;
    JLabel fromunit,tounit;
    TextField fromtext;
    TextField Answer;

    String[] Currencies=
            {
                    "units",
                    "Indian Rupee",
                    "US Dollar",
                    "Canadian Dollar",
                    "Dubai Dirhem",
                    "Nigerian Naira",
                    "Brazilian Real",
                    "Indonesian Rupiah",
                    "Pakistani Rupee",

            };

    double Indian_Rupee = 95.21;
    double Pakistani_Rupee = 162.74;
    double US_Dollar = 1.31;
    double Canadian_Dollar = 1.71;
    double Dubai_Dirhem = 132.53;
    double Nigerian_Naira = 476.57;
    double Brazilian_Real = 5.47;
    double Indonesian_Rupiah = 19554.94;


    CurrencyConverter()
    {
        setBounds(300,60,790,700);
        getContentPane().setBackground(Color.LIGHT_GRAY); //Color of Our GUI Window

        JLabel maintitle = new JLabel("Currency Converter "); //Title of Application
        maintitle.setBounds(50,10,900,60);
        maintitle.setFont(new Font("Castellar",Font.BOLD,50));
        maintitle.setForeground(Color.CYAN);
        add(maintitle);

        JLabel maintitle1 = new JLabel("using java");
        maintitle1.setBounds(60,50,900,60);
        maintitle1.setFont(new Font("Castellar",Font.BOLD,25));
        maintitle1.setForeground(Color.RED);
        add(maintitle1);


        JLabel from = new JLabel("From");
        from.setBounds(45,160,50,50);
        from.setFont(new Font("Times New Roman",Font.BOLD,20));
        from.setForeground(Color.black);
        add(from);

        //Conversion options
        fromcountry = new JComboBox(new String[] { "Select One", "India", "USA", "Canada", "Dubai", "Ngeria", "Brazil", "Indonesia", "pak" });
        fromcountry.setBounds(100,165,200,40);
        fromcountry.setFont(new Font("Times New Roman",Font.BOLD,20));
        fromcountry.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                fromcountryItemStateChanged(evt);
            }
        });
        add(fromcountry); //This will add our Item menu

        fromtext = new TextField();
        fromtext.setBounds(350,165,250, 40);
        fromtext.setFont(new Font("Times New Roman",Font.BOLD,20));
        fromtext.setForeground(Color.BLACK);
        add(fromtext);

        fromunit = new JLabel("Unit");
        fromunit.setBounds(605,160,200,40);
        fromunit.setFont(new Font("Times New Roman",Font.BOLD,18));
        fromunit.setForeground(Color.BLACK);
        add(fromunit);

        JLabel to = new JLabel("To");
        to.setBounds(65,310,50,50);
        to.setFont(new Font("Times New Roman",Font.BOLD,20));
        to.setForeground(Color.black);
        add(to);

        tocountry = new JComboBox(new String[] { "Select One", "India", "USA", "Canada", "Dubai", "Ngeria", "Brazil", "Indonesia", "pak" });
        tocountry.setBounds(100,310,200,40);
        tocountry.setFont(new Font("Times New Roman",Font.BOLD,20));
        
        tocountry.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                tocountryItemStateChanged(evt);
            }
        });
        add(tocountry);

        Answer = new TextField(" ");
        Answer.setBounds(350,310,250, 40);
        Answer.setFont(new Font("Times New Roman",Font.BOLD,20));
        Answer.setForeground(Color.BLACK);
        add(Answer);

        tounit = new JLabel("Unit");
        tounit.setBounds(605,290,250,90);
        tounit.setFont(new Font("Times New Roman",Font.BOLD,18));
        tounit.setForeground(Color.BLACK);
        add(tounit);

        //Adding Convertr button
        //Currency will be converted by pressing this button
        convert = new JButton("Convert Currency");
        convert.setBounds(100,450,200,40);
        convert.setFont(new Font("Sans-serif",Font.HANGING_BASELINE,18));
        convert.addActionListener(this);
        add(convert);

        //Adding Reset button
        //This button will reset all the inputs in our application
        reset = new JButton("Reset");
        reset.setBounds(450,450,200,40);
        reset.setFont(new Font("Sans-serif",Font.HANGING_BASELINE,18));
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(reset);

        //Adding Exit Button
        //This button is used to exit from our application
        exit = new JButton("Exit");
        exit.setBounds(300,550,100,40);
        exit.setFont(new Font("Sans-serif",Font.HANGING_BASELINE,18));
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(exit);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        fromcountry.setSelectedIndex(0);
        tocountry.setSelectedIndex(0);
        fromtext.setText(null);
        Answer.setText(null);
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    public static void main(String[] args)
    {
        new CurrencyConverter();
    }


    private void fromcountryItemStateChanged(java.awt.event.ItemEvent evt) {
        int position = fromcountry.getSelectedIndex();
        fromunit.setText(Currencies[position]);
    }

    private void tocountryItemStateChanged(java.awt.event.ItemEvent evt) {
        int position = tocountry.getSelectedIndex();
        tounit.setText(Currencies[position]);
    }

    //Using method Override for calculation of conversion of one currency into another 
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == convert) {
            if (fromcountry.getSelectedIndex() == 0 || tocountry.getSelectedIndex() == 0 || fromtext.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Invalid Input", "Getting Error", JOptionPane.ERROR_MESSAGE);

            } else {
                double amountToChange = Double.parseDouble(fromtext.getText());
                double amountInPounds = 0.0;
                //From Ammout change into pounds
                switch (fromcountry.getSelectedItem().toString()) {
                    case "India":
                        amountInPounds = amountToChange / Indian_Rupee;
                        break;
                    case "USA":
                        amountInPounds = amountToChange / US_Dollar;
                        break;
                    case "Canada":
                        amountInPounds = amountToChange / Canadian_Dollar;
                        break;
                    case "Dubai":
                        amountInPounds = amountToChange / Dubai_Dirhem;
                        break;
                    case "Ngeria":
                        amountInPounds = amountToChange / Nigerian_Naira;
                        break;
                    case "Brazil":
                        amountInPounds = amountToChange / Brazilian_Real;
                        break;
                    case "Indonesia":
                        amountInPounds = amountToChange / Indonesian_Rupiah;
                        break;
                    case "pak":
                        amountInPounds = amountToChange / Pakistani_Rupee;
                        break;
                    default:
                        amountInPounds = 0.0;
                }

                double newamount = 0.0;
                switch (tocountry.getSelectedItem().toString()) {
                    case "India":
                        newamount = amountInPounds * Indian_Rupee;
                    case "USA":
                        newamount = amountInPounds * US_Dollar;
                        break;
                    case "Canada":
                        newamount = amountInPounds * Canadian_Dollar;
                        break;
                    case "Dubai":
                        newamount = amountInPounds * Dubai_Dirhem;
                        break;
                    case "Ngeria":
                        newamount = amountInPounds * Nigerian_Naira;
                        break;
                    case "Brazil":
                        newamount = amountInPounds * Brazilian_Real;
                        break;
                    case "Indonesia":
                        newamount = amountInPounds * Indonesian_Rupiah;
                        break;
                    case "pak":
                        amountInPounds = amountToChange / Pakistani_Rupee;
                        break;
                    default:
                        newamount = amountInPounds = 0.0;
                }
                String amount = String.format("%.2f", newamount);
                Answer.setText(amount);
            }
        }


    }
}