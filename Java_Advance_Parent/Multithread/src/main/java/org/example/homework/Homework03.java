package org.example.homework;

class ExamPaper {
    private int paperCount;

    public ExamPaper() {
        paperCount = 0;
    }

    public synchronized void distribute() {
        paperCount++;
        System.out.println(Thread.currentThread().getName() + "正在分发试卷，试卷编号：" + paperCount);
    }
}

class Teacher implements Runnable {
    private ExamPaper examPaper;

    public Teacher(ExamPaper examPaper) {
        this.examPaper = examPaper;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            examPaper.distribute();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Homework03 {
    public static void main(String[] args) {
        ExamPaper examPaper = new ExamPaper();
        Teacher teacher1 = new Teacher(examPaper);
        Teacher teacher2 = new Teacher(examPaper);
        Teacher teacher3 = new Teacher(examPaper);

        Thread thread1 = new Thread(teacher1, "老师1");
        Thread thread2 = new Thread(teacher2, "老师2");
        Thread thread3 = new Thread(teacher3, "老师3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}