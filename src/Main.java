import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
 * Author: Jiansong Shen
 * Version: 1.0
 * 主程序
 */
public class Main extends JFrame{
    OutcomePanel ocp = null;
    SelectPanel selectPanel = null;
    public static void main(String[] args) {
        new Main();

    }

    Main(){
        //初始化属性
        ocp = new OutcomePanel();
        selectPanel = new SelectPanel();

        this.add(selectPanel);
        this.add(ocp);
        this.setSize(640,360);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        this.setLayout(null);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                for (Object obj : ocp.vector) {
                    //在文件关闭时保存记录
                    Record rec = (Record)obj;
                    rec.saveRecord();
                }
            }
        });
    }
}
