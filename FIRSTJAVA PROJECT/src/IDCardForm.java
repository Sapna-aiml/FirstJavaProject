import javax.swing.*;
import java.awt.*;

public class IDCardForm extends JFrame{

    private JTextField txtName;
    private JTextField txtID;
    private JTextField txtDepartment;
    private JTextField txtEmail;
    private JTextField txtMobile;
    private JTextField txtCourse;
    private JLabel IbIPhoto;
    private String imagePath;

    private JLabel IbIShowName;
    private JLabel IbIShowID;
    private JLabel IbIShowDepartment;
    private JLabel IbIShowEmail;
    private JLabel IbIShowMobile;
    private JLabel IbIShowCourse;



    public IDCardForm(){
        setTitle("ID Card Generator System");
        setSize(800,600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel cardPanel=new JPanel();
        cardPanel.setLayout(null);
        cardPanel.setBounds(330,20,280,360);
        cardPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        add(cardPanel);

        cardPanel.setBackground(Color.LIGHT_GRAY);


        JLabel IbIName=new JLabel("Name:");
        IbIName.setBounds(30,30,100,25);
        add(IbIName);

        txtName=new JTextField();
        txtName.setBounds(120,30,180,25);
        add(txtName);

        JLabel IbIID=new JLabel("ID Number:");
        IbIID.setBounds(30,70,100,25);
        add(IbIID);

        txtID=new JTextField();
        txtID.setBounds(120,70,180,25);
        add(txtID);

        JLabel IbIDepartment=new JLabel("Department:");
        IbIDepartment.setBounds(30,110,100,25);
        add(IbIDepartment);

        txtDepartment=new JTextField();
        txtDepartment.setBounds(120,110,180,25);
        add(txtDepartment);

        JLabel IbIEmail=new JLabel("Email:");
        IbIEmail.setBounds(30,150,100,25);
        add(IbIEmail);

        txtEmail=new JTextField();
        txtEmail.setBounds(120,150,180,25);
        add(txtEmail);

        JLabel IbIMobile =new JLabel("Mobile:");
        IbIMobile.setBounds(30,190,100,25);
        add(IbIMobile);

        txtMobile=new JTextField();
        txtMobile.setBounds(120,190,180,25);
        add(txtMobile);

        JLabel IbICourse= new JLabel("Course:");
        IbICourse.setBounds(30,230,100,25);
        add(IbICourse);

        txtCourse= new JTextField();
        txtCourse.setBounds(120,230,180,25);
        add(txtCourse);

        JButton btnGenerator=new JButton("ID card generate");
        btnGenerator.setBounds(80,270,180,35);
        add(btnGenerator);

        JButton btnPhoto=new JButton("choose Photo");
        btnPhoto.setBounds(80,300,180,35);
        add(btnPhoto);


        JButton btnReset=new JButton("Reset");
        btnReset.setBounds(80,340,180,35);
        add(btnReset);

        IbIPhoto=new JLabel();
        IbIPhoto.setBounds(150,120,80,100);
        IbIPhoto.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        cardPanel.add(IbIPhoto);


        btnGenerator.addActionListener(e->{

            if(txtName.getText().trim().isEmpty()||
                    txtID.getText().trim().isEmpty()||
                    txtDepartment.getText().trim().isEmpty()||
                    txtEmail.getText().trim().isEmpty()||
                    txtMobile.getText().trim().isEmpty()||
                    txtCourse.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(this,"please fill all  fields!");
                return;
            }


            if(txtMobile.getText().length()!=10){
                JOptionPane.showMessageDialog(this,"Mobile number must be 10 digits!");
                return;
            }

            if(!txtEmail.getText().contains("@")){
                JOptionPane.showMessageDialog(this,"Enter a valid email!");
                return;
            }


            IbIShowName.setText("Name:"+txtName.getText());
            IbIShowID.setText("ID:"+txtID.getText());
            IbIShowDepartment.setText("Department:"+txtDepartment.getText());
            IbIShowEmail.setText("Email:"+txtEmail.getText());
            IbIShowMobile.setText("Mobile:"+txtMobile.getText());
            IbIShowCourse.setText("Course:"+txtCourse.getText());

        });

        btnPhoto.addActionListener(e->{
            JFileChooser chooser=new JFileChooser();
            int option=chooser.showOpenDialog(null);
            if(option==JFileChooser.APPROVE_OPTION){
                imagePath=chooser.getSelectedFile().getAbsolutePath();
                ImageIcon icon=new ImageIcon(imagePath);
                Image img=
                        icon.getImage().getScaledInstance(80,100,Image.SCALE_SMOOTH);
                IbIPhoto.setIcon(new ImageIcon(img));
            }
        });


        btnReset.addActionListener(e->{
            txtName.setText("");
            txtID.setText("");
            txtDepartment.setText("");
            txtEmail.setText("");
            txtMobile.setText("");
            txtCourse.setText("");

            IbIShowName.setText("Name:");
            IbIShowID.setText("ID:");
            IbIShowDepartment.setText("Department:");
            IbIShowEmail.setText("Email:");
            IbIShowMobile.setText("Mobile:");
            IbIShowCourse.setText("Course:");

            IbIPhoto.setIcon(null);
        });

        JLabel title=new JLabel("Student ID Card");
        title.setBounds(40,10,180,30);
        title.setFont(new Font("Arial",Font.BOLD,16));
        cardPanel.add(title);

        JLabel IbITitle =new JLabel("<html><center>SAGAR INSTITUTE OF SCIENCE<br> TECHNOLOGY AND RESEARCH<br>RATIBAD BHOPAL</CENTER></HTML>");
        IbITitle.setBounds(10,40,230,60);
        IbITitle.setFont(new Font("Arial",Font.BOLD,14));
        cardPanel.add(IbITitle);


        IbIShowName=new JLabel("Name : ");
        IbIShowName.setBounds(20,120,220,25);
        cardPanel.add(IbIShowName);

        IbIShowID=new JLabel("ID : ");
        IbIShowID.setBounds(20,150,220,25);
        cardPanel.add(IbIShowID);


        IbIShowDepartment =new JLabel("Department : ");
        IbIShowDepartment.setBounds(20,180,220,30);
        cardPanel.add(IbIShowDepartment);

        IbIShowEmail =new JLabel("Email : ");
        IbIShowEmail.setBounds(20,210,300,30);
        cardPanel.add(IbIShowEmail);

        IbIShowMobile=new JLabel("Mobile : ");
        IbIShowMobile.setBounds(20,240,220,25);
        cardPanel.add(IbIShowMobile);


        IbIShowCourse =new JLabel("Course : ");
        IbIShowCourse.setBounds(20,270,220,25);
        cardPanel.add(IbIShowCourse);





        setVisible(true);
    }
}
