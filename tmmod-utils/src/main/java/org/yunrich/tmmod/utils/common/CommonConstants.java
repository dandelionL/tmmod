package org.yunrich.tmmod.utils.common;


import java.util.Locale;

/**
 * 通用的一些常量
 * @author master.yang
 * @version $Id: CommonConstants.java, v 0.1 2014-6-9 上午10:24:19 Administrator Exp $
 */
public abstract class CommonConstants {

    /**
     * 空白字符，值包含一个空格
     */
    public static final String BLANK = " ";

    /**
     * 英文空格
     */
    public static final String SPACE = " ";

    /**
     * 英文感叹号
     */
    public static final String BANG = "!";

    /**
     * 英文问号
     */
    public static final String QUESTION_MARK = "?";

    /**
     * 英文逗号
     */
    public static final String COMMA = ",";

    /**
     * 英文句号
     */
    public static final String POINT = ".";

    /**
     * 英文冒号
     */
    public static final String COLON = ":";

    /**
     * 英文分号
     */
    public static final String SEMICOLON = ";";

    /**
     * 英文单引号
     */
    public static final String QUOTE = "'";

    /**
     * 英文带转义的单引号
     */
    public static final String SINGLE_QUOTE = "\'";

    /**
     * 英文带转义的双引号
     */
    public static final String DOUBLE_QUOTE = "\"";

    /**
     * 星号
     */
    public static final String STAR = "*";

    /**
     * 加号
     */
    public static final String PLUS = "+";

    /**
     * 破折号
     */
    public static final String DASH = "-";

    /**
     * 等于号
     */
    public static final String EQUAL = "=";

    /**
     * 斜杠
     */
    public static final String SLASH = "/";

    /**
     * 反斜杠
     */
    public static final String BACK_SLASH = "\\";

    /**
     * 管道符号
     */
    public static final String PIPE = "|";

    /**
     * 下划线
     */
    public static final String UNDERLINE = "_";

    /**
     * 美元符号
     */
    public static final String DOLOR = "$";

    /**
     * @符号
     */
    public static final String AT = "@";

    /**
     * 井号
     */
    public static final String CROSS_HATCH = "#";

    /**
     * 百分号
     */
    public static final String PERCENT = "%";

    /**
     * 连接符号
     */
    public static final String AND = "&";

    /**
     * 尖角号
     */
    public static final String CIRCUMFLEX = "^";

    /**
     * 曲线
     */
    public static final String TILDE = "~";

    /**
     * 左大括号
     */
    public static final String LEFT_BRACE = "{";

    /**
     * 右大括号
     */
    public static final String RIGHT_BRACE = "}";

    /**
     * 左中括号
     */
    public static final String LEFT_BRACKET = "[";

    /**
     * 右中括号
     */
    public static final String RIGHT_BRACKET = "]";

    /**
     * 小于号
     */
    public static final String LEFT_ANGLE_BRACKET = "<";

    /**
     * 大于号
     */
    public static final String RIGHT_ANGLE_BRACKET = ">";

    /**
     * 左小括号
     */
    public static final String LEFT_PARENTHESES = "(";

    /**
     * 右小括号
     */
    public static final String RIGHT_PARENTHESES = ")";

    /**
     * 换行符
     */
    public static final String LINE_CHANGE_SYMBOL = "\n";

    /**
     * 回车符
     */
    public static final String ENTER_SYMBOL = "\r";

    /**
     * Classpath前缀
     */
    public static final String CLASSPATH_PREFIX = "classpath:";

    /**
     * JAVA Properties文件后缀
     */
    public static final String PROPERTIES_SUFFIX = ".properties";

    /**
     * JAVA源文件编译后的class文件后缀
     */
    public static final String CLASS_SUFFIX = ".class";

    /**
     * TXT文件后缀
     */
    public static final String TXT_SUFFIX = ".txt";

    /**
     * CSV文件后缀
     */
    public static final String CSV_SUFFIX = ".csv";

    /**
     * 区域数组，可以使用齐总定义的一些常用的区域
     */
    public static final String[] ALL_LOCALES_STRING = { Locale.ENGLISH.toString(),
                                                       Locale.FRENCH.toString(),
                                                       Locale.GERMAN.toString(),
                                                       Locale.ITALIAN.toString(),
                                                       Locale.JAPANESE.toString(),
                                                       Locale.KOREAN.toString(),
                                                       Locale.CHINESE.toString(),
                                                       Locale.SIMPLIFIED_CHINESE.toString(),
                                                       Locale.TRADITIONAL_CHINESE.toString(),
                                                       Locale.FRANCE.toString(),
                                                       Locale.GERMANY.toString(),
                                                       Locale.ITALY.toString(),
                                                       Locale.JAPAN.toString(),
                                                       Locale.KOREA.toString(),
                                                       Locale.CHINA.toString(),
                                                       Locale.PRC.toString(),
                                                       Locale.TAIWAN.toString(),
                                                       Locale.UK.toString(), Locale.US.toString(),
                                                       Locale.CANADA.toString(),
                                                       Locale.CANADA_FRENCH.toString() };
    /**
     * 系统使用的编码集<code>utf-8</code>
     */
    public static final String SYSTEM_CHARSET = "UTF-8";

    /**
     * 字符串值"NULL"，有时一些参数的值为字符串"null"或"NULL"
     * 在判断是否为null时可以转换大写后与此常量进行比较
     */
    public static final String PARAMS_NULL_VALUE = "NULL";
    
}