import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Vector;

/*
 * Author: Jiansong Shen
 * Version: 1.0
 * 支出界面
 */
public class OutcomePanel extends JPanel implements Runnable {
    //本次运行中产生的记录
    Vector<Record> vector = new Vector<>();
    Record record = null;
    //本次软件启动中的支出
    double outcome = 0;

    OutcomePanel() {
        //初始化
        this.record = new Record();
        this.setPreferredSize(new Dimension(660, 100));

        this.setLayout(new FlowLayout());

        record = new Record();
        Date now = new Date();
        now.getTime();

        record.setDate(now.toString());

        //各种模块的初始化
        //按钮初始化
        JButton button1 = new JButton("吃饭");
        JButton button2 = new JButton("娱乐");
        JButton button3 = new JButton("学习工作");
        JButton deleteRecordButton = new JButton("删除上一条记录");

        //文本框初始化，用于输入金额
        TextField textField = new TextField();

        //标签初始化
        JLabel jLabel = new JLabel("开销类型:");
        JLabel jLabel_return_message = new JLabel("");
        JLabel titleLabel = new JLabel("BILL SYSTEM");
        JLabel remindLabel = new JLabel("请输入你支出的金额：");


        textField.setPreferredSize(new Dimension(400, 50));
        textField.setFont(new Font("微软雅黑", 0, 40));

        button1.setPreferredSize(new Dimension(200, 80));
        button2.setPreferredSize(new Dimension(200, 80));
        button3.setPreferredSize(new Dimension(200, 80));
        deleteRecordButton.setPreferredSize(new Dimension(200, 40));
        button1.setFont(new Font("微软雅黑", Font.BOLD, 24));
        button2.setFont(new Font("微软雅黑", Font.BOLD, 24));
        button3.setFont(new Font("微软雅黑", Font.BOLD, 24));
        deleteRecordButton.setFont(new Font("微软雅黑", Font.BOLD, 18));

        titleLabel.setFont(new Font("隶书", 0, 60));
        jLabel.setFont(new Font("微软雅黑", 0, 30));
        jLabel.setPreferredSize(new Dimension(480, 40));
        jLabel.setDisplayedMnemonic(JLabel.CENTER);
        remindLabel.setFont(new Font("宋体", 0, 40));
        remindLabel.setPreferredSize(new Dimension(480, 40));


        this.add(titleLabel);
        this.add(remindLabel);
        this.add(jLabel_return_message);
        this.add(textField);
        this.add(deleteRecordButton);
        this.add(jLabel);
        this.add(button1);
        this.add(button2);
        this.add(button3);

        //设置按下按钮的行为
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //接收输入
                try {
                    outcome = Double.parseDouble(textField.getText());
                } catch (NumberFormatException ex) {
                    textField.setText("请输入数字");
                }
                
                if (outcome != 0) {
                    //用于初始化record的日期类
                    Date temp = new Date();
                    temp.getTime();
                    record = new Record(temp.toString(), outcome, "1");
                    vector.add(record);
                    //用户输入完后清空输入栏
                }
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    outcome = Double.parseDouble(textField.getText());
                } catch (NumberFormatException ex) {
                    textField.setText("请输入数字");
                }
                if (outcome != 0) {
                    Date temp = new Date();
                    temp.getTime();
                    record = new Record(temp.toString(), outcome, "2");
                    vector.add(record);
                }
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    outcome = Double.parseDouble(textField.getText());
                } catch (NumberFormatException ex) {
                    textField.setText("请输入数字");
                }
                if (outcome != 0) {
                    Date temp = new Date();
                    temp.getTime();
                    record = new Record(temp.toString(), outcome, "3");
                    vector.add(record);
                }
            }
        });
        deleteRecordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!vector.isEmpty()) {
                    vector.remove(vector.lastElement());
                }
            }
        });

    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }
        this.repaint();
    }
}
