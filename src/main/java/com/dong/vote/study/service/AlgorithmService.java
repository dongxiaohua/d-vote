package com.dong.vote.study.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
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

    for (int right = 0; right <= nums.length - 1; right++) {
      if (map.containsKey(nums[right])) {
        left = Math.max(left, map.get(nums[right]));
      }
      res = Math.max(res, right - left);
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
      }

      // 判断转化为二进制数字后是否在0-255
      if (num < 0 || num > 255) {
        return false;
      }
    }

    return true;
  }

}
