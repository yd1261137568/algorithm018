学习笔记

#HashMap
hashMap底层采用数据+链表实现

HashMap的主体是一个Entry数组,因为存在hash冲突问题所以在数组元素位置又追加了链表结构
使用hashMap结构需要合理的设置hashCode方法,保留每个元素均匀的散列在hash表中

hashmap put
![hashmapput](hashmapput.png)
