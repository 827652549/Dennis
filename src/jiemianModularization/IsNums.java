package jiemianModularization;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IsNums {
	/**
     * ����������ʽ�ж��ַ����Ƿ�������
     * @param str
     * @return
     */
    public boolean isNumeric(String str){
           Pattern pattern = Pattern.compile("[0-9]*");
           Matcher isNum = pattern.matcher(str);
           if( !isNum.matches() ){
               return false;
           }
           return true;
    }
}
