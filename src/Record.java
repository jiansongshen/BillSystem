import java.io.*;
import java.util.Date;

/*
 * Author: Jiansong Shen
 * Version: 1.0
 */
public class Record implements OutcomeCase{
    private String date;
    private double outcome;
    private String reason;
    private String path = "src\\record.txt";

    public Record() {

    }

    public boolean saveRecord(){
        File file = new File(path);
        System.out.println("准备保存记录");

        //如果不存在就创建
        if(!file.exists()){
            System.out.println("记录文件不存在，正在创建...");
            try {
                file.createNewFile();
                System.out.println("创建成功！");;
            } catch (IOException e) {
                System.out.println("文件不存在，创建失败");
            }
        }

        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            System.out.println("文件出错！");
        }

        return false;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getOutcome() {
        return outcome;
    }

    public void setOutcome(double outcome) {
        this.outcome = outcome;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Record(String date, double outcome, String reason) {
        this.date = date;
        this.outcome = outcome;
        this.reason = reason;
    }
}
