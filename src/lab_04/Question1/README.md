# Question 1：多态 1

## 第一问

原代码中的关键语句是：

```java
Base b = new Child();
b.hello();
```

输出：

```text
base hello
```

`b` 的编译时类型是 `Base`，实际指向一个 `Child` 对象。但是 `Base.hello()` 是 `private` 方法，只能在 `Base` 内部访问，也不会被子类继承或覆盖。

`b.hello()` 写在 `Base.main()` 内部，因此这里调用的是 `Base` 自己的私有 `hello()`。`Child.hello()` 是一个新的、与它无覆盖关系的方法。

## 第二问

改为：

```java
Child c = new Child();
c.hello();
```

输出：

```text
child hello
```

此时 `c` 的编译时类型是 `Child`，编译器找到的是 `Child` 中公开的 `hello()`，因此调用 `Child.hello()`。

当前的 `Test.java` 把这两种情况放在一起演示，所以完整运行结果是：

```text
base hello
child hello
```

这两个调用不能用通常的“运行时看右边”直接解释，因为该口诀只适用于能够被覆盖的实例方法。父类的 `private` 方法不参与覆盖。

## 第三问

如果父类方法改成：

```java
public void hello() {
    System.out.println("base hello");
}
```

同时把子类方法改成：

```java
private void hello() {
    System.out.println("child hello");
}
```

程序不能编译，因此没有运行输出。

父类的 `public hello()` 可以被继承，子类中签名相同的方法会被视为覆盖。Java 不允许覆盖方法缩小访问权限：父类方法是 `public`，子类覆盖方法也必须是 `public`。

典型编译错误含义是：

```text
hello() in Child cannot override hello() in Base:
attempting to assign weaker access privileges; was public
```

## 核心结论

- `private` 方法不能被子类访问，也不参与方法覆盖。
- 子类可以声明一个同名、同参数的方法，但它与父类的 `private` 方法是两个不同的方法。
- 真正覆盖父类方法时，子类不能降低访问权限。
- 更严谨地说，`private` 方法之所以不能被覆盖，是因为它不会被继承；不应把它理解成普通的 `final` 方法参与了继承。

## 编译和运行

在本目录执行：

```powershell
javac -encoding UTF-8 Test.java
java Test
```

期望输出：

```text
base hello
child hello
```
