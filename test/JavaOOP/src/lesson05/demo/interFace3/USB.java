package lesson05.demo.interFace3;
class Mouse implements USB {
    @Override
    public void open() {
        System.out.println("鼠标插入，红灯闪烁...");
    }

    @Override
    public void close() {
        System.out.println("鼠标拔出，红灯熄灭！");
    }
    //鼠标实现类的特有方法
    public void onClick() {
        System.out.println("鼠标点击！");
    }
}
class Keyboard implements USB {

    @Override
    public void open() {
        System.out.println("键盘接入，绿灯闪烁...");
    }

    @Override
    public void close() {
        System.out.println("键盘拔出，绿灯熄灭！");
    }
    public void onType() {
        System.out.println("键盘打字！");
    }
}
class Laptop {
    public void startup() {
        System.out.println("笔记本开机");
    }
    public void useUSB(USB[] usbs) {
        if (usbs == null || usbs.length == 0) {
            System.out.println("未插入USB设备！");
        }
        else {
            for (USB usb : usbs) {
                usb.open();
                // 重点
                //instanceof操作符作用是测试它左边的对象是否是它右边的类的实例，返回 boolean 的数据类型。
                System.out.println("usb.getClass() = " + usb.getClass());
                System.out.println("Mouse.class = " + Mouse.class);
                if (usb.getClass() == Mouse.class) {
                    //对象名.getClass()和类.class获取类型Class对象
                    //向下转型（java.lang.ClassCastException类型转换异常），
                    //1、instanceof操作符判断类型   2、父类型/接口类型变量引用一定要指向被强制类型转换的具体子类/实现类的对象
                    //usb->new Mouse()
                    ((Mouse) usb).onClick();
                } else if (usb instanceof Keyboard) {
                    ((Keyboard) usb).onType();
                }
                usb.close();
            }
        }
    }
    public void shutdown() {
        System.out.println("笔记本关机");
    }
}

public interface USB {
    /**
     * 开启和关闭USB设备功能
     */
    void open();
    void close();
}
class Test {
    public static void main(String[] args) {
        Laptop laptop = new Laptop();
        laptop.startup();
        laptop.useUSB(new USB[]{new Mouse(),new Keyboard()});
        laptop.shutdown();
    }
}
