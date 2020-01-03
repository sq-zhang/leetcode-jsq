/*
 * @lc app=leetcode.cn id=1169 lang=java
 *
 * [1169] 查询无效交易
 *
 * https://leetcode-cn.com/problems/invalid-transactions/description/
 *
 * algorithms
 * Medium (27.48%)
 * Likes:    10
 * Dislikes: 0
 * Total Accepted:    2.5K
 * Total Submissions: 9.1K
 * Testcase Example:  '["alice,20,800,mtv","alice,50,100,beijing"]'
 *
 * 如果出现下述两种情况，交易 可能无效：
 * 
 * 
 * 交易金额超过 ¥1000
 * 或者，它和另一个城市中同名的另一笔交易相隔不超过 60 分钟（包含 60 分钟整）
 * 
 * 
 * 每个交易字符串 transactions[i] 由一些用逗号分隔的值组成，这些值分别表示交易的名称，时间（以分钟计），金额以及城市。
 * 
 * 给你一份交易清单 transactions，返回可能无效的交易列表。你可以按任何顺序返回答案。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：transactions = ["alice,20,800,mtv","alice,50,100,beijing"]
 * 输出：["alice,20,800,mtv","alice,50,100,beijing"]
 * 解释：第一笔交易是无效的，因为第二笔交易和它间隔不超过 60 分钟、名称相同且发生在不同的城市。同样，第二笔交易也是无效的。
 * 
 * 示例 2：
 * 
 * 输入：transactions = ["alice,20,800,mtv","alice,50,1200,mtv"]
 * 输出：["alice,50,1200,mtv"]
 * 
 * 
 * 示例 3：
 * 
 * 输入：transactions = ["alice,20,800,mtv","bob,50,1200,mtv"]
 * 输出：["bob,50,1200,mtv"]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * transactions.length <= 1000
 * 每笔交易 transactions[i] 按 "{name},{time},{amount},{city}" 的格式进行记录
 * 每个交易名称 {name} 和城市 {city} 都由小写英文字母组成，长度在 1 到 10 之间
 * 每个交易时间 {time} 由一些数字组成，表示一个 0 到 1000 之间的整数
 * 每笔交易金额 {amount} 由一些数字组成，表示一个 0 到 2000 之间的整数
 * 
 * 
 */

// @lc code=start
class Solution {

    private class Trade {
        private String name;
        private Integer time;
        private Integer amount;
        private String city;

        public Trade(String name, Integer time, Integer amount, String city) {
            this.name = name;
            this.time = time;
            this.amount = amount;
            this.city = city;
        }

        @Override
        public boolean equals(Object object) {
            Trade trade = (Trade) object;
            return this.name.equals(trade.name) && !this.city.equals(trade.city)
                && Math.abs(this.time - trade.time) <= 60;
        }

        @Override
        public String toString() {
            return name + "," + time + "," + amount + "," + city;
        }

    }

    public List<String> invalidTransactions(String[] transactions) {
        List<String> result = new ArrayList<String>();
        List<Trade> trades = new ArrayList<Trade>();

        for (String s : transactions) {
            String[] split = s.split(",");
            Trade t = new Trade(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]),
                    split[3]);
            trades.add(t);
        }

        trades.forEach(trade -> {
            if (trade.amount > 1000 || trades.contains(trade)) {
                result.add(trade.toString());
            }
        });

        return result;
    }
}
// @lc code=end

