import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Math.sqrt;

public class main extends JComponent{

    private int x, y, z;
    private int Side1Int, Side2Int, Side3Int;
    private String Side1Str, Side2Str, Side3Str;

    public int getx() {
        return x;
    }
    public void setx(int x) {
        this.x = x;
    }
    public int gety() {
        return y;
    }
    public void sety(int y) {
        this.y = y;
    }
    public int getz() {
        return z;
    }
    public void setz(int z){
        this.z = z;
    }
    public void setSide1Str(String Side1Str){
        this.Side1Str = Side1Str;
    }
    public void setSide2Str(String Side2Str){
        this.Side2Str = Side2Str;
    }
    public void setSide3Str(String Side3Str){
        this.Side3Str = Side3Str;
    }
    public String getSide1Str(){
        return Side1Str;
    }
    public String getSide2Str(){
        return Side2Str;
    }
    public String getSide3Str(){
        return Side3Str;
    }
    public void setSide1Int(int Side1Int){
        this.Side1Int = Side1Int;
    }
    public void setSide2Int(int Side2Int){
        this.Side2Int = Side2Int;
    }
    public void setSide3Int(int Side3Int){
        this.Side3Int = Side3Int;
    }
    public int getSide1Int(){
        return Side1Int;
    }
    public int getSide2Int(){
        return Side2Int;
    }
    public int getSide3Int(){
        return Side3Int;
    }

    public static void main(String[] args) {
        main m1 = new main();
        JFrame frame =new JFrame();
        JTextField jt1, jt2, jt3;
        JLabel jl1, jl2;
        JButton jb1;
        Font MyFont = (new Font("MyFont2", Font.PLAIN, 14));

        JLabel jtl1 = new JLabel("Сторона 1");
        JLabel jtl2 = new JLabel("Сторона 2");
        JLabel jtl3 = new JLabel("Сторона 3");
        frame.add(jtl1);
        frame.add(jtl2);
        frame.add(jtl3);
        jtl1.setFont(MyFont);
        jtl2.setFont(MyFont);
        jtl3.setFont(MyFont);
        jtl1.setBounds(50, 150, 100, 70);
        jtl2.setBounds(250, 150, 100, 70);
        jtl3.setBounds(450, 150, 100, 70);

        jt1 = new JTextField();
        jt2 = new JTextField();
        jt3 = new JTextField();
        jt1.setEditable(true);
        jt2.setEditable(true);
        jt3.setEditable(true);
        frame.add(jt1);
        frame.add(jt2);
        frame.add(jt3);
        jt1.setBounds(50, 200, 70, 25);
        jt2.setBounds(250, 200, 70, 25);
        jt3.setBounds(450, 200, 70, 25);



        jb1 = new JButton("Вивести периметр та площу");
        frame.add(jb1);
        jb1.setBounds(200, 50, 200, 60);
        jb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                m1.setSide1Str(jt1.getText().toString());
                m1.setSide2Str(jt2.getText().toString());
                m1.setSide3Str(jt3.getText().toString());
                try {
                    m1.setSide1Int(Integer.parseInt(m1.getSide1Str()));
                    m1.setSide2Int(Integer.parseInt(m1.getSide2Str()));
                    m1.setSide3Int(Integer.parseInt(m1.getSide3Str()));

                    double x1 = m1.getSide1Int();
                    double x2 = m1.getSide2Int();
                    double x3 = m1.getSide3Int();

                    if(x1 < x2+x3 && x2 < x1+x3 && x3 < x1+x2) {
                            double perimeter = (x1 + x2 + x3);
                            double perimeterd2 = perimeter / 2;
                            double sqrtsum = (perimeterd2) * (perimeterd2 -x1) * (perimeterd2 - x2) * (perimeterd2 - x3);
                            double area = Math.sqrt(sqrtsum);


                            JOptionPane.showMessageDialog(frame,
                                    "Периметр: " + perimeter + "\nПлоща: " + area,
                                    "Трикутник",
                                    JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        System.out.println("Не може бути трикутника зі стороною більшою за дві інших");
                    }
                } catch (Exception event) {
                    System.out.println(event);
                }
            }
        });

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(new main());
        frame.pack();
        frame.setSize(new Dimension(600, 300));
        frame.setVisible(true);
    }

}