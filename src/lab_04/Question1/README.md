# Question 1：多态 1

## 1. `Base` 引用调用 `hello`

```java
Base b = new Child();
b.hello();
```

输出：

```text
base hello
```

`Base.hello()` 是 `private` 方法，只能在 `Base` 内部访问，且不会被子类继承或覆盖。因此，`Base.main()` 中的 `b.hello()` 调用的是 `Base.hello()`。

## 2. `Child` 引用调用 `hello`

```java
Child c = new Child();
c.hello();
```

输出：

```text
child hello
```

此时编译器直接找到 `Child.hello()`。它与父类的私有同名方法是两个不同的方法，不构成覆盖。

## 3. 父类 `public`、子类 `private`

不能编译。子类使用相同签名的方法覆盖父类方法时，不能缩小访问权限；父类方法是 `public`，子类方法也必须是 `public`。

## 结论

- `private` 方法不会被继承，也不参与方法覆盖。
- 只有可覆盖的实例方法才适用运行时多态。
- 覆盖方法不能缩小父类方法的访问权限。

## 运行

当前 `Test.java` 同时演示前两种调用：

```powershell
javac -encoding UTF-8 Test.java
java Test
```

```text
base hello
child hello
```
