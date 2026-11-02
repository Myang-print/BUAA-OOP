# BUAA OOP

北京航空航天大学面向对象程序设计课程的实验代码仓库。

## 当前内容

```text
BUAA_OOP/
├── src/
│   ├── lab_00/                 # Java 入门
│   ├── lab_01/                 # 类与对象
│   └── lab_04/Question1/       # 多态：private 方法与方法覆盖
├── figs/lab_01/                # Lab 1 图片资源
├── .gitignore
└── README.md
```

各实验目录中的源码和 README 可独立查看；具体编译入口与预期结果以题目目录内的说明为准。

## 基本运行方式

进入包含主类的目录后执行：

```powershell
javac -encoding UTF-8 Main.java
java Main
```

如果主类名称不是 `Main`，请将命令中的类名替换为对应的 `public class` 名称。运行类名不包含 `.java`。
