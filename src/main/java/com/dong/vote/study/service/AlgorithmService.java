package com.dong.vote.study.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 算法练习
 *
 * @author dongxiaohua
 */
@Service
@Slf4j
public class AlgorithmService {
  /**
   * 最长回文串
   * <p>
   * 根据给定字符串获取最长回文串长度
   * 难度：简单
   * <p>
   * 取出每个字符的个数
   * 如果是偶数的话，全部加进去
   * 如果是奇数的话，减一加进去
   * 如果没有加完，说明有个数是奇数的存在，可以取一个放在中间位置
   *
   * @param s
   */
  public Integer palindrome(String s) {
    int n = s.length();
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      char c = s.charAt(i);
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    int res = 0;
    for (Character key : map.keySet()) {
      Integer val = map.get(key);
      //      if ((val & 1) == 1) {
      if ((val % 2) == 1) {
        res += val - 1;
      } else {
        res += val;
      }
    }
    if (res < n) {
      return res + 1;
    } else {
      return res;
    }
  }

  /**
   * 两数之和
   * <p>
   * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标
   * 难度：简单
   * <p>
   * 反向思维
   * 用给定的目标值减数组中元素
   *
   * @return
   */
  public int[] sum(int[] nums, int target) {
    int[] res = new int[2];
    HashMap<Integer, Integer> map = new HashMap();
    for (int i = 0; i < nums.length; i++) {
      int value = target - nums[i];
      //如果map中存在此差值，则返回
      if (map.containsKey(value)) {
        res[0] = map.get(value) + 1;
        res[1] = i + 1;
        break;
      }
      map.put(nums[i], i);
    }
    return res;
  }

