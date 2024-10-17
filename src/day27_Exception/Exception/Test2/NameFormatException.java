package day27_Exception.Exception.Test2;

public class NameFormatException extends RuntimeException {
    // 技巧
    // NameFormat：当前异常的名字，表示姓名格式化问题
    // Exception：异常，表示这是一个异常类

    // 运行时：RuntimeException 核心是表示由于参数错误而导致的问题
    // 编译时：Exception 核心是提醒程序员检查本地信息


    public NameFormatException() {
        super();
    }

    public NameFormatException(String message) {
        super("名字出错啦！"+message);
    }
}
