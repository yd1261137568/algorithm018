学习笔记
# 冒泡排序
```$xslt
public static int[] bubbleSort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr.length - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int tmp = arr[j + 1];
                arr[j + 1] = arr[j];
                arr[j] = tmp;
            }
        }
    }
    return arr;
}
```

# 选择排序
```$xslt
public static int[] selectionSort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[i] > arr[j]) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
    }
    return arr;
}
```

# 插入排序
```$xslt
for (int i = 1; i < arr.length; i++) {
    int tmp = arr[i];
    int j = i;

    while (j > 0 && tmp < arr[j - 1]) {
        arr[j] = arr[j - 1];
        j--;
    }

    if (j != i) {
        arr[j] = tmp;
    }
}
return arr;
```

# 桶排序
```$xslt
public static int[] bucketSort(int[] arr) {

        //1.计算出需要排序数组的最大最小值
        int max = arr[0];
        int min = arr[0];

        for (int i = 0; i < arr.length; i++) {
            max = max > arr[i] ? max : arr[i];
            min = min < arr[i] ? min : arr[i];
        }

        //1.计算差值
        int d = max - min;

        //2.初始化桶
        int bucketNum = arr.length;
        List<LinkedList<Integer>> bucketList = new ArrayList<>();

        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new LinkedList<Integer>());
        }

        //3.遍历原始数组,将每个元素放入桶中
        for (int i = 0; i < bucketNum; i++) {
            int num = ((arr[i] - min) * (bucketNum - 1) / d);
            bucketList.get(num).add(arr[i]);
        }

        //4.对每个桶内部进行排序
        for (int i = 0; i < bucketNum; i++) {
            Collections.sort(bucketList.get(i));
        }

        //5.输出全部元素
        int[] sortArr = new int[arr.length];

        int index = 0;
        for (LinkedList<Integer> bucket : bucketList) {
            for (Integer value : bucket) {
                sortArr[index++] = value;
            }
        }

        return sortArr;
    }
```

# 计数排序
```$xslt
 public static int[] countSort(int[] arr) {

        //1.异常值处理
        if (arr == null || arr.length == 0) {
            return arr;
        }

        //2.获取最大值
        int max = arr[0];

        for (int value : arr) {
            max = max > value ? max : value;
        }

        //3.创建数组 插入数据
        int[] tmpArr = new int[max + 1];

        for (int value : arr) {
            tmpArr[value]++;
        }

        int index = 0;
        for (int i = 0; i < tmpArr.length; i++) {
            for (int j = 0; j < tmpArr[i]; j++) {
                arr[index++] = i;
            }
        }
        return arr;
    }
```