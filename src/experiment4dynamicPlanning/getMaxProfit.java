package experiment4dynamicPlanning;

public class getMaxProfit {
    public static class Result{
        public double profit;
        public Integer[] num;
        // 定义结果集，num数组表示分给每个工程的资源，profit表示利润。
        public Result(double profit,Integer m) {
            this.profit = profit;
            this.num = new Integer[m];
        }
        public Result() {}

        public void setNum(Integer[] num) {
            this.num = num;
        }

        public Integer[] getNum() {
            return num;
        }

        public void setProfit(double profit) {
            this.profit = profit;
        }

        public double getProfit() {
            return profit;
        }
    }
    public static Result computeMaxProfit(Integer m,Integer n, double[][] profitTable) {
        //保存结果
        Result result = new Result(0,m);
        // 定义计算利润的表。定义每一行的最大值。
        double[] F = new double[n];
        // 每一行每一个值取最大值时分配的资源数。
        Integer[][] P= new Integer[n][m + 1];
        // 定义每一行中取最大值时的下标
        Integer[] M = new Integer[n];
        // 定义分给前几项工程时获益最大，tag表示哪个工程
        int tag = 0;
        // 初始化每行的最大值为0。
        double[][] computeTable = new double[n][m + 1];
        // 初始化表的第一行。与给出的利润表一样。
        for (int i = 1;i < m;i++) {
            computeTable[0][i] = profitTable[0][i];
        }
        // 每个工程分配资源是0时利润都是0
        for (int i = 0;i < n;i++) {
            computeTable[i][0] = 0;
        }
        for (int i = 1;i <= m;i++) {
            P[0][i] = i;
        }
        for (int i = 0;i < n;i++) {
            P[i][0] = 0;
        }
        // 计算其余行。
        for (int j = 1;j < n;j++) {
            //计算每一列
            for (int k = 1;k <= m;k++) {
                // 计算具体的每一个值。
                for (int x = 0;x <= k;x++) {
                    if (computeTable[j][k] < computeTable[j - 1][x] + profitTable[j][k - x]) {
                        computeTable[j][k] =  computeTable[j - 1][x] + profitTable[j][k - x];
                        P[j][k] = k - x;
                    }
                }
                if (F[j] < computeTable[j][k]) {
                    F[j] = computeTable[j][k];
                    M[j] = k;
                }
            }
            if (result.getProfit() < F[j]) {
                result.setProfit(F[j]);
                tag = j;
            }
        }
        for (int i = tag + 1;i < n;i++) {
            result.getNum()[i] = 0;
        }
        int y = M[tag];
        for (int i = tag;i >= 0;i--) {
            result.getNum()[i] = P[i][y];
            y = y - P[i][y];
        }
        return result;
    }

    public static void main(String[] args) {
        double[][] init = {
                {0,1.2,1.5,1.85,2.4,2.8,3.3},
                {0,1.8,2.0,2.25,2.4,2.5,2.6},
                {0,1.3,1.9,2.2,2.45,2.7,3.0}
        };
        Result result = getMaxProfit.computeMaxProfit(6, 3, init);
        System.out.println(result.getProfit());
        System.out.println(result.getNum());
    }
}
