public class ProgressBar {
    public static void main(String[] args) throws InterruptedException {
        int total = 100; // 总进度

        for (int i = 0; i <= total; i++) {
            // 1. 生成进度条的方块视觉效果 (每10%增加一个方块)
            StringBuilder bar = new StringBuilder();
            int barsCount = i / 10;
            for (int j = 0; j < 10; j++) {
                if (j < barsCount) {
                    bar.append("■");
                } else {
                    bar.append("□");
                }
            }

            // 2. 使用 \r 让光标回到行首，实现动态刷新
            System.out.print("\rdownloading: [" + bar + "] " + i + "%");

            // 3. 强制刷新输出流
            System.out.flush();

            // 模拟耗时操作 (延时100毫秒)
            Thread.sleep(100);
        }

        // 进度完成后换行
        System.out.println("\ncomplete!");
    }
}
