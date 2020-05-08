import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ActionListenerDemo {
    public static void main(String[] args){
        //创建一个窗体
        JFrame f = new JFrame("ActionListenerDemo");
        f.setSize(300,300);
        f.setLocationRelativeTo(null);
        f.setBackground(Color.BLUE);
        final JTextField tf = new JTextField();
        tf.setBounds(75, 52, 150, 30);
        JButton b= new JButton("点击发送信息");
        b.setBounds(50, 150, 80, 30);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = tf.getText();
                System.out.println("接受到消息，内容为:"+text);
            }
        });
        JButton c = new JButton("关闭");
        c.setBounds(170, 150,80, 30);
        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        f.add(b);
        f.add(tf);
        f.add(c);
        f.setLayout(null);
        f.setVisible(true);


    }

}
