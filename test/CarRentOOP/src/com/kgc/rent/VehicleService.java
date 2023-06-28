package com.kgc.rent;

public class VehicleService {
    public static Vehicle[] vehicles = new Vehicle[10];//保存车辆的集合对象

    /*
      初始化系统数据
      */
    static {
        vehicles[0] = new Car("京NY28588","宝马",800,"X6");
        vehicles[1] = new Car("京CNY3284","宝马",600,"550i");
        vehicles[2] = new Car("京NT37465","别克",300,"林荫大道");
        vehicles[3] = new Car("京NT96968","别克",600,"GL8");

        vehicles[4] = new Bus("京6566754","金杯",800,16);
        vehicles[5] = new Bus("京8696997","金龙",800,16);
        vehicles[6] = new Bus("京9696996","金杯",1500,34);
        vehicles[7] = new Bus("京8696998","金龙",1500,34);

        vehicles[8] = new Truck("京MH98725","一汽解放",1200,40);
        vehicles[9] = new Truck("京L593216","重庆红岩",2800,60);
    }

    /**
     *
     * @param brand 品哦
     * @param type 型号
     * @param load 载重量
     * @param seatCount 座位数
     * @return v
     */

    public static Vehicle rentCar(String brand,String type,int load,int seatCount) {
        Vehicle v = null;
        for (Vehicle vehicle: vehicles) {
            if (vehicle == null) continue;
            if (vehicle instanceof Car car) {
                if (car.getBrand().equals(brand) && car.getType().equals(type)) {
                    v = car;
                    break;
                }
            } else if (vehicle instanceof Bus bus) {
                if (bus.getBrand().equals(brand) && bus.getSeatCount() == seatCount) {
                    v = bus;
                    break;
                }
            } else if (vehicle instanceof Truck truck) {
                if (truck.getBrand().equals(brand) && truck.getLoad() == load) {
                    v = truck;
                    break;
                }
            }
        }
        return v;
    }
}
