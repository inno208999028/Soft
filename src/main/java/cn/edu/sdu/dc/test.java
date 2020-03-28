package cn.edu.sdu.dc;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;

import com.sun.management.OperatingSystemMXBean;

public class test {
    /***@RequestMapping("/getVerifyCode ")

    public void getVerificationCode(HttpServletResponse response,HttpServletRequest request) {

        try {

            int width=200;

            int height=69;

            BufferedImage verifyImg=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

//生成对应宽高的初始图片

            String randomText = VerifyCode.drawRandomText(width,height,verifyImg);

//单独的一个类方法，出于代码复用考虑，进行了封装。

//功能是生成验证码字符并加上噪点，干扰线，返回值为验证码字符

            request.getSession().setAttribute("verifyCode", randomText);

            response.setContentType("image/png");//必须设置响应内容类型为图片，否则前台不识别

            OutputStream os = response.getOutputStream(); //获取文件输出流

            ImageIO.write(verifyImg,"png",os);//输出图片流

            os.flush();

            os.close();//关闭流

        } catch (IOException e) {

            this.logger.error(e.getMessage());

            e.printStackTrace();

        }

    }**/
private static OperatingSystemMXBean osb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
public static int memoryLoad(){
double totalMemory =osb.getTotalPhysicalMemorySize();
double freeMemorySize=osb.getFreePhysicalMemorySize();
double value = freeMemorySize/totalMemory;
int percentLoad=(int) ((1-value)*100);
return percentLoad;}
    private static OperatingSystemMXBean osmb=(OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        public static int cpuLoad(){
        double cpuload=osmb.getSystemCpuLoad();
        int percentCpuLoad=(int)(cpuload*100);
        return percentCpuLoad;}
    public static void main(String[] args){
        System.out.println(test.cpuLoad());
        System.out.println(test.memoryLoad());
    }
}