  /**
   * 给出一个有n个元素的数组S，S中是否有元素a,b,c满足a+b+c=0？找出数组S中所有满足条件的三元组。
   * 注意：
   * 三元组（a、b、c）中的元素必须按非降序排列。（即a≤b≤c）
   * 解集中不能包含重复的三元组。
   * <p>
   * 解：
   * 1. 将数组升序排序
   * 2. 先将第一个元素指定为i（固定）
   * 3. 再指定left、right
   * 4. 根据left+right<0 则 left右移，left+right>0 则right左移，=0则记录
   *
   * @return
   */
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);

    List<List<Integer>> res = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
      // i去重
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int l = i + 1;
      int r = nums.length;
      while (l < r) {
        if (nums[i] + nums[l] + nums[r] < 0) {
          l++;
        } else if (nums[i] + nums[l] + nums[r] > 0) {
          r++;
        } else {
          res.add(Arrays.asList(nums[i], nums[l], nums[r]));

          // l、r去重
          int t = nums[l];
          while (l < r && t == nums[l]) {
            l++;
          }

          t = nums[r];
          while (r > l && t == nums[r]) {
            r--;
          }
        }
      }

    }

    return res;
  }


  /**
   * 动态规划
   * <p>
   * 零钱兑换
   * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
   * 示例 1:
   * 输入: coins = [1, 2, 5], amount = 11
   * 输出: 3
   * 解释: 11 = 5 + 5 + 1
   * 示例 2:
   * 输入: coins = [2], amount = 3
   * 输出: -1
   * 说明:
   * 你可以认为每种硬币的数量是无限的。
   *
   * @param coins
   * @param amount
   * @return
   */
  public int countAmount(int[] coins, int amount) {
    if (coins == null || coins.length == 0) {
      return -1;
    }

    Map<Integer, Integer> map = new HashMap<>();


    return -1;
  }


  /**
   * 无重复字符串的最长子串
   * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
   *
   * @param s
   * @return
   */
  public int solution(String s) {
    int flag = 0;
    int length = 0;
    int result = 0;
    for (int i = 0; i < s.length(); i++) {
      //string.charAt(i) 用于返回指定索引处的字符
      //string.indexOf(str,int) 返回指定字符在指定索引开始第一次出现的索引，没有指定字符返回-1
      int pos = s.indexOf(s.charAt(i), flag);
      if (pos < i) {
        if (length > result) {
          result = length;
        }
        if (result >= s.length() - pos - 1) {
          return result;
        }
        length = i - pos - 1;
        flag = pos + 1;
      }
      length++;
    }
    return length;
  }


  /**
   * 实现Pow(x,n)
   * x的n次幂
   *
   * @param x
   * @param n
   * @return
   */
  public double powXn(double x, int n) {
    if (x == 0.0) {
      return 0.0d;
    }
    long N = n;
    if (n < 0) {
      N = -N;
      x = 1 / x;
    }
    double res = 1.0;
    while (N > 0) {
      if ((N & 1) == 1) {
        res *= x;
      }
      x *= x;
      N >>= 1;
    }
    return res;
  }


  /**
   * 给定一个长度为 n 的数组 num 和滑动窗口的大小 size ，找出所有滑动窗口里数值的最大值。
   * <p>
   * 滑动窗口
   *
   * @param nums
   * @param size
   * @return
   */
  public ArrayList<Integer> slidingWindow(int[] nums, int size) {

    ArrayList<Integer> res = new ArrayList<>();
    if (nums == null || nums.length == 0 || size == 0) {
      return res;
    }

    int max = 0;
    for (int i = 0; i <= nums.length - size; i++) {
      max = nums[i];
      for (int j = i; j < i + size; j++) {
        if (max < nums[j]) {
          max = nums[j];
        }
      }
      res.add(max);
    }

    return res;
  }


  /**
   * 最长不重复子串
   * <p>
   * 给定一个长度为n的数组nums，返回arr的最长无重复元素子数组的长度，无重复指的是所有数字都不相同。
   * 子数组是连续的，比如[1,3,5,7,9]的子数组有[1,3]，[3,5,7]等等，但是[1,3,7]不是子数组
   *
   * @param nums
   * @return
   */
  public int maxLength(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int left = -1;
    int res = 0;
    Map<Integer, Integer> map = new HashMap<>();

    // 左指针-1开始，有指针0开始
    for (int right = 0; right <= nums.length - 1; right++) {
      // 查看当前元素是否存在于map中，存在则移动左指针，需要和存在于map中相同元素的下标取最大值
      if (map.containsKey(nums[right])) {
        left = Math.max(left, map.get(nums[right]));
      }
      // 更新结果，当前结果与最新长度取最大值
      res = Math.max(res, right - left);
      // 更新重复元素下标
      map.put(nums[right], right);
    }

    return res;
  }


  /**
   * IPv4 地址由十进制数和点来表示，每个地址包含4个十进制数，其范围为 0 - 255， 用(".")分割。比如，172.16.254.1；
   * 同时，IPv4 地址内的数不会以 0 开头。比如，地址 172.16.254.01 是不合法的
   *
   * @param IP
   * @return
   */
  public boolean IPv4(String IP) {
    if (IP == null) {
      return false;
    }

    if (!IP.contains(".")) {
      return false;
    }

    String[] ipArr = IP.split("\\.");

    // IP地址必有4段
    if (ipArr.length != 4) {
      return false;
    }

    for (int i = 0; i < ipArr.length; i++) {
      String s = ipArr[i];
      // 如果为0，则代表有连续..
      if (s.length() == 0) {
        return false;
      }
      // 判断长度是否在4个以内
      if (s.length() > 3) {
        return false;
      }
      // 判断是否以0开头
      if (s.startsWith("0")) {
        return false;
      }

      int num = 0;
      // 判断是否全部为数字
      for (int j = 0; j < s.length(); j++) {
        char c = s.charAt(j);
        if (c < '0' || c > '9') {
          return false;
        }

        num = num * 10 + (int) (c - '0');
        // 判断转化为二进制数字后是否在0-255
        if (num < 0 || num > 255) {
          return false;
        }
      }
    }

    return true;
  }


  /**
   * 描述（String）两个十进制数字的差
   *
   * @param a
   * @param b
   * @return
   */
  public int difference(String a, String b) {

    int aNum = 0, bNum = 0;

    for (int i = 0; i < a.length(); i++) {
      char c = a.charAt(i);
      aNum = aNum * 10 + (int) (c - '0');
    }

    for (int i = 0; i < b.length(); i++) {
      char c = b.charAt(i);
      bNum = bNum * 10 + (int) (c - '0');
    }

    return aNum - bNum;
  }


  /**
   * 二进制中1的个数
   * 输入一个整数 n ，输出该数32位二进制表示中1的个数。其中负数用补码表示。
   * <p>
   * 解：
   * 利用位运算，不算右移并判断
   * >> 表示右移，如果该数为正，则高位补0，若为负数，则高位补1；
   * >>> 无符号右移，也叫逻辑右移，即若该数为正，则高位补0，而若该数为负数，则右移后高位同样补0。
   *
   * @param n
   * @return
   */
  public int NumberOf1(int n) {
    int res = 0;
    while (n > 0) {
      if ((n & 1) != 0) {
        res++;
      }
      n = n >>> 1;
    }
    return res;
  }


  /**
   * 进制转换
   * 给定一个十进制数 M ，以及需要转换的进制数 N 。将十进制数 M 转化为 N 进制数。
   * 当 N 大于 10 以后， 应在结果中使用大写字母表示大于 10 的一位，如 'A' 表示此位为 10 ， 'B' 表示此位为 11 。
   * 若 M 为负数，应在结果中保留负号。
   * <p>
   * 解： 除N取余，然后倒序排列，高位补零
   *
   * @param M
   * @param N
   * @return
   */
  public String solve(int M, int N) {
    if (M == 0) {
      return "0";
    }
    boolean f = false;
    if (M < 0) {
      f = true;
      M = -M;
    }
    String s = "0123456789ABCDEF";
    StringBuilder sb = new StringBuilder();

    while (M != 0) {
      sb.append(s.charAt(M % N));
      M /= N;
    }

    if (f) {
      sb.append("_");
    }

    return sb.reverse().toString();
  }


  /**
   * 最大矩形面积
   * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
   * [2,1,5,6,2,3]
   * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
   *
   *  单调栈
   *
   *  1. 左右各增加一个0
   *  2. 每次将下表入栈
   *  3. 入栈前要判断，当前位置的高度是否比之前位置(栈中按顺序拿)的小，小则出栈计算当前面积，宽：当前下表-栈中弹出的下标-1，高：栈中取出的位置的高（较小的那个）
   *
   * @param heights
   * @return
   */
  public int largestRectangleArea(int[] heights) {
    int res = 0;
    LinkedList<Integer> stack = new LinkedList<>();
    int[] new_heights = new int[heights.length + 2];
    for (int i = 1; i < heights.length + 1; i++) {
      new_heights[i] = heights[i - 1];
    }
    for (int i = 0; i < new_heights.length; i++) {
      while (!stack.isEmpty() && new_heights[stack.peek()] > new_heights[i]) {
        int cur = stack.pop();
        res = Math.max(res, (i - stack.peek() - 1) * new_heights[cur]);
      }
      stack.push(i);
    }
    return res;
  }




  /**
   * 现在有一个没有重复元素的整数集合S，求S的所有子集
   * 注意：
   * 你给出的子集中的元素必须按升序排列
   * 给出的解集中不能出现重复的元素
   *
   * [1,2,3]
   *[[],[1],[2],[3],[1,2],[1,3],[2,3],[1,2,3]]
   * @param S
   * @return
   */
  public ArrayList<ArrayList<Integer>> subsets(int[] S) {
    ArrayList<ArrayList<Integer> > res = new ArrayList<>();
    //临时存储作用
    List<Integer> temp = new ArrayList<>();
    //首先放入空集
    res.add(new ArrayList<>(temp));
    //i用来表示每次返回几个长度的子集，如 i = 1返回长度为1的子集
    for (int i = 1; i <= S.length; i ++) {
      dfs(i, 0, S, temp, res);
    }
    return res;
  }

  /*
  k 代表temp每次最多存储几个，index代表遍历到哪个位置，S代表给你的数组, temp临时存储
  */
  public void dfs(int length, int index, int[] S, List<Integer> temp,
                  ArrayList<ArrayList<Integer> > res) {
    //当temp数组的存放长度等于k的时候就把temp丢进res里面
    if (length == temp.size()) {
      res.add(new ArrayList<>(temp));
      return ;
    }
    //进行子集的遍历
    for (int i = index; i < S.length; i ++) {
      //放入当前数
      temp.add(S[i]);
      //下一个位置的递归
      dfs(length, i + 1, S, temp, res);
      //回溯到上一个位置
      temp.remove(temp.size() - 1);
    }
  }

}
