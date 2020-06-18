package cn.zero.leetcode.all.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * 2. 两数相加
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class All_2_AddTwoNumbers {

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int flag = 0;
        ListNode result;
        ListNode tempListNode;
        int val1 = l1.val;
        int val2 = l2.val;
        int sum = val1 + val2;
        int temp = sum % 10;
        if (sum >= 10) {
            flag = 1;
        } else {
            flag = 0;
        }
        result = new ListNode(temp);
        tempListNode = result;
        while (true) {
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            if (l1 != null && l2 != null) {
                val1 = l1.val;
                val2 = l2.val;
                sum = val1 + val2 + flag;
            } else if (l1 != null && l2 == null) {
                val1 = l1.val;
                sum = val1 + flag;
            } else if (l1 == null && l2 != null) {
                val2 = l2.val;
                sum = val2 + flag;
            } else if (l1 == null && l2 == null) {
                if (flag > 0) {
                    sum = flag;
                } else {
                    break;
                }
            }
            temp = sum % 10;
            if (sum >= 10) {
                flag = 1;
            } else {
                flag = 0;
            }
            tempListNode.next = new ListNode(temp);
            tempListNode = tempListNode.next;
        }
        return result;
    }

    @Test
    public void test() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode listNode = addTwoNumbers(l1, l2);
        Assert.assertEquals(listNode.val, 7);
        Assert.assertEquals(listNode.next.val, 0);
        Assert.assertEquals(listNode.next.next.val, 8);
        System.out.println(listNode.val);
        System.out.println(listNode.next.val);
        System.out.println(listNode.next.next.val);
    }

    @Test
    public void test1() {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        ListNode listNode = addTwoNumbers(l1, l2);
        Assert.assertEquals(listNode.val, 0);
        Assert.assertEquals(listNode.next.val, 1);
        System.out.println(listNode.val);
        System.out.println(listNode.next.val);
    }
}