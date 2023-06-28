package lesson05.homework04;

public class Test {
    /**
     * 比较对象排序方法
     */
    public static void sort(Object[] objs) {
        for (int i = 0; i < objs.length - 1; i++) {
            for (int j = 0; j < objs.length - 1 - i; j++) {
                if (((Comparable)objs[j]).compareTo(objs[j+1]) <= 0) {
                    swap(objs,j,j+1);
                }
            }
        }
    }

    //交换
    private static void swap(Object[] x,int a,int b) {
        Object t = x[a];
        x[a] = x[b];
        x[b] = t;
    }

    public static void main(String[] args) {
        Student s1 = new Student("1","托尼",23,80);
        Student s2 = new Student("2","詹姆斯",19,95);
        Student s3 = new Student("3","皮特",17,90);
        Student s4 = new Student("4","爱丽丝",25,75);

        Student[] list = {
                s1,s2,s3,s4
        };
        System.out.println("未排序");
        for (Student student : list) {
            System.out.println(student);
        }
        sort(list);
        System.out.println("已排序");
        for (Student student : list) {
            System.out.println(student);
        }
        News n1 = new News(10023,"震惊！安徽某张姓男子旅游南京遭遇了这些事情！","内容略",114514);
        News n2 = new News(10025,"不看后悔！2024年的安徽高考生有这些需要注意！","内容略",114515);
        News[] list2 = {
                n1,n2
        };
        System.out.println("未排序");
        for (News news : list2) {
            System.out.println(news);
        }
        sort(list2);
        System.out.println("已排序");
        for (News news : list2) {
            System.out.println(news);
        }
    }
}
