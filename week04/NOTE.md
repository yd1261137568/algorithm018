学习笔记
# 树和图的遍历

## dfs深度优先遍历
一般用递归或者手动维护栈的方式做
前序
中序
后序
常用于动态规划、回溯
```$xslt
static class TreeNode {
    int val;
    List<TreeNode> children;
    TreeNode(int x) {
        val = x;
    }
}
    
public static void dfs(TreeNode treeNode) {
    if (treeNode == null) {
        return;
    }

    System.out.println(treeNode.val);

    if (treeNode.children != null) {
        List<TreeNode> children = treeNode.children;

        for (TreeNode child : children) {
            dfs(child);
        }
    }
}
```


## bfs广度优先遍历
一般用队列+临时变量来控制层序遍历 
常用于求最短路径
```$xslt
static class TreeNode {
    int val;
    List<TreeNode> children;
    TreeNode(int x) {
        val = x;
    }
}

public static void bfs(TreeNode treeNode) {

    if (treeNode == null) {
        return;
    }

    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(treeNode);
    while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            TreeNode poll = queue.poll();
            System.out.println(poll.val);
            if (poll.children != null) {
                for (TreeNode child : poll.children) {
                    queue.add(child);
                }
            }
        }
    }
}
```

# 贪心
每一步都找最优解,以此来尝试获取全局最优解
代码逻辑往往不复杂,难点在于如何推导题目能不能用贪心求解

# 二分查找

进行二分查找的前提是数据有序,能将时间复杂度O(n)的查找降低为事件复杂度O(logn)

## 二分公式
```$xslt
public static void main(String[] args) {

    int[] arr = {1, 2, 3, 4, 5, 6};
    int target = 2;

    int left = 0;
    int right = arr.length - 1;

    while (left < right) {
        int mid = (left + right) / 2;
        if (arr[mid] > target) {
            right = mid;
        } else if (arr[mid] < right) {
            left = mid;
        } else {
            System.out.println(mid);
            break;
        }
    }
    System.out.println(-1);
}
```


